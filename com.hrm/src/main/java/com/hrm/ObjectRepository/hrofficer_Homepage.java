package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebdriverUtility;

public class hrofficer_Homepage extends WebdriverUtility{
@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
private WebElement Employee;

@FindBy(xpath="//p[text()='Add Employee']")
private WebElement addemployee;

@FindBy(xpath="//i[@class=\"fa fa-user\"]")
private WebElement account;

@FindBy(xpath="//i[@class=\"fa fa-power-off\"]")
private WebElement lgout;



public hrofficer_Homepage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}

public WebElement getEmployee() {
	return Employee;
}

public WebElement getAddemployee() {
	return addemployee;
}

public WebElement getAccount() {
	return account;
}

public WebElement getLgout() {
	return lgout;
}
// business libraries
public void createemployee()
{
	Employee.click();
	addemployee.click();
	}
public void signout(WebDriver driver) {
	account.click();
	lgout.click();
	acceptAlert(driver);
}

}
