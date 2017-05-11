package com.jdbc.students;

public class Student {

	private Integer sid;
	private String sname,course;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", course="
				+ course + "]";
	}
	
	
}
