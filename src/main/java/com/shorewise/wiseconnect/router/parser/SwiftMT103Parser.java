package com.shorewise.wiseconnect.router.parser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.shorewise.wiseconnect.router.model.SwiftMT103;

@Component
public class SwiftMT103Parser {

    public SwiftMT103 parse(String swiftMessage) {
        SwiftMT103 mt103 = new SwiftMT103();

        // Extract header information
        String header1 = extractHeader(swiftMessage, 1);
        String header2 = extractHeader(swiftMessage, 2);
        
        mt103.setSwidta(header1);
        mt103.setSwircv(header2);
      
    

        return mt103;
    }

    private String extractHeader(String swiftMessage, int headerNumber) {
        String headerPattern = "\\{" + headerNumber + ":(.*?)\\}";
        Pattern pattern = Pattern.compile(headerPattern);
        Matcher matcher = pattern.matcher(swiftMessage);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null; // Header not found
        }
    }

    
}
