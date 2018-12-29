package com.xyz.custdao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.model.Customer;
import com.xyz.model.Product;
import com.xyz.model.UserDetails;

@Repository
public class CustomerDAOimp implements CustomerDAOint {

	@Autowired
	private SessionFactory sf;

	public String generateCustId() {
		String newcustid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from Customer");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(customerid) from Customer");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int custid = Integer.parseInt(existingMaxId.substring(4));
		custid++;
		if (custid <= 9) {
			newcustid = "CUST0000" + custid;
		} else if (custid <= 99) {
			newcustid = "CUST000" + custid;
		} else if (custid <= 999) {
			newcustid = "CUST00" + custid;
		} else if (custid <= 9999) {
			newcustid = "CUST0" + custid;
		} else {
			newcustid = "CUST" + custid;
		}
		}
		else {
			newcustid="CUST00001";
		}
		return newcustid;
	}

	public String generateUserId() {
		String newuserid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from UserDetails");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(userid) from UserDetails");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int userid = Integer.parseInt(existingMaxId.substring(2));
		userid++;
		if (userid <= 9) {
			newuserid = "US0000" + userid;
		} else if (userid <= 99) {
			newuserid = "US000" + userid;
		} else if (userid <= 999) {
			newuserid = "US00" + userid;
		} else if (userid <= 9999) {
			newuserid = "US0" + userid;
		} else {
			newuserid = "US" + userid;
		}
		}
		else {
			newuserid="US00001";
		}
		return newuserid;
	}

	public String generateShippingAddressId() {
		String newsaddid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from ShippingAddress");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(shippingaddressid) from ShippingAddress");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int saddid = Integer.parseInt(existingMaxId.substring(4));
		saddid++;
		if (saddid <= 9) {
			newsaddid = "SADD0000" + saddid;
		} else if (saddid <= 99) {
			newsaddid = "SADD000" + saddid;
		} else if (saddid <= 999) {
			newsaddid = "SADD00" + saddid;
		} else if (saddid <= 9999) {
			newsaddid = "SADD0" + saddid;
		} else {
			newsaddid = "SADD" + saddid;
		}
		}
		else {
			newsaddid="SADD00001";
		}
		return newsaddid;
	}

	public String generateBillingAddressId() {
		String newbaddid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from BillingAddress");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(billingaddressid) from BillingAddress");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int baddid = Integer.parseInt(existingMaxId.substring(4));
		baddid++;
		if (baddid <= 9) {
			newbaddid = "BADD0000" + baddid;
		} else if (baddid <= 99) {
			newbaddid = "BADD000" + baddid;
		} else if (baddid <= 999) {
			newbaddid = "BADD00" + baddid;
		} else if (baddid <= 9999) {
			newbaddid = "BADD0" + baddid;
		} else {
			newbaddid = "BADD" + baddid;
		}
		}
		else {
			newbaddid="BADD00001";
		}
		return newbaddid;
	}

	public String generateCartid() {
		String newcartid=null;
		Session session = sf.openSession();
		Query qry = session.createQuery(" from Cart");
		int nor=qry.list().size();
		session.close();
		
		if(nor>0) { //if table is empty
		Session ses = sf.openSession();
		Query qr = ses.createQuery("select max(cartid) from Cart");
		List<String> data = qr.list();
		ses.close();
		String existingMaxId = data.get(0);
		int cartid = Integer.parseInt(existingMaxId.substring(4));
		cartid++;
		if (cartid <= 9) {
			newcartid = "CART0000" + cartid;
		} else if (cartid <= 99) {
			newcartid = "CART000" + cartid;
		} else if (cartid <= 999) {
			newcartid = "CART00" + cartid;
		} else if (cartid <= 9999) {
			newcartid = "CART0" + cartid;
		} else {
			newcartid = "CART" + cartid;
		}
		}
		else {
			newcartid="CART00001";
		}
		return newcartid;
	}
	
	private void saveCustomerImage(Customer cust) {
		try {
			if(cust.getImagefile()!=null) {
				Path path = Paths.get("F:\\new-project\\testsite\\src\\main\\webapp\\resources\\images\\customers\\"+cust.getCustomerid()+".jpg");
			cust.getImagefile().transferTo(new File(path.toString()));
			}
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}

	public String addCustomer(Customer cust) {
		String userid=null;
		cust.setCustomerid(generateCustId());
		cust.getUserDetails().setUserid(generateUserId());
		cust.getShippingAddress().setShippingaddressid(generateShippingAddressId());
		cust.getBillingAddress().setBillingaddressid(generateBillingAddressId());
		cust.getCart().setCartid(generateCartid());
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(cust);
		session.getTransaction().commit();
		session.close();
		saveCustomerImage(cust);
		userid=cust.getUserDetails().getUserid();
		return userid;
		
	}

	public Customer getCustomerByUserId(String uid) {
		
		Session session =sf.openSession();
		UserDetails ud = session.get(UserDetails.class, uid);
		session.close();
		return ud.getCustomer();
	}
	

}
