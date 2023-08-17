package com.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestngFeatures {

	@BeforeClass
	public void config_BC() {
		System.out.println("-openbrowser-");
	}
	@BeforeMethod
	public void  cofig_BM() {
		System.out.println("-login-");
	}
	@BeforeSuite
	public void  config_BS() {
		System.out.println("-connect to database-");
	}
	@AfterClass
	public void config_AC() {
		System.out.println("-close browser-");
	}
	
	@Test
	public void hrm() {
		System.out.println("-HumanResourceManagement-");
	}
	@AfterMethod
	public void  cofig_AM() {
		System.out.println("-log out-");
	}
	@AfterSuite
	public void  cofig_AS() {
		System.out.println("-disconnect from database-");
	}
}
