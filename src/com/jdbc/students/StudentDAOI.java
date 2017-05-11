package com.jdbc.students;

import java.util.List;

public interface StudentDAOI {

	public boolean addStudent(Student s) throws Exception;
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Integer sid) throws Exception;
	public Student findStudentById(Integer sid) throws Exception;
	public List<Student> findAllStudents() throws Exception;
}
