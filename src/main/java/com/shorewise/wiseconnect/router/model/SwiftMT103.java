package com.shorewise.wiseconnect.router.model;

import lombok.Data;

@Data
public class SwiftMT103 {
    private String sender;
    private String receiver;
    private double amount;

    // Getters and setters for the above fields
}
