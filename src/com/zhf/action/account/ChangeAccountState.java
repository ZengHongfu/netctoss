package com.zhf.action.account;

import java.sql.SQLException;

import com.zhf.dao.AccountDao;
import com.zhf.dao.DaoFactory;
import com.zhf.entity.Account;

public class ChangeAccountState {
	String id;
	String state;
	String page;
	AccountDao dao=DaoFactory.getAccountDao();
	public String execute() {
		Account account=new Account();
		account.setID(Integer.parseInt(id));
		account.setSTATUS(state);
		try {
			dao.updateAccount(account);
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
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
}
