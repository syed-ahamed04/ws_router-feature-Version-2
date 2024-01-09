package com.shorewise.wiseconnect.router.beanprocessor;

import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

@Component("activeMqResponseBeanProcessor")
public class ActiveMqResponseBeanProcessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LogManager.getLogger(ActiveMqResponseBeanProcessor.class);

    public void process(@Body String body, Exchange exchange) {
        logger.info("Processing message with Body: {}", body);
        
        String id = extractIdFromXml(body);
        if (id == null) {
            logger.error("ID not found in XML");
            exchange.getMessage().setBody("ID not found in XML");
            return;
        }

        String sql = "UPDATE xml_storage.TransactionData SET status = 'Processed', ti_response = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, body, id);

        logger.info("Updated {} rows in xml_storage.TransactionData for ID: {}", rowsUpdated, id);
        String responseMessage = rowsUpdated > 0 ? "Processed successfully for ID: " + id : "No rows updated for ID: " + id;
        exchange.getMessage().setBody(responseMessage);
    }

    private String extractIdFromXml(String xml) {
        Pattern pattern = Pattern.compile("id=(.*?)}");
        Matcher matcher = pattern.matcher(xml);
        if (matcher.find()) {
            return matcher.group(1);
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml)));
            
            if (doc.getElementsByTagName("id").getLength() > 0) {
                return doc.getElementsByTagName("id").item(0).getTextContent();
            }
        } catch (Exception e) {
            logger.error("Error parsing XML: {}", e);
        }
        return null;
    }
}
