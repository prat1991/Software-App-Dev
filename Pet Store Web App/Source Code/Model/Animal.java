package com.model;

import java.math.BigDecimal;
import java.sql.Date;

public abstract class Animal {
	private BigDecimal price; // cost of this pet
	private Date dateSold;
	private Date dateStocked;
	public static final int MAX = 10;
	public static final int MIN = 3;
	
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateSold() {
		return this.dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public Date getDateStocked() {
		return this.dateStocked;
	}

	public void setDateStocked(Date dateStocked) {
		this.dateStocked = dateStocked;
	}

}
