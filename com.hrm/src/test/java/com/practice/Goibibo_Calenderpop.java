package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_Calenderpop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String datemonth="July 2024";
		String date="21";
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.goibibo.com/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
driver.findElement(By.xpath("//span[text()='Departure']")).click();
String actualdate = "//div[text()='"+datemonth+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']";
String navigate="//span[@aria-label=\"Next Month\"]";


for(;;) {
	try {
		driver.findElement(By.xpath(actualdate)).click();
		break;
	}
	catch (Exception e) {
		// TODO: handle exception
		driver.findElement(By.xpath(navigate)).click();
	}
	
}
driver.findElement(By.xpath("//span[text()='Done']")).click();
driver.close();

	}

}
