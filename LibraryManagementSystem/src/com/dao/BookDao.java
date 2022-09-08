package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.model.Book;
import com.model.User;
import com.util.StringUtil;
import com.view.UserLogOnInterFrm;

public class BookDao {
	public int add(Connection con,Book book)throws Exception {
		//操作的记录数
		String sql="insert into book values(null,?,?,?,?,?,?,?,?,?,?)";
		java.sql.Date pubdate=java.sql.Date.valueOf(book.getPubDate());
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getTitle());
		pstmt.setString(2,book.getISBN());
		pstmt.setString(3,book.getWriter());
		pstmt.setString(4,book.getPublisher());
		pstmt.setDate(5,pubdate);
		pstmt.setInt(6,book.getPrice());
		pstmt.setInt(7,book.getBookNum());
		pstmt.setString(8,book.getBookLib_floor());
		pstmt.setString(9,book.getBookLib_room());
		pstmt.setString(10,book.getBookLib_shelf());
		return pstmt.executeUpdate();
	}

	public ResultSet list(Connection con, Book book) throws Exception {
		// TODO 自动生成的方法存根
		StringBuffer sb=new StringBuffer("select * from book");
		if(book.getBookID()!=-1) {
			sb.append(" and bookID ="+book.getBookID());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	public ResultSet list1(Connection con, Book book) throws Exception {
		// TODO 自动生成的方法存根
		StringBuffer sb=new StringBuffer("select bookID, title, writer, publisher, bookNum, BookLib_floor, BookLib_room, BookLib_shelf from book");
		
		if(!StringUtil.isEmpty(book.getTitle())) {
			sb.append(" and title like '%"+book.getTitle()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,Book book)throws Exception{

		java.sql.Date pubdate=java.sql.Date.valueOf(book.getPubDate());
		String sql="update book set title=?,ISBN=?,writer=?,publisher=?,pubDate=?,price=?,bookNum=?,BookLib_floor=?,BookLib_room=?,BookLib_shelf=? where bookID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getTitle());
		pstmt.setString(2,book.getISBN());
		pstmt.setString(3,book.getWriter());
		pstmt.setString(4,book.getPublisher());
		pstmt.setDate(5,pubdate);
		pstmt.setInt(6,book.getPrice());
		pstmt.setInt(7,book.getBookNum());
		pstmt.setString(8,book.getBookLib_floor());
		pstmt.setString(9,book.getBookLib_room());
		pstmt.setString(10,book.getBookLib_shelf());
		pstmt.setInt(11,book.getBookID());
		
		return pstmt.executeUpdate();
	}

	public int delete(Connection con,String id)throws Exception{
		String sql="delete from book where bookID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		int bookID=Integer.parseInt(id);
		pstmt.setInt(1, bookID);
		return pstmt.executeUpdate();
	}
	
	public int borrow(Connection con,int bookID,User user)throws Exception{

		String sql1="update book set bookNum=bookNum-1 where bookID=?";
		String sql2="insert into bookborrow values(?,?,?,?)";
		String sql3="select dayNum from user where userID=?";
		
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		PreparedStatement pstmt2=con.prepareStatement(sql2);
		PreparedStatement pstmt3=con.prepareStatement(sql3);
		
		pstmt1.setInt(1, bookID);
		pstmt3.setString(1,user.getUserID());
		
        ResultSet rs=pstmt3.executeQuery();
        if(rs.next()){
            user.setDayNum(rs.getInt("dayNum"));
        }
		
        
		LocalDate date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		String temp1=date.format(formatter);
		java.sql.Date beginDate=java.sql.Date.valueOf(temp1);
        

		Calendar calendar =new GregorianCalendar();
		calendar.setTime(beginDate);
		calendar.add(calendar.DATE, user.getDayNum());
		java.util.Date utilDate = (java.util.Date)calendar.getTime();
		java.sql.Date endDate =new java.sql.Date(utilDate.getTime());

		
		pstmt2.setString(1,user.getUserID());
		pstmt2.setInt(2,bookID);
		pstmt2.setDate(3,beginDate);
		pstmt2.setDate(4,endDate);
		
		pstmt2.execute();
		return pstmt1.executeUpdate();
	}
}
