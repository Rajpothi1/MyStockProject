package com.stockproject.model;

import java.util.Objects;

import com.stockproject.dao.AdminDao;

public class Admin {
	
	private String adminName;
	private String adminEmail;
	private String password;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminEmail=" + adminEmail + ", password=" + password + "]";
	}
	public Admin(String adminName, String adminEmail, String password) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminEmail, adminName, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminEmail, other.adminEmail) && Objects.equals(adminName, other.adminName)
				&& Objects.equals(password, other.password);
	}
	public Admin(String email1, String pass) {
		super();
		this.adminEmail = email1;
		this.password = pass;
	}
	public AdminDao validateadmin(String email1, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
