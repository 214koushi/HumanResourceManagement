package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_EmpbyHr_officer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Random ran=new Random();
		int random = ran.nextInt(400);
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test.properties");
Properties p=new Properties();
p.load(fis);
String browser=p.getProperty("browser");
String URL = p.getProperty("url");
String USERNAME = p.getProperty("username3");
String PASSWORD = p.getProperty("password3");
FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\HR_Automate1.xlsx");
Workbook wb = WorkbookFactory.create(fi);
String humanresource = wb.getSheet("Sheet4").getRow(2).getCell(0).getStringCellValue();
String Emptobesearch = wb.getSheet("Sheet3").getRow(6).getCell(1).getStringCellValue();
WebDriver driver;
if (browser.equalsIgnoreCase("firefox")) {
	/*WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();*/
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
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
	Select s=new Select(type);
	s.selectByValue(humanresource);
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
	driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
	driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(Emptobesearch);
	boolean display = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+Emptobesearch+"')]")).isDisplayed();
	if (display) {
		driver.findElement(By.xpath("//i[@class=\"fa fa-edit\"]")).click();
		/*WebElement dep = driver.findElement(By.name("employee_department"));
		String depname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		Select s2=new Select(dep);
		s2.selectByValue(depname);
		WebElement branch = driver.findElement(By.name("employee_branches"));
		String branchname = wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		Select s3= new Select(branch);
		s3.selectByValue(branchname);*/
	WebElement pos = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-body']/descendant::input[@name=\"employee_position\"]"));
	pos.clear();
	pos.sendKeys("movie799");
	
		File f=new File(".\\src\\test\\resources\\resume22.docx");
		String path = f.getAbsolutePath();
		driver.findElement(By.xpath("(//input[@name=\"employee_file201\"])[1]")).sendKeys(path);
		File f1=new File("./src/test/resources/valid credentials.png");
		String path1 = f1.getAbsolutePath();
		driver.findElement(By.xpath("(//input[@name=\"employee_image\"])[1]")).sendKeys(path1);
driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::button[@name=\"edit_emplo\"]")).click();
		
	}
	
	}

}
