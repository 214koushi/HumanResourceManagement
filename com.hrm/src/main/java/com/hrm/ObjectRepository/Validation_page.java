
package com.hrm.ObjectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.GenericUtility.WebdriverUtility;

public class Validation_page extends WebdriverUtility {
	
	@FindBy (xpath="//h4[text()='Add Employee']")
	private WebElement popup;
	
	@FindBy(xpath="//div[@class='modal fade show']/descendant::button[@class=\"close\"]")
	private WebElement close;
	
	public WebElement getClose() {
		return close;
	}

	

	public WebElement getPopup() {
		return popup;
	}



	public Validation_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
 public void popValidating(WebDriver driver) throws Throwable {
	   
  String Expectedtext = popup.getAttribute("innerHTML");
	 Thread.sleep(2000);
	 System.out.println(Expectedtext);
	String Actaultext="Add Employee";
	 Assert.assertTrue(Expectedtext.equals(Actaultext), "fail");
	 System.out.println("pass :"+Expectedtext+ " popup is displayed");
	
	
 }
}
