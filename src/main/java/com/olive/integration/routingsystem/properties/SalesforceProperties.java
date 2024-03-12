package com.olive.integration.routingsystem.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "camel.component.custom.salesforce")
public class SalesforceProperties {
	private Map<String, SalesforcePropertiesMap> instances = new HashMap<>();

	public Map<String, SalesforcePropertiesMap> getInstances() {
		return instances;
	}

	public void setInstances(Map<String, SalesforcePropertiesMap> instances) {
		this.instances = instances;
	}
}
