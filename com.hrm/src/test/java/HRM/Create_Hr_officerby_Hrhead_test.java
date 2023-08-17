package HRM;
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
import org.testng.annotations.Test;

import com.hrm.GenericUtility.Baseclass;
import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.FileUtility;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebdriverUtility;
import com.hrm.ObjectRepository.Adminpage;
import com.hrm.ObjectRepository.Loginpage;
import com.hrm.ObjectRepository.hrhead_Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Create_Hr_officerby_Hrhead_test extends Baseclass {
	@Test
	public void createAdminofficer() throws Throwable {
String USERNAME = flib.readdatafromproperty("username1");
String PASSWORD = flib.readdatafromproperty("password1");
String humanresource =elib.readdatafromExcel("Sheet4", 1, 0);
Loginpage lp=new Loginpage(driver);
lp.login( driver,USERNAME, PASSWORD, humanresource);
hrhead_Homepage hhp=new hrhead_Homepage(driver);
hhp.createAdmin();
String humanresource2 =elib.readdatafromExcel("Sheet4", 2, 0);
Adminpage ap=new Adminpage(driver);
ap.createAdmin(elib.getMultipleDataFromExcelAdmin("Sheet4", 3, 4, 1), driver, humanresource2);
String email1 = elib.readdatafromExcel("Sheet4", 6, 2);
String password1 = elib.readdatafromExcel("Sheet4", 7, 2);
wlib.acceptAlert(driver);
hhp.signout(driver);
//admin login
lp.login(driver, email1, password1, humanresource2);
//wlib.acceptAlert(driver);
boolean welcomemessage = driver.findElement(By.xpath("//a[text()='"+email1+"']")).isDisplayed();
if (welcomemessage) {
	System.out.println("Admin type of Hr officer created by hr head is valid and its credentials are working");
}
	}

}
