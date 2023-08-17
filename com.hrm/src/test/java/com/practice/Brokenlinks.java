package com.practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeOptions option=new ChromeOptions();
option.addArguments("--disable-notifications");
WebDriver driver=new ChromeDriver(option);
driver.get("https://www.vtiger.com/ ");
//driver.switchTo().alert().dismiss();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
List<WebElement> all = driver.findElements(By.xpath("//a"));
int count = all.size();
System.out.println(count);
ArrayList<String> ls=new ArrayList<String>();

for(WebElement single:all) {
	String singles = single.getAttribute("href");
	URL u=null;
	int statuscode=0;
	try {
		u=new URL(singles);
		HttpURLConnection http=(HttpURLConnection) u.openConnection();
		statuscode = http.getResponseCode();
		if (statuscode>=400) {
			ls.add(singles+"_--->_"+statuscode);
			
		}
	} 
	catch (Exception e) {
		ls.add(singles+"_--->_"+statuscode);
	}
	
		
}
System.out.println(ls);
driver.close();

	}

}
