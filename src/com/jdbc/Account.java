package com.jdbc;

public class Account {

	private Integer accountno,balance;
	private String name;
	private Integer amount;
	
	public Account(){
		super();
	}
	
	public Account(Integer acno, Integer initialbal){
		accountno = acno;
		balance = initialbal;
	}
	public Integer getAccountno() {
		return accountno;
	}
	public void setAccountno(Integer accountno) {
		this.accountno = accountno;
	}
	public Integer getBalance() {
		return balance;
	}
	private void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
