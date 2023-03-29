package com.galaxe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.galaxe.controller.mobileController;
import com.galaxe.dao.mobileDAO;
import com.galaxe.model.Mobiles;

@Service
public class mobileServiceImpl implements mobileServices {

	public mobileServiceImpl() {

	}
	

	@Autowired
	Mobiles mobiles;

	@Autowired
	mobileDAO mobiledao;

	@Override
	public List<Mobiles> getAllMobiles() {
		System.out.println("get all mobiles called");
		return (List<Mobiles>) mobiledao.findAll();
	}

	@Override
	public Mobiles saveMobilePhone(Mobiles mobilePhone) {

		
		return mobiledao.save(mobilePhone);
	}

	@Override
	public Mobiles findEmployeeById(long id) {
		Optional<Mobiles> mo = mobiledao.findById(id);
		return mo.get();
	}
	
	

	@Override
	public List<Mobiles> findMobilePhoneByModelName(String modelName) {

		return mobiledao.findByModelName(modelName);
	}
	
	@Override
	public List<Mobiles> findMobilePhoneByBrandName(String brandName) {
		
		return mobiledao.findByBrandName(brandName);
	}
	
   @Override
   public List<Mobiles> findMobilePhoneByCost(double cost) {
		
		return mobiledao.findByCost(cost);
	}
   
   @Override
   public List<Mobiles> findMobilePhoneByColor(String color) {
		
		return mobiledao.findByColor(color);
	}
   
   public List<Mobiles> findMobilePhoneByProcessor(String processor) {
		// TODO Auto-generated method stub
		return  mobiledao.findByProcessor(processor);
	}
   
   
   public List<Mobiles> findMobilePhoneByCostGreater(double cost) {
		// TODO Auto-generated method stub
		return  mobiledao.findByCostGreaterThan(cost);
	}

	@Override
	public Mobiles editMobilephones(Mobiles mobiles) {
		// TODO Auto-generated method stub
		return mobiledao.save(mobiles);
	}

	@Override
	public String deleteMobilePhoneById(long id) {
		mobiledao.deleteById(id);
		return "Delete success";
	}
//
//	@Override
//	public Mobiles getMobilePhone(double cost) {
//		Optional<Mobiles> mob = mobiledao.findByCost(cost);
//		return mob.get();
//	}

//	@Override
//	public List<Mobiles> getByProcessor(String processor) {
//		// TODO Auto-generated method stub
//		return mobiledao.findByProcessor(processor);
//	}
//
//	@Override
//	public List<Mobiles> getByColor(String color) {
//
//		return mobiledao.findByColor(color);
//	}

//	@Override
//	public int getMobilePhones(String modelName) {
//
//		return mobiledao.countByName(modelName);
//	}

	@Override
	public boolean isProductExists(long id) {
		Optional<Mobiles> mob = mobiledao.findById(id);
		
		return mob.isPresent();
	}

//	@Override
//	public List<Mobiles> getMobilePhoneByBrandName(String brandName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getMobilePhonesByCount(String modelName) {
		return mobiledao.countByModelName(modelName);
	}
	
	

	

	
	@Override
	public int getMobilePhones(String modelName) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public String deleteMobilePhoneById(long id) {
//		mobiledao.deleteById(id);
//		return "deleted";
//	}

	

}
