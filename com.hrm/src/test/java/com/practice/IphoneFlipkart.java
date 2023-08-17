package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphoneFlipkart {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 14 pro max"+Keys.ENTER);
Thread.sleep(2000);
List<WebElement> iphone = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone 14 Pro Max ')]"));
List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone 14 Pro Max ')]/../..//div[contains(text(),'₹')]"));
int count = iphone.size();
System.out.println(count);

for (int i = 0; i<count; i++)
{
	String iphonename = iphone.get(i).getText();
    String iphoneprice = price.get(i).getText();
    System.out.println(iphonename+"--------->"+iphoneprice);
	
}////div[contains(text(),'APPLE iPhone 14 Pro Max ')]/../..//div[contains(text(),'₹')]2
////div[contains(text(),'APPLE iPhone 14 Pro Max ')]/../..//div[contains(text(),'₹')]1

	}

}
