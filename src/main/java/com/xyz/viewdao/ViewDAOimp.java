package com.xyz.viewdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.model.Product;
import com.xyz.model.VW_PRD_SUP;


@Repository
public class ViewDAOimp implements ViewDAOint {

	@Autowired
	private SessionFactory sf;
	
	public List<VW_PRD_SUP> getAllVwXpsSupps() {
		List<VW_PRD_SUP> data;
		Session session = sf.openSession();
		Query qr= session.createQuery("from VW_PRD_SUP");
		data= qr.list();
		session.close();
		return null;
	}

	public List<VW_PRD_SUP> getBestPriceVwXpsSupps() {
		
		Session session = sf.openSession();
		String qry="from VW_PRD_SUP v1 where  xpsprice=(select min(xpsprice) from VW_PRD_SUP v2 where v1.productid=v2.productid)";
		Query qr = session.createQuery(qry);
		System.out.print(qry);
		List<VW_PRD_SUP> data = qr.list();
		session.close();
		return data;
	}
	

	public List<VW_PRD_SUP> getAllVwXpsSuppsByproductId(String pid) {
		Session session= sf.openSession();
		String qry="from VW_PRD_SUP where productid='"+ pid +"'";
		Query qr = session.createQuery(qry);
		List<VW_PRD_SUP> data = qr.list();
		session.close();
		return data;
	}
	
	
}

	
	