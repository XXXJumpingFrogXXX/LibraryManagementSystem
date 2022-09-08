package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DbUtil {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/library?useUnicode=true&characterEncoding=GBK&serverTimezone=GMT%2B8&useSSL=true";
    static final String USERNAME = "myuser"; //�û���
    static final String PASSWORD = "XXX"; //�޸�Ϊ���Լ������ݿ����뼴��
    Statement stmt = null;

    public Connection getCon() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        return con;
    }
    
    public void closeCon(Connection con)throws Exception{
        if(con!=null){
            con.close();
        }
    }
    
    public static void main(String[]args){
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("���ӳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("����ʧ��");
        }
    }

}