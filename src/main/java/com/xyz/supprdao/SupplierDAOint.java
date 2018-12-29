package com.xyz.supprdao;

import java.util.List;

import com.xyz.model.Supplier;

public interface SupplierDAOint {
	
	public  abstract List<Supplier> getAllSuppliers();

	public  abstract boolean addSupplier(Supplier supplierObj);
	
	public abstract Supplier getSupplierbyId(String supplierid);
	
	public abstract boolean updateSupplier(Supplier s);
	
	public abstract boolean deleteSupplier(String suppid);
}
