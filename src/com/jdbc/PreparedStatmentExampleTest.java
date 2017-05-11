package com.jdbc;

import java.sql.Connection;
import java.util.List;

import com.jdbc.students.Student;

public class PreparedStatmentExampleTest {

	public static void main(String[] args) throws Exception {


		PreparedStatmentExample obj = new PreparedStatmentExample();

		Connection con = obj.getConnection();

		List<Student> students = obj.getStudents(con);

		for(Student st : students){
			System.out.println(st);
		}
		con.close();

	}
}
