package com.techlabs.model;

public class Transaction {
	private int transactionID;
	private String transactionType;
	private String transactionDate;
	private int quantity;
	public Transaction(int transactionID, String transactionType, String transactionDate, int quantity) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.quantity = quantity;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", quantity=" + quantity + "]";
	}
	
	
	
	

}
