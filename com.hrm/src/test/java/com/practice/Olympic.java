package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		List<WebElement> all = driver.findElements(By.xpath("//div[@data-cy=\"table-content\"]"));
		//span[text()="Argentina"]/ancestor::div[@class="Tablestyles__Wrapper-sc-xjyvs9-0 imdvdL"]
		int count = all.size();
		for (int i = 0; i <count; i++) {
			String text = all.get(i).getText();
			System.out.println(text);
		}
	}

}
