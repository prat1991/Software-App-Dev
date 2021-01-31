package com.model;

import java.math.BigDecimal;

public class Cat extends Animal {
	public static int inStock = 10;
	public final String type = "CAT";
	public Cat() {
		super();
		this.setPrice(new BigDecimal(100.00));
		// TODO Auto-generated constructor stub
	}
	
	
}
