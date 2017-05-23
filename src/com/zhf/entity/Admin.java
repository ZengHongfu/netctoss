package com.zhf.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
	private Integer ID;
	private String ADMIN_CODE;
	private String PASSWORD;
	private String NAME;
	private String TELEPHONE;
	private String EMAIL;
	private Date ENROLLDATE;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getADMIN_CODE() {
		return ADMIN_CODE;
	}
	public void setADMIN_CODE(String aDMINCODE) {
		ADMIN_CODE = aDMINCODE;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Date getENROLLDATE() {
		return ENROLLDATE;
	}
	public void setENROLLDATE(Date eNROLLDATE) {
		ENROLLDATE = eNROLLDATE;
	}
	
	
}
