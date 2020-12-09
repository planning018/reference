package com.planning.jdbc.test;

import com.planning.jdbc.utils.ConnUtils3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestConnUtils3 {
	
	public static void main(String[] args) {
		for(int i = 0; i < 4; i++){
		    new	TestThread3().start();
		}
	}
}

class TestThread3 extends Thread{
	@Override
	public void run() {
		Connection conn = ConnUtils3.getConn();
		System.out.println(this.getName() + "持有连接："+ conn);
		try {
			String sql = "insert into user values('"+ this.getName() +"','Tom','123')";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();
			System.out.println(this.getName() + "子线程执行完成");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
