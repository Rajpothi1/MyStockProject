package com.stockproject.model;

import java.util.Date;

public class Cart {
private int cart;
private int userId;
private int productId;
private int qunatity;
private double totalPrice;
private Date expectedDate;
public int getCart() {
	return cart;
}
public void setCart(int cart) {
	this.cart = cart;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getQunatity() {
	return qunatity;
}
public void setQunatity(int qunatity) {
	this.qunatity = qunatity;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public Date getExpectedDate() {
	return expectedDate;
}
public void setExpectedDate(Date expectedDate) {
	this.expectedDate = expectedDate;
}
@Override
public String toString() {
	return "Cart [cart=" + cart + ", userId=" + userId + ", productId=" + productId + ", qunatity=" + qunatity
			+ ", totalPrice=" + totalPrice + ", expectedDate=" + expectedDate + "]";
}
public Cart(int cart, int userId, int productId, int qunatity, double totalPrice, Date expectedDate) {
	super();
	this.cart = cart;
	this.userId = userId;
	this.productId = productId;
	this.qunatity = qunatity;
	this.totalPrice = totalPrice;
	this.expectedDate = expectedDate;
}
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
	
	
	
	
	
	
}
