package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Selectclass {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50", "root", "root");
		Statement state = con.createStatement();
	ResultSet result = state.executeQuery("select* from car;");
while (result.next()) {
	System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
		
	}

}
