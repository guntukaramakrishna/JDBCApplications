package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.students.Student;

public class PreparedStatmentExample {

	public Connection getConnection() throws Exception {
		// 1. Load the Driver.

		Class.forName("com.mysql.jdbc.Driver");

		// 2. Get the connection

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
		
		CallableStatement cs = con.prepareCall("");
	
		return con;

	}
	
	public List<Student> getStudents(Connection con) throws Exception{
		
		List<Student> students = new ArrayList<Student>();
		// 3. Create the Statement object
		String sql = "select * from student where studentId between ? AND ?";

		PreparedStatement ps = con.prepareStatement(sql);

		// Set the values first
		ps.setInt(1, 1);
		ps.setInt(2, 132);

		// 4. Execute the Statement object

		ResultSet rs = ps.executeQuery();

		//System.out.println("SID\tCOURSE\tSNAME");
		while(rs.next()){
			
			Student s = new Student();
			int value = rs.getInt(1);
			String course = rs.getString(2);
			String name = rs.getString(3);
			
			s.setSid(value);
			s.setCourse(course);
			s.setSname(name);
			
			students.add(s);
		}
		return students;
	}
	
	
}
