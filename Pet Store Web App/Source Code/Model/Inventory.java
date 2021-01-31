package com.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	List<Animal> animalsInStock;
	public List<Supplier> supplierList;
	
	public Inventory() {
		super();
		this.animalsInStock = new ArrayList<Animal>();
		this.supplierList = new ArrayList<Supplier>();
		for (int i = 0; i < Animal.MAX; i++) {
			Cat cat = new Cat();
			this.getAnimalsInStock().add(cat);
			
			Fish fish = new Fish();
			this.getAnimalsInStock().add(fish);
			
			Turtle turtle = new Turtle();
			this.getAnimalsInStock().add(turtle);
		}
		
	}

	public List<Animal> getAnimalsInStock() {
		return animalsInStock;
	}
	
	public void setAnimalsInStock(List<Animal> animalsInStock) {
		this.animalsInStock = animalsInStock;
	}
	public List<Supplier> getSupplierList() {
		return supplierList;
	}
	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	
	

	
}
