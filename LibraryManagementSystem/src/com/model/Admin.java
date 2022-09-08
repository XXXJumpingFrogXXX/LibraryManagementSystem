package com.model;

/**
 * 管理员实体类
 * @author 王麒翔
 *
 */
public class Admin {
    private String ID;
    private String password;
    
	public Admin() {
		super();
		// TODO 自动生成的构造函数存根
	} 
	public Admin(String iD, String password) {
		super();
		ID = iD;
		this.password = password;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
