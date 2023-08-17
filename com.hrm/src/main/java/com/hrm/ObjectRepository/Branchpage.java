package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Branchpage {

	@FindBy(xpath="//button[contains(text(),'Add Branches')]")
	private WebElement addbranchbtn;
	
	@FindBy(xpath="//input[@type=\"search\"]")
	private WebElement branchtbx;
	
	@FindBy(name="branches_name")
	private WebElement branchname;
	
	@FindBy(xpath="//button[@name=\"bran\"]")
	private WebElement savebtn;
	
	public void Branchpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddbranchbtn() {
		return addbranchbtn;
	}

	public WebElement getBranchtbx() {
		return branchtbx;
	}

	public WebElement getBranchname() {
		return branchname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	
	//business library
	public void createBranch(String BRANCHNAME) {
		addbranchbtn.click();
		branchtbx.sendKeys(BRANCHNAME);
		savebtn.click();
	}
}
