package com.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {
	private boolean isVoided;
	private Long UID;
	private boolean isthisaNewSale;
	private List<Animal> animals;
	private Date saleDate;
	private String drawer; //used for Z ereading
	private String username; //store user name used for X reading
	private BigDecimal refunded;
	
	public Sale() {
		super();
		this.drawer = "Register 1";
		this.saleDate = new Date();
		animals = new ArrayList<Animal>();
		UID = this.saleDate.getTime();
		this.isVoided = false;
		refunded = new BigDecimal(0.00);
	}
	
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public boolean isVoided() {
		return isVoided;
	}
	public void setVoided(boolean isVoided) {
		this.isVoided = isVoided;
	}
	public Long getUID() {
		return UID;
	}
	public void setUID(Long uID) {
		UID = uID;
	}
	public boolean isIsthisaNewSale() {
		return isthisaNewSale;
	}
	public void setIsthisaNewSale(boolean isthisaNewSale) {
		this.isthisaNewSale = isthisaNewSale;
	}
	public List<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	public String getDrawer() {
		return drawer;
	}

	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String username) {
		this.username = username;
	}
	

	public BigDecimal getRefunded() {
		return refunded;
	}

	public void setRefunded(BigDecimal refunded) {
		this.refunded = refunded;
	}

	public BigDecimal getTotalAmount() {
		Double amount = 0.0;
		for (int i=0; i< animals.size(); i++) {
			amount += animals.get(i).getPrice().doubleValue(); 
		}
		
		return new BigDecimal(amount);
	}
}
