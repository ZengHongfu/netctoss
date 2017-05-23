package com.zhf.action.fee;

import java.sql.SQLException;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Cost;

public class FeeDetail {
	String id;
	Cost cost;
	int page;
	FeeDao dao=DaoFactory.getFeeDao();
	public String execute(){
		try {
			cost=dao.findCostById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}
	
}
