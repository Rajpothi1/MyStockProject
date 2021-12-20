package com.stockproject.model;

public class Stock {

private String productName;
private double unitPrice;
private int quantity;
private int productId ;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Productss [productName=" + productName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
}
public Stock(String productName, int quantity ,double unitPrice) {
	super();
	this.productName = productName;
	this.unitPrice = unitPrice;
	this.quantity = quantity;
}
public Stock() {
	super();
	// TODO Auto-generated constructor stub
}
public Stock( double unitPrice,String productName) {
	super();
	this.productName = productName;
	this.unitPrice = unitPrice;
}
public Stock(int productId) {
	super();
	this.productId = productId;
}
	
	
	
	
	
}
