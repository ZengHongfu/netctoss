package com.zhf.action.fee;

import java.sql.SQLException;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Cost;

public class StartFee {
	String id;
	FeeDao dao=DaoFactory.getFeeDao();
	public String execute(){
		Cost cost=new Cost();
		cost.setID(Integer.parseInt(id));
		cost.setSTATUS("1");
		try {
			dao.modifyCost(cost);
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
	
	
	
	
}
