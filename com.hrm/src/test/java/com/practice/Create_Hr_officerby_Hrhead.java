package com.practice;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
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
public class Create_Hr_officerby_Hrhead {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility fib=new FileUtility();
String browser=fib.readdatafromproperty("browser");
String URL = fib.readdatafromproperty("url");
String USERNAME = fib.readdatafromproperty("username1");
String PASSWORD = fib.readdatafromproperty("password1");
ExcelUtility elib=new ExcelUtility();
String humanresource =elib.readdatafromExcel("Sheet4", 1, 0);
int count = elib.getLastRowNumber("Sheet4");
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
driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
driver.findElement(By.xpath("//p[text()='Add Admin']")).click();
driver.findElement(By.xpath("//button[contains(text(),'Add Admin')]")).click();
HashMap<String, String> map=new HashMap<String, String>();
// to read data from Excel in the key value pair
for (int i = 1; i <=count; i++) {
	String key = elib.readdatafromExcel("Sheet4", i, 3);
	String value = elib.readdatafromExcel("Sheet4", i, 4);
	map.put(key, value);
}
JavaUtility jlib=new JavaUtility();
//to takedata from excel file
for(Entry<String, String> set:map.entrySet()) {
	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jlib.getRandomno());
}
String email1 = elib.readdatafromExcel("Sheet4", 6, 2)+jlib.getRandomno();
String password1 = elib.readdatafromExcel("Sheet4", 7, 2)+jlib.getRandomno();
WebElement position = driver.findElement(By.id("hr_type"));
String humanresource2 =elib.readdatafromExcel("Sheet4", 2, 0);
wlib.select(position, humanresource2);
driver.findElement(By.xpath("//button[@name=\"hr_admin\"]")).click();
wlib.acceptAlert(driver);
driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
driver.findElement(By.xpath("//i[@class=\"fa fa-power-off\"]")).click();
wlib.acceptAlert(driver);
String USERNAME1 = fib.readdatafromproperty("username1");
String PASSWORD1 =fib.readdatafromproperty("password1");
driver.get(URL);
driver.findElement(By.name("hr_email")).sendKeys(email1);
driver.findElement(By.name("hr_password")).sendKeys(password1);
WebElement type1 = driver.findElement(By.id("hr_type"));
String Humanresource1 =elib.readdatafromExcel("Sheet4", 2, 0);
wlib.select(type1, Humanresource1);
driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
wlib.acceptAlert(driver);
boolean welcomemessage = driver.findElement(By.xpath("//a[text()='"+email1+"']")).isDisplayed();
if (welcomemessage) {
	System.out.println("Admin type of Hr officer created by hr head is valid and its credentials are working");
}
	}

}
