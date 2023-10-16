package org.jsp.userspringproject.controller;

import java.util.Scanner;

import org.jsp.userspringproject.UserConfig;
import org.jsp.userspringproject.dao.UserDao;
import org.jsp.userspringproject.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {
	static UserDao dao;
	static Scanner sc = new Scanner(System.in);
	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		dao = context.getBean(UserDao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User By Id");
		System.out.println("5.Verify User By Id and Password");
		System.out.println("6.Verify User By phone and Password");
		System.out.println("7.Verify User By email and Password");
		System.out.println("Enter Your Choice");
		switch (sc.nextInt()) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			findById();
			break;
		}
		case 4: {
			delete();
			break;
		}
		case 5: {
         verifyById();
          break;
		}
		case 6:
		{
			verifyByPhone();
			break;
		}
		case 7:
		{
			verifyByEmail();
			break;
		}
		}
	}

	public static void save() {
		System.out.println("Enter Your name,phone,email,and password to register");
		User u = new User();
		u.setName(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.saveUser(u);
		System.out.println("User Save With Id: " + u.getId());
	}

	public static void update() {
		System.out.println("Enter the User id to Update");
		int id = sc.nextInt();
		System.out.println("Enter Your name,phone,email,and password to Update");
		User u = new User();
		u.setId(id);
		u.setName(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.updateUser(u);
		System.out.println("User Updated Successfully");
	}

	public static void findById() {
		System.out.println("Enter the User Id to display Details");
		int id = sc.nextInt();
		User u = dao.findById(id);
		if (u != null) {
			System.out.println("User With Id :" + id + "found");
			System.out.println("User Id:" + u.getId());
			System.out.println("User name :" + u.getName());
			System.out.println("Phone Number :" + u.getPhone());
			System.out.println("Email :" + u.getEmail());
			System.out.println("-----------------------");
		} else {
			System.out.println("You have Entered and Invalid Id");
		}

	}

	public static void delete() {
		System.out.println("Enter The User Id To delete The user Details");
		int id = sc.nextInt();
		boolean deleted = dao.deleteById(id);
		if (deleted) {
			System.out.println("User Found and Deleted");
		} else {
			System.out.println("You have entered an Invalid Id");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter the phoneNo to verify the User");
		long phone = sc.nextLong();
		String password = sc.next();
		User u = dao.verifyUser(phone, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.out.println("Invalid Phone and Password");
		}
	}
	public static void verifyByEmail() {
		System.out.println("Enter the Email Id to verify the User");
		String email = sc.next();
		String password = sc.next();
		User u = dao.verifyUser(email, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.out.println("Invalid Email and Password");
		}
	}
	public static void verifyById() {
		System.out.println("Enter the Id to verify the User");
		int id = sc.nextInt();
		String password = sc.next();
		User u = dao.verifyUser(id, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.out.println("Invalid Id and Password");
		}
	}
	
}
