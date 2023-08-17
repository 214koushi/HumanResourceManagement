package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftassertandHardassert {
/*@Test
public void SoftAsset() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String actual = driver.getTitle();
	String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	SoftAssert sa =new SoftAssert();
	sa.assertNotEquals(actual, expected, "Not found");
	System.out.println("hai");
	System.out.println("bye");
	driver.close();
	sa.assertAll();	
}*/
@Test
public void Hardasset() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.actitime.com/login.do");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 boolean actual = driver.getTitle().isBlank();
	boolean expected= false;
	//Assert.assertTrue(actual.equals(expected),"hurrayyyy");
	//Assert.assertEquals(actual, expected);
	System.out.println("hey");
	System.out.println("bey");
	driver.close();
	}
}
