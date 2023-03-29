package com.galaxe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.controller.converter.MobilesConverter;
import com.galaxe.controller.dto.MobilesDto;
import com.galaxe.dao.mobileDAO;
import com.galaxe.model.Mobiles;
import com.galaxe.services.mobileServices;


@RestController
@RequestMapping("mobiles")
public class mobileController {

	@Autowired
	mobileDAO mobiledao;

	@Autowired
	Mobiles mobiles;

	
	@Autowired
	mobileServices mobileservices;

	@Autowired
	MobilesConverter mobilesConverter;
	
	

	@GetMapping // http://localhost:9090/mobiles
	public List<Mobiles> getAllMobiles() {

		return (List<Mobiles>) mobileservices.getAllMobiles();
	}

	@PostMapping // http://localhost:9090/mobiles/ - POST - BODY
	public ResponseEntity<String> saveMobilePhone(@RequestBody Mobiles mobiles) {
		ResponseEntity<String> responseEntity;
		if (mobileservices.isProductExists(mobiles.getId())) {
			responseEntity = new ResponseEntity<String>("product already exists", HttpStatus.CONFLICT);
		} else {
			Mobiles message = mobileservices.saveMobilePhone(mobiles);
			if (message.equals("product saved succesfully..you are geneious")) {
				responseEntity = new ResponseEntity<String>(HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
			}

		}

		return responseEntity;

	}

	@GetMapping("{id}") // http://localhost:9090/mobiles/198
	public ResponseEntity<Mobiles> getMobilePhoneById(@PathVariable("id") long id) {

		ResponseEntity<Mobiles> responseEntity;
		if (mobileservices.isProductExists(id)){
			 mobiles = mobileservices.findMobilePhoneById(id);

			responseEntity = new ResponseEntity<Mobiles>(mobiles, HttpStatus.OK); // 201
		} else {
			responseEntity = new ResponseEntity<Mobiles>(mobiles, HttpStatus.NO_CONTENT); // 201
		}
		return responseEntity;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteMobilePhoneById(@PathVariable("id") long id){
		ResponseEntity<String> responseEntity;
		
		if(mobileservices.isProductExists(id)) {
			mobileservices.deleteMobilePhoneById(id);
			responseEntity = new ResponseEntity<String>("Delete success", HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<String>("", HttpStatus.NO_CONTENT); // 201
		}
		return responseEntity;
	}
	
	@PutMapping // http://localhost:8080/product/ - PUT - BODY
	public Mobiles editMobilephone( @RequestBody Mobiles mobiles) {
		
		return mobileservices.editMobilephones(mobiles);
		
	}
	
	@GetMapping("searchByBrandName/{brandName}")//http://localhost:9090/searchByBrandName/apple
	public ResponseEntity<List<Mobiles>> getMobilePhoneByBrandName(@PathVariable("brandName") String brandname){
		
		ResponseEntity<List<Mobiles>> responseEntity;
		
		List<Mobiles> mobiles = mobileservices.findMobilePhoneByBrandName(brandname);
		if (mobiles.size() == 0) {
			responseEntity = new ResponseEntity<List<Mobiles>>(mobiles, HttpStatus.NO_CONTENT); // 201
		} else {

			responseEntity = new ResponseEntity<List<Mobiles>>(mobiles, HttpStatus.OK); // 200

		}
		return responseEntity;
		
	}
	
	@GetMapping("searchByModelname/{modelName}")
	public ResponseEntity<List<Mobiles>> getMobilePhoneByModelName(@PathVariable("modelName") String modelname){
		
		ResponseEntity<List<Mobiles>> resposeEntity;
		List<Mobiles> mobiles =mobileservices.findMobilePhoneByModelName(modelname);
		if(mobiles.size()==0)
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
		}
		else
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	
	@GetMapping("searchByCostGreaterThan/{cost}")
	public ResponseEntity<List<Mobiles>> getMobilePhoneByCostGreater(@PathVariable("cost") long cost){
		
		ResponseEntity<List<Mobiles>> resposeEntity;
		List<Mobiles> mobiles =mobileservices.findMobilePhoneByCostGreater(cost);
		if(mobiles.size()==0)
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
		}
		else
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	
	@GetMapping("searchByProcessor/{processor}")
	public ResponseEntity<List<Mobiles>> getByProcessor(@PathVariable("processor") String processor){
		
		ResponseEntity<List<Mobiles>> resposeEntity;
		List<Mobiles> mobiles =mobileservices.findMobilePhoneByProcessor(processor);
		if(mobiles.size()==0)
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
		}
		else
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	
	@GetMapping("searchByCost/{cost}")
	public ResponseEntity<List<Mobiles>> getMobilePhoneByModelName(@PathVariable("cost") long cost){
		
		ResponseEntity<List<Mobiles>> resposeEntity;
		List<Mobiles> mobiles =mobileservices.findMobilePhoneByCost(cost);
		if(mobiles.size()==0)
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
		}
		else
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	
	@GetMapping("searchByColor/{color}")
	public ResponseEntity<List<Mobiles>> getByColor(@PathVariable("color") String color){
		
		ResponseEntity<List<Mobiles>> resposeEntity;
		List<Mobiles> mobiles =mobileservices.findMobilePhoneByColor(color);
		if(mobiles.size()==0)
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
		}
		else
		{
			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
		}
		
		return resposeEntity;
		
	}
	
	@GetMapping("countByModelName/{modelName}")
	public int getMobilePhonesByCount(@PathVariable("modelName") String modelName){
		
//		ResponseEntity<List<Mobiles>> resposeEntity;
		int mobiles =mobileservices.getMobilePhonesByCount(modelName);
//		if(mobiles.size()==0)
//		{
//			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.NO_CONTENT);
//		}
//		else
//		{
//			resposeEntity = new ResponseEntity<List<Mobiles>>(mobiles,HttpStatus.OK);
//		}
		
		return mobiles;
		
	}
	
	
	
	
	@GetMapping("findall")
	public List<MobilesDto> findAllDto(){
		List<Mobiles> findAllDto = (List<Mobiles>) mobiledao.findAll();
		
		return mobilesConverter.entityToDto(findAllDto);
		
	}
	
	@GetMapping("findbyid/{id}")
	public MobilesDto findById(@PathVariable(value="id") long id) {
		Mobiles orElse = mobiledao.findById(id).orElse(null);
		return mobilesConverter.entityToDto(orElse);
	}
	
	@GetMapping("findbybrandname/{brandname}")
	public List<MobilesDto> findbybrandname(@PathVariable (value = "brandname") String brandname){
		List<Mobiles> findByBrName = mobiledao.findByBrandName(brandname);
		return mobilesConverter.entityToDto(findByBrName);
	}
}