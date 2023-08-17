package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_search {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String mobile="nokia";
String mobiletype = "//i[@class=\"a-icon a-icon-checkbox\"]/ancestor::div[@id=\"brandsRefinements\"]/descendant::span[text()='"+mobile+"']";
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones"+Keys.ENTER);
List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
List<WebElement> checkname = driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base\"]"));
for(WebElement check:checkname) {
	if(check.equals("Nokia"))
	{
		check.click();
		Thread.sleep(1000);
	}

}
driver.close();}}
