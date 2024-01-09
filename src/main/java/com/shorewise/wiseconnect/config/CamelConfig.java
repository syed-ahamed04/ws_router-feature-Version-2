package com.shorewise.wiseconnect.config;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean
    CamelContextConfiguration camelContextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // Enable Camel Tracing
                context.setTracing(true);
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                // Configuration to apply after Camel starts
            }
        };
    }
}
