package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebdriverUtility;

public class Loginpage extends WebdriverUtility{

	@FindBy(xpath="//input[@type='Email']")
	private WebElement untbx;
	
	@FindBy(name="hr_password")
	private WebElement pwtbx;
	
	@FindBy(id="hr_type")
	private WebElement hrtype;
	
	@FindBy(xpath="//button[@name=\"login_hr\"]")
	private WebElement sgbtn;
	
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUntbx() {
		return untbx;
	}


	public WebElement getPwtbx() {
		return pwtbx;
	}


	public WebElement getHrtype() {
		return hrtype;
	}


	public WebElement getSgbtn() {
		return sgbtn;
	}
	
	//business libraries
	public void login(WebDriver driver,String USERNAME,String PASSWORD, String value ) throws Throwable
	{
		untbx.sendKeys(USERNAME);
		pwtbx.sendKeys(PASSWORD);
		select(hrtype, value);
		sgbtn.click();
		Thread.sleep(2000);
		acceptAlert(driver);
	}
	public void loginAdmin(String USERNAME,String PASSWORD, String value )
	{
		untbx.sendKeys(USERNAME);
		pwtbx.sendKeys(PASSWORD);
		select(hrtype, value);
		sgbtn.click();
	}
	
	
	
}
