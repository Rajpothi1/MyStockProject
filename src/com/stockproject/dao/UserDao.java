package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockproject.model.Stock;
import com.stockproject.model.User;

public class UserDao {

	
	public  void insert(User users)  {
		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
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
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
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
			user=new User(rs.getInt(1),rs.getString(2), emailid,password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" statement error");
		}
		return user;
		// TODO Auto-generated method stub
		
	}
	public void updated(User userupdate) {

		String updateQuery = "update users set  password=? where phonenumber=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);

			pstmt.setString(1, userupdate.getPassword());
			pstmt.setLong(2, userupdate.getPhoneNumber());
			int i = pstmt.executeUpdate();
			System.out.println(i + "updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(User userdelete) {

		String deleteQuery = "delete from users where  email=?";

		Connection con;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);

			pstmt.setString(1, userdelete.getEmail() );
			int i = pstmt.executeUpdate();
			System.out.println(i + "delete");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

	
	

