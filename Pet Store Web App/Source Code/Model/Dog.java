package com.model;

import java.math.BigDecimal;

public class Dog extends Animal {
	public static int inStock = 10;
	public final String type = "DOG";
	public Dog() {
		super();
		this.setPrice(new BigDecimal(130.00));
		// TODO Auto-generated constructor stub
	}
}
