package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class XmlToDataStore extends RouteBuilder  {
    
    private static final Logger logger = LogManager.getLogger(XmlToDataStore.class);

    @Override
    public void configure() {
        // Global exception handling
        onException(Exception.class)
            .handled(true)
            .process(exchange -> {
                Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                logger.error("Exception caught in route: {}", cause.getMessage());
                exchange.getIn().setBody("Error processing request: " + cause.getMessage());
            })
            .log("Processed exception in the route");

        // Configure REST DSL
        restConfiguration()
            .component("servlet")
            .apiContextPath("/api-doc");

        // Define REST service
        rest("/wiseconnect")
            .post("/transactions/save")
            .consumes(MediaType.APPLICATION_XML_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)
            .route()
            	.process(exchange -> logger.info("Received XML message: {}", exchange.getIn().getBody(String.class)))
                .to("bean:dataStoreBeanProcessor") // Assuming this processor persists the XML and returns an ID
                .process(exchange -> {
                    String id = exchange.getIn().getBody(String.class);
                    exchange.setProperty("persistedId", id);
                    logger.info("XML message processed and persisted with ID: {}", id);
                })
                .to("direct:processToActiveMQ")
            .endRest();

        from("direct:processToActiveMQ")
            .process(exchange -> {
                String id = exchange.getProperty("persistedId", String.class);
                exchange.getIn().setHeader("id", id);
                logger.info("Forwarding ID to ActiveMQ route: {}", id);
            })
            .to("direct:readAndSendToActiveMQ");
    }
}
