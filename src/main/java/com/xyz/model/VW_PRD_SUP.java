package com.xyz.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_PRD_SUP {

	
	private String productid;
	private String productname;
	private String productdescription;
	private boolean isproductavailable;
	private String supplierid;
	private String suppliername;
	private String supplierdescription;
	private boolean issupplieravailable;
	
	@Id
	private String xpsid;
	private int xpsprice;
	private int xpsstock;
	private String isxpsavailable;
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
	public String getXpsid() {
		return xpsid;
	}
	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}
	
	public int getXpsprice() {
		return xpsprice;
	}
	public void setXpsprice(int xpsprice) {
		this.xpsprice = xpsprice;
	}
	public int getXpsstock() {
		return xpsstock;
	}
	public void setXpsstock(int xpsstock) {
		this.xpsstock = xpsstock;
	}
	public String getIsxpsavailable() {
		return isxpsavailable;
	}
	public void setIsxpsavailable(String isxpsavailable) {
		this.isxpsavailable = isxpsavailable;
	}
	
	
}
