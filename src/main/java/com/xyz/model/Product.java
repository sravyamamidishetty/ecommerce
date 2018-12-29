package com.xyz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	private String productid;
	private String productname;
	private String productdescription;
	private boolean isproductavailable;
	
	@Transient	 //only for model will not effect in DB
	private MultipartFile imagefile;
	
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public boolean isIsproductavailable() {
		return isproductavailable;
	}
	public void setIsproductavailable(boolean isproductavailable) {
		this.isproductavailable = isproductavailable;
	}
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	
	
}
