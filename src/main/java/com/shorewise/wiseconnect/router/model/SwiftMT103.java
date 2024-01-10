package com.shorewise.wiseconnect.router.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SwiftMT103 {
	  
		private int swiftMT103Id;
	    private String swidta;
	    private String swircv;
	    private String swisnd;
	    private String billReferenceNumber;
	    private String swidat;
	    private String switim;
	    private String transactionReferenceNumber;
	    private String relatedReference;
	    private String timeIndication;
	    private String valueDate;
	    private String currencyCode;
	    private BigDecimal amount;
	    private String orderingInstitution;
	    private String sendersCorrespondent;
	    private String receiversCorrespondent;
	    private String intermediary;
	    private String accountWithInstitution;
	    private String beneficiaryInstitution;
	    private String senderToReceiverInformation;


}
