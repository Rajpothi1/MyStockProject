package com.stockproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stockproject.model.Cart;
import com.stockproject.model.Purchase;

public class CartDao {

	public void insert(Cart cart) {

		String insertQuery = "insert into cart (user_id,product_id,quantity,totalPrice,delivery_date) values (?,?,?,?,?)";

		Connection con = null;
		try {
			con = ConnectionUtil.gbConnection();
			PreparedStatement pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getProductId());
			pstmt.setInt(3, cart.getQunatity());
			pstmt.setDouble(4, cart.getTotalPrice());
			pstmt.setDate(5, new java.sql.Date(cart.getExpectedDate().getTime()));
			int i = pstmt.executeUpdate();
			System.out.println(i + "inserted");
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
	
public List<Cart>allcart(Cart cart){
	List<Cart>cartDetails=new ArrayList<Cart>();
	String insertquery="select*from cart where user_id=?";
	
	try {
		Connection con=ConnectionUtil.gbConnection();
		PreparedStatement pstmt = con.prepareStatement(insertquery);
		pstmt.setInt(1, cart.getUserId());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			
			Cart cart1=new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDate(6));
			System.out.println(cart1);
			cartDetails.add(cart1);
			System.out.println(cart1);
			
		}} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cartDetails;
			
			
			
}		
	public void delete(Cart cart) throws SQLException, ClassNotFoundException {
		
		String deleteQuery="delete from cart where  product_id=? and user_id=?";
		
		Connection con=ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(deleteQuery);
		
		pstmt.setInt(1, cart.getProductId());
		pstmt.setInt(2, cart.getUserId());
		
		int i=pstmt.executeUpdate();
		System.out.println(i+"delete");
		}
		
			
			
			
			
			
}		


