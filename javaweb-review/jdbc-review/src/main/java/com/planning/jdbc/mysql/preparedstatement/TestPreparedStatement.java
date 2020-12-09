package com.planning.jdbc.mysql.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.planning.jdbc.mysql.utils.JdbcUtils;
import org.junit.Test;


/**
 * 用PreparedStatement进行表的CRUD操作
 * 预编译的作用
 * 	1 sql语句中可变的数据用?代替
 * 　    2 执行sql语句之前一定将数据设置到对应?上
 * 
 * @author Administrator
 * 
 */
public class TestPreparedStatement {

	//准备数据
	private String name = "zhangsan";
	private String password = "zhangsan";
	private int age = 21;
	
	/**
	 * 增加
	 */
	@Test
	public void testSave(){
		//获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;
		
		//sql语句中的不定值用?来代替
		String sql = "insert into p_user(name,password,age) values(?,?,?)";
		
		try {
			//预编译
			//调用prepareStatement(sql)得到PreparedStatement的实现类对象
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			psmt.setString(2, password);
			psmt.setInt(3, age);
			
			//在执行sql之前必须把数据设置进去
			int result = psmt.executeUpdate();
			System.out.println("update result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 修改
	 */
	@Test
	public void testUpdate(){
		//获取连接
		Connection conn = JdbcUtils.getConnection();
	    PreparedStatement psmt = null;
		
		String sql = "update p_user set name=?,password=?,age=? where id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, "lisi");
			psmt.setString(2, "lisi");
			psmt.setInt(3, 18);
			psmt.setInt(4, 2);
			
			int result = psmt.executeUpdate();
			System.out.println("update result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除
	 */
	@Test
	public void testDelete(){
		//获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "delete from p_user where id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, 2);
			
			int result = psmt.executeUpdate();
			System.out.println("update result:" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 */
	@Test
	public void TestSelect(){
		//获取连接
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement psmt = null;
		
		String sql = "select * from p_user where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, 1);
			
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				System.out.println("name=" + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
