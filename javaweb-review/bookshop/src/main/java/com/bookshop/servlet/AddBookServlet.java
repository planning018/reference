package com.bookshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.bookshop.bean.Book;
import com.bookshop.dao.BookDao;

@SuppressWarnings("serial")
public class AddBookServlet extends HttpServlet {
	
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
		
		//从requset对象中获取值
		String id = (String) req.getParameter("id");
		String title = (String) req.getParameter("title");
		String price = (String) req.getParameter("price");
		
		//创建book对象
		BookDao bookDao = new BookDao();
		Book newBook = new Book(id,title,price);

		String bookId = null;
		// 调用dao存储book对象
		bookId = bookDao.saveBook(newBook);

		PrintWriter out = resp.getWriter();
		if(bookId != null){
			out.print("保存成功，请返回查询页面查看");
		}else{
			out.print("保存失败，请重新保存");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/page/tips.jsp");
		//设置自动刷新
		String refreshUrl = req.getContextPath()+"/findAllBook";
		out.print("3秒钟后自动刷新，<a href="+ refreshUrl +">手动刷新</a>");
		dispatcher.include(req, resp);
		resp.setHeader("refresh", "3;url="+refreshUrl);
	}
}
