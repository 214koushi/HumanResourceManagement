package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iccrankings2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");
 List<WebElement> alys = driver.findElements(By.xpath("(//table/tbody/tr[*])[position()>5]"));
 for(WebElement aly:alys) {
System.out.println(aly.getText());

}
driver.close();
	}

}
