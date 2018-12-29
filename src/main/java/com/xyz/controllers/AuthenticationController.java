package com.xyz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.custdao.CustomerDAOint;
import com.xyz.dao.ProductDAOint;
import com.xyz.model.Customer;
import com.xyz.model.Product;
import com.xyz.model.VW_PRD_SUP;
import com.xyz.viewdao.ViewDAOint;


@Controller
public class AuthenticationController {
	
	@Autowired
	private ProductDAOint productDao;
	
	@Autowired 
	private ViewDAOint viewDao;
	
	@Autowired
	private CustomerDAOint customerDao;
	
	@RequestMapping("/reqSpringLoginPage")
	public String displaySpringLoginpage() {
		return "springloginpage";
	}
	
	@RequestMapping("/loginSuccess")
	public String loginSuccesPage(Model m) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String userrole = authentication.getAuthorities().toString();
		System.out.print("\nUser ID : "+ username);
		System.out.print("\nRole : "+ userrole);
		
		Customer cust = customerDao.getCustomerByUserId(username);
		System.out.print("\n customer name: "+cust.getCustname());
		m.addAttribute("customer", cust);
		
		if(userrole.contains("ROLE_ADMIN")) {
			System.out.print("\nAdmin logedin");
			return "loginsuccespage_admin";
		}
		else {
			System.out.print("\nUser logedin");
		List<VW_PRD_SUP> vw_prd_sup = viewDao.getBestPriceVwXpsSupps();
		m.addAttribute("vwprdsup",vw_prd_sup);
		return "loginsuccespage_user";
		}
	}
	
	@RequestMapping("/reqMoreSuppliers")
	public String displayMoreSuppliersofProducts(
			@RequestParam(name="pid")String pid,Model m) {
		List<VW_PRD_SUP> viewpsdata = viewDao.getAllVwXpsSuppsByproductId(pid);
		m.addAttribute("vwxps_all_sup_data", viewpsdata);
		return "moredetails_user";
	}
	
	@RequestMapping("/reqDisplayAllProductUser")
	public String displayProductpage(Model m) {
	List<Product> products = productDao.getAllProducts();
	m.addAttribute("products",products);
	return "product1";
	}
	
	
	@RequestMapping("/reqforPreviousPage")
	public String displayPrevious() {
		return "redirect:/loginSuccess";
	}
	
	

	@RequestMapping("/reqLogout")
	public String Logout() {
		return "redirect:/reqSpringLoginPage";
	}
	
	
}
