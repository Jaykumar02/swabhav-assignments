package com.techlabs.model;

public class Account {
	private String name;
	private int accountNumber;
	private int balance;
	
	public void setName( String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAccno(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getAccno() {
		return accountNumber;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void depositAmount(int addAmount) {
		balance += addAmount;
	}
	
	public void withdrawAmount(int amount ) {
		if((balance-amount)>=500 ) {
		balance -= amount;
		System.out.println("Money Withdrawn Successfully");
		}else {
			System.out.println("You Cannot Withdraw Money");
			System.out.println("Minimum Balance Reequired Rs.500");
		}
	}
	
	public void showBalance() {
		System.out.println("Your Balance is : "+ balance);
	}

	
	

}
