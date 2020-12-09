package com.bookshop.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.bean.Book;
import com.bookshop.dao.BookDao;

public class PreUpdateBookServlet extends HttpServlet {

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

		// 获取需要修改书籍的id
		String id = req.getParameter("bookId");
        // 调用dao查询书籍
		BookDao bookDao = new BookDao();
		Book book = bookDao.findBookById(id);
		if(book == null){
			
		}else{
			req.setAttribute("book", book);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/page/updateBook.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}
