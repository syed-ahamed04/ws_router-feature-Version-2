package com.shorewise.wiseconnect.router.beanprocessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("mt103Processor")
public class MT103Processor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Get the SWIFT MT103 message from the exchange
        String mt103Message = exchange.getIn().getBody(String.class);

        // You can now process the message or log it
        System.out.println("Processing MT103 Message: " + mt103Message);

        // Perform further processing or transformations here

        // For example, if you want to set a header for the message type
        exchange.getIn().setHeader("CamelSwiftMessageType", "103");
    }
}
