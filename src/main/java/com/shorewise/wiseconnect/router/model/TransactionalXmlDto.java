package com.shorewise.wiseconnect.router.model;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Add this annotation to specify the root element for XML
public class TransactionalXmlDto  {

  	private String id;
    private String ti_request;
    private String ti_response;
    private String operation_type;
    private String customer_id;
    private String status;
    private String master_ref;
    private String event_ref;
    private String createdUser;
	private String updatedUser;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public void setId(String id) {
  		this.id = id;
  	}
    
    public void setTi_response(String ti_response) {
		this.ti_response = ti_response;
	}
    
    public void setTi_request(String ti_request) {
		this.ti_request = ti_request;
	}
    
	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public void setStatus(String status) {
  		this.status = status;
  	}
	
	public void setMaster_ref(String master_ref) {
		this.master_ref = master_ref;
	}

	public void setEvent_ref(String event_ref) {
		this.event_ref = event_ref;
	}

  	public void setCreatedUser(String createdUser) {
  		this.createdUser = createdUser;
  	}

  	public void setUpdatedUser(String updatedUser) {
  		this.updatedUser = updatedUser;
  	}

  	public void setCreatedAt(Timestamp createdAt) {
  		this.createdAt = createdAt;
  	}

  	public void setUpdatedAt(Timestamp updatedAt) {
  		this.updatedAt = updatedAt;
  	}

    // Add JAXB annotations to the getter methods
    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public String getTi_request() {
		return ti_request;
	}

	@XmlElement
	public String getTi_response() {
		return ti_response;
	}
	
    @XmlElement
    public String getOperation_type() {
		return operation_type;
	}
    
    @XmlElement
	public String getCustomer_id() {
		return customer_id;
	}

	@XmlElement
    public String getStatus() {
        return status;
    }

    @XmlElement
	public String getEvent_ref() {
		return event_ref;
	}
    
    @XmlElement
	public String getMaster_ref() {
		return master_ref;
	}
    
    @XmlElement
    public String getCreatedUser() {
        return createdUser;
    }

    @XmlElement
    public String getUpdatedUser() {
        return updatedUser;
    }

    @XmlElement
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @XmlElement
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    
}
