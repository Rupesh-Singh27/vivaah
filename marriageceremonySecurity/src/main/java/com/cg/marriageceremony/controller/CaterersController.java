package com.cg.marriageceremony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.marriageceremony.model.Caterers;
import com.cg.marriageceremony.service.CaterersService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/marriageceremony")
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class CaterersController {
	
	@Autowired
	private CaterersService caterersService;
	
	@PostMapping("caterer/addCaterer")
	public  Caterers addCateres(@RequestBody  Caterers catarer) {
		Caterers caterers=caterersService.addCaterers(catarer);
				return caterers;
	}
	
	@GetMapping("caterer/getAllCaterers")
	public List<Caterers> allCateres(){
		return caterersService.allCateres();
	}
	
    @GetMapping("caterer/searchByCatererName")
    public List<Caterers> searchingByName(@RequestParam("cName") String catererName){
    	return caterersService.searchingByName(catererName);
    }
	
    @DeleteMapping("caterer/deleteCaterer/{vendorId}")
    public int deleteVendor(@PathVariable("vendorId") int vendorId) {
    	return caterersService.deleteVendor(vendorId);
    }
}