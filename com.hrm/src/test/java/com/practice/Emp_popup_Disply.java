package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
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

public class Emp_popup_Disply {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileUtility fib=new FileUtility();
JavaUtility j= new JavaUtility();
String browser=fib.readdatafromproperty("browser");
String URL =fib.readdatafromproperty("url");
String USERNAME =fib.readdatafromproperty("username3");
String PASSWORD =fib.readdatafromproperty("password3");
ExcelUtility elib=new ExcelUtility();
String humanresource = elib.readdatafromExcel("Sheet4", 2, 0);
WebDriver driver;
WebdriverUtility wlib=new WebdriverUtility();
if (browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get(URL);
	wlib.maximize(driver);
	wlib.implicitWait(driver);
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
	driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
	WebElement type = driver.findElement(By.id("hr_type"));
	wlib.select(type, humanresource);
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	wlib.acceptAlert(driver);
	driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
	driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]")).click();
	boolean popup = driver.findElement(By.xpath("//div[@class=\"modal-header\"]/h4[text()='Add Employee']")).isDisplayed();
	if (popup) {
		System.out.println("Employee popup is displayed");
	}
	}

}
