package com.techlabs.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.techlabs.exceptions.DuplicateProductNameException;
import com.techlabs.exceptions.DuplicateSupplierName;
import com.techlabs.exceptions.InvalidIDException;

public class SupplierInventory {
	private Supplier supplier;
	private List<Supplier> suppliers;
	private SaveDetails details;
	
	public SupplierInventory() {
		suppliers = new ArrayList<Supplier>();
		details = new SaveDetails();
	}
	
	public void addSupplier(Supplier supplier) {
		for (Supplier supplierCheck : suppliers) {
	        if (supplierCheck.getSupplierName().equalsIgnoreCase(supplier.getSupplierName())) {
	            throw new DuplicateSupplierName();
	        }
	    }
	  
		suppliers.add(supplier);
	}
	
	public void ViewSupplierDetail(Supplier supplier) {
		System.out.println(supplier);
	}
	
	public void viewAllSupplier() {
		for(Supplier supplierList:suppliers) {
			System.out.println(supplierList);
		}
	}
	
	public void updateSupplier(int supplierID, String supplierName, String supplierInfo) {
		for(Supplier supplierList : suppliers) {
			if(supplierList.getSupplierID()==supplierID) {
				if(!supplierName.trim().isEmpty()) {
					supplierList.setSupplierName(supplierName);
				}
				if(!supplierInfo.trim().isEmpty()) {
					supplierList.setSupplierContactInfo(supplierInfo);
				}
			}else {
				throw new InvalidIDException();
			}
		}
		
	}
	
	
	
	public void deleteSupplier(int supplierID) {
		Iterator<Supplier> iterator = suppliers.iterator();
		while(iterator.hasNext()) {
			Supplier supplierList = iterator.next();
			if(supplierList.getSupplierID()==supplierID) {
				iterator.remove();
				System.out.println("Supplier with ID " + supplierID + " has been removed.");
				break;
			}else {
				throw new InvalidIDException();
			}
		}
	}
	
	
public void saveDetails() {
		
		details.saveSuppliers(suppliers);
	
	}
	

}
