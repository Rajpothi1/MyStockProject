package com.stockproject.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.stockproject.model.*;
import com.stockproject.dao.AdminDao;
import com.stockproject.dao.InvoiceBillDao;
import com.stockproject.dao.StackDao;
import com.stockproject.dao.UserDao;
import com.stockproject.model.Admin;
import com.stockproject.model.Stock;
import com.stockproject.model.User;

public class TestMainCheck {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		UserDao userDao=new UserDao();
		Scanner scan=new Scanner(System.in);
		System.out.println("\n1.Register\n2.Login\n3.adminlogin Enter your chioce");
		int choice=Integer.parseInt(scan.nextLine());
		UserDao currentUser=null;
		 Admin admin=null;
		switch(choice) {
		case 1:
		String userName=null;
      	String email=null;
		String address=null;
		String password=null;
		long phonenumber=0;
		do {
		System.out.println("enter the user name");
		 userName=scan.nextLine();
		 if(!userName.matches("[a-zA-Z]{3,}"))
		 {
			 System.out.println(" name must be 3 characters ");
		 }
		 if(userName.isEmpty())
		 {
			 System.out.println("please enter name");
		 }
		}while(!userName.matches("[a-zA-Z]{3,}"));
		
		 do {
		System.out.println("enter the email");
		 email=scan.nextLine();
		 if(!email.matches("[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}"))
		 {
			 System.out.println("must be provide valide emailid");
		 }
		 if(email.isEmpty()) {
			 System.out.println("must be provide email");
		 }
		 }while(!email.matches("[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}"));
		 do {
		System.out.println("enter the address");
		 address=scan.nextLine();
		 if(address.isEmpty())
		 {
			 System.out.println("please enter address");
		 }
		 }while(address.isEmpty());
		 do {
		System.out.println("enter the password");
		 password=scan.nextLine();
		 if(!password.matches("[A-Za-z0-9]+[@][A-za-z0-9]*"))
				 {
			 System.out.println("must be provide 8 characters and use some special characters for safty purpose");
				 }
		 if(password.isEmpty())
		 {
			 System.out.println("must be provide password");
		 }
		 }while(!password.matches("[A-Za-z0-9]+[@][A-Za-z0-9]*"));
		 String MobileNumber=null;
			do {
				System.out.println("enter the phone number");
				MobileNumber=scan.nextLine();
				if(!MobileNumber.matches("[6-9]{1}[0-9]{9}")) 
				{
					System.out.println("must be provide 10 values");
				}
				if(MobileNumber.isEmpty()) 
				{
				System.out.println("must be provide phone numnber");
				}
			}while(!MobileNumber.matches("[6-9]{1}[0-9]{9}"));
			phonenumber=Long.parseLong(MobileNumber);
		User user=new User(userName, email, address, password, phonenumber);
	      userDao.insert(user);
	case 2:
			user=new User();
			do {
			System.out.println("login");
			System.out.println("\n emailid");	
			 String emailid=scan.nextLine();
			 System.out.println("\nenter password");
			 String password1=scan.nextLine();
			 currentUser=new UserDao();
			 user=UserDao.validateUser(emailid, password1);
				if(user!=null)
				{
				System.out.println("login successed "+user.getUserName());
				System.out.println("\nshow product");
				
				StackDao prodao=new StackDao();
				prodao.showProduct();
				System.out.println("enter product id");
				int id= Integer.parseInt(scan.nextLine());
				System.out.println("enter product quantity");
				int quantity= Integer.parseInt(scan.nextLine());
				System.out.println("bill");
			    InvoiceBillDao obj=new InvoiceBillDao();
			    obj.showProduct();
			    
				} 
				else {
				
					System.out.println("invalid entry");
				}
			}while(user==null);
			break;
		case 3:
			
			AdminDao admin1=null;
			 Admin admin21=null;
			do {
				System.out.println("Admin login");
				System.out.println("\nenter the register emailid");	
				 String email1=scan.nextLine();
				 System.out.println("\nenter the  password");
				 String pass=scan.nextLine();
				 admin21=new Admin();
				 admin1=new  AdminDao();
				admin21=admin1.validateadmin(email1, pass);
				 if(admin21!=null) {
					System.out.println("register successed "+admin21.getAdminName());
					System.out.println("\n1.Add stock\n2.update stock\n3.delete stock");
					int select=Integer.parseInt(scan.nextLine());
					 Stock stock=null;
					 StackDao Sdao=null;
					switch(select) {
					case 1:
						System.out.println("Enter product name");
					    String proname=scan.nextLine();
					    System.out.println("Quantity");
					    int proqty=Integer.parseInt(scan.nextLine());
					    System.out.println("unitprice");
					    double proprice=Double.parseDouble(scan.nextLine());
					     stock=new Stock(proname,proqty,proprice);
					     Sdao=new StackDao();
					    Sdao.insert(stock);
					    break;
					    
					case 2:
						System.out.println("i will update current price");
						double price=Double.parseDouble(scan.nextLine());
						System.out.println("for this product name");
						String productname=scan.nextLine();
						stock=new Stock(price,productname);
						 Sdao=new StackDao();
						 Sdao.updated(stock);
						break;
					case 3:
						System.out.println("Delete product id");
						int delete=Integer.parseInt(scan.nextLine());
						stock=new Stock(delete);
						Sdao=new StackDao();
						Sdao.delete(stock);
						break;
						}
					
				} 
					else
					{
						System.out.println("invalid entry");
					}
			}while(admin21==null);
			
			
		}
	}


}


