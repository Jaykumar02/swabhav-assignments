package com.techlabs.model;

import java.util.Random;
import java.util.Scanner;

import com.techlabs.exceptions.DuplicateProductNameException;
import com.techlabs.exceptions.InvalidIDException;

public class ProductManagement {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	private Product product;
	private ProductInventory inventory;
	
	
	
	public ProductManagement(ProductInventory inventory) {
		super();
		this.inventory = inventory;
	}



	public void addProduct() {
		System.out.println("Enter Name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter Description: ");
		String description = scanner.nextLine();
		System.out.println("Enter Price: ");
		double price = scanner.nextDouble();
		System.out.println("Enter Quantity: ");
		int quantity = scanner.nextInt();
		int productID = random.nextInt(10000)+1;
		scanner.nextLine();
		product = new Product(productID, name, description, quantity, price);
		try {
		inventory.addProduct(product);
		}catch(DuplicateProductNameException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateProductDetails(int productID) {
		try {
		inventory.updateProduct(productID);
		}catch(InvalidIDException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteProduct(int productID) {
		try {
			inventory.removeProduct(productID);
			}catch(InvalidIDException e) {
				System.out.println(e.getMessage());
			}
		
	}



	public void viewProduct() {
		inventory.viewProduct(product);
	}
	
	public void viewAllProduct() {
		inventory.viewAllProduct();
	}
	
	
	
	

}
