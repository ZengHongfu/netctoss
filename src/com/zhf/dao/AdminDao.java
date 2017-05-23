package com.zhf.dao;

import java.sql.SQLException;

import com.zhf.entity.Admin;


public interface AdminDao {
	public Integer findAdmin(String adminCode,String password) throws SQLException;
	
}
