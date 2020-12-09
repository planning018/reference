package com.planning.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
/**
 * 为什么要有连接池
	　１：维护多个连接。必须要保证每一个线程获取到的是不同的connection对象。
	　２：提供一个方法可以回收连接。
 * @author Administrator
 *
 */
public class ConnUtils2 {

	//声明一个容器,放所有声明的连接Connection
	private static List<Connection> pool = new ArrayList<Connection>();
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///study?characterEncoding=UTF8";
			for(int i = 0; i < 3; i++){
				Connection conn = DriverManager.getConnection(url, "root", "123");
				pool.add(conn);
			}
			System.out.println("三个连接为：" + pool);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static Connection getConnection(){
		synchronized (pool) {
			Connection conn = pool.remove(0);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("连接池中还有：" + pool);
			return conn;
		}
	}
	
	//手动的还连接
	public static void back(Connection conn){
		System.out.println("交还连接："+ conn);
		pool.add(conn);
	}
	
	
	
	
	
	
}
