package com.bookshop.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import com.bookshop.bean.Book;
import com.bookshop.utils.XmlUtils;

public class BookDao {

	/**
	 * 查询所有书籍
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Book> findAllBook() {
		// 封装结果集
		List<Book> bookList = new ArrayList<Book>();

		Document document = XmlUtils.getDocument();
		Element rootElement = document.getRootElement();
		List<Element> rootEleList = rootElement.elements();
		// 取到每一本书--对象
		for (Element rootEle : rootEleList) {
			Book book = new Book();
			book.setId(rootEle.attributeValue("id"));

			List<Element> bookEleList = rootEle.elements();
			for (Element eleBook : bookEleList) {
				if ("title".endsWith(eleBook.getName())) {
					book.setTitle(eleBook.getText());
				}
				if ("price".endsWith(eleBook.getName())) {
					book.setPrice(eleBook.getText());
				}
			}
			bookList.add(book);
		}
		return bookList;
	}

	/**
	 * 保存书籍
	 * @param newBook
	 * @return
	 */
	public String saveBook(Book newBook) {
		
		Document document = XmlUtils.getDocument();
		//获取根对象
		Element rootElement = document.getRootElement();
		//创建book对象
		Element bookElement = rootElement.addElement("book");
		//添加id属性
		bookElement.addAttribute("id", newBook.getId());
		//分别添加title和price属性
		bookElement.addElement("title").setText(newBook.getTitle());
		bookElement.addElement("price").setText(newBook.getPrice());
		
		try {
			XmlUtils.saveDocument(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newBook.getId();
	}

	/**
	 * 根据书籍id查询书籍
	 * @param id
	 * @return
	 */
	public Book findBookById(String id) {
		Document document = XmlUtils.getDocument();
		// xpath表达式
		Element bookElement = (Element) document.selectSingleNode("//book[@id='" + id + "']");
		if (bookElement == null) {
			return null;
		}
		Book book = new Book();
		book.setId(bookElement.attributeValue("id"));
		book.setPrice(bookElement.element("price").getText());
		book.setTitle(bookElement.element("title").getText());
		
		return book;
	}

	/**
	 * 更新书籍信息
	 * @param book 
	 * @return
	 * @throws IOException 
	 */
	public String updateBook(Book book) throws IOException {
		Document document = XmlUtils.getDocument();
		Element bookElement = (Element) document.selectSingleNode("//book[@id='" + book.getId() + "']");
		if (bookElement != null) {
			bookElement.element("title").setText(book.getTitle());
			bookElement.element("price").setText(book.getPrice());
			XmlUtils.saveDocument(document);
			return bookElement.attributeValue("id");
		}
		return null;
	}

	public boolean delete(String id) throws IOException {
		Document document = XmlUtils.getDocument();
		Element bookElement = (Element) document.selectSingleNode("//book[@id='" + id + "']");
		if(bookElement != null){
			Element pElement = bookElement.getParent();
			boolean result = pElement.remove(bookElement);
			XmlUtils.saveDocument(document);
			return result;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
