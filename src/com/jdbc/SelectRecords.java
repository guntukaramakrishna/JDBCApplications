package com.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecords {

	public static void main(String args[]){/*
		try {
			// InterfaceI ref = new ClassA();
			//1. Load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);

			//Class.forName("com.mysql.jdbc.Driver");
			
			//2. Obtain connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");

			//3. Create a Statement
			Statement ps = con.createStatement();
			
			//4. Execute the Statement 
			
			ResultSet rs = ps.executeQuery("select * from student");
			
			// rs.next() -- will check wheter data is there or not
			
			// getter method of RS will give you the data
			
			while(rs.next()){
				
				int value = rs.getInt("studentId");
				String course = rs.getString("program");
				String name = rs.getString(3);
				
				System.out.println(value+","+course+","+name);
				
			}
			
			//5. Closing the connection
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	
*/}
}
