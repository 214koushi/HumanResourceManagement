package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
 WebElement h = driver.findElement(By.xpath("//div[text()='Home & Furniture']"));
 //System.out.println("print");
Actions a=new Actions(driver);
a.moveToElement(h).perform();
WebElement lighting = driver.findElement(By.xpath("//a[text()='Lightings & Electricals']"));
a.moveToElement(lighting).perform();
//System.out.println("print");
WebElement tube = driver.findElement(By.xpath("//a[text()='Tubelights']"));
Thread.sleep(2000);
a.moveToElement(tube).click().perform();
//System.out.println("print");
WebElement crompton = driver.findElement(By.xpath("//div[@style=\"flex-grow: 1; overflow: auto;\"]/ancestor::div[@class=\"_1YokD2 _2GoDe3\"]/descendant::div[@data-id=\"TULGD5ATVPF3PWGH\"]"));
System.out.println(crompton.getText());
	}

}
