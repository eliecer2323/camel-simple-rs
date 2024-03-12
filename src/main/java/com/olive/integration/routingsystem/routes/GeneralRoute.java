package com.olive.integration.routingsystem.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.processor.idempotent.MongoDbIdempotentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.olive.integration.routingsystem.dtos.QueryRecordsPolicyFordSF;
import com.olive.integration.routingsystem.processors.GeneralMapper;
import com.olive.integration.routingsystem.properties.SftpProperties;

@Component
public class GeneralRoute extends RouteBuilder {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SftpProperties sftpProps;
	
	@Autowired
	private MongoClient mongoClient;
	
	@Override
	public void configure() throws Exception {
		MongoDbIdempotentRepository idempotentRepository = new MongoDbIdempotentRepository(mongoClient, "routeOne", "idempotent_repository");
		
		String filePrefix = "testingFile.txt";
        String sftpConnection = sftpProps.buildUri("one");
        logger.info("sftpConnection: "+sftpConnection);
        
        onCompletion()
	    	.onWhen(exchange -> exchange.getProperty(Exchange.DUPLICATE_MESSAGE, Boolean.FALSE, Boolean.class))
	    	.log("File skipped because was already processed");
		
        String sfQuery = "SELECT Id,VIN__c,Ford_Contract_Number__c FROM Policy__c WHERE VIN__c != Null AND VIN__c = '${exchangeProperty.vin}'";
        
        // This is for simulating 3 different routes executing at 10, 11 and 12 o'clock respectively
        for (int i = 0; i < 3; i++) {
            from("sftp:"+sftpConnection+"&include="+filePrefix+"&noop=true&idempotent=false&scheduler=spring&scheduler.cron=0+0+"+(10+i)+"+*+*+?"
                    + "&sortBy=reverse:file:modified&eagerMaxMessagesPerPoll=false&maxMessagesPerPoll=2&passiveMode=true")
                .routeId("Route"+(i+1))
                .setHeader("instance", constant(i+1))
                .log(LoggingLevel.INFO, "Trying instance ${header.instance} with file: ${file:name} ${file:modified}")
                .idempotentConsumer(simple("${header.CamelFileHost}://${header.CamelFileAbsolutePath}--${header.CamelFileLastModified}"))
            	.idempotentRepository(idempotentRepository)
            	.log(LoggingLevel.INFO, "Route started")
    	        .split().tokenize("\n")
    	        .streaming()
    				.log(LoggingLevel.INFO, "--------=========-------")
    				.log(LoggingLevel.INFO, "File raw: ${body}")
    	        	.setProperty("vin", simple("${body.substring(0, 17)}"))
    	        	.setProperty("contractNumber", simple("${body.substring(17, 19)}"))
    	        	.setProperty("verificationCode", simple("${body.substring(19, 20)}"))
    				.choice()
    				.when(simple("${exchangeProperty.verificationCode} == 'Y'"))
    					.log(LoggingLevel.INFO, "Looking Policy in SF by VIN: ${exchangeProperty.vin}")
    		        	.setHeader("sObjectQuery", simple(sfQuery))
    					.setHeader("sObjectClass", constant(QueryRecordsPolicyFordSF.class.getName()))
    	        		.toD("salesforceOne:query?sObjectQuery=${header.sObjectQuery}&sObjectClass=${header.sObjectClass}")
    	        		.choice()
    	            	.when(simple("${body.records.size} > 0"))
    						.setBody(simple("${body.records}"))
    						.split(body())
    							.log(LoggingLevel.INFO, "SFQueryResponse: ${body}")
    							.process(new GeneralMapper())
    							.log(LoggingLevel.INFO, "Policy after mapping: ${body}")
    							.to("salesforceOne:updateSObject?sObjectName=Policy__c")
    							.log(LoggingLevel.INFO, "SFUpdateResponse successed: ${body}")
    					.endChoice()
    					.otherwise()
    						.log(LoggingLevel.INFO, "Policy skipped and untouched in SF: no policy found")
    					.endChoice()
    				.otherwise()
    					.log(LoggingLevel.INFO, "Policy skipped and untouched in SF: no records valid")
    				.end()
    	    	.end();
		}

	}
}
