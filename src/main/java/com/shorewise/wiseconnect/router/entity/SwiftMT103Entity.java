package com.shorewise.wiseconnect.router.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "swift_mt103", schema = "xml_storage")
public class SwiftMT103Entity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SWIDTA")
    private String swidta;

    @Column(name = "SWIRCV")
    private String swircv;

    @Column(name = "SWISND")
    private String swisnd;

    @Column(name = "Sender_Detail", length = 1000)
    private String senderDetail;

    @Column(name = "Beneficiary_Account")
    private String beneficiaryAccount;

    @Column(name = "SWIDAT")
    private LocalDate swidat;

    @Column(name = "SWITIM")
    private LocalTime switim;

    @Column(name = "Sender_Reference", unique = true)
    private String senderReference;

    @Column(name = "Time_Indication")
    private String timeIndication;

    @Column(name = "Bank_Operation_Code")
    private String bankOperationCode;

    @Column(name = "Instruction_Code")
    private String instructionCode;

    @Column(name = "Transaction_Type_Code")
    private String transactionTypeCode;

    @Column(name = "Value_Date_Currency_Interbank_Settled_Amount")
    private String valueDateCurrencyInterbankSettledAmount;

    @Column(name = "Currency_Instructed_Amount")
    private String currencyInstructedAmount;

    @Column(name = "Exchange_Rate", precision = 10, scale = 6)
    private BigDecimal exchangeRate;

    @Column(name = "Ordering_Customer", length = 1000)
    private String orderingCustomer;

    @Column(name = "Sending_Institution")
    private String sendingInstitution;

    @Column(name = "Ordering_Institution")
    private String orderingInstitution;

    @Column(name = "Sender_Correspondent")
    private String senderCorrespondent;

    @Column(name = "Receiver_Correspondent")
    private String receiverCorrespondent;

    @Column(name = "Third_Reimbursement_Institution")
    private String thirdReimbursementInstitution;

    @Column(name = "Intermediary_Institution")
    private String intermediaryInstitution;

    @Column(name = "Account_With_Institution")
    private String accountWithInstitution;

    @Column(name = "Beneficiary_Customer", length = 1000)
    private String beneficiaryCustomer;

    @Column(name = "Remittance_Information", length = 1000)
    private String remittanceInformation;

    @Column(name = "Details_of_Charges")
    private String detailsOfCharges;

    @Column(name = "Sender_Charges", precision = 10, scale = 2)
    private BigDecimal senderCharges;

    @Column(name = "Receiver_Charges", precision = 10, scale = 2)
    private BigDecimal receiverCharges;

    @Column(name = "Sender_to_Receiver_Information", length = 1000)
    private String senderToReceiverInformation;

    @Column(name = "Regulatory_Reporting", length = 1000)
    private String regulatoryReporting;

    
    public String getId() {
		return id;
	}


	public String getSwidta() {
		return swidta;
	}


	public String getSwircv() {
		return swircv;
	}


	public String getSwisnd() {
		return swisnd;
	}


	public String getSenderDetail() {
		return senderDetail;
	}


	public String getBeneficiaryAccount() {
		return beneficiaryAccount;
	}


	public LocalDate getSwidat() {
		return swidat;
	}


	public LocalTime getSwitim() {
		return switim;
	}


	public String getSenderReference() {
		return senderReference;
	}


	public String getTimeIndication() {
		return timeIndication;
	}


	public String getBankOperationCode() {
		return bankOperationCode;
	}


	public String getInstructionCode() {
		return instructionCode;
	}


	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}


	public String getValueDateCurrencyInterbankSettledAmount() {
		return valueDateCurrencyInterbankSettledAmount;
	}


	public String getCurrencyInstructedAmount() {
		return currencyInstructedAmount;
	}


	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}


	public String getOrderingCustomer() {
		return orderingCustomer;
	}


	public String getSendingInstitution() {
		return sendingInstitution;
	}


	public String getOrderingInstitution() {
		return orderingInstitution;
	}


	public String getSenderCorrespondent() {
		return senderCorrespondent;
	}


	public String getReceiverCorrespondent() {
		return receiverCorrespondent;
	}


	public String getThirdReimbursementInstitution() {
		return thirdReimbursementInstitution;
	}


	public String getIntermediaryInstitution() {
		return intermediaryInstitution;
	}


	public String getAccountWithInstitution() {
		return accountWithInstitution;
	}


	public String getBeneficiaryCustomer() {
		return beneficiaryCustomer;
	}


	public String getRemittanceInformation() {
		return remittanceInformation;
	}


	public String getDetailsOfCharges() {
		return detailsOfCharges;
	}


	public BigDecimal getSenderCharges() {
		return senderCharges;
	}


	public BigDecimal getReceiverCharges() {
		return receiverCharges;
	}


	public String getSenderToReceiverInformation() {
		return senderToReceiverInformation;
	}


	public String getRegulatoryReporting() {
		return regulatoryReporting;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setSwidta(String swidta) {
		this.swidta = swidta;
	}


	public void setSwircv(String swircv) {
		this.swircv = swircv;
	}


	public void setSwisnd(String swisnd) {
		this.swisnd = swisnd;
	}


	public void setSenderDetail(String senderDetail) {
		this.senderDetail = senderDetail;
	}


	public void setBeneficiaryAccount(String beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}


	public void setSwidat(LocalDate swidat) {
		this.swidat = swidat;
	}


	public void setSwitim(LocalTime switim) {
		this.switim = switim;
	}


	public void setSenderReference(String senderReference) {
		this.senderReference = senderReference;
	}


	public void setTimeIndication(String timeIndication) {
		this.timeIndication = timeIndication;
	}


	public void setBankOperationCode(String bankOperationCode) {
		this.bankOperationCode = bankOperationCode;
	}


	public void setInstructionCode(String instructionCode) {
		this.instructionCode = instructionCode;
	}


	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}


	public void setValueDateCurrencyInterbankSettledAmount(String valueDateCurrencyInterbankSettledAmount) {
		this.valueDateCurrencyInterbankSettledAmount = valueDateCurrencyInterbankSettledAmount;
	}


	public void setCurrencyInstructedAmount(String currencyInstructedAmount) {
		this.currencyInstructedAmount = currencyInstructedAmount;
	}


	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	public void setOrderingCustomer(String orderingCustomer) {
		this.orderingCustomer = orderingCustomer;
	}


	public void setSendingInstitution(String sendingInstitution) {
		this.sendingInstitution = sendingInstitution;
	}


	public void setOrderingInstitution(String orderingInstitution) {
		this.orderingInstitution = orderingInstitution;
	}


	public void setSenderCorrespondent(String senderCorrespondent) {
		this.senderCorrespondent = senderCorrespondent;
	}


	public void setReceiverCorrespondent(String receiverCorrespondent) {
		this.receiverCorrespondent = receiverCorrespondent;
	}


	public void setThirdReimbursementInstitution(String thirdReimbursementInstitution) {
		this.thirdReimbursementInstitution = thirdReimbursementInstitution;
	}


	public void setIntermediaryInstitution(String intermediaryInstitution) {
		this.intermediaryInstitution = intermediaryInstitution;
	}


	public void setAccountWithInstitution(String accountWithInstitution) {
		this.accountWithInstitution = accountWithInstitution;
	}


	public void setBeneficiaryCustomer(String beneficiaryCustomer) {
		this.beneficiaryCustomer = beneficiaryCustomer;
	}


	public void setRemittanceInformation(String remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}


	public void setDetailsOfCharges(String detailsOfCharges) {
		this.detailsOfCharges = detailsOfCharges;
	}


	public void setSenderCharges(BigDecimal senderCharges) {
		this.senderCharges = senderCharges;
	}


	public void setReceiverCharges(BigDecimal receiverCharges) {
		this.receiverCharges = receiverCharges;
	}


	public void setSenderToReceiverInformation(String senderToReceiverInformation) {
		this.senderToReceiverInformation = senderToReceiverInformation;
	}


	public void setRegulatoryReporting(String regulatoryReporting) {
		this.regulatoryReporting = regulatoryReporting;
	}


	

   
}
