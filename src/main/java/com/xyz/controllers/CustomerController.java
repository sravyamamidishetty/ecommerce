package com.xyz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.model.ShippingAddress;
import com.xyz.custdao.CustomerDAOint;
import com.xyz.model.BillingAddress;
import com.xyz.model.Cart;
import com.xyz.model.Customer;
import com.xyz.model.UserDetails;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDAOint customerDao;
	
	@RequestMapping("/reqSignUpPage")
	public String displaySignUppage(Model m) {
		//create a customer object and attach the same to customer
		Customer cust = new Customer();
		cust.setUserDetails(new UserDetails());
		cust.setShippingAddress(new ShippingAddress());
		cust.setBillingAddress(new BillingAddress());
		cust.setCart(new Cart());
		m.addAttribute("customer",cust);
		return "signuppage";
		
	}
	
	@RequestMapping("/reqSignUpDataToDB")
	public String addProductToDB(@ModelAttribute("customer")Customer cust,Model m) {
		
		
		cust.getUserDetails().setRole("ROLE_USER");
		cust.getUserDetails().setEnabled(true);
		
		cust.getBillingAddress().setHouseno(cust.getShippingAddress().getHouseno());
		cust.getBillingAddress().setArea(cust.getShippingAddress().getArea());
		cust.getBillingAddress().setStreet(cust.getShippingAddress().getStreet());
		cust.getBillingAddress().setCity(cust.getShippingAddress().getCity());
		cust.getBillingAddress().setState(cust.getShippingAddress().getState());
		cust.getBillingAddress().setCountry(cust.getShippingAddress().getCountry());
		cust.getBillingAddress().setPincode(cust.getShippingAddress().getPincode());
		
		
		String userid=null;
	
		userid=customerDao.addCustomer(cust);
		if(userid!=null) {
			m.addAttribute("userid",userid);
			return "loginpage";
		}
		else {
			return "redirect:/reqSignUpPage";
		}
		
	}
}
