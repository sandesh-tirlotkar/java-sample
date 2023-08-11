package com.java.atm;

public class Account {
	
	private Integer accountNumber;
	private Integer pin;
	private double balance;
	
	public Account(Integer accountNumber, Integer pin, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}
