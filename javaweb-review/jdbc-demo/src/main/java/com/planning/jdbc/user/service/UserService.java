package com.planning.jdbc.user.service;

import com.planning.jdbc.user.dao.UserDao;
import com.planning.jdbc.user.domain.User;

import java.util.UUID;


public class UserService {

	private UserDao dao = new UserDao();
	
	public void register(User user) {
		//使用UUID来设置userId
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		dao.register(user);
	}
	

}
