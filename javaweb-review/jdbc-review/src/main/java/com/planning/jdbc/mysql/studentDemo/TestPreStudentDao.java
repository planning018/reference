package com.planning.jdbc.mysql.studentDemo;

import org.junit.Test;

public class TestPreStudentDao {

	@Test
	public void testSave(){
		PreStudentDao dao = new PreStudentDao();
		Student student = new Student(1, "zhangsan", "男", 88.88);
		dao.save(student);
	}
	
	@Test
	public void testUpdate(){
		PreStudentDao dao = new PreStudentDao();
		Student student = new Student(1, "lisi", "男", 75.55);
		dao.update(student);
	}
	
	@Test
	public void testSelect(){
		PreStudentDao dao = new PreStudentDao();
		Student stu = dao.findStudent(1);
		System.out.println(stu.toString());
	}
	
	@Test
	public void testDelete(){
		PreStudentDao dao = new PreStudentDao();
		Student student = new Student(1, "lisi", "男", 75.55);
		dao.delete(student);
	}
}
