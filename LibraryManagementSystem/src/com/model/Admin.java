package com.model;

/**
 * ����Աʵ����
 * @author ������
 *
 */
public class Admin {
    private String ID;
    private String password;
    
	public Admin() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
