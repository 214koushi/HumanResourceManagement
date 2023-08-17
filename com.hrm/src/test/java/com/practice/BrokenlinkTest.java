package com.practice;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenlinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver =new ChromeDriver();
driver.get("https://www.facebook.com/");
List<WebElement> all = driver.findElements(By.tagName("a"));
int count = all.size();
System.out.println(count);
ArrayList<String> ls=new ArrayList<String>();
int statuscode=0;
String eac=null;
for (int i = 0; i < count; i++) {
	
 eac = all.get(i).getAttribute("href");
try {
	URL u= new URL(eac);
	HttpsURLConnection http=(HttpsURLConnection)u.openConnection();
	 statuscode = http.getResponseCode();
	if (statuscode>=400) {
		ls.add(eac+"----"+statuscode);
	}
}
catch (Exception e) {
	// TODO: handle exception
	
}
}
System.out.println(eac+">>>>>>>>>>"+statuscode);
System.out.println(ls);

driver.close();
	}

}
