package com.galaxe.controller.converter;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.galaxe.controller.dto.MobilesDto;
import com.galaxe.model.Mobiles;

@Component
public class MobilesConverter {

	public MobilesDto entityToDto (Mobiles mobiles) {
		MobilesDto dto = new MobilesDto();
		dto.setId(mobiles.getId());
		dto.setBrandName(mobiles.getBrandName());
		dto.setModelName(mobiles.getModelName());
		dto.setCost(mobiles.getCost());
		
		return dto;
	}
	
	
	public List<MobilesDto> entityToDto (List<Mobiles> mobiles) {
		
		
		return mobiles.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	public Mobiles dtoToEntity(MobilesDto dto) {
		Mobiles mob = new Mobiles();
		mob.setBrandName(dto.getBrandName());
		mob.setId(dto.getId());
		mob.setModelName(dto.getModelName());
		mob.setCost(dto.getCost());
		
		return mob;
	}
	
	public List<Mobiles> dtoToEntity(List<MobilesDto> dto) {
				
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
