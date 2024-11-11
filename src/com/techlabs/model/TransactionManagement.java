package com.techlabs.model;

import java.util.Random;
import java.util.Scanner;

import com.techlabs.exceptions.InsufficientStockException;
import com.techlabs.exceptions.InvalidIDException;

public class TransactionManagement {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	private TransactionInventory transactionInventory;
	private ProductInventory productInventory;
	private Product product;
	private Transaction transaction;
	
	int productID;
	int stock;
	String transactionDate;
	int transactionID;
	String transactiontype;
	int quantity;
	
	public TransactionManagement(TransactionInventory TInventory,ProductInventory productInventory) {
		super();
		this.transactionInventory = TInventory;
		this.productInventory=productInventory;
		
	}
	
	public void displayProducts() {
		productInventory.viewAllProduct();
	}
	
	
	public void takeInputs() {
		System.out.println("Enter Product ID : ");
		productID = scanner.nextInt();
		
		try {
		product = productInventory.findProductByID(productID);
		}catch(InvalidIDException e) {
			System.out.println(e.getMessage());
		}
		
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
		
		System.out.println("Enter the Number Of Stock : ");
		stock = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Transaction Date ");
		transactionDate = scanner.nextLine();
	
		transactionID = random.nextInt(1000)+1;
		System.out.println("Your Transaction ID is: "+transactionID);
		
		
		
	}
	
	public void addStock() {
		transactiontype = "Added Stock";
		try {
		quantity = product.getProductQuantity()+stock;
		product.setProductQuantity(quantity);
		transaction = new Transaction(transactionID, transactiontype, transactionDate, stock);
		transactionInventory.addStock(transaction);
		System.out.println("Transaction Complete ");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void removeStock() {
		
		if(product.getProductQuantity()<stock) {
			throw new InsufficientStockException(stock);
		}else {
		quantity = product.getProductQuantity()-stock;
		product.setProductQuantity(quantity);
		transactiontype = "Removed Stock";
		System.out.println("Transaction Complete ");
		}
		
		transaction = new Transaction(transactionID, transactiontype, transactionDate, stock);
		transactionInventory.addStock(transaction);
		
		
	}
	
	public void viewTransactionHistory() {
		transactionInventory.viewHistory();
	}
}
