package com.olive.integration.routingsystem.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "camel.component.custom.sftp")
public class SftpProperties {
	private Map<String, SftpPropertiesMap> instances = new HashMap<>();

	public String buildUri(String instance) {
		return buildUri(instance, null);
	}

	public String buildUri(String instance, String path) {
		SftpPropertiesMap props = instances.get(instance);

		String sftpHost = props.getHost();
		String sftpPort = Integer.toString(props.getPort());
		String sftpUser = props.getUser();
		String sftpPass = props.getPass();
		String sftpPath = props.getPath();

		String sftpServerUri = sftpHost + ":" + sftpPort + "/" + (path != null ? path : sftpPath) + "?username="
				+ sftpUser + "&password=" + sftpPass;
		return sftpServerUri;
	}

	public Map<String, SftpPropertiesMap> getInstances() {
		return instances;
	}

	public void setInstances(Map<String, SftpPropertiesMap> instances) {
		this.instances = instances;
	}
}
