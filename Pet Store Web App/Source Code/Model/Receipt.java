package com.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {
	private BigDecimal total;
	private String username;
	private String drawer;
	private List<String> items; //all the items purchased
	private Long UID;
	private Date saleDate;
	private Boolean isVoided;
	private BigDecimal refunded;
	
	public Receipt() {
		super();
		items  = new ArrayList<String>();
		refunded = new BigDecimal(0.00);
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDrawer() {
		return drawer;
	}
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public Long getUID() {
		return UID;
	}
	public void setUID(Long uID) {
		UID = uID;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Boolean getIsVoided() {
		return isVoided;
	}
	public void setIsVoided(Boolean isVoided) {
		this.isVoided = isVoided;
	}
	public BigDecimal getRefunded() {
		return refunded;
	}
	public void setRefunded(BigDecimal refunded) {
		this.refunded = refunded;
	}
}
