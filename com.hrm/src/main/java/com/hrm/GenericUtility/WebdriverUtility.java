package com.hrm.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *This method is used to wait until element to be visible
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	/**
	 * This method is used to wait until element to be visible
	 * @param driver
	 */
	
	public void waitUntillElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to handle drop down using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method is used to handle dropdown using text
	 * @param Text
	 * @param element
	 */
	public void select(String Text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	
	/**
	 * This method will perform MouseHover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	/**
	 * This method will double click on WebPage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform right click on element
	 * @param driver
	 * @param element
	 */
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * This method will Press Enter Key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will Press Enter Key
	 * @param driver
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/** 
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * This method will switch the frame based on nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method is used to cancel alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}
	
}