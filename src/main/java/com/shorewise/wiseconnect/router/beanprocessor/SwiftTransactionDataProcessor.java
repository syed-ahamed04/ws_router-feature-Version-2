package com.shorewise.wiseconnect.router.beanprocessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.shorewise.wiseconnect.router.entity.SwiftTransactionDataEntity;
import com.shorewise.wiseconnect.router.mapper.SwiftTransactionDataMapper;
import com.shorewise.wiseconnect.router.model.SwiftTransactionData;
import com.shorewise.wiseconnect.router.repository.SwiftTransactionDataRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component("SwiftTransactionDataProcessor")
public class SwiftTransactionDataProcessor implements Processor {

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Autowired
	private SwiftTransactionDataRepository repository;

	@Override
	public void process(Exchange exchange) throws Exception {
		try {
			String line = exchange.getIn().getBody(String.class);
			String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

			// Create a new instance of SwiftTransactionData for each line processed
			SwiftTransactionData swiftTransactionData = new SwiftTransactionData();

			// Assuming the data follows the correct order and length
			swiftTransactionData.setInstRefNum(data[0]);
			swiftTransactionData.setOwnerRefNum(data[1]);
			swiftTransactionData.setCcy(data[2]);
			swiftTransactionData.setAmount(new BigDecimal(data[3].trim()));
			swiftTransactionData.setSolIdB(Integer.valueOf(data[4]));
			swiftTransactionData.setSolIdC(Integer.valueOf(data[5]));
			swiftTransactionData.setUniqueId(data[6]);

			// Parse the date strings into LocalDateTime objects assuming the time part is
			// at the start of the day
			LocalDateTime entryDateTime = LocalDate.parse(data[7], dateFormatter).atStartOfDay();
			LocalDateTime valueDateTime = LocalDate.parse(data[8], dateFormatter).atStartOfDay();

			swiftTransactionData.setEntryDate(entryDateTime);
			swiftTransactionData.setValueDate(valueDateTime);

			swiftTransactionData.setDrCr(data[9]);
			swiftTransactionData.setNostro(data[10]);
			swiftTransactionData.setField86(data[11]);

			swiftTransactionData.setId(UUID.randomUUID().toString()); // Generate a new UUID for each record
			swiftTransactionData.setCreatedAt(LocalDateTime.now()); // Set created time to current time
			swiftTransactionData.setUpdatedAt(LocalDateTime.now()); // Set updated time to current time
			swiftTransactionData.setCreatedUser("truser01"); // Default created user
			swiftTransactionData.setUpdatedUser("truser01"); // Default updated user

			// Map the POJO to an entity
			SwiftTransactionDataEntity swiftTransactionEntity = SwiftTransactionDataMapper
					.toEntity(swiftTransactionData);

			repository.save(swiftTransactionEntity);

			// You can now access the parsed data and perform further processing or logging
			System.out.println("Parsed SWIFT transaction Message: " + swiftTransactionEntity);

			// Set the parsed MT103 object as the message body for further processing
			exchange.getIn().setBody(swiftTransactionEntity);
		} catch (DataIntegrityViolationException e) {

			System.err.println("A record with the same unique_id already exists: " + e.getMessage());

			throw e;
		}
	}
}
