package com.practice;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.Baseclass;

public class Admin_hrHead extends Baseclass {
	@Test (retryAnalyzer = com.hrm.GenericUtility.RetrImpclass.class)
	public void createAdmin() {
	fail();
		System.out.println("Admin created");	
	}
		
	@Test(retryAnalyzer = com.hrm.GenericUtility.RetrImpclass.class)
	public void editAdmin() {
	System.out.println("Admin edited");
	}
}
