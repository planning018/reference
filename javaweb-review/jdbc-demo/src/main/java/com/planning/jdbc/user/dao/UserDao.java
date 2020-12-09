package com.planning.jdbc.user.dao;

import com.planning.jdbc.user.domain.User;
import com.planning.jdbc.utils.ConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

	public void register(User user) {
		Connection conn = null;
		try {
			// 获取连接
			conn = ConnUtils.getConnection();
			// 声明sql
			String sql = "insert into user(id,name,password) value(?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getUsername());
			psmt.setString(3, user.getPassword());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
