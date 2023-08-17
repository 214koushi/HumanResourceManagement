package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceltest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		int row=0;
		
		for (int i = row; i < 10; i++) {
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Abcd.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet1");
Row ro = sh.getRow(i);
Cell c = ro.getCell(0);
String value = c.getStringCellValue();
System.out.println(value);
wb.close();
		}


	}

}
