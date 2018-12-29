package com.xyz.dao;

import java.util.List;

import com.xyz.model.Product;

public interface ProductDAOint {
	
	public abstract List<Product> getAllProducts();

	public abstract boolean addproduct(Product p);
	
	public abstract Product getProductbyId(String pid);
	
	public abstract boolean updateProduct(Product p);
	
	public abstract boolean deleteProduct(String pid);
		
}
