package com.stockproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stockproject.model.Cart;

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

}
