package com.shorewise.wiseconnect.router.routing;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SwiftFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        // REST DSL configuration
        restConfiguration()
            .component("servlet");
           

        // REST endpoint to trigger processing
        rest("/swift")
            .post("/processFile")
            .to("direct:readFile");

        // Route to read SWIFT messages from files and send to parser
        from("file:/Users/syedzubairahamed/Downloads/wiseconnect/SWIFT_Wiseconnect?noop=true&fileName=swift-message.txt")
            .routeId("file-reader-route")
            .convertBodyTo(String.class)
            .to("direct:processSwiftMessage");

        // Route to process SWIFT message content
        from("direct:processSwiftMessage")
            //.bean("swiftMessageParser", "parse")
            .log("Processed SWIFT Message: ${body}");

        
    }
}
