package com.practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_iphone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("i phone"+Keys.ENTER);
List<WebElement> phone = driver.findElements(By.xpath("//span[text()='Apple']/following-sibling::span[text()='iPhone']/ancestor::h2"));
List<WebElement> Price = driver.findElements(By.xpath("(//span[text()='Apple']/following-sibling::span[text()='iPhone']/ancestor::h2)/../..//span[@class=\"a-price-whole\"]"));
	int count = phone.size();
	//System.out.println(Price.size());
	//System.out.println(count);
	for (int i = 0; i <count; i++) {
		System.out.println(phone.get(i).getText()+"----------->"+Price.get(i).getText());
	}
	driver.close();
	}

}
