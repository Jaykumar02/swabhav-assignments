package com.techlabs.test;

import java.util.Random;
import java.util.Scanner;

import com.techlabs.model.Account;

public class AccountManagementSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();

		Account account = new Account();

		System.out.println("***Welcome to Account Management System***");

		System.out.println("You First need to Create an Account");
		System.out.println("Enter Your Name: ");
		String name = scanner.nextLine();
		account.setName(name);
		int accNo = rand.nextInt(100000, 999999);
		System.out.println("Your Account Number is: " + accNo);
		account.setAccno(accNo);
		System.out.println("You can now Proceed to Perfrom Below Operations");

		boolean start = true;
		while (start) {
			System.out.println("1. Enter in Account ");
			System.out.println("2. Deposit Amount  ");
			System.out.println("3. Withdraw Amount ");
			System.out.println("4. Show Balance ");
			System.out.println("5. Exit ");
			System.out.print("Enter the Number You want to Peform: ");
			int value = scanner.nextInt();

			switch (value) {
			case 1:
				System.out.println("Enter the Account Number: ");
				int valid = scanner.nextInt();
				if (valid == accNo) {
					System.out.println("Logged In Successfully");

				}else {
					System.out.println("Incorrect Account Number");
				}
				break;

			case 2:
				System.out.println("Enter The Amount to be Deposited: ");
				int money = scanner.nextInt();
				account.depositAmount(money);
				System.out.println("Amount Deposited Successfully");
				break;
			case 3:
				System.out.println("Enter the Amount to be Withdrawn: ");
				int amount = scanner.nextInt();
				account.withdrawAmount(amount);
				break;
			case 4:
				account.showBalance();
				break;
			case 5:
				System.out.println("Thank you " + account.getName() + " See you Soon");
				start = false;

			}

		}

	}

}
