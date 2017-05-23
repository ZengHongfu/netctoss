package com.zhf.dao;



public class DaoFactory {
	public static AdminDao getAdminDao(){
		AdminDao dao=new AdminDaoDemo1();
		return dao;
	}
	public static FeeDao getFeeDao(){
		FeeDao dao=new FeeDaoDemo1();
		return dao;
	}
	public static AccountDao getAccountDao(){
		AccountDao dao=new AccountDaoDemo1();
		return dao;
	}
}
