package com.galaxe.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.galaxe.model.Mobiles;




@Component
public interface mobileDAO extends PagingAndSortingRepository<Mobiles, Long>{
	
//	public List<Mobiles> findByModelName(String modelName);
//	public List<Mobiles> findByBrandName(String brandName);
//	public Optional<Mobiles> findByCost(double cost);
//	public List<Mobiles> findByColor(String color);
//	public List<Mobiles> findByCost(int min);
//	public List<Mobiles> findByProcessor(String processor);
//	public Mobiles deleteById(long id);
//	public int countByName(String modelName);
	public List<Mobiles> findByModelName(String modelName);
	public List<Mobiles> findByBrandName(String brandName);
	public List<Mobiles> findByCost(double cost);
	public List<Mobiles> findByColor(String color);
	public List<Mobiles> findByProcessor(String processor);
	public List<Mobiles> findByCostGreaterThan(double cost);
	public int countByModelName(String modelName);
}
