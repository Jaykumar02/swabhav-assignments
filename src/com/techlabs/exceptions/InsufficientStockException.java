package com.techlabs.exceptions;

public class InsufficientStockException extends RuntimeException{
	int stock;
	public InsufficientStockException(int stock) {
		super();
		this.stock = stock;
	}
	public String getMessage() {
		return "InSufficient Stock";
	}

}
