package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceltest1 {

	public static void main(String[] args) throws IOException,EncryptedDocumentException {
		// TODO Auto-generated method stub
int row=0;
		
		for (int i = row; i < 10; i++) {
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Abcd.xlsx");
Workbook wb = WorkbookFactory.create(fis);
FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Abcd.xlsx");
 wb.getSheet("Sheet1").getRow(i).getCell(4).setCellValue("Testyantra");
wb.write(fos);
wb.close();
	}

}}
