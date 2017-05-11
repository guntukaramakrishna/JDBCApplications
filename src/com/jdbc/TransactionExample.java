package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionExample {

	private Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
		return con;
	}
	
	public boolean insertAccount(Account ac) throws Exception{
		Connection con = getConnection();
		
		// SQL statement
		String sql = "insert into accounts values(?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ac.getAccountno());
		ps.setString(2, ac.getName());
		ps.setInt(3, ac.getBalance());
		
		int count = ps.executeUpdate();
		
		con.close();
		
		if(count == 1) {
			return true;
		}
		return false;
	}
	
	public boolean transferAmount(Account src, Account dest) throws Exception{
		
		Connection con = getConnection();
		
		con.setAutoCommit(false);
		// SQL -1 
		String sql1 = "update accounts set balance=balance-? where accountid=?";
		String sql2 = "update accounts set balance=balance+? where accountid=?";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setInt(1, src.getAmount());
			ps.setInt(2, src.getAccountno());
			
			int sCount = ps.executeUpdate();
			
			ps = con.prepareStatement(sql2);
			ps.setInt(1, dest.getAmount());
			ps.setInt(2, dest.getAccountno());
			
			int dCount = ps.executeUpdate();
			
			int balance = getBalance(con, src.getAccountno());
			if(balance > 0){
				con.commit();
				System.out.println("-------committed the transaction ----");
				return true;
			}
			else{
				con.rollback();
				System.out.println("-------rolled back the transaction ----");
				return false;
			}
			/*if(sCount > 0 && dCount > 0)
				return true;*/
		}catch(Exception ex){
			con.rollback();
			throw ex;
		}finally{
			if(con != null){
				con.close();
			}
		}
	}
	
	private Integer getBalance(Connection con, Integer accountId) throws Exception{
		//Connection con = getConnection();
		// Run a SQL to get balance of Source account 
		String balCheckSQL = "select balance from accounts where accountid=?";
		PreparedStatement ps = con.prepareStatement(balCheckSQL);
		ps.setInt(1, accountId);

		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Integer balance = rs.getInt(1);
			System.out.println("The balance available in account- "+accountId+" is "+balance);
			return balance;
		}
		else{
			throw new Exception("Account Doesn't exist");
		}
		
	}
}
