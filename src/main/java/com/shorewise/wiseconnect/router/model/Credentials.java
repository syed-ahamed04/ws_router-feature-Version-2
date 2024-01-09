package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Credentials {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Password")
    private String password;

    @XmlElement(name = "Certificate")
    private String certificate;

    @XmlElement(name = "Digest")
    private String digest;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getCertificate() {
		return certificate;
	}

	public String getDigest() {
		return digest;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

    
}
