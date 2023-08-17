package com.hrm.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * This method is used to read data from excel
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
public String  readdatafromExcel(String sheetname, int rowno, int cellno) throws Throwable {
	FileInputStream fis1=new FileInputStream(IpthConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis1);
	String data = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	return data;
}
/**
 * This method is used to write data into excel
 * @param sheetname
 * @param rowno
 * @param cellno
 * @throws Throwable
 */
public void writedataintoexcel(String sheetname, int rowno, int cellno, String value) throws Throwable {
	FileInputStream fis1=new FileInputStream(IpthConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis1);
	wb.getSheet(sheetname).getRow(rowno).getCell(cellno).setCellValue(value);
	FileOutputStream fot=new FileOutputStream(IpthConstants.Excelpath);
	wb.write(fot);
	wb.close();
}
/**
 * This method is used to get last row number from excel 
 * @param sheetname
 * @return
 * @throws Throwable
 */
public int getLastRowNumber(String sheetname) throws Throwable {
	FileInputStream fis1=new FileInputStream(IpthConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet(sheetname);
	int count = sh.getLastRowNum();
	return count;
	
}
/**
 * This method is used to get the multiple data from excel
 * @param sheetname
 * @param keyCelno
 * @param valueCelno
 * @return
 * @throws Throwable
 */
public HashMap<String, String> getMultipleDataFromExcelAdmin(String sheetname ,int keyCelno ,int valueCelno,int j) throws Throwable {
	FileInputStream fis1=new FileInputStream(IpthConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet(sheetname);
	int count = sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for (int i=j; i <=count; i++) {
		String key=sh.getRow(i).getCell(keyCelno).getStringCellValue();
	    String value=sh.getRow(i).getCell(valueCelno).getStringCellValue();
				map.put(key, value);
	}
	return map;
}

public  void getMultipledatafromExcel(String sheetname ,int keyCelno ,int valueCelno,int j) throws Throwable {
	FileInputStream fis1=new FileInputStream(IpthConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet(sheetname);
	int count = sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for (int i=j; i <=count; i++) {
		String key=sh.getRow(i).getCell(keyCelno).getStringCellValue();
			    String value=sh.getRow(i).getCell(valueCelno).getStringCellValue();
				map.put(key, value);
	}
}
public Object[][] multipledatafromDataprovider(String sheetname, int a) throws Throwable {
	
		FileInputStream fis=new FileInputStream(IpthConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrownum = sh.getLastRowNum();
		int lastcellnum = sh.getRow(a).getLastCellNum();
		Object[][] obj=new Object[lastrownum+1][lastcellnum];
		for (int i = 0; i <=lastrownum; i++) {
			for (int j = 0; j < lastcellnum; j++) {
				
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}

