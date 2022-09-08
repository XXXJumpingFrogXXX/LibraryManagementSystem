package com.model;

public class Reader {
	String IDnum;
	String name;
	String gender;
	String telnum;
	String birthday;
	String User_userID;
	
	public Reader() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Reader(String iDnum, String name, String gender, String telnum, String birthday) {
		super();
		IDnum = iDnum;
		this.name = name;
		this.gender = gender;
		this.telnum = telnum;
		this.birthday = birthday;
	}
	
	public Reader(String iDnum, String name, String gender, String telnum, String birthday, String user_userID) {
		super();
		IDnum = iDnum;
		this.name = name;
		this.gender = gender;
		this.telnum = telnum;
		this.birthday = birthday;
		User_userID = user_userID;
	}

	public String getIDnum() {
		return IDnum;
	}
	public void setIDnum(String iDnum) {
		IDnum = iDnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUser_userID() {
		return User_userID;
	}
	public void setUser_userID(String user_userID) {
		User_userID = user_userID;
	}

}
