package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cmd_execution {
	@Test
	public void login()
	{
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username1");
		String PASSWORD = System.getProperty("password1");
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get(URL);
		 driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		 driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		 WebElement type = driver.findElement(By.id("hr_type"));
		 Select s=new Select(type);
		 
		 s.selectByValue("HR Head");
		 driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		 driver.switchTo().alert().accept();
	}
	
	
	
	
	
}
