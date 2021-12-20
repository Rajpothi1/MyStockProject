package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.stockproject.model.Stock;

public class StackDao {

	public void showProduct()
	{
		String prod="select * from stock";
		Connection con;
		try {
		con = ConnectionUtil.gbConnection();
		Statement stmt=con.createStatement();
	    ResultSet rs=stmt.executeQuery(prod);
			while(rs.next())
			{
				System.out.format("%-5s%-15s%-10s%-5s",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				System.out.println();
			}}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void insert(Stock pro)  {
	
	String insertQuery="insert into stock (product_name,product_qty ,price) values (?,?,?)";
	
	Connection con=null;
	try {
		con = ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
		System.out.println(pro.getProductName()+ pro.getQuantity()+ pro.getUnitPrice());
		
		pstmt.setString(1, pro.getProductName());
		pstmt.setInt(2, pro.getQuantity());
		pstmt.setDouble(3, pro.getUnitPrice());
		int i=pstmt.executeUpdate();
		System.out.println(i+ "inserted");
		pstmt.close();
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void updated(Stock pro1) {
	
	String updateQuery="update stock set price=? where product_name=?";
	
	Connection con;
	try {
		con = ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(updateQuery);

	     pstmt.setDouble(1, pro1.getUnitPrice());
	     pstmt.setString(2, pro1.getProductName());
		     int i=pstmt.executeUpdate();
		     System.out.println(i+"updated");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    

}

public void delete(Stock pro2) {

String deleteQuery="delete from stock where product_id=?";

Connection con;
try {
	con = ConnectionUtil.gbConnection();
	PreparedStatement pstmt= con.prepareStatement(deleteQuery);

	pstmt.setInt(1, pro2.getProductId() );
	int i=pstmt.executeUpdate();
	System.out.println(i+"delete");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}


}

		

		
	
	
	

