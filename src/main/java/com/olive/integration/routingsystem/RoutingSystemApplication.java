package com.olive.integration.routingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcraft.jsch.JSch;

@SpringBootApplication
public class RoutingSystemApplication {

	public static void main(String[] args) {
		// As of Camel 3.17.0, key types and algorithms that use SHA1 have been deprecated. This code block is for restoring it.
		JSch.setConfig("server_host_key",  JSch.getConfig("server_host_key") + ",ssh-rsa");
		JSch.setConfig("PubkeyAcceptedAlgorithms", JSch.getConfig("PubkeyAcceptedAlgorithms") + ",ssh-rsa");
		JSch.setConfig("kex", JSch.getConfig("kex") + ",diffie-hellman-group1-sha1,diffie-hellman-group14-sha1");
		
		SpringApplication.run(RoutingSystemApplication.class, args);
	}

}
