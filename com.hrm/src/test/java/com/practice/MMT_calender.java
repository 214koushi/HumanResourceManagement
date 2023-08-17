package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String datemonth="January 2024";
		 int date = 2;
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.makemytrip.com/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/*Actions a=new Actions(driver);
a.moveByOffset(40, 40);*/
driver.navigate().refresh();
driver.findElement(By.xpath("//span[text()='Departure']")).click();
String actualdate="//div[text()='"+datemonth+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']";
String navigate = "//span[@aria-label=\"Next Month\"]";
for(;;) {
try {
driver.findElement(By.xpath(actualdate)).click();
break;
}
catch (Exception e) {
	// TODO: handle exception
driver.findElement(By.xpath(navigate)).click();
}}


	}
}
