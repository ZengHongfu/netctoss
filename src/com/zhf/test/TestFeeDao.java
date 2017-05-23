package com.zhf.test;

import java.sql.SQLException;
import java.util.List;

import com.zhf.dao.AccountDao;
import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Account;
import com.zhf.entity.Cost;

public class TestFeeDao {
	public static void main(String[] args) throws SQLException{
//		FeeDao dao=DaoFactory.getFeeDao();
//		List<Cost> costList=dao.findAll();
//		for(Cost cost:costList){
//			System.out.println(cost.getID()+cost.getNAME()+cost.getCREATE_TIME()+",,,"+cost.getSTART_TIME());
//		}
		
		AccountDao aDao=DaoFactory.getAccountDao();
		List<Account> accountList=aDao.findAll();
		for(Account account :accountList){
			System.out.println(account.getLOGIN_NAME()+",,"+account.getCREATE_DATE());
		}
	}
}
