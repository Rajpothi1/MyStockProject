package com.stockproject.model;

import java.util.Objects;

public class User {
	private int userId; 
	private String userName;
	private String email;
	private String address;
	private String password;
	private long phoneNumber;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhonenumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", address=" + address + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	public User(String userName, String email, String address, String password, long phoneNumber) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public User(int userId, String userName, String email, String address, String password, long phoneNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public User(String emailid, String password) {
		super();
		this.email = emailid;
		this.password = password;
	}
	public User(int userId, String userName, String emailid, String password) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.userName=userName;
		this.email=emailid;
		this.password=password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email, password, phoneNumber, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && phoneNumber == other.phoneNumber
				&& Objects.equals(userName, other.userName);
	}
	public User(String password, long phoneNumber) {
		super();
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public User(String email) {
		super();
		this.email = email;
	}
		
	
	
	
	
	
	
	
}
