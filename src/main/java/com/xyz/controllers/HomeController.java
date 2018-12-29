package com.xyz.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.xyz.dao.ProductDAOint;
import com.xyz.model.Product;


@Controller
public class HomeController {
	
	@Autowired
	private ProductDAOint productDao;
	
	
	@RequestMapping(value= {"/","/reqHomePage"})
	public String displayHomepage(Model m) {
		/*m.addAttribute("data","Hi, Sravya!!!");
		return "homepage";*/
		return "home";
		
	}
	
	
	// for html
	@RequestMapping("/reqAdminSendProductDataToDB")
	public String addProduct(
			@RequestParam(name="productname")String pname,
			@RequestParam(name="productdescription")String pdesc) {
		
		Product p = new Product();
		p.setProductname(pname);
		p.setProductdescription(pdesc);
		p.setIsproductavailable(true);
		productDao.addproduct(p);
		return "redirect:/reqAdminProductPage";
	}

	
}
