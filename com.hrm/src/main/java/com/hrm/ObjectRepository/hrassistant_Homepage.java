package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hrassistant_Homepage {
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement Employee;
	
	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addemployee;
	
	@FindBy(xpath="//i[@class=\"fa fa-user\"]")
	private WebElement account;
	
	@FindBy(xpath="//i[@class=\"fa fa-power-off\"]")
	private WebElement lgout;

	public void Homepage_hrofficer(WebDriver driver) {
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
	public void signout() {
		account.click();
		lgout.click();
	}
	
	
}
