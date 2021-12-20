package com.stockproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stockproject.model.Supplier;

public class SupplierDao {

public void insert(Supplier sup) throws SQLException, ClassNotFoundException {
		
		String insertQuery="insert into suppliers values (?,?,?,?,?,?,?,?)";
		
		Connection con=ConnectionUtil.gbConnection();
		PreparedStatement pstmt= con.prepareStatement(insertQuery);
		
		pstmt.setInt(1,sup.getSupplierId() );
		pstmt.setString(2, sup.getSupplierName());
		pstmt.setString(3,sup.getSupplierCompany());
		pstmt.setString(4, sup.getSupplierEmail());
		pstmt.setLong(5, sup.getSupplierPhno());
		pstmt.setString(6, sup.getProductName());
		pstmt.setDouble(7, sup.getProductPrice());
		pstmt.setInt(8, sup.getQuantity());
		int i=pstmt.executeUpdate();
		System.out.println(i+ "inserted");
		pstmt.close();
		con.close();
}
public void updated(Supplier sup1) throws SQLException, ClassNotFoundException {
	
	String updateQuery="update customers set product_price=? where SUPPLIER_id=?";
	
	Connection con=ConnectionUtil.gbConnection();
	PreparedStatement pstmt= con.prepareStatement(updateQuery);
	  pstmt.setDouble(1, sup1.getProductPrice());
      pstmt.setInt(2, sup1.getSupplierId());
   
	     int i=pstmt.executeUpdate();
     System.out.println(i+"updated");
     pstmt.close(); 
 	con.close();
}

public void delete(Supplier sup2) throws SQLException, ClassNotFoundException {
	
	String deleteQuery="delete from stock_details where productname=?";
	
	Connection con=ConnectionUtil.gbConnection();
	PreparedStatement pstmt= con.prepareStatement( deleteQuery);

	pstmt.setString(1, sup2.getProductName());
	int i=pstmt.executeUpdate();
	System.out.println(i+"delete");
	pstmt.close(); 
	con.close();

}	
	

}

	
	

