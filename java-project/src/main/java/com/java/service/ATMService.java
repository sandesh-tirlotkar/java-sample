package com.java.service;

import com.java.dto.Account;

public class ATMService {
	
	private double balance;

	public ATMService() {
		balance = 0;
	}
	
	

	public double checkBalance() {
		return balance;
	}


	// for deposit cash
	public void depositCash(Account currentAccount, double depositAmount) {

		if (depositAmount > 0) {
			double balance2 = currentAccount.getBalance();
			balance = balance2 + depositAmount;
			System.out.println("Amount Deposit successful!");
		} else {
			System.out.println("Invalid deposit amount.");
		}
		
	}


	//for withdraw cash
	public void withdrawCash(Account currentAccount, double withdrawalAmount) {
		if (withdrawalAmount > balance) {
			System.out.println("Insufficient balance.");
		} else if (withdrawalAmount <= 0) {
			System.out.println("Invalid withdrawal amount.");
		} else {
			balance -= withdrawalAmount;
			System.out.println("Withdrawal successful!");
		}
		
	}
	
	
	

}
