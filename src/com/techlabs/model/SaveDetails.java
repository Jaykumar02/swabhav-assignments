package com.techlabs.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveDetails {
	public  void saveProduts(List<Product> products) {
	    System.out.println("Attempting to save products to file...");
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt", true))) {
	    	writer.write("Product Details:\n");
	    	writer.write("Product ID, Product Name, Product Description, Product Quantity, Product Price\n");
	        for (Product product : products) {
	        	
	            writer.write(product.getProductID() + " , " + product.getProductName() + " , " + 
	                         product.getProductDescription() + " , " + product.getProductQuantity() + " , " + 
	                         product.getProductPrice());
	            
	            writer.newLine();
	            writer.write("*******************************************************************************\n");
	            
	        }
	        System.out.println("Products saved successfully.");
	    } catch (IOException e) {
	        System.out.println("Error saving products: " + e.getMessage());
	    }
	}
	
	
	public  void saveSuppliers(List<Supplier> suppliers) {
	    System.out.println("Attempting to save suppliers to file...");
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt", true))) {
	        writer.write("Supplier Details:\n");
	        writer.write("Supplier ID, Supplier Name, Supplier Contact Info\n");
	        for (Supplier supplier : suppliers) {
	            writer.write(supplier.getSupplierID() + " , " + supplier.getSupplierName() + " , " + 
	                         supplier.getSupplierContactInfo());
	            writer.newLine();
	            writer.write("*******************************************************************************\n");
	        }
	        System.out.println("Suppliers saved successfully.");
	    } catch (IOException e) {
	        System.out.println("Error saving suppliers: " + e.getMessage());
	    }
	}
	   
	
	
	public  void saveTransactions(List<Transaction> transactions) {
	    System.out.println("Attempting to save transactions to file...");
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt", true))) {
	        writer.write("Transaction Details:\n");
	        writer.write("Transaction ID, Transaction type, Quantity, Date,\n");
	        for (Transaction transaction : transactions) {
	            writer.write(transaction.getTransactionID() + " , " +  transaction.getTransactionType() + " , " + 
	            		transaction.getQuantity()   + " , " + transaction.getTransactionDate() + " , ");
	            writer.newLine();
	        }
	        System.out.println("Transactions saved successfully.");
	    } catch (IOException e) {
	        System.out.println("Error saving transactions: " + e.getMessage());
	    }
	}



}
	
