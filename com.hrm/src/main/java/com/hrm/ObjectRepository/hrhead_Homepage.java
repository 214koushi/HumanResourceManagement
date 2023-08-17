package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.GenericUtility.WebdriverUtility;

public class hrhead_Homepage extends WebdriverUtility {
	@FindBy(xpath="//p[contains(text(),'CORPORATE')]")
	private WebElement corporate;
	
	@FindBy(xpath="//p[text()='Add Corporate']")
	private WebElement addcorporate;
	
	@FindBy(xpath="//p[contains(text(),'BRANCHES')]")
	private WebElement branches;
	
	@FindBy(xpath="//p[text()='Add Braches']")
	private WebElement addbranch;
	
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement Employee;
	
	@FindBy(xpath="//p[text()='Add Employee']")
	private WebElement addemployee;
	
	@FindBy(xpath="//i[@class=\"fa fa-user\"]")
	private WebElement account;
	
	@FindBy(xpath="//i[@class=\"fa fa-power-off\"]")
	private WebElement lgout;
	
    @FindBy(xpath="//p[contains(text(),'ADMIN')]")
    private WebElement admin;
    
     @FindBy(xpath="//p[text()='Add Admin']")
     private WebElement addadmin;
   
   
	public hrhead_Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCorporate() {
		return corporate;
	}

	public WebElement getAddcorporate() {
		return addcorporate;
	}

	public WebElement getBranches() {
		return branches;
	}

	public WebElement getAddbranch() {
		return addbranch;
	}

	public WebElement getEmployee() {
		return Employee;
	}

	public WebElement getAddemployee() {
		return addemployee;
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getAddadmin() {
		return addadmin;
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
	public void createAdmin() {
		admin.click();
		addadmin.click();
	}
	public void createCorporate() {
		corporate.click();
		addcorporate.click();
	}
	public void createbranches() {
		branches.click();
		addbranch.click();
	}
	public void signout(WebDriver driver) {
		account.click();
		lgout.click();
		acceptAlert(driver);
	}
	
	
}
