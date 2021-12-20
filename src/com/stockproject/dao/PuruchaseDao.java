package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stockproject.model.Purchase;

public class PuruchaseDao {
public void insert(Purchase purchase) throws SQLException, ClassNotFoundException {
		
		String insertQuery="insert into purchases values (?,?,?,?,?)";
		
		Connection con=ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
		
		pstmt.setInt(1, purchase.getUserId());
		pstmt.setString(2, purchase.getProductName());
		pstmt.setInt(3, purchase.getOrderQty());
		pstmt.setDouble(4, purchase.getTotalPrice());
		pstmt.setDate(5, new java.sql.Date( purchase.getOrderDate().getTime()));
		int i=pstmt.executeUpdate();
		System.out.println(i+ "inserted");
		pstmt.close();
		con.close();
	}
public void updated(Purchase purchase1 ) throws SQLException, ClassNotFoundException {
		
		String insertQuery="update purchases set product_name=? where user_id=?";
		Connection con=ConnectionUtil.gbConnection();
		
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
	
	     pstmt.setString(1, purchase1.getProductName());
         pstmt.setInt(2, purchase1.getUserId());
   	     int i=pstmt.executeUpdate();
	     System.out.println(i+"updated");
	
}
	
	public void delete(Purchase  purchase2) throws SQLException, ClassNotFoundException {
	
	String deleteQuery="delete from purchases where  product_name=?";
	
	Connection con=ConnectionUtil.gbConnection();
	PreparedStatement pstmt= con.prepareStatement(deleteQuery);

	pstmt.setString(1, purchase2.getProductName());
	int i=pstmt.executeUpdate();
	System.out.println(i+"delete");
	
	
		
		
		

}
}

