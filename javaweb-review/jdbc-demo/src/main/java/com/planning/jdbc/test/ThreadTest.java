package com.planning.jdbc.test;

import com.planning.jdbc.utils.ConnUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ThreadTest {
	
	public static void main(String[] args) {
		for(int i = 0; i < 4; i++){
		    new	MyThread().start();
		}
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		Connection conn = ConnUtils2.getConnection();
		System.out.println(this.getName() + "持有连接："+ conn);
		try {
			conn.setAutoCommit(false);
			String sql = "insert into user values('"+ this.getName() +"','Tom','123')";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
			conn.commit();
			System.out.println(this.getName() + "子线程执行完成");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				conn.setAutoCommit(true);
				// 关闭连接,但是此处不能关闭，将一个关闭的连接放入池中无意义
				// Connection.close() has already been called. Invalid operation in this state.
				// conn.close();
				// 归还连接
				ConnUtils2.back(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
