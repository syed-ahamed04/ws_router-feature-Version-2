package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name = "ServiceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceRequest {

    @XmlElement(name = "RequestHeader")
    private RequestHeader requestHeader;
    
    @XmlElement(name = "TFILCAMN", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCAMN tfilcamn;
    
    
    @XmlElement(name = "TFILCCOR", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCAMN tfilccor;
    
    @XmlElement(name = "TFSHGAPP", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCAMN tfshgapp;
    
    
	public TFILCAMN getTfshgapp() {
		return tfshgapp;
	}

	public void setTfshgapp(TFILCAMN tfshgapp) {
		this.tfshgapp = tfshgapp;
	}

	public TFILCAMN getTfilccor() {
		return tfilccor;
	}

	public void setTfilccor(TFILCAMN tfilccor) {
		this.tfilccor = tfilccor;
	}

	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	public TFILCAMN getTfilcamn() {
		return tfilcamn;
	}

	public void setTfilcamn(TFILCAMN tfilcamn) {
		this.tfilcamn = tfilcamn;
	}

	

    // Getters and setters
}
