package com.java.atm;

import java.util.Scanner;



public class AtmDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AtmDemoApplication.class, args);
		
		ATMService atmService = new ATMService();
		Scanner scanner = new Scanner(System.in);
		Account accounts = null;
		int choice;
		int accountCount = 0;

		while (true) {
			System.out.println("Welcome to the ATM");
			System.out.println("1. Create Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
			
				
				System.out.print("Enter account number: ");
				int accountNumber = scanner.nextInt();
				System.out.print("Enter PIN: ");
				int pin = scanner.nextInt();
				System.out.print("Enter initial balance: $ ");
				double balance = scanner.nextDouble();
				accounts = new Account(accountNumber, pin, balance);
				System.out.println("Account created successfully!");
				accountCount++;
				break;

			case 2:
				System.out.print("Enter account number: ");
				int accountNumberInput = scanner.nextInt();
				System.out.print("Enter PIN: ");
				int pinNumberInput = scanner.nextInt();
				Account currentAccount = null;
				for (int i = 0; i < accountCount; i++) {
					Account account = accounts;
					if (account.getAccountNumber().equals(accountNumberInput)  && account.getPin().equals(pinNumberInput)) {
						currentAccount = account;
						break;
					}
				}

				if (currentAccount != null) {
					System.out.println("Login successful!");

					do {
						System.out.println("Welcome to the ATM");
						System.out.println("1. Check Balance");
						System.out.println("2. Deposit");
						System.out.println("3. Withdraw");
						System.out.println("4. Exit");
						System.out.print("Choose an option: ");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Current balance: $" + currentAccount.getBalance());
							break;
						case 2:
							System.out.print("Enter Deposit Amount: $");
							double depositAmount = scanner.nextDouble();
							double balance2 = currentAccount.getBalance();
							double bb = balance2 + depositAmount;
							currentAccount.setBalance(bb);
							atmService.depositCash(currentAccount, depositAmount);
							break;
						case 3:
							System.out.print("Enter Withdrawal Amount: $");
							double withdrawalAmount = scanner.nextDouble();
							currentAccount.setBalance(currentAccount.getBalance() - withdrawalAmount);
							atmService.withdrawCash(currentAccount, withdrawalAmount);
							break;
						case 4:
							System.out.println("Goodbye!");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
						}
						System.out.println();
					} while (choice != 4);
				} else {
					System.out.println("Invalid account number or PIN.");
				}
				break;

			case 3:
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();
		}
	}
	

}
