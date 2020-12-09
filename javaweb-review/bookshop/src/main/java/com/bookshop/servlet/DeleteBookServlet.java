package com.bookshop.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.dao.BookDao;

public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//从request中获取id
		String id = req.getParameter("bookId");
		//调用dao执行删除书籍的方法
		BookDao bookDao = new BookDao();
		boolean result = bookDao.delete(id);
		PrintWriter out = resp.getWriter();
		if(result == false){
			out.print("删除失败!");
		}else{
			out.print("删除成功!");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/page/tips.jsp");
		String refreshUrl = req.getContextPath()+"/findAllBook";
		out.print("3秒钟后自动刷新，<a href="+ refreshUrl +">手动刷新</a>");
		dispatcher.include(req, resp);
		resp.setHeader("refresh", "3;url="+refreshUrl);
	}
}
