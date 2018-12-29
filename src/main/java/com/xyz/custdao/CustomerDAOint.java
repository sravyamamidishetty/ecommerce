package com.xyz.custdao;

import com.xyz.model.Customer;

public interface CustomerDAOint {
	public String generateCustId();
	public String generateUserId();
	public String generateShippingAddressId();
	public String generateBillingAddressId();
	public String generateCartid();

	public String addCustomer(Customer cust);
	public Customer getCustomerByUserId(String uid);
	}

