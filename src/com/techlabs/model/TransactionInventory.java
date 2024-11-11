package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

public class TransactionInventory {
	private Transaction transaction;
	private List<Transaction> transactions;
	private SaveDetails details;
	
	public TransactionInventory() {
		transactions = new ArrayList<Transaction>();
		details = new SaveDetails();
	}
	
	public void addStock(Transaction transaction) {
		
		transactions.add(transaction);
	}
	
	public void viewHistory() {
		for(Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}
	
public void saveDetails() {
		
		details.saveTransactions(transactions);
	
	}
	
	
	
	

}
