package com.olive.integration.routingsystem.components;

import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.olive.integration.routingsystem.properties.SalesforceProperties;
import com.olive.integration.routingsystem.properties.SalesforcePropertiesMap;

@Configuration
public class Salesforce {

	@Autowired
	private SalesforceProperties salesforceProps;
	
	@Bean(name = "salesforceOne")
	public SalesforceComponent salesforceComponentOlive() {
		SalesforcePropertiesMap salesforceMap = salesforceProps.getInstances().get("one");
		SalesforceComponent component = getSalesforceComponentByPropertiesMap(salesforceMap);
		return component;
	}

//	@Bean(name = "salesforceTwo")
//	public SalesforceComponent salesforceComponentFord() {
//		SalesforcePropertiesMap salesforceMap = salesforceProps.getInstances().get("two");
//		SalesforceComponent component = getSalesforceComponentByPropertiesMap(salesforceMap);
//		return component;
//	}

	public SalesforceComponent getSalesforceComponentByPropertiesMap(SalesforcePropertiesMap salesforceMap) {
		SalesforceLoginConfig loginConfig = new SalesforceLoginConfig();
		loginConfig.setType(salesforceMap.getLoginType());
		loginConfig.setLoginUrl(salesforceMap.getLoginUrl());
		loginConfig.setClientId(salesforceMap.getClientId());
		loginConfig.setClientSecret(salesforceMap.getClientSecret());
		loginConfig.setUserName(salesforceMap.getUserName());
		loginConfig.setPassword(salesforceMap.getPassword());
		loginConfig.setRefreshToken(salesforceMap.getRefreshToken());
//		loginConfig.setLazyLogin(true);
		
		SalesforceComponent component = new SalesforceComponent();
		component.setLoginConfig(loginConfig);
//		component.setLazyStartProducer(true);
		return component;
	}
}
