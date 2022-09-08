package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Book;
import com.model.Reader;
import com.model.User;
import com.util.StringUtil;

public class ReaderDao {
	public ResultSet list(Connection con, User user) throws Exception {
		// TODO 自动生成的方法存根
		StringBuffer sb=new StringBuffer("select * from reader");
		
		if(!StringUtil.isEmpty(user.getUserID())) {
			sb.append(" and User_userID like '%"+user.getUserID()+"%'");
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int add(Connection con,Reader reader)throws Exception {
		//操作的记录数
		String sql="insert into reader values(?,?,?,?,?,?)";
		java.sql.Date birthday=java.sql.Date.valueOf(reader.getBirthday());
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,reader.getIDnum());
		pstmt.setString(2,reader.getName());
		pstmt.setString(3,reader.getGender());
		pstmt.setString(4,reader.getTelnum());
		pstmt.setDate(5,birthday);
		pstmt.setString(6,reader.getUser_userID());

		return pstmt.executeUpdate();
	}
	
	public int update(Connection con,Reader reader)throws Exception{
		java.sql.Date birthday=java.sql.Date.valueOf(reader.getBirthday());
		String sql="update reader set name=?,gender=?,telnum=?,birthday=?,User_userID=? where IDnum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,reader.getName());
		pstmt.setString(2,reader.getGender());
		pstmt.setString(3,reader.getTelnum());
		pstmt.setDate(4,birthday);
		pstmt.setString(5,reader.getUser_userID());
		pstmt.setString(6,reader.getIDnum());
		
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from reader where IDnum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
}