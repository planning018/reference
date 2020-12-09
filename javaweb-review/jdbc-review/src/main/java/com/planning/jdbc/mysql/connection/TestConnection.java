package com.planning.jdbc.mysql.connection;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 实现得到代表与数据库连接的Connection实现类对象  三种方式
 * 
 * 三种方式
 * 		1 创建Driver接口的实现类对象去得到连接：需要记key:user password
 * 		2 DriverManager注册Driver接口的实现类对象，并获得连接
 * 		3 通过Class.for("Driver接口的实现类的全类")来注册
 * 
 * 	加入mysql的驱动jar包:
 *      mysql-connector-java-5.0.8-bin.jar
 *      ojdbc14.jar(基础包)
 * @author Administrator
 *
 */
public class TestConnection {
	
	/**
	 * 1 创建Driver接口的实现类对象去得到连接：需要记key:user password
	 */
	@Test
	public void getConnection() {
		try {
			//创建mysql的Driver对象
			Driver driver = new com.mysql.jdbc.Driver();
            //构造参数
			String url = "jdbc:mysql://localhost:3306/test";
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "123");
            //通过Driver对象得到连接对象
			Connection connection = driver.connect(url, prop);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 2. DriverManager.registerDriver(new com.mysql.jdbc.Driver())
	 */
	@Test
	public void getConnection2(){
		try {
			//使用DriverManager注册驱动对象
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123";
			//使用DriverManager得到连接对象
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 3 通过Class.for("Driver接口的实现类的全类")来注册
	 */
	@Test
	public void getConnection3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123";
			//使用DriverManager得到连接对象
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
