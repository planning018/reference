package com.bookshop.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.bean.Book;
import com.bookshop.dao.BookDao;

public class UpdateBookServlet extends HttpServlet {

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
		
		//获取req中的属性值
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String price = req.getParameter("price");
		
		Book book = new Book(id, title, price);
		BookDao bookDao = new BookDao();
		//调用dao层的update方法
		String bookId = bookDao.updateBook(book);
		
		//设置跳转页面
		PrintWriter out = resp.getWriter();
		if(bookId == null){
			out.print("修改失败，请重新修改");
		}else{
			out.print("修改成功");
		}
		String refreshUrl = req.getContextPath()+"/findAllBook";
		RequestDispatcher dispatcher = req.getRequestDispatcher("/page/tips.jsp");
		out.print("3秒后自动调转至查询页面,<a href="+ refreshUrl +">手动跳转</a>");
		dispatcher.include(req, resp);
		resp.setHeader("refresh", "3;url="+refreshUrl);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
