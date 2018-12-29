package com.xyz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier {

	@Id
	private String supplierid;
	private String suppliername;
	private String supplierdescription;
	private boolean issupplieravailable;
	
	@Transient
	private MultipartFile imagefile;
	
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierdescription() {
		return supplierdescription;
	}
	public void setSupplierdescription(String supplierdescription) {
		this.supplierdescription = supplierdescription;
	}
	public boolean isIssupplieravailable() {
		return issupplieravailable;
	}
	public void setIssupplieravailable(boolean issupplieravailable) {
		this.issupplieravailable = issupplieravailable;
	}
	
	
}
