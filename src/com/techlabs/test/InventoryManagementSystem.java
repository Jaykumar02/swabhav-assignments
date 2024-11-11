package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.exceptions.InsufficientStockException;
import com.techlabs.exceptions.InvalidInputExecption;
import com.techlabs.model.LoadData;
import com.techlabs.model.ProductInventory;
import com.techlabs.model.ProductManagement;
import com.techlabs.model.SaveDetails;
import com.techlabs.model.Supplier;
import com.techlabs.model.SupplierInventory;
import com.techlabs.model.SupplierManagement;
import com.techlabs.model.TransactionInventory;
import com.techlabs.model.TransactionManagement;

public class InventoryManagementSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductInventory inventory = new ProductInventory();
		ProductManagement productManagement = new ProductManagement(inventory);

		SupplierInventory supplierInventory = new SupplierInventory();
		SupplierManagement supplierManagement = new SupplierManagement(supplierInventory);

		TransactionInventory transactionInventory = new TransactionInventory();
		TransactionManagement transactionManagement = new TransactionManagement(transactionInventory, inventory);

		SaveDetails details = new SaveDetails();
		LoadData loadDetails = new LoadData();

		System.out.println("Welcome to Inventory Management System");
		boolean start = true;
		while (start) {
			System.out.println("1. Product Management");
			System.out.println("2. Supplier Management");
			System.out.println("3. Transaction Management");
			System.out.println("4.Save Data");
			System.out.println("5.Load Data");
			System.out.println("6. Exit");
			 int value;
	            try {
	                value = scanner.nextInt();
	            } catch (Exception e) {
	                System.out.println("Invalid input. Please enter a number between 1 and 6.");
	                scanner.nextLine();
	                continue;
	            }

			switch (value) {
			case 1:
				boolean managementCases = true;
				while (managementCases) {
					System.out.println("1. Add product");
					System.out.println("2. Update product");
					System.out.println("3. Delete product");
					System.out.println("4. View product Details");
					System.out.println("5. View All product");
					System.out.println("6. Exit");
					int casesInput;
		            try {
		            	casesInput = scanner.nextInt();
		            } catch (Exception e) {
		                System.out.println("Invalid input. Please enter a number between 1 and 6.");
		                scanner.nextLine();
		                continue;
		            }

					switch (casesInput) {
					case 1:
						productManagement.addProduct();
						break;
					case 2:
						System.out.println("Enter Product ID you want to update: ");
						int id = scanner.nextInt();
						productManagement.updateProductDetails(id);
						break;
					case 3:
						System.out.println("Enter Product ID you want to Delete: ");
						int productID = scanner.nextInt();
						productManagement.deleteProduct(productID);
						break;
					case 4:
						productManagement.viewProduct();
						break;
					case 5:
						productManagement.viewAllProduct();
						break;
					case 6:
						managementCases = false;
						break;

					}
				}
				break;
			case 2:
				boolean supplierCases = true;
				while (supplierCases) {
					System.out.println("1. Add Supplier");
					System.out.println("2. Update Supplier Details");
					System.out.println("3. Delete Supplier");
					System.out.println("4. View Supplier Detail");
					System.out.println("5. View All Suppliers");
					System.out.println("6. Exit");
					int supplierInput;
						try {
							supplierInput = scanner.nextInt();
						}catch(Exception e) {
							System.out.println("Invalid input. Please enter a number between 1 and 6.");
							scanner.nextLine();
							continue;
						}

					switch (supplierInput) {
					case 1:
						supplierManagement.addSupplier();
						System.out.println("Supplier Added Successfully");
						break;
					case 2:
						supplierManagement.updateSupplier();
						System.out.println("Supplier Updated Successfully");
						break;
					case 3:
						supplierManagement.deleteSupplier();
						break;
					case 4:
						supplierManagement.viewSupplierDetail();
						break;
					case 5:
						supplierManagement.ViewAllSupplier();
						break;
					case 6:
						supplierCases = false;
						break;
					}
					
					
				}
				break;
			case 3:
				System.out.println("Available Product Stock Are: ");
				transactionManagement.displayProducts();
				boolean transaction = true;
				while (transaction) {

					System.out.println("1. Add Stock");
					System.out.println("2. Remove Stock");
					System.out.println("3. View Transaction History");
					System.out.println("4. Exit");

					int value2;
					try {
						value2 = scanner.nextInt();
					}catch(Exception e) {
						System.out.println("Enter Number between 1 to 4");
						continue;
					}

					switch (value2) {
					case 1:
						transactionManagement.takeInputs();
						transactionManagement.addStock();
						break;
					case 2:
						transactionManagement.takeInputs();
						try {
						transactionManagement.removeStock();
						}catch(InsufficientStockException e) {
							System.out.println(e.getMessage()); 
						}
						break;
					case 3:
						transactionManagement.viewTransactionHistory();
						break;
					case 4:
						transaction = false;
						break;

					}
				}
				break;
			case 4:
				inventory.saveDetails();
			    supplierInventory.saveDetails();
			    transactionInventory.saveDetails();		
				break;
			case 5:
				loadDetails.loadProducts();
				loadDetails.loadSuppliers();
				loadDetails.loadTransactions();
				
				break;

			}
		}

	}

}
