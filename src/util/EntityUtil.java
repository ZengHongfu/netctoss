package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhf.entity.Account;
import com.zhf.entity.Cost;

public class EntityUtil {
	public static List<Cost> toCostList(ResultSet rs) throws SQLException{
		List<Cost> costList=new ArrayList<Cost>();
		while(rs.next()){
			Cost cost=new Cost();
			cost.setID(rs.getInt("ID"));
			cost.setNAME(rs.getString("NAME"));
			cost.setCOST_TYPE(rs.getInt("COST_TYPE"));
			cost.setBASE_DURATION(rs.getInt("BASE_DURATION"));
			cost.setBASE_COST(rs.getInt("BASE_COST"));
			cost.setUNIT_COST(rs.getInt("UNIT_COST"));
			cost.setSTATUS(rs.getString("STATUS"));
			cost.setDESCR(rs.getString("DESCR"));
			cost.setCREATE_TIME(rs.getDate("CREATE_TIME"));
			cost.setSTART_TIME(rs.getDate("START_TIME"));
			costList.add(cost);
		}
		return costList;
		
	}
	public static Cost toCost(ResultSet rs) throws SQLException{
		Cost cost=new Cost();
		if(rs.next()){
			cost.setID(rs.getInt("ID"));
			cost.setNAME(rs.getString("NAME"));
			cost.setCOST_TYPE(rs.getInt("COST_TYPE"));
			cost.setBASE_DURATION(rs.getInt("BASE_DURATION"));
			cost.setBASE_COST(rs.getInt("BASE_COST"));
			cost.setUNIT_COST(rs.getInt("UNIT_COST"));
			cost.setSTATUS(rs.getString("STATUS"));
			cost.setDESCR(rs.getString("DESCR"));
			cost.setCREATE_TIME(rs.getDate("CREATE_TIME"));
			cost.setSTART_TIME(rs.getDate("START_TIME"));
		}
		return cost;
	}
	
	public static List<Account> toAccountList(ResultSet rs)throws SQLException{
		List<Account> accountList=new ArrayList<Account>();
		while(rs.next()){
			Account account=new Account();
			account.setID(rs.getInt("ID"));
			account.setRECOMMENDER_ID(rs.getInt("RECOMMENDER_ID"));
			account.setLOGIN_NAME(rs.getString("LOGIN_NAME"));
			account.setLOGIN_PASSWD(rs.getString("LOGIN_PASSWD"));
			account.setSTATUS(rs.getString("STATUS"));
			account.setCREATE_DATE(rs.getDate("CREATE_DATE"));
			account.setPAUSE_DATE(rs.getDate("PAUSE_DATE"));
			account.setCLOSE_DATE(rs.getDate("CLOSE_DATE"));
			account.setREAL_NAME(rs.getString("REAL_NAME"));
			account.setIDCARD_NO(rs.getString("IDCARD_NO"));
			account.setBIRTHDATE(rs.getDate("BIRTHDATE"));
			account.setGENDER(rs.getString("GENDER"));
			account.setOCCUPATION(rs.getString("OCCUPATION"));
			account.setTELEPHONE(rs.getString("TELEPHONE"));
			account.setEMAIL(rs.getString("EMAIL"));
			account.setMAILADDRESS(rs.getString("MAILADDRESS"));
			account.setZIPCODE(rs.getString("ZIPCODE"));
			account.setQQ(rs.getString("QQ"));
			account.setLAST_LOGIN_TIME(rs.getDate("LAST_LOGIN_TIME"));
			account.setLAST_LOGIN_IP(rs.getString("LAST_LOGIN_IP"));
			accountList.add(account);
		}
		return accountList;
	}
	public static Account toAccount(ResultSet rs)throws SQLException{
		Account account=new Account();
		if(rs.next()){
			account.setID(rs.getInt("ID"));
			account.setRECOMMENDER_ID(rs.getInt("RECOMMENDER_ID"));
			account.setLOGIN_NAME(rs.getString("LOGIN_NAME"));
			account.setLOGIN_PASSWD(rs.getString("LOGIN_PASSWD"));
			account.setSTATUS(rs.getString("STATUS"));
			account.setCREATE_DATE(rs.getDate("CREATE_DATE"));
			account.setPAUSE_DATE(rs.getDate("PAUSE_DATE"));
			account.setCLOSE_DATE(rs.getDate("CLOSE_DATE"));
			account.setREAL_NAME(rs.getString("REAL_NAME"));
			account.setIDCARD_NO(rs.getString("IDCARD_NO"));
			account.setBIRTHDATE(rs.getDate("BIRTHDATE"));
			account.setGENDER(rs.getString("GENDER"));
			account.setOCCUPATION(rs.getString("OCCUPATION"));
			account.setTELEPHONE(rs.getString("TELEPHONE"));
			account.setEMAIL(rs.getString("EMAIL"));
			account.setMAILADDRESS(rs.getString("MAILADDRESS"));
			account.setZIPCODE(rs.getString("ZIPCODE"));
			account.setQQ(rs.getString("QQ"));
			account.setLAST_LOGIN_TIME(rs.getDate("LAST_LOGIN_TIME"));
			account.setLAST_LOGIN_IP(rs.getString("LAST_LOGIN_IP"));
			
		}
		return account;
	}
	
	
}
