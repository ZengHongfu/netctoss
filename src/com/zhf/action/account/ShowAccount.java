package com.zhf.action.account;

import java.sql.SQLException;
import java.util.List;

import com.zhf.dao.AccountDao;
import com.zhf.dao.DaoFactory;
import com.zhf.entity.Account;

public class ShowAccount {
	List<Account> accountList;
	String pageString="1";
	int page;
	int pageNum;
	String idcardNo="不验证";
	String realName="不验证";
	String loginName="不验证";
	String state="-1";
	AccountDao dao=DaoFactory.getAccountDao();
	
	public String execute(){
		//System.out.println(idcardNo+realName+loginName+state+"///////////////////////////////////////////////////////////////////");
		Account account=new Account();
		if(idcardNo!=null&&!idcardNo.equals("不验证")){
			account.setIDCARD_NO(idcardNo.trim());
		}
		if(realName!=null&&!realName.equals("不验证")){
			account.setREAL_NAME(realName.trim());
		}
		if(loginName!=null&&!loginName.equals("不验证")){
			account.setLOGIN_NAME(loginName.trim());
		}
		if(state!=null&&!"-1".equals(state)){
			account.setSTATUS(state);
		}
		int pageSize=2;
System.out.println("hello-pageString:"+pageString);
		page=Integer.parseInt(pageString);
		try {
			int size=dao.findAll(account).size();
			if(size%2==0){
				pageNum=size/pageSize;
			}else{
				pageNum=size/pageSize+1;
			}
			if(page<=0){
				page=1;
			}
			if(page>pageNum){
				page=pageNum;
			}
			accountList=dao.findAll(page,pageSize,account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
System.out.println("hello-page:"+page);
		return "success";
	}
	
	
	
	
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
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




	public String getIdcardNo() {
		return idcardNo;
	}




	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}




	public String getRealName() {
		return realName;
	}




	public void setRealName(String realName) {
		this.realName = realName;
	}




	public String getLoginName() {
		return loginName;
	}




	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getPageString() {
		return pageString;
	}




	public void setPageString(String pageString) {
		this.pageString = pageString;
	}
}
