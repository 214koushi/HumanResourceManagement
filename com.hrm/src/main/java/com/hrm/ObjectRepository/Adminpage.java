package com.hrm.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.WebdriverUtility;

public class Adminpage extends WebdriverUtility {

	@FindBy(xpath="//button[contains(text(),'Add Admin')]")
	private WebElement addadmin;
	
	@FindBy(xpath="//input[@type=\"search\"]")
	private WebElement searchadmin;
	
	@FindBy(name="hr_companyid")
	private WebElement compid;
	
	@FindBy(name="hr_firstname")
	private WebElement firstname;
	
	@FindBy(name="hr_lastname")
	private WebElement lastname;
	
	@FindBy(name="hr_middlename")
	private WebElement middlename;
	
	@FindBy(name="hr_contactno")
	private WebElement contact;
	
	@FindBy(id="hr_type")
	private WebElement hrtype;
	
	@FindBy(name="hr_email")
	private WebElement email;
	
	@FindBy(name="hr_password")
	private WebElement password;
	
	@FindBy(xpath="//button[@name=\"hr_admin\"]")
	private WebElement savebtn;
	
	public  Adminpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddadmin() {
		return addadmin;
	}

	public WebElement getSearchadmin() {
		return searchadmin;
	}

	public WebElement getCompid() {
		return compid;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getMiddlename() {
		return middlename;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getHrtype() {
		return hrtype;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	// business library
	public void createAdmin(HashMap<String , String>  map, WebDriver driver,String value) throws Throwable {
		addadmin.click();
		for(Entry<String, String> set:map.entrySet())
		{ 
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		select(hrtype, value);
		savebtn.click();
	}
	
	
}
