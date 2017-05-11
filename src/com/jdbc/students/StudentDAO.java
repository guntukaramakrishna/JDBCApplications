package com.jdbc.students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentDAOI{

	public boolean addStudent(Student s) throws Exception{
		Connection con = ConnectionManager.getConnection();
		Statement ps = con.createStatement();
		String query = "insert into student values("+s.getSid()+",'"+s.getCourse()+"','"+s.getSname()+"')";
		int count = ps.executeUpdate(query);
		if(count == 1){
			return true;
		}
		return false;
	}
	public boolean updateStudent(Student s){
		
		return false;
	}
	public boolean deleteStudent(Integer sid) throws Exception{
		Connection con = ConnectionManager.getConnection();
		Statement ps = con.createStatement();
		String query = "delete from student where studentId="+sid;
		int count = ps.executeUpdate(query);
		if(count == 1){
			return true;
		}
		return false;
	}
	public Student findStudentById(Integer sid) throws Exception{
		
		Student s = null;
		Connection con = ConnectionManager.getConnection();
		Statement ps = con.createStatement();
		
		ResultSet rs = ps.executeQuery("select * from student where studentId="+sid);
		
		while(rs.next()){
			s = new Student();
			
			int value = rs.getInt("studentId");
			String course = rs.getString("program");
			String name = rs.getString(3);
			
			s.setSid(value);
			s.setCourse(course);
			s.setSname(name);
		}
		return s;
	}
	
	public List<Student> findAllStudents() throws Exception{
		List<Student> students = new ArrayList<Student>();
		
		Connection con = ConnectionManager.getConnection();
		Statement ps = con.createStatement();
		
		ResultSet rs = ps.executeQuery("select * from student");

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
