package com.xyz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.model.Product;
import com.xyz.model.Supplier;
import com.xyz.supprdao.SupplierDAOint;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAOint supplierDao;
	
	@RequestMapping("/reqSupplierPage")
	public String displaySsupplierpage(Model m) {
		List<Supplier> supplier = supplierDao.getAllSuppliers();
		m.addAttribute("suppliers",supplier);
		
		Supplier supObj = new Supplier();
		m.addAttribute("supplierObject",supObj);
		return "supplierpage";
	}
	
	@RequestMapping("/reqSupplierDataTtoDB")
	public String addSupplier(
			@RequestParam(name="suppliername")String supname,
			@RequestParam(name="supplierdescription")String supdesc) {
		
		Supplier supplierObj = new Supplier();
		supplierObj.setSuppliername(supname);
		supplierObj.setSupplierdescription(supdesc);
		supplierObj.setIssupplieravailable(true);
		
		supplierDao.addSupplier(supplierObj);
		return "redirect:/reqSupplierPage";
		
	}
	@RequestMapping("/reqSpringSupplierDataTtoDB")
	public String addSupplierSpringToDB(@ModelAttribute("supplierObject")Supplier supObj) {
		supObj.setIssupplieravailable(true);
		supplierDao.addSupplier(supObj);
		return "redirect:/reqSupplierPage";
		
	}
	
	
}
