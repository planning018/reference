package com.planning.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用静态工厂方法管理一个唯一的可重用的连接
 */
public class ConnUtils {

	private static Connection conn;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///study?characterEncoding=UTF8";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
}
