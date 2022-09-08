package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.model.Book;
import com.model.BookBorrow;
import com.model.User;
import com.util.StringUtil;

public class BookBorrowDao {

	public ResultSet list(Connection con, BookBorrow bookBorrow)throws Exception {
		// TODO 自动生成的方法存根
		StringBuffer sb=new StringBuffer("select * from bookborrow");
		if(!StringUtil.isEmpty(bookBorrow.getUserID())) {
			sb.append(" and User_userID like '%"+bookBorrow.getUserID()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	
	public int returnB(Connection con, int bookID, User user)throws Exception {
		// TODO 自动生成的方法存根
		String sql1="update book set bookNum=bookNum+1 where bookID=?";
		String sql2="delete from bookborrow where User_userID=? and Book_bookID=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		
		pstmt1.setInt(1, bookID);
	
		pstmt2.setString(1,user.getUserID());
		pstmt2.setInt(2,bookID);
		
		pstmt2.execute();
		return pstmt1.executeUpdate();
	}
}
