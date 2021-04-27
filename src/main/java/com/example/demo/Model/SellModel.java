package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SellModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	
	 private String name;
  
     private Long number;
     private Long sell;
     private Long stock;
     private String simple1;
     
     
     
     
     
   
	public String getSimple1() {
		return simple1;
	}
	public void setSimple1(String simple1) {
		this.simple1 = simple1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getSell() {
		return sell;
	}
	public void setSell(Long sell) {
		this.sell = sell;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
     
     
	
}
