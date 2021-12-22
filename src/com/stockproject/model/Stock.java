package com.stockproject.model;

import java.util.Objects;

public class Stock {

	private int productId;
	private String productName;
	private int quantity;
	private double unitPrice;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Stock [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + "]";
	}

	public Stock(String productName, int quantity, double unitPrice) {
		super();
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(double unitPrice, String productName) {
		super();
		this.productName = productName;
		this.unitPrice = unitPrice;
	}

	public Stock(int productId) {
		super();
		this.productId = productId;
	}

	public Stock(int productId, String productName, int quantity, double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, quantity, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return productId == other.productId && Objects.equals(productName, other.productName)
				&& quantity == other.quantity
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}
	

}
