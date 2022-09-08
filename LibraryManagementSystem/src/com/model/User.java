package com.model;

public class User {
	String userID;
	String userPsd;
	int fine=0;
	int dayNum=30;
	
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public User(String userID, String userPsd) {
		super();
		this.userID = userID;
		this.userPsd = userPsd;
	}

	public User(String userID, int fine, int dayNum) {
		super();
		this.userID = userID;
		this.fine = fine;
		this.dayNum = dayNum;
	}

	public User(String userID, String userPsd, int fine, int dayNum) {
		super();
		this.userID = userID;
		this.userPsd = userPsd;
		this.fine = fine;
		this.dayNum = dayNum;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPsd() {
		return userPsd;
	}
	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public int getDayNum() {
		return dayNum;
	}
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

}
