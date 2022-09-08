package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Admin;
import com.model.Book;


public class AdminDao {
	public Admin login(Connection con, Admin admin)throws Exception{
        Admin resultAdmin=null;
        String sql="select * from administrator where adminID=? and adminPsd=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,admin.getID());
        pstmt.setString(2,admin.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultAdmin=new Admin();
            resultAdmin.setID(rs.getString("adminID"));
            resultAdmin.setPassword(rs.getString("adminPsd"));
        }
        return resultAdmin;
    }
	
	public int add(Connection con,Admin admin)throws Exception {
		//操作的记录数
		String sql="insert into Administrator values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,admin.getID());
		pstmt.setString(2,admin.getPassword());
		return pstmt.executeUpdate();
	}
}
