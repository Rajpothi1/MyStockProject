package com.stockproject.model;

import java.util.Date;

public class Purchase {
	private int cartId;
	private int productId;
	private int userId;
	private String productName;
	private int orderQty;
	private double totalPrice;
	private String status;
	private Date orderDate;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Purchase [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + ", productName="
				+ productName + ", orderQty=" + orderQty + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", orderDate=" + orderDate + "]";
	}
	public Purchase(int cartId, int productId, int userId, String productName, int orderQty, double totalPrice,
			String status, Date orderDate) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.orderQty = orderQty;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderDate = orderDate;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
