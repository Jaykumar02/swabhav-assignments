package com.techlabs.model;

import java.util.Random;
import java.util.Scanner;

import com.techlabs.exceptions.DuplicateSupplierName;
import com.techlabs.exceptions.InvalidIDException;

public class SupplierManagement {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	private Supplier supplier;
	private SupplierInventory supplierIvnentory;
	
	public SupplierManagement(SupplierInventory supplierInventory) {
		super();
		this.supplierIvnentory = supplierInventory;
	}
	
	public void addSupplier() {
		System.out.println("Enter Supplier Name: ");
		String supplierName = scanner.nextLine();
		System.out.println("Enter Supplier Contact Info:");
		String supplierInfo = scanner.nextLine();
		int supplierID = random.nextInt(1000)+1;
		System.out.println("Supplier ID is : "+supplierID);
		
		supplier = new Supplier(supplierID, supplierName, supplierInfo);
		try {
		supplierIvnentory.addSupplier(supplier);
		}catch(DuplicateSupplierName e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void viewSupplierDetail() {
		System.out.println("| Supplier  ID    | Supplier Name       | Supplier ContactInfo            |");
		System.out.println("****************************************************************************");
		supplierIvnentory.ViewSupplierDetail(supplier);
	}
	
	public void ViewAllSupplier() {
		System.out.println("| Supplier  ID | Supplier Name      | Supplier ContactInfo            |");
		System.out.println("****************************************************************************");
		supplierIvnentory.viewAllSupplier();
	}
	
	public void updateSupplier() {
		System.out.println("Enter Supplier ID you want to update: ");
		int suppID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter New Supplier Name or Press ENTER to keep same");
		String suppName = scanner.nextLine();
		
		System.out.println("Enter New Supplier Info or Press ENTER to keep same");
		String suppInfo = scanner.nextLine();
		try {
		supplierIvnentory.updateSupplier(suppID, suppName, suppInfo);
		}catch(InvalidIDException e) {
			System.out.println(e.getMessage());
		}
		
		
		}
	public void deleteSupplier() {
		System.out.println("Enter Supplier ID you want to Delete");
		int supplierID = scanner.nextInt();
		try {
		supplierIvnentory.deleteSupplier(supplierID);
		}catch(InvalidIDException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
