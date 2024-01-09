package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestHeader {

    @XmlElement(name = "Service")
    private String service;

    @XmlElement(name = "Operation")
    private String operation;

    @XmlElement(name = "ReplyFormat")
    private String replyFormat;

    @XmlElement(name = "SourceSystem")
    private String sourceSystem;

    @XmlElement(name = "NoRepair")
    private String noRepair;

    @XmlElement(name = "NoOverride")
    private String noOverride;

    @XmlElement(name = "CorrelationId")
    private String correlationId;

    @XmlElement(name = "TransactionControl")
    private String transactionControl;

	public String getService() {
		return service;
	}

	public String getOperation() {
		return operation;
	}

	public String getReplyFormat() {
		return replyFormat;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public String getNoRepair() {
		return noRepair;
	}

	public String getNoOverride() {
		return noOverride;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public String getTransactionControl() {
		return transactionControl;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setReplyFormat(String replyFormat) {
		this.replyFormat = replyFormat;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public void setNoRepair(String noRepair) {
		this.noRepair = noRepair;
	}

	public void setNoOverride(String noOverride) {
		this.noOverride = noOverride;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public void setTransactionControl(String transactionControl) {
		this.transactionControl = transactionControl;
	}

	 @XmlElement(name = "Credentials")
	    private Credentials credentials;
}
