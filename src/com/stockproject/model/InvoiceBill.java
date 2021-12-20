package com.stockproject.model;

import java.util.Date;

public class InvoiceBill {
    private int billId;
	private int userId;
	private int productId;
	private int quantity;
	private double totalPrice;
	private Date orderDate;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "InvoiceBill [billId=" + billId + ", userId=" + userId + ", productId=" + productId + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + "]";
	}
	public InvoiceBill(int billId, int userId, int productId, int quantity, double totalPrice, Date orderDate) {
		super();
		this.billId = billId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public InvoiceBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
