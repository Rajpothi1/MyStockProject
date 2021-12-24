package com.stockproject.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.stockproject.model.*;
import com.stockproject.dao.AdminDao;
import com.stockproject.dao.CartDao;
import com.stockproject.dao.InvoiceBillDao;
import com.stockproject.dao.PuruchaseDao;
import com.stockproject.dao.StackDao;
import com.stockproject.dao.SupplierDao;
import com.stockproject.dao.UserDao;
import com.stockproject.model.Admin;
import com.stockproject.model.Stock;
import com.stockproject.model.User;

public class TestMainCheck {

	public static String proName;
	public static int quantity;
	public static String adminpro;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub

		UserDao userDao = new UserDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("\n1.Register\n2.Login\n3.adminlogin Enter your chioce");
		int choice = Integer.parseInt(scan.nextLine());
		UserDao currentUser = null;
		Admin admin = null;
		switch (choice) {
		case 1:
			String userName = null;
			String email = null;
			String address = null;
			String password = null;
			long phonenumber = 0;
			User user = null;

			do {
				System.out.println("enter the user name");
				userName = scan.nextLine();
				if (!userName.matches("[a-zA-Z]{3,}")) {
					System.out.println(" name must be 3 characters ");
				}
				if (userName.isEmpty()) {
					System.out.println("please enter name");
				}
			} while (!userName.matches("[a-zA-Z]{3,}"));

			do {
				System.out.println("enter the email");
				email = scan.nextLine();
				if (!email.matches("[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}")) {
					System.out.println("must be provide valide emailid");
				}
				if (email.isEmpty()) {
					System.out.println("must be provide email");
				}
			} while (!email.matches("[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}"));
			do {
				System.out.println("enter the address");
				address = scan.nextLine();
				if (address.isEmpty()) {
					System.out.println("please enter address");
				}
			} while (address.isEmpty());
			do {
				System.out.println("enter the password");
				password = scan.nextLine();
				if (!password.matches("[A-Za-z0-9]+[@][A-za-z0-9]*")) {
					System.out
							.println("must be provide 8 characters and use some special characters for safty purpose");
				}
				if (password.isEmpty()) {
					System.out.println("must be provide password");
				}
			} while (!password.matches("[A-Za-z0-9]+[@][A-Za-z0-9]*"));
			String MobileNumber = null;
			do {
				System.out.println("enter the phone number");
				MobileNumber = scan.nextLine();
				if (!MobileNumber.matches("[6-9]{1}[0-9]{9}")) {
					System.out.println("must be provide 10 values");
				}
				if (MobileNumber.isEmpty()) {
					System.out.println("must be provide phone numnber");
				}
			} while (!MobileNumber.matches("[6-9]{1}[0-9]{9}"));
			Long phonenumber1 = Long.parseLong(MobileNumber);
			// user = new User(0, userName, email, password);
			user = new User(userName, email, address, password, phonenumber1);
			userDao.insert(user);
		case 2:
			user = new User();
			do {
				System.out.println("\n1.login \n2.Forget password\n3.Delete your account");
				int userchoice = Integer.parseInt(scan.nextLine());

				switch (userchoice) {
				case 1:
					System.out.println("\n emailid");
					String emailid = scan.nextLine();
					System.out.println("\nenter password");
					String password1 = scan.nextLine();
					currentUser = new UserDao();
					user = UserDao.validateUser(emailid, password1);
					if (user != null) {
						System.out.println("login successed " + user.getUserName());
						System.out.println("\nshow product");

						StackDao prodao = new StackDao();
						prodao.showProduct();
						char youChoice;
						do {
							System.out.println("\nenter product name");
							proName = scan.nextLine();

							Stock userpro = prodao.validateProduct(proName);
							System.out.println(userpro);
							System.out.println("enter product quantity");
							quantity = Integer.parseInt(scan.nextLine());
//					System.out.println(userpro.getUnitPrice());

							prodao.updateQuantity(proName, quantity);

							double totalPrice = quantity * userpro.getUnitPrice();
							System.out.println(totalPrice);
							int userId = user.getUserId();
							System.out.println("Enter you want expected date");
							String tempDate = scan.nextLine();
							Date date = new SimpleDateFormat("dd-MM-yyyy").parse(tempDate);
							System.out.println(date);

//					System.out.println(userId);
							int productId = userpro.getProductId();
							Cart cart = new Cart(0, userId, productId, quantity, totalPrice, date);
							CartDao cartdao = new CartDao();
							cartdao.insert(cart);
							System.out.println("Do you order more product y/n");
							youChoice = scan.nextLine().charAt(0);
						} while (youChoice == 'y' || youChoice == 'Y');

						System.out.println("\n1.confirm order\n2.cancel order");
						int orderchoice = Integer.parseInt(scan.nextLine());
						CartDao cartDao = new CartDao();
						switch (orderchoice) {

						case 1:
							int userId = user.getUserId();
							Cart cart = new Cart(0, userId, 0, 0, 0, null);
							System.out.println(userId);
							List<Cart> cartList = cartDao.allcart(cart);
							System.out.println(cartList);
							for (int i = 0; i < cartList.size(); i++) {
								Cart allOrder = cartList.get(i);
								System.out.println(allOrder);
								int productId = allOrder.getProductId();
								Stock stock = new Stock(productId);
								StackDao stockDao = new StackDao();
								Stock productId1 = stockDao.validateProductId(productId);
								String productName = productId1.getProductName();
								int userId1 = allOrder.getUserId();
								int quantity = allOrder.getQunatity();
								double totalprice = allOrder.getTotalPrice();
								Purchase purchase = new Purchase(0, productId, userId1, productName, quantity,
										totalprice, null, null);
								PuruchaseDao purchaseDao = new PuruchaseDao();
								purchaseDao.insert(purchase);
								Cart cartdelete = new Cart(0, userId1, productId, 0, 0, null);
								cartDao.delete(cartdelete);

							}
							break;
						case 2:
							System.out.println("Thank you");
							
							

						}

					} else {

						System.out.println("invalid entry");
					}

//		           Purchase purchase=new Purchase();
//					PuruchaseDao puruchseDao=new PuruchaseDao();

//					System.out.println("bill");
//					InvoiceBillDao obj = new InvoiceBillDao();
//					obj.showProduct();
					break;
				case 2:
					System.out.println("please enter your New password");
					String newpassword = scan.nextLine();
					System.out.println("enter your phonenumber");
					phonenumber = Long.parseLong(scan.nextLine());
					user = new User(newpassword, phonenumber);
					userDao.updated(user);
					break;
				case 3:
					System.out.println("Delete your account");
					System.out.println("Delete your account mail id");
					String deletemail = scan.nextLine();
					user = new User(deletemail);
					userDao.delete(user);
					break;
				}

			} while (user == null);
			break;
		case 3:

			AdminDao admin1 = null;
			Admin admin21 = null;
			do {
				System.out.println("Admin login");
				System.out.println("\nenter the register emailid");
				String email1 = scan.nextLine();
				System.out.println("\nenter the  password");
				String pass = scan.nextLine();
				admin21 = new Admin();
				admin1 = new AdminDao();
				admin21 = admin1.validateadmin(email1, pass);
				if (admin21 != null) {
					System.out.println("register successed " + admin21.getAdminName());
					StackDao prodao = new StackDao();
					prodao.showProduct();

					System.out.println("\n1.buy product\n2.new product insert\n3.update stock\n4.delete stock");
					int select = Integer.parseInt(scan.nextLine());
					Stock stock = null;
					StackDao Sdao = new StackDao();
					switch (select) {
					case 1:
						SupplierDao supplierDao = new SupplierDao();
						supplierDao.showSupplier();
						System.out.println("enter product name");
						adminpro = scan.nextLine();
						Supplier supplier = new Supplier(0, null, null, null, null, adminpro, 0, 0);
						Supplier crtSupply = supplierDao.validateProduct(adminpro);
						System.out.println(crtSupply);
						System.out.println("Enter product quantity");

						int adminqty = Integer.parseInt(scan.nextLine());
						Stock pro1 = new Stock(0, adminpro, adminqty, 0);
						Sdao.Adminupdated(pro1);

						break;
					case 2:
						System.out.println("Enter product name");
						String proname = scan.nextLine();
						System.out.println("Quantity");
						int proqty = Integer.parseInt(scan.nextLine());
						System.out.println("unitprice");
						double proprice = Double.parseDouble(scan.nextLine());
						stock = new Stock(proname, proqty, proprice);
						Sdao = new StackDao();
						Sdao.insert(stock);
						break;

					case 3:
						System.out.println("i will update current price");
						double price = Double.parseDouble(scan.nextLine());
						System.out.println("for this product name");
						String productname = scan.nextLine();
						stock = new Stock(price, productname);
						Sdao = new StackDao();
//						Sdao.updated(stock);
						break;
					case 4:
						System.out.println("Delete product id");
						int delete = Integer.parseInt(scan.nextLine());
						stock = new Stock(delete);
						Sdao = new StackDao();
						Sdao.delete(stock);
						break;
					}

				} else {
					System.out.println("invalid entry");
				}
			} while (admin21 == null);
			// here to write inovoice bill update code

		}
	}

	private static SimpleDateFormat SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
