package com.shorewise.wiseconnect.router.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQToRestRouteJson extends RouteBuilder {

	 @Override
	    public void configure() throws Exception {
	        from("activemq:queue:Processed")
	            .routeId("activeMqToDatabaseRoute")
	            .log("Received message from ActiveMQ: ${body}")
	            .bean("activeMqResponseBeanProcessor")
	            .log("Database updated successfully");
	    }
}
