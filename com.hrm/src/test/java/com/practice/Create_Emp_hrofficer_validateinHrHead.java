package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
public class Create_Emp_hrofficer_validateinHrHead {
	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
FileUtility fib=new FileUtility();
String browser=fib.readdatafromproperty("browser");
String URL =fib.readdatafromproperty("url");
String USERNAME =fib.readdatafromproperty("username3");
String PASSWORD =fib.readdatafromproperty("password3");
ExcelUtility elib=new ExcelUtility();
JavaUtility jlib=new JavaUtility();
String Corporate = elib.readdatafromExcel("Sheet1", 1, 0);
String branch = elib.readdatafromExcel("Sheet2", 1, 0);
String compid = elib.readdatafromExcel("Sheet3", 2, 0)+jlib.getRandomno();
String firstname =  elib.readdatafromExcel("Sheet3", 2, 1)+jlib.getRandomno();;
String lastname =  elib.readdatafromExcel("Sheet3", 2, 2)+jlib.getRandomno();
String middlename =  elib.readdatafromExcel("Sheet3", 2, 3)+jlib.getRandomno();;
String datefrom =  elib.readdatafromExcel("Sheet3", 2, 4)+jlib.getRandomno();
String recentdate = elib.readdatafromExcel("Sheet3", 2, 5)+jlib.getRandomno();
String position = elib.readdatafromExcel("Sheet3", 2, 6)+jlib.getRandomno();
String contact =  elib.readdatafromExcel("Sheet3", 2, 7)+jlib.getRandomno();
String hdmf =  elib.readdatafromExcel("Sheet3", 2, 8)+jlib.getRandomno();
String gsis =  elib.readdatafromExcel("Sheet3", 2, 9)+jlib.getRandomno();
String Humanresource =  elib.readdatafromExcel("Sheet4", 2, 0);
WebDriver driver;
if (browser.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
else
{
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	}
driver.get(URL);
driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
WebElement type = driver.findElement(By.id("hr_type"));
WebdriverUtility wlib=new WebdriverUtility();
wlib.select(type, Humanresource);
driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
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
driver.findElement(By.name("employee_department")).sendKeys(Corporate);
driver.findElement(By.name("employee_branches")).sendKeys(branch);
driver.findElement(By.name("employee_position")).sendKeys(position);
driver.findElement(By.name("employee_contact")).sendKeys(contact);
driver.findElement(By.name("employee_hdmf_pagibig")).sendKeys(hdmf);
driver.findElement(By.name("employee_gsis")).sendKeys(gsis);

WebElement file = driver.findElement(By.xpath("(//input[@name=\"employee_file201\"])[1]"));
fib.fileupload(file);
WebElement image = driver.findElement(By.xpath("(//input[@name=\"employee_image\"])[1]"));
fib.imageupload(image);
driver.findElement(By.xpath("//button[@name='emplo']")).click();
wlib.acceptAlert(driver);
driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
driver.findElement(By.xpath("//i[@class=\"fa fa-power-off\"]")).click();
wlib.acceptAlert(driver);
String USERNAME1 = fib.readdatafromproperty("username1");
String PASSWORD1 = fib.readdatafromproperty("password1");
driver.get(URL);
driver.findElement(By.name("hr_email")).sendKeys(USERNAME1);
driver.findElement(By.name("hr_password")).sendKeys(PASSWORD1);
WebElement type1 = driver.findElement(By.id("hr_type"));
String Humanresource1 =elib.readdatafromExcel("Sheet4", 1, 0);
wlib.select(type1, Humanresource1);
driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
wlib.acceptAlert(driver);
driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(firstname);
String Firstname=firstname;
boolean empname = driver.findElement(By.xpath("//table[@id=\"example1\"]//td[text()='"+Firstname+"']")).isDisplayed();
if (empname) {
	System.out.println("Employee created by Hr officer is displayed in Hr head");
}
driver.close();
	}

}
