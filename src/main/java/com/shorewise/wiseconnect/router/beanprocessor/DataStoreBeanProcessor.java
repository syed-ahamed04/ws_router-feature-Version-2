package com.shorewise.wiseconnect.router.beanprocessor;

import java.io.IOException;
import java.io.StringReader;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Component("dataStoreBeanProcessor")
public class DataStoreBeanProcessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger logger = LogManager.getLogger(DataStoreBeanProcessor.class);

    String operation;
    String ti_request;
	String ti_response;
	String customer_id;
	String master_ref;
	String event_ref;

    public void process(@Body String body, Exchange exchange) {
    	logger.info("Processing message with Body: {}", body);
    	// Example of parsing the body to extract XML and other data
    	// This parsing depends on the format of 'body'
    	ti_request = ti_response = extractXmlFrom(body); // Implement this method based on your data format
    	String status = extractStatusFrom(body); // Similarly extract status
    	String user = extractUserFrom(body); // And the user
    	UUID uuid = UUID.randomUUID();
    	String uuidString = uuid.toString();
    	operation = extractOperationFrom(ti_request);
    	// SQL statement with placeholders for parameters
    	String insertSQL = "INSERT INTO xml_storage.TransactionData "
    			+ "(id, ti_request, ti_response, operation_type, customer_id, status, master_ref, event_ref, "
    			+ "created_user, updated_user, created_at, updated_at) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
    	
    	try {
            logger.info("Inserting record into database");
            int rowsUpdated = insertRecord(insertSQL, uuidString, ti_request, ti_response, operation, 
					customer_id, status, master_ref, event_ref, user);
            String responseMessage = rowsUpdated > 0 ? "Record inserted successfully with ID: " + uuidString : "No rows inserted";
            exchange.getMessage().setBody(responseMessage);
            //logger.info("Record inserted successfully with ID: {}", uuidString);
            exchange.getOut().setBody(uuidString);
        }
    	
    	catch (DataAccessException e)
    	{
            logger.error("Record cannot be inserted/updated into DB due to an exception.", e);
            exchange.getOut().setBody("Error inserting record");
        }
    }
    
    //Check if entry already exists in database
    private boolean recordExists(String id) {
    	String sql = "SELECT * from xml_storage.TransactionData where id = '"+id+"'";
    	return !jdbcTemplate.queryForList(sql).isEmpty();
    }
    
    //Insert new entry into xml_storage.transactional_xml
    private int insertRecord(String insertSQL, String uuidString, String ti_request, String ti_response,
    		String operation, String customer_id, String status, String master_ref, String event_ref, String createdUser) {
    	return jdbcTemplate.update(insertSQL, uuidString, ti_request, ti_response, operation, customer_id, status, master_ref, event_ref, createdUser, createdUser);
    }
    
  
    // Example methods to parse the incoming message
    private String extractXmlFrom(String body) {
        // Implement parsing logic here
        return body; // Return extracted XML
    }

    private String extractStatusFrom(String body) {
        // Implement parsing logic here
        return "Received"; // Return extracted status
    }

    private String extractUserFrom(String body) {
        // Implement parsing logic here
        return "truser01"; // Return extracted user
    }
    
    private String extractOperationFrom(String xmlData) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // parse XML file
    		DocumentBuilder db = dbf.newDocumentBuilder();
    		Document doc = db.parse(new InputSource(new StringReader(xmlData)));
    		doc.getDocumentElement().normalize();

    		//System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());

    		String full_operation = doc.getDocumentElement().getNodeName();
    		operation = full_operation.substring(full_operation.lastIndexOf(":")+1);
    		customer_id = getElementValue(doc, "urn:common.service.ti.apps.tiplus2.misys.com","Customer");
    		master_ref = getElementValue(doc, "urn:messages.service.ti.apps.tiplus2.misys.com","eBankMasterRef");
    		event_ref = getElementValue(doc, "urn:messages.service.ti.apps.tiplus2.misys.com","eBankEventRef");

//    		System.out.println("Operation: "+operation+" customer_id: "+customer_id+
//    				" master_ref: "+master_ref+" event_ref: "+event_ref);
    		return operation;
    	} catch (ParserConfigurationException | SAXException | IOException e) {
    		logger.error("XML cannot be parsed due to an exception: {}", e);
    		return "";
    	}
    }
    
    
    //Get Element Value by Tag Name - Name Space
    private String getElementValue(Document doc, String url, String element) {
    	NodeList list = doc.getElementsByTagNameNS(url, element);    	
    	return list.getLength()!=0 ? list.item(0).getTextContent() : "";
    }
}