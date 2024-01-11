package com.shorewise.wiseconnect.router.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class SwiftMT103 {
	  
	    private String id;
	    private String swidta;
	    private String swircv;
	    private String swisnd;
	    private String senderDetail;
	    private String beneficiaryAccount;
	    private String swidat;
	    private String switim;
	    private String senderReference;
	    private String timeIndication;
	    private String bankOperationCode;
	    private String instructionCode;
	    private String transactionTypeCode;
	    private String valueDateCurrencyInterbankSettledAmount;
	    private String currencyInstructedAmount;
	    private BigDecimal exchangeRate;
	    private String orderingCustomer;
	    private String sendingInstitution;
	    private String orderingInstitution;
	    private String senderCorrespondent;
	    private String receiverCorrespondent;
	    private String thirdReimbursementInstitution;
	    private String intermediaryInstitution;
	    private String accountWithInstitution;
	    private String beneficiaryCustomer;
	    private String remittanceInformation;
	    private String detailsOfCharges;
	    private BigDecimal senderCharges;
	    private BigDecimal receiverCharges;
	    private String senderToReceiverInformation;
	    private String regulatoryReporting;
	
	    
	    public SwiftMT103() {
	        this.id = UUID.randomUUID().toString(); // Generate UUID for the id
	    }
	    
	    @Override
		public String toString() {
			return "SwiftMT103 [id=" + id + ", swidta=" + swidta + ", swircv=" + swircv + ", swisnd=" + swisnd
					+ ", senderDetail=" + senderDetail + ", beneficiaryAccount=" + beneficiaryAccount + ", swidat="
					+ swidat + ", switim=" + switim + ", senderReference=" + senderReference + ", timeIndication="
					+ timeIndication + ", bankOperationCode=" + bankOperationCode + ", instructionCode="
					+ instructionCode + ", transactionTypeCode=" + transactionTypeCode
					+ ", valueDateCurrencyInterbankSettledAmount=" + valueDateCurrencyInterbankSettledAmount
					+ ", currencyInstructedAmount=" + currencyInstructedAmount + ", exchangeRate=" + exchangeRate
					+ ", orderingCustomer=" + orderingCustomer + ", sendingInstitution=" + sendingInstitution
					+ ", orderingInstitution=" + orderingInstitution + ", senderCorrespondent=" + senderCorrespondent
					+ ", receiverCorrespondent=" + receiverCorrespondent + ", thirdReimbursementInstitution="
					+ thirdReimbursementInstitution + ", intermediaryInstitution=" + intermediaryInstitution
					+ ", accountWithInstitution=" + accountWithInstitution + ", beneficiaryCustomer="
					+ beneficiaryCustomer + ", remittanceInformation=" + remittanceInformation + ", detailsOfCharges="
					+ detailsOfCharges + ", senderCharges=" + senderCharges + ", receiverCharges=" + receiverCharges
					+ ", senderToReceiverInformation=" + senderToReceiverInformation + ", regulatoryReporting="
					+ regulatoryReporting + "]";
		}
	    
	    
	    
}
