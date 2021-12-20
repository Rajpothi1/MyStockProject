package com.stockproject.model;

import java.util.Date;

public class Purchase {
	private int userId;
	private String productName;
	private int orderQty;
	private double totalPrice;
	private Date orderDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Purchase(int userId, String productName, int orderQty, double totalPrice, Date orderDate) {
		super();
		this.userId = userId;
		this.productName = productName;
		this.orderQty = orderQty;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
