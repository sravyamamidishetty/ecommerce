package com.xyz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.dao.ProductDAOint;
import com.xyz.model.Product;
import com.xyz.model.Supplier;
import com.xyz.supprdao.SupplierDAOint;

@Controller
public class AdminController {
	
	@Autowired
	private ProductDAOint productDao;
	
	@Autowired
	private SupplierDAOint supplierDao;
	
	@RequestMapping("/reqAdminProductPage")
	public String displayAdminProductpage(Model m) {
	List<Product> products = productDao.getAllProducts();
	m.addAttribute("products",products);
	
	Product prd = new Product();
	m.addAttribute("productObject",prd);
	return "productpage_admin";
	}
		
	//method for spring
	@RequestMapping("/reqAdminSendProductDataToDB1")
	public String addAdminProductToDBSpring(@ModelAttribute("productObject")Product prd) {
		prd.setIsproductavailable(true);
		productDao.addproduct(prd);
		return "redirect:/reqAdminProductPage";
	}
	
	@RequestMapping("/reqAdminEditProductPage")
	public String displayAdminProductEditPage(@RequestParam(name="productid")String pid,Model m) {
	
		Product prd =productDao.getProductbyId(pid);
		System.out.println(prd);
		m.addAttribute("product", prd);
		return "editproduct_admin";
	}
	
	
	@RequestMapping("/reqAdminUpdateproduct")
	public String adminProductUpdate(@ModelAttribute("product")Product p) {
		productDao.updateProduct(p);
		return "redirect:/reqAdminProductPage";
	}
	
	@RequestMapping("/reqAdminDeleteProductPage")
	public String adminProductDelete(@RequestParam(name="productid")String pid) {
		productDao.deleteProduct(pid);
		return "redirect:/reqAdminProductPage";
	}

	//Admin for supplier
	
	@RequestMapping("/reqAdminSupplierPage")
	public String displayAdminSupplierPage(Model m) {
		List<Supplier> supObj = supplierDao.getAllSuppliers();
		m.addAttribute("suppliers",supObj);
		
		Supplier sup = new Supplier();
		m.addAttribute("supplierObj",sup);
		return "supplierpage_admin";
	}
	
	@RequestMapping("/reqAdminSpringSupplierDataTtoDB")
	public String addAdminSupplierToDB(@ModelAttribute("supplerObj")Supplier sup) {
		sup.setIssupplieravailable(true);
		supplierDao.addSupplier(sup);
		return "redirect:/reqAdminSupplierPage";
	}
	
	@RequestMapping("/reqAdminSupplierEditPage")
	public String displayAdminSupplierEditPage(@RequestParam(name="supplierid")String suppid,Model m) {
		Supplier supp = supplierDao.getSupplierbyId(suppid);
		System.out.println(supp);
		m.addAttribute("supplier",supp);
		return "editsupplier_admin";
	}
	
	@RequestMapping("/reqAdminUpdateSupplier")
	public String adminUpdateSupplier(@ModelAttribute("supplier")Supplier supp) {
		supplierDao.updateSupplier(supp);
		return "redirect:/reqAdminSupplierPage";
	}
	
	@RequestMapping("/reqAdminSupplierDelete")
	public String adminSupplierDelete(@RequestParam(name="supplierid")String suppid) {
		supplierDao.deleteSupplier(suppid);
		return "redirect:/reqAdminSupplierPage";
	}
}
