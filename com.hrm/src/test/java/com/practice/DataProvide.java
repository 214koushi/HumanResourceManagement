package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {

	@Test(dataProviderClass = Dataprovider.class, dataProvider = "family" )
	public void getFamily(String father, String mother, String elder ,String younger) {
		System.out.println("FATHERNAME-->"+father+"  MOTHERNAME---->"+mother+"  ELDER---->"+elder+"   YOUNG--->"+younger);
	}
	
	@Test(dataProvider = "employe")
	public void getEmployee(String empname, String company, String compid, int salary) {
		System.out.println("EMPLOYEE"+empname+"   COMPANYNAME---->"+company+"    EMPLOYEEID--->"+compid+"WAGES"+salary);
	}
	@DataProvider
	public Object[][] employe(){
		Object[][] obj=new Object[2][4];
		
		obj[0][0]="arjuna";
		obj[0][1]="TYSS";
		obj[0][2]="TY0123";
		obj[0][3]=50000;
		
		obj[1][0]="Rama";
		obj[1][1]="SONY";
		obj[1][2]="SO432";
		obj[1][3]=700000;
		
		 return obj;
	}
}
