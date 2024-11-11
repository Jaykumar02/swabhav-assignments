package com.techlabs.model;

public class Product {
	private int productID;
	private String productName;
	private String productDescription;
	private int productQuantity;
	private double productPrice;
	
	public Product(int productID, String productName, String productDescription, int productQuantity,
			double productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return 
				String.format("| %-15s | %-20s | %-30s | %-15s | %-10.2f |",
                productID, productName, productDescription, productQuantity, productPrice);
	}
	
	
	

}
