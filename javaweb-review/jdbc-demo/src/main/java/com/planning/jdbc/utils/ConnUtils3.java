package com.planning.jdbc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Properties;

public class ConnUtils3 {

	// 声明一个容器,放所有声明的连接Connection
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	static {
		try {
			// 声明资源器类
			Properties prop = new Properties();
			URL url = ConnUtils3.class.getClassLoader().getResource("jdbc.properties");
			String path = url.getPath();
			// 为了防止有中文或者空格
			path = URLDecoder.decode(path, "UTF-8");
			File file = new File(path);
			// 加载jdbc.properties这个文件
			prop.load(new FileInputStream(file));
			String driver = prop.getProperty("driver");
			String jdbcurl = prop.getProperty("url");
			String user = prop.getProperty("name");
			String password = prop.getProperty("pwd");
			// 创建三个原生的连接，都将它们代理
			String poolSize = prop.getProperty("poolSize");
			Class.forName(driver);
			int size = Integer.parseInt(poolSize);
			for (int i = 0; i < size; i++) {
				final Connection conn = DriverManager.getConnection(jdbcurl,user, password);
				//对conn进行代理
				Object proxyObj = Proxy.newProxyInstance(ConnUtils3.class.getClassLoader(), //1.获取类加载器
						               new Class[]{Connection.class}, //2.要代理类的接口
						               new InvocationHandler() { // 3.执行句柄
										public Object invoke(Object proxy, Method method, Object[] args)
												throws Throwable {
											//是否是close方法
											if("close".equals(method.getName())){
												synchronized (pool) {
													pool.addLast((Connection) proxy);
													pool.notify();
												}
												//如果是close方法，则不会调用被代理类的方法
												return null;
											}
											return method.invoke(conn, args);
										}
									});
				//将代理对象放到pool中
				pool.add((Connection) proxyObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		synchronized (pool) {
			if(pool.size() == 0){
				try {
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return getConn();
			}else{
				Connection conn = pool.removeFirst();
				System.out.println("连接池中还有："+ pool.size()+ "个连接!");
				return conn;
			}
		}
	}

}
