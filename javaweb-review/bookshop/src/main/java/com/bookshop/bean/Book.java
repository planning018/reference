package com.bookshop.bean;

public class Book {

	private String id;
	private String title;
	private String price;
	
	public Book(){
		
	}
	
	public Book(String id, String title, String price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", title=" + title + "]";
	}
	
	
	
}
