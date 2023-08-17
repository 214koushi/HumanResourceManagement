package HRM;
import java.io.IOException;

import org.openqa.selenium.By;
import  static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hrm.GenericUtility.Baseclass;
import com.hrm.ObjectRepository.Loginpage;
import com.hrm.ObjectRepository.Validation_page;
import com.hrm.ObjectRepository.hrhead_Homepage;
@Listeners(com.hrm.GenericUtility.listenerImplementation.class)
public class Emp_popup_Disply_test extends Baseclass {
	@Test
	public void employeepopup() throws Throwable {
		String USERNAME = flib.readdatafromproperty("username1");
		String PASSWORD = flib.readdatafromproperty("password1");
		String humanresource =elib.readdatafromExcel("Sheet4", 1, 0);
		Loginpage lp=new Loginpage(driver);
		lp.login( driver,USERNAME, PASSWORD, humanresource);
	hrhead_Homepage hhp= new hrhead_Homepage(driver);
	hhp.createemployee();
	Assert.fail();
	driver.findElement(By.xpath("//button[contains(text(),'Add Employee')]")).click();
   Validation_page vp=new Validation_page(driver);
	vp.popValidating(driver);
	
	}

}
