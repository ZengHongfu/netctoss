package com.zhf.action.fee;

import java.sql.SQLException;

import com.zhf.dao.DaoFactory;
import com.zhf.dao.FeeDao;
import com.zhf.entity.Cost;

public class FeeAdd {
	String name;
	String feeType;
	String base_duration;
	String base_cost;
	String unit_cost;
	String descr;
	FeeDao dao=DaoFactory.getFeeDao();
	
	public String execute(){
		Cost cost=new Cost();
		int maxId=0;
		try {
			maxId = dao.findMaxId();
		} catch (SQLException e) {
			e.printStackTrace();
			//return "error";
		}
		int id=maxId+1;
		cost.setID(id);
		cost.setNAME(name);
		cost.setCOST_TYPE(Integer.parseInt(feeType));
		cost.setBASE_DURATION(Integer.parseInt(base_duration));
		cost.setBASE_COST(Integer.parseInt(base_cost));
		cost.setUNIT_COST(Integer.parseInt(unit_cost));
		cost.setDESCR(descr);
		try {
			dao.addCost(cost);
		} catch (SQLException e) {
			e.printStackTrace();
			//return "error";
		}
		
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getBase_duration() {
		return base_duration;
	}

	public void setBase_duration(String baseDuration) {
		base_duration = baseDuration;
	}

	public String getBase_cost() {
		return base_cost;
	}

	public void setBase_cost(String baseCost) {
		base_cost = baseCost;
	}

	public String getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(String unitCost) {
		unit_cost = unitCost;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
	
	
}
