package com.techlabs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.techlabs.exceptions.DuplicateProductNameException;
import com.techlabs.exceptions.InvalidIDException;

public class ProductInventory {
	Scanner scanner = new Scanner(System.in);
	private List<Product> products;
	private SaveDetails details;
	
	
	public ProductInventory() {
		products = new ArrayList<Product>();
		details = new SaveDetails();
	}
	
	public void addProduct(Product product) {
	    for (Product productCheck : products) {
	        if (productCheck.getProductName().equalsIgnoreCase(product.getProductName())) {
	            throw new DuplicateProductNameException();
	        }
	    }
	    
	    products.add(product);
	}

		
	
	
	public void updateProduct(int productID) {
		for(Product product:products) {
		if(product.getProductID()==productID) {
			 scanner.nextLine();
			System.out.println("Enter new Name: ");
			String newName = scanner.nextLine();
			if(!newName.trim().isEmpty()) {
				product.setProductName(newName);
			}
			
			System.out.println("Enter new Description: ");
			String newDescription = scanner.nextLine();
			if(!newDescription.trim().isEmpty()) {
				product.setProductDescription(newDescription);
			}
			
			System.out.println("Enter new Price Or press Zero(0) to keep same price: ");
			double newPrice = scanner.nextDouble();
			if(!(newPrice==0)) {
				product.setProductPrice(newPrice);
			}
			
			System.out.println("Enter new Quantity Or press Zero(0) to keep same Quantity: ");
			int newQuantity = scanner.nextInt();
			if(!(newQuantity==0)) {
				product.setProductQuantity(newQuantity);
			}
		}else {
			throw new InvalidIDException();
		}
		}
			
		
	}
	
	public void removeProduct(int productID1) {
		 Iterator<Product> iterator = products.iterator();
		    while (iterator.hasNext()) {
		        Product rmProduct = iterator.next();
		        if (rmProduct.getProductID() == productID1) {
		            iterator.remove(); 
		            System.out.println("Product with ID " + productID1 + " removed successfully.");
		            return; 
		        }else {
					throw new InvalidIDException();
				}
		    }
		    System.out.println("Product with ID " + productID1 + " not found.");
	}

	public void viewProduct(Product product) {
		System.out.println("| Product ID    | Product Name       | Product Description            | Product Quantity | Product Price |");
		 System.out.println("**********************************************************************************************************");
		System.out.println(product);
		
	}
	
	public void viewAllProduct() {
		System.out.println("| Product ID    | Product Name       | Product Description            | Product Quantity | Product Price |");
		 System.out.println("**********************************************************************************************************");
		for(Product productList:products) {
			System.out.println(productList);
		}
		
	}
	
	
	   
	public Product findProductByID(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }else {
            	throw new InvalidIDException();
            }
        }
		return null;
	
	}
	
	public void saveDetails() {
		
		details.saveProduts(products);
	
	}
	
		
}
