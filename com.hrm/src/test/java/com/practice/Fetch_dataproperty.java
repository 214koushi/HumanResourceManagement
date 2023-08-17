package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fetch_dataproperty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	 
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Test.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un1 = p.getProperty("username1");
		String pwd1 = p.getProperty("password1");
		String un2 = p.getProperty("username2");
		String pwd2 = p.getProperty("password2");
		String un3 = p.getProperty("username3");
		String pwd3 = p.getProperty("password3");
		String b = p.getProperty("browser");
		 WebDriver driver ;
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.findElement(By.name("hr_email")).sendKeys(un1);
			driver.findElement(By.name("hr_password")).sendKeys(pwd1);
			WebElement type = driver.findElement(By.id("hr_type"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select s=new Select(type);
		List<WebElement> alltype = s.getOptions();
		s.selectByValue("HR Head");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.switchTo().alert().accept();
		}}


