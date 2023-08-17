package com.practice.DataproviderFolder;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.IpthConstants;

public class ExceldataFetchDP {

	@Test(dataProvider = "fetchData")
	public void FetchData(String comp,String pos, String emps, String sal, String loc) {
		System.out.println("COMPANY-->"+comp+"POSITION-->"+pos+"EMPLOYEE--->"+emps+"SALARY--->"+sal+"LOCATION-->"+loc);
	}
	@DataProvider
	public Object[][] fetchData() throws Throwable {
		FileInputStream fis=new FileInputStream(IpthConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet6");
		int lastrownum = sh.getLastRowNum();
		int lastcellnum = sh.getRow(1).getLastCellNum();
		System.out.println(lastrownum);
		System.out.println(lastcellnum);
		Object[][] obj=new Object[lastrownum+1][lastcellnum];
		for (int i = 0; i <=lastrownum; i++) {
			for (int j = 0; j < lastcellnum; j++) {
				
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
