package com.galaxe.services;

import java.util.List;

import com.galaxe.model.Mobiles;


public interface mobileServices {

	public List<Mobiles> getAllMobiles();

	public Mobiles saveMobilePhone(Mobiles mobiles);

	public Mobiles findMobilePhoneById(long id);

	public List<Mobiles> findMobilePhoneByBrandName(String brandName);

	public List<Mobiles> findMobilePhoneByModelName(String modelName);

	public Mobiles editMobilephones(Mobiles mobilePhone);

	public String deleteMobilePhoneById(long id);

	public List<Mobiles> findMobilePhoneByCost(double cost);

	public List<Mobiles> findMobilePhoneByProcessor(String processor);

	public List<Mobiles> findMobilePhoneByColor(String color);
	
	public List<Mobiles> findMobilePhoneByCostGreater(double cost);

	public int getMobilePhones(String modelName);

	public boolean isProductExists(long id);

	public int getMobilePhonesByCount(String modelName);

	Mobiles findEmployeeById(long id);
    
	// public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long
	// MobilePhoneListId);

	// public MobilePhoneList addMobilePhoneToList(MobilePhone mobilePhone,
	// MobilePhoneList mobilePhoneList);
}
