package com.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kayak_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.kayak.co.in/");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//a[@data-test-menu-nav-id=\"flights\"]")).click();
driver.findElement(By.xpath("//input[@class=\"k_my-input\" and @aria-label=\"Flight origin input\"]")).sendKeys("bengaluru");
driver.findElement(By.xpath("//input[@class=\"k_my-input\" and @aria-controls=\"flight-destination-smarty-input-list\"]")).sendKeys("mangalore");
driver.findElement(By.xpath("//span[@aria-label=\"Start date calendar input\"]")).click();
driver.findElement(By.xpath("//div[text()='August 2023']/ancestor::div[@class=\"onx_ onx_-pres-mcfly onx_-double\"]/descendant::div[text()='28']")).click();
driver.findElement(By.xpath("//span[@aria-label=\"End date calendar input\"]")).click();
driver.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class=\"onx_ onx_-pres-mcfly onx_-double\"]/descendant::div[text()='21']")).click();
driver.findElement(By.xpath("//div[@class=\"zEiP-formField zEiP-submit\"]")).click();
driver.findElement(By.xpath("(//div[@aria-label=\"Close\"])[2]")).click();
//String tab = driver.getWindowHandle();
System.out.println(driver.getTitle());
//driver.switchTo().window(tab);
//driver.findElement(By.xpath("(//div[@aria-label=\"Best\"]/ancestor::div[@class=\"header-wrapper\"]/following-sibling::div[@class=\"resultsContainer\"]/descendant::div[contains(text(),'Select')])[1]")).click();
//driver.close();

//driver.findElement(By.xpath(""))
	}

}
