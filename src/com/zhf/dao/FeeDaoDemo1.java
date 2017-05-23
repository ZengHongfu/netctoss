package com.zhf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import util.EntityUtil;

import com.zhf.entity.Cost;

public class FeeDaoDemo1 implements FeeDao{

	public List<Cost> findAll(int page,int pageSize) throws SQLException {
		List<Cost> costList=new ArrayList<Cost>();
		Connection conn=DBUtil.getConnection();
		//∑÷“≥≤È—Ø
		String sql="select c.*,ROWNUM rn from cost c";
		sql="select * from ("+sql+") where rn between ? and ?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, (page-1)*pageSize+1);
		ps.setInt(2, page*pageSize);
		ResultSet rs=ps.executeQuery();
		costList=EntityUtil.toCostList(rs);
		DBUtil.closeConnection();
		return costList;
	}

	public List<Cost> findAll() throws SQLException {
		List<Cost> costList=new ArrayList<Cost>();
		Connection conn=DBUtil.getConnection();
		String sql="select c.*,ROWNUM rn from cost c";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		costList=EntityUtil.toCostList(rs);
		DBUtil.closeConnection();
		return costList;
	}

	public void addCost(Cost cost) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="insert into cost values(?,?,?,?,?,?,'0',?,default,null)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt( 1,cost.getID() );
		ps.setString(2, cost.getNAME());
		ps.setInt(3, cost.getCOST_TYPE());
		ps.setInt(4, cost.getBASE_DURATION());
		ps.setInt(5, cost.getBASE_COST());
		ps.setInt(6, cost.getUNIT_COST());
		ps.setString(7, cost.getDESCR());
		ps.executeUpdate();
		DBUtil.closeConnection();
		
		
	}

	public int findMaxId() throws SQLException {
		int maxId=0;
		Connection conn=DBUtil.getConnection();
		String sql="select max(ID) maxId from cost";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			maxId=rs.getInt("maxId");
		}
		return maxId;
	}

	public void modifyCost(Cost cost) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="update cost set ID="+cost.getID()+" ";
		List<Object> objList=new ArrayList<Object>();
		if(!"".equals(cost.getNAME())&&cost.getNAME()!=null){
			sql+=",NAME=?";
			objList.add(cost.getNAME());
		}
		if(cost.getCOST_TYPE()!=null){
			sql+=",COST_TYPE=?";
			objList.add(cost.getCOST_TYPE());
		}
		if(cost.getBASE_DURATION()!=null){
			sql+=",BASE_DURATION=?";
			objList.add(cost.getBASE_DURATION());
		}
		if(cost.getBASE_COST()!=null){
			sql+=",BASE_COST=?";
			objList.add(cost.getBASE_COST());
		}
		if(cost.getUNIT_COST()!=null){
			sql+=",UNIT_COST=?";
			objList.add(cost.getUNIT_COST());
		}
		if(!"".equals(cost.getSTATUS())&&cost.getSTATUS()!=null){
			sql+=",STATUS=?";
			objList.add(cost.getSTATUS());
			sql+=",START_TIME=?";
			Date date=new Date(System.currentTimeMillis());
			objList.add(date);
		}
		if(!"".equals(cost.getDESCR())&&cost.getDESCR()!=null){
			sql+=",DESCR=?";
			objList.add(cost.getDESCR());
		}
		sql+=" where ID="+cost.getID();
		PreparedStatement ps=conn.prepareStatement(sql);
		int i=0;
		for(Object obj:objList){
			i++;
			ps.setObject(i, obj);
		}
		ps.executeUpdate();
	}

	public void deleteCost(int id) throws SQLException {
		Connection conn=DBUtil.getConnection();
		String sql="delete from cost where ID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		
		
	}

	public Cost findCostById(int id) throws SQLException{
		Cost cost;
		Connection conn=DBUtil.getConnection();
		String sql="select * from cost where ID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		cost=EntityUtil.toCost(rs);
		return cost;
	}

	

}
