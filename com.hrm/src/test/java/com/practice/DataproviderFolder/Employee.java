package com.practice.DataproviderFolder;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.IpthConstants;

public class Employee {

	@Test(dataProvider="Employeedata")
	public void empData() {
		
	}
	@DataProvider
	public void Employeedata() throws Throwable {
		FileInputStream fis=new FileInputStream(IpthConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet5");
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(1).getLastCellNum();
		Object[][] obj=new Object[lastrow+1][lastcell];
		WebDriver driver;
		driver=new ChromeDriver();
		driver.get(null);
		
		for (int i = 0; i <=lastrow; i++) {
			for (int j = 0; j < lastcell; j++) {
				
			}
		}
		
		
	}	
	
	
	
	
}
