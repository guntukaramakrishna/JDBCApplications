package com.jdbc.students;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionManager {

	private static Connection connection;

	public static Connection getConnection() throws Exception{
		if(connection == null){
			Properties properties = loadDetails();
			String driverName = properties.getProperty("driver");
			System.out.println(driverName);
			Class.forName(driverName);
			/*Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);*/
			String jdbcUrl = properties.getProperty("jdbcurl");
			System.out.println(jdbcUrl);
			connection = DriverManager.getConnection(jdbcUrl, "root", "root");
		}
		return connection;
	}

	private static Properties loadDetails() throws Exception{
		File f = new File("E://databaseinfo.properties");
		if(f.exists()){
			FileInputStream fis = new FileInputStream(f);
			Properties pro = new Properties();
			pro.load(fis);
			return pro;
		}
		else{
			throw new RuntimeException("File doesn't exist.");
		}
	}

	public static Connection giveConnection() throws Exception{
		BasicDataSource dataSource = new BasicDataSource();

		//dataSource.setMaxTotal(5);
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		connection = dataSource.getConnection();
		System.out.println(dataSource.getMinIdle());
		System.out.println(dataSource.getMaxTotal());
		return connection;
	}
	public static void main(String[] args) {
		
		try {
			Connection con = giveConnection();
			if(con != null){
				System.out.println("successfull..");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
