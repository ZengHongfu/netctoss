package com.zhf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhf.entity.Admin;

import util.DBUtil;


public class AdminDaoDemo1 implements AdminDao{

	public  Integer findAdmin(String adminCode, String password) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="select ID from admin_info where ADMIN_CODE=? and PASSWORD=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, adminCode);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			Integer id=rs.getInt(1);
			return id;
		}
	
		return null;
	}

}
