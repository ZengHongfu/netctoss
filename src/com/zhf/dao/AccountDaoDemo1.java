package com.zhf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import util.EntityUtil;

import com.zhf.entity.Account;
import com.zhf.entity.Cost;

public class AccountDaoDemo1 implements AccountDao{

	public List<Account> findAll(Account account) throws SQLException {
		List<Account> accountList=new ArrayList<Account>();
		Connection conn=DBUtil.getConnection();
		String sql="select a.*,ROWNUM rn from account a where 1=1 ";
		List<Object> objList=new ArrayList<Object>();
		if(account.getSTATUS()!=null&&!"".equals(account.getSTATUS())){
			sql+="and status=?";
			objList.add(account.getSTATUS());
		}
		if(account.getIDCARD_NO()!=null){
			sql+=" and IDCARD_NO like ?";
			objList.add("%"+account.getIDCARD_NO()+"%");
		}
		if(account.getREAL_NAME()!=null){
			sql+=" and REAL_NAME like ?";
			objList.add("%"+account.getREAL_NAME()+"%");
		}
		if(account.getLOGIN_NAME()!=null){
			sql+=" and LOGIN_NAME like ?";
			objList.add("%"+account.getLOGIN_NAME()+"%");
		}
		PreparedStatement ps=conn.prepareStatement(sql);
		int i=0;
		for(Object obj:objList){
			i++;
			ps.setObject(i, obj);
		}
		ResultSet rs=ps.executeQuery();
		accountList=EntityUtil.toAccountList(rs);
		DBUtil.closeConnection();
		return accountList;
	}
	/**
	 * ∑÷“≥≤È—Ø
	 */
	public List<Account> findAll(int page,int pageSize,Account account) throws SQLException {
		List<Account> accountList=new ArrayList<Account>();
		Connection conn=DBUtil.getConnection();
		String sql="select a.*,ROWNUM rn from account a where 1=1 ";
		List<Object> objList=new ArrayList<Object>();
		if(account.getSTATUS()!=null&&!"".equals(account.getSTATUS())){
			sql+="and status=?";
			objList.add(account.getSTATUS());
		}
		if(account.getIDCARD_NO()!=null){
			sql+=" and IDCARD_NO like ?";
			objList.add("%"+account.getIDCARD_NO()+"%");
		}
		if(account.getREAL_NAME()!=null){
			sql+=" and REAL_NAME like ?";
			objList.add("%"+account.getREAL_NAME()+"%");
		}
		if(account.getLOGIN_NAME()!=null){
			sql+=" and LOGIN_NAME like ?";
			objList.add("%"+account.getLOGIN_NAME()+"%");
		}
		sql="select * from ("+sql+") where rn between ? and ?";
		PreparedStatement ps=conn.prepareStatement(sql);
		objList.add((page-1)*pageSize+1);
		objList.add(page*pageSize);
		//ps.setInt(1, (page-1)*pageSize+1);
		//ps.setInt(2,page*pageSize);
		int i=0;
		for(Object obj:objList){
			i++;
			ps.setObject(i, obj);
		}
		ResultSet rs=ps.executeQuery();
		accountList=EntityUtil.toAccountList(rs);
		DBUtil.closeConnection();
		return accountList;
	}
	public void updateAccount(Account account) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="update account set id="+account.getID();
		List<Object> objList=new ArrayList<Object>();
		if(account.getSTATUS()!=null&&!"".equals(account.getSTATUS())){
			sql+=",status=?";
			objList.add(account.getSTATUS());
		}
		sql+=" where id="+account.getID();
		PreparedStatement ps=conn.prepareStatement(sql);
		int i=0;
		for(Object obj:objList){
			i++;
			ps.setObject(i, obj);
		}
		ps.executeUpdate();
		DBUtil.closeConnection();
	}
	

}
