package com.stockproject.model;

public class Supplier {
	private  int supplierId;
	private String supplierName;
	private String supplierCompany;
	private String supplierEmail;
	private Long supplierPhno;
	private String productName;
	private double productPrice;
	private int quantity;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierCompany() {
		return supplierCompany;
	}
	public void setSupplierCompany(String supplierCompany) {
		this.supplierCompany = supplierCompany;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public Long getSupplierPhno() {
		return supplierPhno;
	}
	public void setSupplierPhno(Long supplierPhno) {
		this.supplierPhno = supplierPhno;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierCompany="
				+ supplierCompany + ", supplierEmail=" + supplierEmail + ", supplierPhno=" + supplierPhno
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}
	public Supplier(int supplierId, String supplierName, String supplierCompany, String supplierEmail,
			Long supplierPhno, String productName, double productPrice, int quantity) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierCompany = supplierCompany;
		this.supplierEmail = supplierEmail;
		this.supplierPhno = supplierPhno;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int supplierId, double productPrice) {
		super();
		this.supplierId = supplierId;
		this.productPrice = productPrice;
	}
	public Supplier(String productName) {
		super();
		this.productName = productName;
	}
	
	
	
	
	
}