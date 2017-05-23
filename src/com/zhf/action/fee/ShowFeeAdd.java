package com.zhf.action.fee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Cost;

public class ShowFeeAdd implements SessionAware{
	Map<String ,Object> session;
	FeeDao dao=DaoFactory.getFeeDao();
	List<Cost> costList;
	
	public String execute(){
		
		if(session.get("id")==null){
			return "error";
		}
		
		return "success";
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Cost> getCostList() {
		return costList;
	}

	public void setCostList(List<Cost> costList) {
		this.costList = costList;
	}
	
	
	
}
