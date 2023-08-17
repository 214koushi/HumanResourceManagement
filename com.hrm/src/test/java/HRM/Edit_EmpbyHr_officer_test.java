package HRM;

import  org.openqa.selenium.Alert
;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hrm.GenericUtility.Baseclass;
import com.hrm.ObjectRepository.Employeepage;
import com.hrm.ObjectRepository.Loginpage;
import com.hrm.ObjectRepository.hrofficer_Homepage;
@Listeners(com.hrm.GenericUtility.listenerImplementation.class)
public class Edit_EmpbyHr_officer_test extends Baseclass {
@Test
public void editEmloyee() throws Throwable {
		
String USERNAME = flib.readdatafromproperty("username2");
String PASSWORD = flib.readdatafromproperty("password2");
String humanresource = elib.readdatafromExcel("Sheet4", 2, 0);
String Emptobesearch = elib.readdatafromExcel("Sheet3", 12, 0);
	Loginpage lp=new Loginpage(driver);
	lp.login(driver, USERNAME, PASSWORD, humanresource);
	hrofficer_Homepage hhp=new hrofficer_Homepage(driver);
	hhp.createemployee();
	Employeepage ep=new Employeepage(driver);
	ep.searchEmployee(Emptobesearch);
    ep.editEmployeewithbranchdepartmentposition(driver, Emptobesearch, "cardriver");
	Alert pop = driver.switchTo().alert();	
	String text = pop.getText();
	System.out.println(pop.getText());
	pop.accept();
if (text!=null) {
	System.out.println("Employee is updated");
}

	}
	
	}
