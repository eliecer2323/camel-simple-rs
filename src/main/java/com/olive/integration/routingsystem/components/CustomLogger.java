package com.olive.integration.routingsystem.components;

import org.apache.camel.Exchange;
import org.apache.camel.spi.CamelLogger;
import org.apache.camel.spi.ExchangeFormatter;
import org.apache.camel.spi.LogListener;
import org.springframework.stereotype.Component;

@Component
public class CustomLogger implements LogListener {
	
	@Override
	public String onLog(Exchange exchange, CamelLogger camelLogger, String message) {
		ExchangeFormatter exchangeFormatter = exchange.getContext().getTracer().getExchangeFormatter();
		return "Custom message: " + message + "; Exchange: " + exchangeFormatter.format(exchange);
	}
}
