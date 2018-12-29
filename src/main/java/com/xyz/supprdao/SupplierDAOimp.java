package com.xyz.supprdao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.model.Product;
import com.xyz.model.Supplier;

@Repository
public class SupplierDAOimp implements SupplierDAOint {
	
	@Autowired
	private SessionFactory sf;

	public List<Supplier> getAllSuppliers() {
	
		List<Supplier> data;
		Session session = sf.openSession();
		Query qr =session.createQuery(" from Supplier");
		data=qr.list();
		session.close();
		return data;
		
	}

	private String generateSupplierId(){
		String newsuppid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from Supplier");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) {
		//String result=null;
		Session ses = sf.openSession();
		Query qr = ses.createQuery(" select max(supplierid) from Supplier");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId=data.get(0);
		int suppid=Integer.parseInt(existingMaxId.substring(3));
		suppid++;
		
		if(suppid<=9) {
			newsuppid="SUP0000"+suppid;
		}
		else if(suppid<=99) {
			newsuppid="SUP000"+suppid;
		}
		else if(suppid<=999) {
			newsuppid="SUP00"+suppid;
		}
		else if(suppid<=9999) {
			newsuppid="SUP0"+suppid;
		}
		else  {
			newsuppid="SUP"+suppid;
		}
		}
		else {
			newsuppid="SUP00001";
		}
		return newsuppid;
	}
	
	private void saveSupplierImage(Supplier supObj) {
		try {
			if(supObj.getImagefile()!=null) {
				Path path = Paths.get("F:\\new-project\\testsite\\src\\main\\webapp\\resources\\images\\suppliers\\"+supObj.getSupplierid()+".jpg");
			supObj.getImagefile().transferTo(new File(path.toString()));
			}
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}
	
	public boolean addSupplier(Supplier supplierObj) {
		boolean result=false;
		try {
		supplierObj.setSupplierid(generateSupplierId());
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(supplierObj);
		session.getTransaction().commit();
		saveSupplierImage(supplierObj);
		session.close();
		result=true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	

	public Supplier getSupplierbyId(String supplierid){
		Supplier result = null;
		Session session = sf.openSession();
		result = session.get(Supplier.class,supplierid);
		session.close();
		return result;
	}

		public boolean updateSupplier(Supplier s) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(s);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		

		public boolean deleteSupplier(String supplierid) {
			Session session =sf.openSession();
			Supplier sup = session.get(Supplier.class,supplierid);
			session.beginTransaction();
			session.delete(sup);
			session.getTransaction().commit();
			session.close();
			return true;
		
		}
}
