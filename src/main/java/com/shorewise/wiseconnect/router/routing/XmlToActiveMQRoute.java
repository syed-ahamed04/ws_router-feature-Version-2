package com.shorewise.wiseconnect.router.routing;


import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class XmlToActiveMQRoute extends RouteBuilder {
   
    private static final Logger logger = LogManager.getLogger(XmlToActiveMQRoute.class);

    @Override
    public void configure() {
        // Configure REST DSL and Swagger
        restConfiguration()
            .component("servlet")
            .port(8092)
            .host("localhost")
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "shorewise wiseconnect router")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true"); 

        // Define REST service
        rest("/wiseconnect")
            .post("/transactions/submitTomq")
            .consumes(MediaType.APPLICATION_XML_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)
            .route()
                .process(exchange -> logger.info("Received XML message: {}", exchange.getIn().getBody(String.class)))
                .setExchangePattern(ExchangePattern.InOnly)
                .to("activemq:queue:Ingress")
                .process(exchange -> logger.info("Message forwarded to ActiveMQ queue: Ingress"))
            .endRest();
    }
}
