package com.olive.integration.routingsystem.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyListener {
	private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        logger.info("Running RoutingSystemApplication");
    }
}

