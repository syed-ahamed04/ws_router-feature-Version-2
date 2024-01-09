package com.shorewise.wiseconnect.router.beanprocessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("mt202Processor")
public class MT202Processor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // Get the SWIFT MT202 message from the exchange
        String mt202Message = exchange.getIn().getBody(String.class);

        // You can now process the message or log it
        System.out.println("Processing MT202 Message: " + mt202Message);

        // Perform further processing or transformations here

        // For example, if you want to set a header for the message type
        exchange.getIn().setHeader("CamelSwiftMessageType", "202");
    }
}
