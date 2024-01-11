package com.shorewise.wiseconnect.router.beanprocessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shorewise.wiseconnect.router.entity.SwiftMT103Entity;
import com.shorewise.wiseconnect.router.mapper.SwiftMT103Mapper;
import com.shorewise.wiseconnect.router.model.SwiftMT103;
import com.shorewise.wiseconnect.router.parser.SwiftMT103Parser;
import com.shorewise.wiseconnect.router.repository.SwiftMT103Repository;

@Component("mt103Processor")
public class MT103Processor implements Processor {

	private final SwiftMT103Parser mt103Parser;
	
	@Autowired
    private SwiftMT103Repository repository;

    @Autowired
    public MT103Processor(SwiftMT103Parser mt103Parser) {
        this.mt103Parser = mt103Parser;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        // Get the SWIFT MT103 message from the exchange
        String mt103Message = exchange.getIn().getBody(String.class);

        // Parse the SWIFT MT103 message
        SwiftMT103 mt103 = mt103Parser.parse(mt103Message);

        SwiftMT103Entity mt103Entity = SwiftMT103Mapper.toEntity(mt103);
        
        repository.save(mt103Entity);     
        
        // You can now access the parsed data and perform further processing or logging
        System.out.println("Parsed MT103 Message: " + mt103);

        // Set the parsed MT103 object as the message body for further processing
        exchange.getIn().setBody(mt103);
    }
}
