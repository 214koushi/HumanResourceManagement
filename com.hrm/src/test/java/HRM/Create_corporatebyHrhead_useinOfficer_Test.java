package HRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.Baseclass;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.FileUtility;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebdriverUtility;
import com.hrm.ObjectRepository.Corporatepage;
import com.hrm.ObjectRepository.Employeepage;
import com.hrm.ObjectRepository.Loginpage;
import com.hrm.ObjectRepository.hrhead_Homepage;
import com.hrm.ObjectRepository.hrofficer_Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.hrm.GenericUtility.listenerImplementation.class)
public class Create_corporatebyHrhead_useinOfficer_Test extends Baseclass {
	@Test
	public void createCorporate() throws Throwable {
		String USERNAME = flib.readdatafromproperty("username1");
		String PASSWORD = flib.readdatafromproperty("password1");
String Humanresource = elib.readdatafromExcel("Sheet4", 1, 0);
Loginpage lp1=new Loginpage(driver);
lp1.login(driver, USERNAME, PASSWORD, Humanresource);
hrhead_Homepage hhp=new hrhead_Homepage(driver);
	hhp.createCorporate();
String Corporate_name=elib.readdatafromExcel("Sheet1", 1, 0)+jlib.getRandomno();
Corporatepage cp=new Corporatepage(driver);
cp.createCorporate(Corporate_name);
Thread.sleep(2000);
driver.switchTo().alert().accept();
hhp.signout(driver);
//wlib.acceptAlert(driver);

//HR OFFICER LOGIN
Loginpage lp=new Loginpage(driver);
String USERNAME1 = flib.readdatafromproperty("username3");
String PASSWORD1 = flib.readdatafromproperty("password3");
String humanresource1 = elib.readdatafromExcel("Sheet4", 3, 0);
lp.login( driver,USERNAME1, PASSWORD1, humanresource1);

hrofficer_Homepage hhp1=new hrofficer_Homepage(driver);
hhp1.createemployee();
String branch_Name = elib.readdatafromExcel("Sheet2", 1, 0);
Employeepage ep=new Employeepage(driver);
ep.employeeCreationwithoutFN(elib.getMultipleDataFromExcelAdmin("Sheet5", 0, 1, 22), driver, branch_Name, Corporate_name);
Alert pop = driver.switchTo().alert();
String poptext = pop.getText();
System.out.println(poptext);
pop.accept();
if (poptext != null) {
	System.out.println("Corporate created by Hr head is sucesfully added to corporate list");
}
hhp1.signout(driver);
//wlib.acceptAlert(driver);
lp.login(driver, USERNAME, PASSWORD, Humanresource);
}}
