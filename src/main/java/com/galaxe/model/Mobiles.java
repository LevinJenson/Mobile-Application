package com.galaxe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="mobiles")
@Component
public class Mobiles {

	public Mobiles() {
		
	}
	@Id
	private long id;
	private String brandName;
	private String modelName;
	private String processor;
	private String color;
	private double cost;
	public Mobiles(long id, String brandName, String modelName, String processor, String color, double cost) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.modelName = modelName;
		this.processor = processor;
		this.color = color;
		this.cost = cost;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Mobiles [id=" + id + ", brandName=" + brandName + ", modelName=" + modelName + ", processor="
				+ processor + ", color=" + color + ", cost=" + cost + "]";
	}
	
	
}
