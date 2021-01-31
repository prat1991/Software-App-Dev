package com.model;

import java.math.BigDecimal;

public class Turtle extends Animal {
	public static int inStock =10;
	public final String type = "TURTLE";
	public Turtle() {
		super();
		this.setPrice(new BigDecimal(25.00));
		// TODO Auto-generated constructor stub
	}

}
