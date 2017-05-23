package com.zhf.action.fee;

import java.sql.SQLException;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;

public class DeleteFee {
	String id;
	FeeDao dao=DaoFactory.getFeeDao();
	public String execute(){
		try {
			dao.deleteCost(Integer.parseInt(id));
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
}
