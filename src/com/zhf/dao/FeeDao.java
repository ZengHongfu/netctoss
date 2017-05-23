package com.zhf.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhf.entity.Cost;

public interface FeeDao {
	public List<Cost> findAll (int page,int pageSize)throws SQLException;
	public List<Cost> findAll ()throws SQLException;
	public int findMaxId() throws SQLException;
	public void addCost(Cost cost)throws SQLException;
	public void modifyCost(Cost cost)throws SQLException;
	public void deleteCost(int id)throws SQLException;
	public Cost findCostById(int id)throws SQLException;
}
