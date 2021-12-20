package com.stockproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InvoiceBillDao {

	
	
	public void showProduct()
	{
		String prod="select * from bills";
		Connection con;
		try {
		con = ConnectionUtil.gbConnection();
		Statement stmt=con.createStatement();
	    ResultSet rs=stmt.executeQuery(prod);
			while(rs.next())
			{
				System.out.format("%-5s%-15s%-10s%-5s%-5s%-5s",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getDouble(5),rs.getDate(6));
				System.out.println();
			}}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
}}
