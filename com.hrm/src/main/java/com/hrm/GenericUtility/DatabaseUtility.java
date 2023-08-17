package com.hrm.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	/**
	 * @author Koushik MN
	 * @throws SQLException
	 */
 public void connectTodatabase() throws SQLException {
	 Driver d=new Driver();
	 DriverManager.registerDriver(d);
	 con = DriverManager.getConnection(IpthConstants.dbURL, IpthConstants.dbUsername, IpthConstants.dbPassword);
 }
 /**
  * @author Koushik MN
  * @param query
  * @param coloumnindex
  * @param Expecteddata
  * @return
  * @throws SQLException
  */
 public String createStatementandExecute(String query,int coloumnindex,String Expecteddata) throws SQLException {
	 Statement state = con.createStatement();
	ResultSet result = state.executeQuery(query);
	 boolean flag=false;
	 while (result.next()) {
		String data = result.getString(coloumnindex);
		if (data.equalsIgnoreCase(Expecteddata)) {
			flag=true;
			break;
		}
	}
	 if (flag) {
		System.out.println("data validated");
		return Expecteddata;
	}
	 else
		 System.out.println("data is not validated");
	 return "";
 }
 /**
  * @author Koushik MN
  * @throws SQLException
  */
 public void closedatabase() throws SQLException {
	 con.close();
 }
}
