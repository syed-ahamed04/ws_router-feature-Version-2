package com.shorewise.wiseconnect.router.routing;


import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;


@Component
public class SwiftBatchProcessorRoute extends RouteBuilder {
	
	 @Override
	    public void configure() {
	        restConfiguration().component("servlet");

	        // Define exception handling
	        onException(DataIntegrityViolationException.class)
	            .process(exchange -> {
	                Throwable caused = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
	                // Log the error or perform any other error handling logic here
	                System.err.println("Error during processing: " + caused.getMessage());
	            })
	            .log("Handled exception: ${exception.message}")
	            .handled(true); // This prevents the exception from propagating further

	        from("file:/Users/syedzubairahamed/Downloads/wiseconnect/SWIFT_Wiseconnect?noop=true&fileName=MT103.csv")
	            .routeId("csv-file-route")
	            .split().tokenize("\n").streaming() // Split the file into lines
	            .choice()
	                .when(simple("${exchangeProperty.CamelSplitIndex} > 0")) // Skip the first line (index 0)
	                    .bean("SwiftTransactionDataProcessor")
	                .end()
	            .end(); // End the choice and split blocks
	    }
	}