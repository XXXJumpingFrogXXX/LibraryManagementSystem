package com.model;

public class Book {
	private int bookID;
	private String title; 
	private String ISBN; 
	private String writer;
	private String publisher;
	private String pubDate;
	private int price;
	private int bookNum;
	private String BookLib_floor;
	private String BookLib_room;
	private String BookLib_shelf;
	
	public Book() {
		super();
		this.bookID=-1;
		// TODO 自动生成的构造函数存根
	}
	
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public Book(int bookID, String title, String iSBN, String writer, String publisher, String pubDate, int price,
			int bookNum, String bookLib_floor, String bookLib_room, String bookLib_shelf) {
		super();
		this.bookID = bookID;
		this.title = title;
		ISBN = iSBN;
		this.writer = writer;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.price = price;
		this.bookNum = bookNum;
		BookLib_floor = bookLib_floor;
		BookLib_room = bookLib_room;
		BookLib_shelf = bookLib_shelf;
	}

	public Book(String title, String iSBN, String writer, String publisher, String pubDate, int price,
			int bookNum, String bookLib_floor, String bookLib_room, String bookLib_shelf) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.writer = writer;
		this.publisher = publisher;
		this.pubDate = pubDate;
		this.price = price;
		this.bookNum = bookNum;
		BookLib_floor = bookLib_floor;
		BookLib_room = bookLib_room;
		BookLib_shelf = bookLib_shelf;
	}

	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookLib_floor() {
		return BookLib_floor;
	}
	public void setBookLib_floor(String bookLib_floor) {
		BookLib_floor = bookLib_floor;
	}
	public String getBookLib_room() {
		return BookLib_room;
	}
	public void setBookLib_room(String bookLib_room) {
		BookLib_room = bookLib_room;
	}
	public String getBookLib_shelf() {
		return BookLib_shelf;
	}
	public void setBookLib_shelf(String bookLib_shelf) {
		BookLib_shelf = bookLib_shelf;
	}
	
}
