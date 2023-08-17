package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Corporatepage {

	@FindBy(xpath="//button[contains(text(),'Add Corporate')]")
	private WebElement addcorporate;
	
	@FindBy(xpath="//input[@type=\"search\"]")
	private WebElement searchcorp;
	
	@FindBy(name="corporate_name")
	private WebElement corptbx;
	
	@FindBy(xpath="//button[@name=\"corp\"]")
	private WebElement savebtn;
	
	public Corporatepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddcorporate() {
		return addcorporate;
	}

	public WebElement getSearchcorp() {
		return searchcorp;
	}

	public WebElement getCorptbx() {
		return corptbx;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//business library
	public void createCorporate(String CORPORATENAME) {
		addcorporate.click();
		corptbx.sendKeys(CORPORATENAME);
		savebtn.click();
	}
	
	
	
	
}
