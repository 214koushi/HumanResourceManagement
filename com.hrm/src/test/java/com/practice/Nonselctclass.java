package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Nonselctclass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method 
Driver d=new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50\", \"root\", \"root");
Statement state = con.createStatement();
int a = state.executeUpdate("insert into car values('toyata',4,'velfair');");
if (a>0) {
	System.out.println("rows updated");
}
	}

}
