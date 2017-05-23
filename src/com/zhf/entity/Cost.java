package com.zhf.entity;

import java.io.Serializable;
import java.util.Date;

public class Cost implements Serializable{
	private Integer ID;
	private String NAME;
	private Integer COST_TYPE;
	private Integer BASE_DURATION;
	private Integer BASE_COST;
	private Integer	UNIT_COST;
	private String STATUS;
	private String DESCR;
	private Date CREATE_TIME;
	private Date START_TIME;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Integer getCOST_TYPE() {
		return COST_TYPE;
	}
	public void setCOST_TYPE(Integer cOSTTYPE) {
		COST_TYPE = cOSTTYPE;
	}
	public Integer getBASE_DURATION() {
		return BASE_DURATION;
	}
	public void setBASE_DURATION(Integer bASEDURATION) {
		BASE_DURATION = bASEDURATION;
	}
	public Integer getBASE_COST() {
		return BASE_COST;
	}
	public void setBASE_COST(Integer bASECOST) {
		BASE_COST = bASECOST;
	}
	public Integer getUNIT_COST() {
		return UNIT_COST;
	}
	public void setUNIT_COST(Integer uNITCOST) {
		UNIT_COST = uNITCOST;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getDESCR() {
		return DESCR;
	}
	public void setDESCR(String dESCR) {
		DESCR = dESCR;
	}
	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}
	public void setCREATE_TIME(Date cREATETIME) {
		CREATE_TIME = cREATETIME;
	}
	public Date getSTART_TIME() {
		return START_TIME;
	}
	public void setSTART_TIME(Date sTARTTIME) {
		START_TIME = sTARTTIME;
	}
	
	
}
