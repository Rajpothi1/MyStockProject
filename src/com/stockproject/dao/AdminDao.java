package com.stockproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockproject.model.Admin;

public class AdminDao {

	public  Admin validateadmin(String email1, String pass) throws ClassNotFoundException, SQLException
	{
		
		Connection con=ConnectionUtil.gbConnection();
		String query1="select * from admin where admin_email='"+email1+"' and password='"+pass+"'";
	Admin admin=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query1);
			if(rs.next())
			{	
			admin=new Admin(rs.getString(2),email1,pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	
}

}


