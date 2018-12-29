package com.xyz.dao;

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

@Repository
public class ProductDAOimp implements ProductDAOint {
	@Autowired
	private SessionFactory sf;

	public List<Product> getAllProducts() {
		List<Product> data;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from Product");
		data = qry.list();
		session.close();
		return data;
	}

	private String generateProductId(){
		String newpdid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from Product");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(productid) from Product");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int pdid = Integer.parseInt(existingMaxId.substring(2));
		pdid++;
		if (pdid <= 9) {
			newpdid = "PR0000" + pdid;
		} else if (pdid <= 99) {
			newpdid = "PR000" + pdid;
		} else if (pdid <= 999) {
			newpdid = "PR00" + pdid;
		} else if (pdid <= 9999) {
			newpdid = "PR0" + pdid;
		} else {
			newpdid = "PR" + pdid;
		}
		}
		else {
			newpdid="PR00001";
		}
		return newpdid;
	}
	
	private void saveProductImage(Product prd) {
		try {
			if(prd.getImagefile()!=null) {
				Path path = Paths.get("F:\\new-project\\testsite\\src\\main\\webapp\\resources\\images\\products\\"+prd.getProductid()+".jpg");
			prd.getImagefile().transferTo(new File(path.toString()));
			}
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}
		public boolean addproduct(Product p) {
		boolean result=false;
		try {
		p.setProductid(generateProductId());
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		saveProductImage(p);
		session.close();
		result=true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}

	public Product getProductbyId(String productid) {
		Product result=null;
		Session session = sf.openSession();
		result =session.get(Product.class,productid);
		session.close();
		return result;
	}

	public boolean updateProduct(Product p) {
		
		Session session =sf.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean deleteProduct(String productid) {
		Session session =sf.openSession();
		Product prd = session.get(Product.class,productid);
		session.beginTransaction();
		session.delete(prd);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	}

	

	
	


