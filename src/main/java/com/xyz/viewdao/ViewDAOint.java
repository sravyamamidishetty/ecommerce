package com.xyz.viewdao;

import java.util.List;

import com.xyz.model.VW_PRD_SUP;


public interface ViewDAOint {
	 

	public List<VW_PRD_SUP> getAllVwXpsSupps(); 
	public List<VW_PRD_SUP> getBestPriceVwXpsSupps();
	public List<VW_PRD_SUP> getAllVwXpsSuppsByproductId(String pid);
}
