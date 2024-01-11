package com.shorewise.wiseconnect.router.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.shorewise.wiseconnect.router.model.SwiftMT103;

@Component
public class SwiftMT103Parser {

    public SwiftMT103 parse(String swiftMessage) {
        
    	SwiftMT103 mt103 = new SwiftMT103();

        // Extract header information
        String swircv = extractSWIRCV(swiftMessage);
        String swisnd = extractSWISND(swiftMessage);
        String senderDetails = extractSenderdetails(swiftMessage);
        String beneficiaryAccount = extractBeneficiaryAccount(swiftMessage);
        String senderReference = extractSenderReference(swiftMessage);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter swidteFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        DateTimeFormatter switimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String swidate = now.format(swidteFormatter);
        String switme = now.format(switimeFormatter);
      
        mt103.setSwidta(swiftMessage);    
        mt103.setSwircv(swircv);
        mt103.setSwisnd(swisnd);
        mt103.setSenderDetail(senderDetails);
        mt103.setBeneficiaryAccount(beneficiaryAccount);
        mt103.setSwidat(swidate);
        mt103.setSwitim(switme);
        mt103.setSenderReference(senderReference);       
        return mt103;
    }

  

   


	private String extractSenderReference(String swiftMessage) {
		// Define the pattern for the sender reference which starts with ':20:' and is followed by alphanumeric characters
	    String senderReferencePattern = ":20:([a-zA-Z0-9]+)";
	    Pattern pattern = Pattern.compile(senderReferencePattern);
	    Matcher matcher = pattern.matcher(swiftMessage);

	    if (matcher.find()) {
	        return matcher.group(1); // Return the sender reference
	    } else {
	        return null; // Sender reference not found
	    }
	}



	private String extractBeneficiaryAccount(String swiftMessage) {
        // Define the pattern for beneficiary details which starts with ':59:'
        String beneficiaryAccountPattern = ":59:/(\\d+)";
        Pattern pattern = Pattern.compile(beneficiaryAccountPattern);
        Matcher matcher = pattern.matcher(swiftMessage);

        if (matcher.find()) {
            return matcher.group(1); // Return the beneficiary account number
        } else {
            return null; // Beneficiary account number not found
        }
    }



	private String extractSenderdetails(String swiftMessage) {
        // Define the pattern for sender details which starts with :50K: and ends before the next ':'
    	 String senderDetailsPattern = ":50K:/?(.*?)(?=\\n:)";
        Pattern pattern = Pattern.compile(senderDetailsPattern, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(swiftMessage);

        if (matcher.find()) {
            String senderDetails = matcher.group(1).trim(); // .trim() to remove leading/trailing whitespace
            return senderDetails; // Return the sender details
        } else {
            return null; // Sender details not found
        }
     }



	private String extractSWISND(String swiftMessage) {
        // Use a regex pattern to extract SWISND (CITIUS33EXXX)
    	String swisindPattern = "\\{2:O\\d+([A-Z]{6}[A-Z0-9]{5})";
        Pattern pattern = Pattern.compile(swisindPattern);
        Matcher matcher = pattern.matcher(swiftMessage);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // SWISIND not found
        }
    }

    
	private String extractSWIRCV(String swiftMessage) {
        // Use a regex pattern to extract SWIDTA (UBININBBAXXX) from {1:F01UBININBBAXXX0000000000}
        String swidtaPattern = "\\{1:F01(\\w{12})";
        Pattern pattern = Pattern.compile(swidtaPattern);
        Matcher matcher = pattern.matcher(swiftMessage);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // SWIDTA not found
        }
    }
    

}
