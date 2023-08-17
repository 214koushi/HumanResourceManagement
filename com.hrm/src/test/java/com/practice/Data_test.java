package com.practice;

import org.testng.annotations.Test;

public class Data_test {

	@Test(dataProviderClass = Dataprovider.class, dataProvider = "family" )
	public void getFamily(String father, String mother, String elder ,String younger) {
		System.out.println("FATHERNAME-->"+father+"  MOTHERNAME---->"+mother+"  ELDER---->"+elder+"   YOUNG--->"+younger);
	}
	
	@Test(dataProviderClass = DataProvide.class ,dataProvider = "employe")
	public void getEmployee(String empname, String company, String compid, int salary) {
		System.out.println("EMPLOYEE"+empname+"   COMPANYNAME---->"+company+"    EMPLOYEEID--->"+compid+"WAGES"+salary);
	}
}
