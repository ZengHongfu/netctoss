package com.zhf.action.fee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Cost;

public class ShowFee implements SessionAware{
	Map<String ,Object> session;
	FeeDao dao=DaoFactory.getFeeDao();
	List<Cost> costList;
	int page;
	int pageNum;
	
	public String execute(){
		int pageSize=2;
		if(page<=0){
			page=1;
		}
		if(session.get("id")==null){
			return "error";
		}
		try {
			costList=dao.findAll();
			pageNum=costList.size()/pageSize;
			if(page>pageNum){
				page=pageNum;
			}
			costList=dao.findAll(page,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
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

	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
}
