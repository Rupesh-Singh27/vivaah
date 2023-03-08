package com.cg.marriageceremony.service;

import java.util.List;

import com.cg.marriageceremony.model.Caterers;



public interface CaterersService {
	
	Caterers addCaterers(Caterers caterer);
	
	List<Caterers> allCateres();
	
	List<Caterers> searchingByName(String catarerName);
	
	int deleteVendor(int vendorId);

}
