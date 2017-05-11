package com.jdbc;

public class TransactionExampleTest {

	public static void main(String[] args) {
		
		TransactionExample object = new TransactionExample();
		
		//insertAccounts(object);
		balanceTransfer(object,100);
		
	}
	private static void balanceTransfer(TransactionExample object,int transerferAmount) {
		
		Account srcAc = new Account();
		srcAc.setAccountno(124);
		srcAc.setAmount(transerferAmount);
		
		Account destAc = new Account();
		destAc.setAccountno(123);
		destAc.setAmount(transerferAmount);
		
		
		try {
			boolean status = object.transferAmount(srcAc, destAc);
			if(status) System.out.println("transfered successfully");
			else System.out.println("transaction failed");
		} catch (Exception e) {
			System.out.println("transaction aborted/declined");
			e.printStackTrace();
		}
		
	}
	public static void insertAccounts(TransactionExample object){
		Account account1 = new Account(123,500);
		//account1.se
		account1.setName("Raj");
		
		try {
			boolean flag = object.insertAccount(account1);
			if(flag) System.out.println("Created Account for Raj");
			else System.out.println("Sorry problem in creating account");
		} catch (Exception e) {
			System.out.println("Not inserted");
			e.printStackTrace();
		}
		
		Account account2 = new Account(124,1200);
		//account1.se
		account2.setName("Ram");
		
		try {
			boolean flag = object.insertAccount(account2);
			if(flag) System.out.println("Created Account for Ram");
			else System.out.println("Sorry problem in creating account");
		} catch (Exception e) {
			System.out.println("Not inserted");
			e.printStackTrace();
		}
	}
}
