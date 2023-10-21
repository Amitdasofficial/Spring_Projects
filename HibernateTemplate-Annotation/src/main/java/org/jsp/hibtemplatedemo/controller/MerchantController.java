package org.jsp.hibtemplatedemo.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibtemplatedemo.config.MerchantConfig;
import org.jsp.hibtemplatedemo.dao.MerchantDao;
import org.jsp.hibtemplatedemo.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class MerchantController {

	private final MerchantDao dao;
	private static Scanner s;

	@Autowired
	public MerchantController(MerchantDao dao) {
		this.dao = dao;
		this.s = new Scanner(System.in);
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MerchantConfig.class);
		MerchantController controller = context.getBean(MerchantController.class);
		controller.start();
	}

	public void start() {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("1. Save Merchant");
			System.out.println("2. Update Merchant");
			System.out.println("3. Find Merchant By Id");
			System.out.println("4. Delete Merchant By Id");
			System.out.println("5. Find All Merchants");
			System.out.println("6. Exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				saveMerchant();
				break;
			case 2:
				updateMerchant();
				break;
			case 3:
				findMerchantById();
				break;
			case 4:
				deleteMerchant();
				break;
			case 5:
				findAllMerchants();
				break;
			case 6:
				isRunning = false;
				System.out.println("Thank You!!! Application Closed");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		s.close();
	}

	private void saveMerchant() {
		// Input and save merchant logic
		System.out.println("Enter the name,phone,email,gst and password to save merchant");
		Merchant m = new Merchant();
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPassword(s.next());
		m = dao.saveMerchant(m);
		System.out.println("Merchant Saved With Id" + m.getId());
	}

	private void updateMerchant() {
		// Input and update merchant logic
		System.out.println("Enter the Merchant Id to Update");
		int id = s.nextInt();
		System.out.println("Enter the name,phone,email,gst and password to save merchant");
		Merchant m = new Merchant();
		m.setId(id);
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPassword(s.next());
		m = dao.updateMerchant(m);
		System.out.println("Merchant updated Successfully");
	}

	private void findMerchantById() {
		// Input and find merchant by ID logic
		System.out.println("Enter the Id to find Merchant");
		int id = s.nextInt();
		Merchant m = dao.findById(id);
		if (m != null) {
			System.err.println("-----------------------");
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
			System.out.println("GST:" + m.getGst());
			System.err.println("-----------------------");
		} else {
			System.out.println("You have Entered an Invalid Id");
		}
	}

	private void deleteMerchant() {
		// Input and delete merchant by ID logic
	
				System.out.println("Enter the Merchant Id to Delete Merchant");
				int id = s.nextInt();
				if (dao.deleteMerchant(id)) 
				{
					System.out.println("Merchant Deleted");
				} else 
				{
					System.out.println("Invalid Merchant Id");
				}
	}

	private void findAllMerchants() {
		// List all merchants logic
		List<Merchant> merchants = dao.findAll();
		for (Merchant m : merchants) {
			System.err.println("=============================");
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
			System.out.println("GST:" + m.getGst());
			System.err.println("=============================");
		}
	}
}
