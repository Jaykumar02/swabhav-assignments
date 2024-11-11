package com.techlabs.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {


    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        System.out.println("Attempting to load products from file...");
        try (BufferedReader reader = new BufferedReader(new FileReader("Products.txt"))) {
            String line;
            reader.readLine(); // Skip header
            reader.readLine(); // Skip column names
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                if (parts.length == 5) {
                    Product product = new Product(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            Integer.parseInt(parts[3]),
                            Double.parseDouble(parts[4])
                    );
                    products.add(product);
                }
            }
            System.out.println("Products loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
        return products;
    }

    
    public static List<Supplier> loadSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        System.out.println("Attempting to load suppliers from file...");
        try (BufferedReader reader = new BufferedReader(new FileReader("Products.txt"))) {
            String line;
            reader.readLine(); // Skip header
            reader.readLine(); // Skip column names
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                if (parts.length == 3) {
                    Supplier supplier = new Supplier(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2]
                    );
                    suppliers.add(supplier);
                }
            }
            System.out.println("Suppliers loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading suppliers: " + e.getMessage());
        }
        return suppliers;
    }

  
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        System.out.println("Attempting to load transactions from file...");
        try (BufferedReader reader = new BufferedReader(new FileReader("Products.txt"))) {
            String line;
            reader.readLine(); // Skip header
            reader.readLine(); // Skip column names
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                if (parts.length == 4) {
                	Transaction transaction = new Transaction(
                		    Integer.parseInt(parts[0]), // transactionID
                		    parts[1],                   // transactionType
                		    parts[3],                   // transactionDate
                		    Integer.parseInt(parts[2])  // quantity
                		);

                    transactions.add(transaction);
                }
            }
            System.out.println("Transactions loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }
}
