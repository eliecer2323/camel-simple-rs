package com.olive.integration.routingsystem.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.olive.integration.routingsystem.dtos.PolicyFordSF;

public class GeneralMapper implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		PolicyFordSF policy = exchange.getIn().getBody(PolicyFordSF.class);
		policy.setFord_Contract_Number__c(exchange.getIn().getExchange().getProperty("contractNumber", String.class));
		exchange.getIn().setBody(policy);
	}

}
