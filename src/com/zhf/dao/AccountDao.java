package com.zhf.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhf.entity.Account;

public interface AccountDao {
	public List<Account> findAll(Account account)throws SQLException;
	public List<Account> findAll(int page,int pageSize,Account account)throws SQLException;
	public void updateAccount(Account account) throws SQLException;
	
}
