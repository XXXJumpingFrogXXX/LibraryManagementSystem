package com.model;

public class BookBorrow {
	String userID;
	int bookID;
	String beginDate;
	String endDate;
	
	public BookBorrow() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public BookBorrow(String userID) {
		super();
		this.userID = userID;
	}

	public BookBorrow(String userID, int bookID, String beginDate, String endDate) {
		super();
		this.userID = userID;
		this.bookID = bookID;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
