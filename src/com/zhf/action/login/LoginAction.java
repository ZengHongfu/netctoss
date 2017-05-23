package com.zhf.action.login;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.zhf.dao.AdminDao;
import com.zhf.dao.DaoFactory;


public class LoginAction implements SessionAware{
	String name;
	String pwd;
	String verCode;
	String ok;
	private Map<String,Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getVerCode() {
		return verCode;
	}

	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	private AdminDao dao=DaoFactory.getAdminDao();
	public String execute() throws SQLException{
		//System.out.println("excute()..."+name+","+pwd);
		if(!session.get("verificationCode").equals(verCode)){
			ok="vc_error";
			return "error";
		}
		Integer id=dao.findAdmin(name, pwd);
		if(id==null){
			ok="false";
			return "error";
		}
		session.put("id", id);
		ok="true";
		return "success";
	}
}
