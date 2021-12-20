package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockproject.model.User;

public class UserDao {

	
	public static void insert(User users) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtil.gbConnection();
		String query="insert into users(user_name,email,address,password,phonenumber)values(?,?,?,?,?)";
			
			PreparedStatement pstmt = null;
		
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, users.getUserName());
				pstmt.setString(2, users.getEmail());
				pstmt.setString(3, users.getAddress());
				pstmt.setString(4, users.getPassword());
				pstmt.setLong(5, users.getPhoneNumber());
				int i=pstmt.executeUpdate();
				System.out.println("Register success");
			
			

			
	}

	public static  User validateUser(String emailid,String password) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtil.gbConnection();
		String query="select * from users where email='"+emailid+"' and password='"+password+"'";
		User user=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{	
			user=new User(rs.getString(2), emailid,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" statement error");
		}
		return user;
		// TODO Auto-generated method stub
		
	}
}

	
	

