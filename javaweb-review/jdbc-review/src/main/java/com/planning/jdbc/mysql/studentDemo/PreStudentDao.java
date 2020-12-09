package com.planning.jdbc.mysql.studentDemo;

import com.planning.jdbc.mysql.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 使用PreparedStatement操作student的CRUD
 * 
 * @author Administrator
 * 
 */
public class PreStudentDao {

	public void save(Student stu) {
		// 获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;

		String sql = "insert into student(id,name,sex,grade) values(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, stu.getId());
			psmt.setString(2, stu.getName());
			psmt.setString(3, stu.getSex());
			psmt.setDouble(4, stu.getGrade());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, psmt, null);
		}
	}

	public void update(Student stu) {
		// 获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;

		String sql = "update student set name=?,sex=?,grade=? where id=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, stu.getName());
			psmt.setString(2, stu.getSex());
			psmt.setDouble(3, stu.getGrade());
			psmt.setInt(4, stu.getId());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, psmt, null);
		}
	}

	public void delete(Student stu) {
		// 获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;

		String sql = "delete from student where id=?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, stu.getId());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, psmt, null);
		}
	}

	public Student findStudent(int id) {
		// 获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "select * from student where id=?";

		Student stu = new Student();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setGrade(rs.getDouble("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, psmt, rs);
		}
		return stu;
	}

}
