package HRM;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.GenericUtility.Baseclass;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.FileUtility;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebdriverUtility;
import com.hrm.ObjectRepository.Employeepage;
import com.hrm.ObjectRepository.Loginpage;
import com.hrm.ObjectRepository.hrhead_Homepage;
import com.hrm.ObjectRepository.hrofficer_Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.hrm.GenericUtility.listenerImplementation.class)
public class Create_Emp_hrofficer_validateinHrHead_test extends Baseclass {
	@Test
	public void employeeCreation() throws Throwable  {
		// TODO Auto-generated method stub
String USERNAME =flib.readdatafromproperty("username3");
String PASSWORD =flib.readdatafromproperty("password3");
String Humanresource =  elib.readdatafromExcel("Sheet4", 3, 0);
Loginpage lp=new Loginpage(driver);
lp.login( driver,USERNAME, PASSWORD, Humanresource);
hrofficer_Homepage hhp=new hrofficer_Homepage(driver);
hhp.createemployee();
String Corporate = elib.readdatafromExcel("Sheet1", 1, 0);
String branch = elib.readdatafromExcel("Sheet2", 1, 0);
String firstname =  elib.readdatafromExcel("Sheet3", 2, 2);
//EMPLOYEE CREATION BY HR OFFICER
Employeepage ep=new Employeepage(driver);
ep.employeeCreation(elib.getMultipleDataFromExcelAdmin("Sheet5", 0,1, 23),firstname, driver, branch, Corporate);
wlib.acceptAlert(driver);
hhp.signout(driver);
//HR HEAD LOGIN
String USERNAME1 = flib.readdatafromproperty("username1");
String PASSWORD1 = flib.readdatafromproperty("password1");
String Humanresource1 =elib.readdatafromExcel("Sheet4", 1, 0);
lp.login( driver,USERNAME1, PASSWORD1, Humanresource1);
hrhead_Homepage hhp1=new hrhead_Homepage(driver);
hhp1.createemployee();
driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(firstname);
String Firstname=firstname;
 String empname = driver.findElement(By.xpath("//table[@id=\"example1\"]//td[text()='"+Firstname+"']")).getText();
if (empname.contains(Firstname)) {
	System.out.println("Employee created by Hr officer is displayed in Hr head");
}
	}

}
