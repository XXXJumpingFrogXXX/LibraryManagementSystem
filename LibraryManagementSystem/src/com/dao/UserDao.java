package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.model.User;
import com.util.StringUtil;

public class UserDao {
	public User login(Connection con, User user)throws Exception{
        User resultUser=null;
        String sql="select * from user where userID=? and userPsd=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getUserID());
        pstmt.setString(2,user.getUserPsd());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setUserID(rs.getString("userID"));
            resultUser.setUserPsd(rs.getString("userPsd"));
        }
        return resultUser;
    }
	
	public int findFine(Connection con, User user)throws Exception{
		int res=0;
        String sql="select fine from user where userID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getUserID());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            res=rs.getInt("fine");
        }
        return res;
    }
	
	public int checkFine(Connection con, User user)throws Exception{
		int res=0;
        String sql="select fine from user where userID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getUserID());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            res=rs.getInt("fine");
        }
        return res;
    }
	
	public int add(Connection con, User user)throws Exception {
		// TODO 自动生成的方法存根
		String sql="insert into user values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserID());
		pstmt.setString(2,user.getUserPsd());
		pstmt.setInt(3,user.getFine());
		pstmt.setInt(4,user.getDayNum());
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection con, User user) throws Exception {
		// TODO 自动生成的方法存根
		StringBuffer sb=new StringBuffer("select * from user");
		if(!StringUtil.isEmpty(user.getUserID())) {
			sb.append(" and userID like '%"+user.getUserID()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	public int update(Connection con, User user)throws Exception {
		// TODO 自动生成的方法存根
		String sql="update user set fine=?,dayNum=? where userID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,user.getFine());
		pstmt.setInt(2,user.getDayNum());
		pstmt.setString(3,user.getUserID());
		
		return pstmt.executeUpdate();
	}

	public int delete(Connection con, String id)throws Exception {
		// TODO 自动生成的方法存根
		String sql="delete from user where userID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public void confirmFine(Connection con, User user)throws Exception {
		// TODO 自动生成的方法存根
		String sql1="select b_endDate from bookborrow where User_userID=?";
		PreparedStatement pstmt1=con.prepareStatement(sql1);
		pstmt1.setString(1, user.getUserID());
        ResultSet rs=pstmt1.executeQuery();
        
        java.util.Date ddl = null;
        if(rs.next()){
           ddl = rs.getDate("b_endDate");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ddlDate = sdf.format(ddl);
        
        LocalDate tempDate = LocalDate.now(); 

        if((tempDate.minusDays(user.getDayNum())).toString().compareTo(ddlDate)>0) {
    		String sql2="update user set fine=fine+100 where userID=?";
    		PreparedStatement pstmt2=con.prepareStatement(sql2);
    		pstmt2.setString(1, user.getUserID());
    		pstmt2.execute();
        }
        
        return;
	}
}