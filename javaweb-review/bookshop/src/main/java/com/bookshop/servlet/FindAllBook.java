package com.bookshop.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.bean.Book;
import com.bookshop.dao.BookDao;
import com.bookshop.utils.XmlUtils;

/**
 * 查询所有图书
 * @author planning
 *
 */
@SuppressWarnings("serial")
public class FindAllBook extends HttpServlet {

	@Override
	public void init() throws ServletException {
        //获取book.xml的真实项目路径,在tomcat中webapps下
		//E:\WorkSpace\MyEclipse8.5\bookshop_1\src\com\bookshop\servlet\FindAllBook.java
		//E:\WorkSpace\MyEclipse8.5\bookshop_1\WebRoot\books.xml
		String path = this.getServletContext().getRealPath("/books.xml");
		System.out.println(path);
		XmlUtils.setPath(path);
	}
	
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
		
		//查询书籍
		BookDao bookDao = new BookDao();
		List<Book> bookList = bookDao.findAllBook();
		req.setAttribute("bookList", bookList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/page/findBooks.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
