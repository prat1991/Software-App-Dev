package com.model;

import java.math.BigDecimal;

public class Fish extends Animal {
	public static int inStock = 10;
	public final String type = "FISH";
	public Fish() {
		super();
		this.setPrice(new BigDecimal(10.00));
		// TODO Auto-generated constructor stub
	}
}
