package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Host_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year="2023";
		int date=23;
		
WebDriverManager.chromedriver().setup();
ChromeOptions option=new ChromeOptions();
option.addArguments("--disable-notifications");
WebDriver driver=new ChromeDriver(option);
driver.get("https://hotelsearchdirect.com/");
driver.findElement(By.xpath("//button[@class=\"leading-none text-abbey font-bold text-2xl absolute\"]")).click();
String actualdate="//span[text()='"+year+"']/ancestor::div[@class=\"vd-picker\"]/descendant::span[text()='"+date+"']";
driver.findElement(By.xpath(actualdate)).click();

	}

}
