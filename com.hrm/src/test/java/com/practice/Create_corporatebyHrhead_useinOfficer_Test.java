package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.FileUtility;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_corporatebyHrhead_useinOfficer_Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileUtility fib=new FileUtility();
String BROWSER = fib.readdatafromproperty("browser");
String URL = fib.readdatafromproperty("url");
String USERNAME = fib.readdatafromproperty("username1");
String PASSWORD = fib.readdatafromproperty("password1");
ExcelUtility elib=new ExcelUtility();
String Humanresource = elib.readdatafromExcel("Sheet4", 1, 0);
WebDriver driver;
if (BROWSER.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
	driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
	WebElement type = driver.findElement(By.id("hr_type"));
	WebdriverUtility wlib=new WebdriverUtility();
	wlib.select(type, Humanresource);
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	wlib.acceptAlert(driver);
driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
driver.findElement(By.xpath("//p[text()='Add Corporate']")).click();
driver.findElement(By.xpath("//button[contains(text(),'Add Corporate')]")).click();
JavaUtility jlib=new JavaUtility();
String Corporate_name=elib.readdatafromExcel("Sheet1", 1, 0)+jlib.getRandomno();
driver.findElement(By.name("corporate_name")).sendKeys(Corporate_name);
driver.findElement(By.xpath("//button[@name='corp']")).click();
driver.switchTo().alert().accept();
driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
wlib.acceptAlert(driver);
String USERNAME1 = fib.readdatafromproperty("username3");
String PASSWORD1 = fib.readdatafromproperty("password3");
driver.findElement(By.name("hr_email")).sendKeys(USERNAME1);
driver.findElement(By.name("hr_password")).sendKeys(PASSWORD1);
WebElement type1 = driver.findElement(By.id("hr_type"));
String humanresource1 = elib.readdatafromExcel("Sheet4", 2, 0);
wlib.select(type1, humanresource1);
driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//wlib.acceptAlert(driver);
String compid = elib.readdatafromExcel("Sheet3", 5, 1)+jlib.getRandomno();
String firstname = elib.readdatafromExcel("Sheet3", 6, 1)+jlib.getRandomno();
String lastname = elib.readdatafromExcel("Sheet3", 7, 1)+jlib.getRandomno();
String middlename =elib.readdatafromExcel("Sheet3", 8, 1)+jlib.getRandomno();
String datefrom = elib.readdatafromExcel("Sheet3", 9, 1)+jlib;
String recentdate = elib.readdatafromExcel("Sheet3", 10, 1);
String position = elib.readdatafromExcel("Sheet3", 11, 1)+jlib.getRandomno();
String contact = elib.readdatafromExcel("Sheet3", 12, 1)+jlib.getRandomno();
String hdmf = elib.readdatafromExcel("Sheet3", 13, 1)+jlib.getRandomno();
String gsis = elib.readdatafromExcel("Sheet3", 14, 1)+jlib.getRandomno();
wlib.acceptAlert(driver);
driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]")).click();
driver.findElement(By.name("employee_companyid")).sendKeys(compid);
driver.findElement(By.name("employee_firstname")).sendKeys(firstname);
driver.findElement(By.name("employee_lastname")).sendKeys(lastname);
driver.findElement(By.name("employee_middlename")).sendKeys(middlename);
driver.findElement(By.name("branches_datefrom")).sendKeys(datefrom);
driver.findElement(By.name("branches_recentdate")).sendKeys(recentdate);
driver.findElement(By.name("employee_position")).sendKeys(position);
driver.findElement(By.name("employee_contact")).sendKeys(contact);
driver.findElement(By.name("employee_hdmf_pagibig")).sendKeys(hdmf);
driver.findElement(By.name("employee_gsis")).sendKeys(gsis);
WebElement Department = driver.findElement(By.name("employee_department"));
wlib.select(Department, Corporate_name);
WebElement branch = driver.findElement(By.name("employee_branches"));
String branch_Name = elib.readdatafromExcel("Sheet2", 1, 0);
wlib.select(branch, branch_Name);
WebElement file = driver.findElement(By.xpath("(//input[@name=\"employee_file201\"])[1]"));
fib.fileupload(file);
WebElement image = driver.findElement(By.xpath("(//input[@name=\"employee_image\"])[1]"));
fib.imageupload(image);
driver.findElement(By.xpath("//button[@name=\"emplo\"]")).click();
Alert pop = driver.switchTo().alert();
String poptext = pop.getText();
System.out.println(poptext);
pop.accept();
if (poptext != null) {
	System.out.println("Corporate created by Hr head is sucesfully added to corporate list");
}
driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
wlib.acceptAlert(driver);
}}
