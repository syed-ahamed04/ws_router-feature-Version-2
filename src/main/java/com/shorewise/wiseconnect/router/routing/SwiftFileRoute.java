package com.shorewise.wiseconnect.router.routing;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SwiftFileRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet");

        rest("/swift")
            .post("/processFile")
            .to("direct:readFile");

        from("file:/Users/syedzubairahamed/Downloads/wiseconnect/SWIFT_Wiseconnect?noop=true&fileName=swift-message.txt")
            .routeId("file-reader-route")
            .convertBodyTo(String.class)
            .to("direct:processSwiftMessage");

        from("direct:processSwiftMessage")
            .routeId("swift-message-processor-route")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) {
                    String body = exchange.getIn().getBody(String.class);
                    // Extract message type, for example, MT102 or MT202
                    String messageType = extractMessageType(body);
                    exchange.getIn().setHeader("MessageType", messageType);
                }
            })
            .choice()
                .when(header("MessageType").isEqualTo("103"))
                    .bean("mt103Processor")
                //.when(header("MessageType").isEqualTo("202"))
                  //  .bean("mt202Processor")
                // Add additional when clauses for other types
                .otherwise()
                    .log("Unsupported SWIFT message type")
            .end();
           
    }

    private String extractMessageType(String body) {
      
        return "103"; // Return the message type, e.g., "102" or "202"
    }
}
