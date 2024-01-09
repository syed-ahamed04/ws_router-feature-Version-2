package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DataStoreToActiveMqRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:readAndSendToActiveMQ")
            .routeId("datastore-to-activemq-route")
            .log("Received request to process ID for ActiveMQ")
            .process(exchange -> {
                String id = exchange.getIn().getHeader("id", String.class);
                exchange.getIn().setHeader("CamelSqlQuery", 
                    "SELECT id, ti_request FROM xml_storage.TransactionData WHERE id = :?id");
                exchange.getIn().setHeader("id", id);
            })
            .to("sql:${header.CamelSqlQuery}")
            .split(body())
            .log("Sending XML record with ID ${header.id} to ActiveMQ")
            .to("activemq:queue:Processed")
            .log("Record with ID ${header.id} sent to ActiveMQ");
    }
}
