package com.cg.marriageceremony.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.marriageceremony.exceptions.MarriageCeremonyApplicationException;
import com.cg.marriageceremony.exceptions.NoCatererPresentException;
import com.cg.marriageceremony.exceptions.CatererDoesNotExistException;
import com.cg.marriageceremony.exceptions.FieldCannotBeEmptyException;
import com.cg.marriageceremony.model.Caterers;
import com.cg.marriageceremony.model.Vendor;
import com.cg.marriageceremony.repository.CaterersRepository;


@Component
public class CaterersServiceImpl implements CaterersService{
	
	@Autowired
	private CaterersRepository caterersRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Caterers addCaterers(Caterers caterer) {
		try {
			if(caterer.getcDiscription() == null || caterer.getcName() == null || caterer.getImagepath() == null) {
				throw new FieldCannotBeEmptyException("Please fill every field appropriately");
			}
			return caterersRepository.save(caterer);
		}catch(FieldCannotBeEmptyException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	@Override
	public List<Caterers> allCateres() {
		
		try {
			List<Caterers> caterersList=caterersRepository.findAll();
			
			if(caterersList.isEmpty()) {
				throw new NoCatererPresentException("There in no caterers present in database");
			}
			return caterersList;
		}catch (NoCatererPresentException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Caterers> searchingByName(String catererName) {
		if(catererName != null) {
		Query query=entityManager.createQuery("select c from Caterers c where c.cName like :CC");
		query.setParameter("CC","%"+catererName+"%");
		List<Caterers> catererNameList = query.getResultList();
		if(catererNameList.size()==0) {
			String message = "Sorry !! The Caterers "+  catererName +"  is not available";
			throw new MarriageCeremonyApplicationException(message);
		}
		return catererNameList;
	}

		String message = "Sorry !! The Caterers "  + catererName +  "  is not available";
		throw new MarriageCeremonyApplicationException(message);
	}

	@Override
	@Transactional
	public int deleteVendor(int vendorId) {
		
		try {
			Optional<Caterers> caterer = caterersRepository.findById(vendorId);
			if(caterer.isEmpty()) {
				throw new CatererDoesNotExistException("Caterer does not exist with the id " + vendorId);
			}
			return caterersRepository.deleteVendor(vendorId);
		}catch(CatererDoesNotExistException exception) {
			throw exception;
		}catch(RuntimeException exception) {
			throw new RuntimeException(exception.getMessage());
		}
		
		
//		Optional<Caterers> caterer = caterersRepository.findById(vendorId);
//		
//		if(caterer.isEmpty()) {
//			throw new CatererDoesNotExistException("Caterer does not exist with the id " + vendorId);
//		
//		}
//		return caterersRepository.deleteVendor(vendorId);
	}

}
