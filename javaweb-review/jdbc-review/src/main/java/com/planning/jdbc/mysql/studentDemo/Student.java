package com.planning.jdbc.mysql.studentDemo;

/**
 * 与student表对应的实体类
 * @author Administrator
 *
 */
public class Student {

	private int id;
	private String name;
	private String sex;
	private double grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public Student(){
		
	}
	
	public Student(int id, String name, String sex, double grade) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", id=" + id + ", name=" + name
				+ ", sex=" + sex + "]";
	}
	
	
}
