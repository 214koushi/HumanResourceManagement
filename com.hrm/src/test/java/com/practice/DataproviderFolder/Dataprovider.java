package com.practice.DataproviderFolder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider{
	@Test(dataProvider = "family")
	public void getFamily(String father, String mother, String elder ,String younger) {
		System.out.println("FATHERNAME-->"+father+"  MOTHERNAME---->"+mother+"  ELDER---->"+elder+"   YOUNG--->"+younger);
	}
	
	@DataProvider
	public Object[][] family(){
		Object[][] obj=new Object[2][4];
		obj[0][0]="Nataraju";
		obj[0][1]="Anuradha";
		obj[0][2]="Karthik";
		obj[0][3]="Koushik";
		
		obj[1][0]="Nataraju";
		obj[1][1]="Manjula";
		obj[1][2]="Kruthik";
		obj[1][3]="Pruthvik";
		
		return obj;
		
		
	}
}
