package com.planning.jdbc.user.servlet;

import com.planning.jdbc.user.domain.User;
import com.planning.jdbc.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	private UserService service = new UserService();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//复习：设置发送编码，此处不需要。
		//resp.setContentType("text/html;charset=UTF-8");
		
		//获取参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User(null, username, password);
		service.register(user);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
