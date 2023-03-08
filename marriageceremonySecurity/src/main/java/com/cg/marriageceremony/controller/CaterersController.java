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
	
	@ApiOperation("Add caterer in database")
	@PostMapping("caterer/addCaterer")
	public  Caterers addCateres(@RequestBody  Caterers catarer) {
		Caterers caterers=caterersService.addCaterers(catarer);
				return caterers;
	}
	
	@ApiOperation("Get caterers in database")
	@GetMapping("caterer/getAllCaterers")
	public List<Caterers> allCateres(){
		return caterersService.allCateres();
	}
	
	@ApiOperation("Search caterer in database by caterer name")
    @GetMapping("caterer/searchByCatererName")
    public List<Caterers> searchingByName(@RequestParam("cName") String catererName){
    	return caterersService.searchingByName(catererName);
    }
	
	@ApiOperation("Delete caterers in database")
    @DeleteMapping("caterer/deleteCaterer/{vendorId}")
    public int deleteVendor(@PathVariable("vendorId") int vendorId) {
    	return caterersService.deleteVendor(vendorId);
    }
}