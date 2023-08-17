package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iccranking_above30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='generic-splash-promo__close js-close']")).click();

		WebElement rank = driver.findElement(By.xpath("//div[@class=\"main-navigation__header u-hide-desktop\"]/descendant::nav[@aria-label=\"Header Navigation\"]/descendant::button[contains(.,'Rankings') and @class=\"linked-list__dropdown-label js-dropdown-btn\"]"));
		Actions a= new Actions(driver);
		a.moveToElement(rank).perform();
		driver.findElement(By.xpath("//div[@class=\"main-navigation__header u-hide-desktop\"]/descendant::a[@href=\"/rankings/womens/team-rankings\"]")).click();
		List<WebElement> match = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class=\"table-body__cell u-center-text\" and text()<20]"));
	List<WebElement> country = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class=\"table-body__cell u-center-text\" and text()<20]/preceding-sibling::td[@class=\"table-body__cell rankings-table__team\"]"));
		int count = country.size();
		for(int i = 0; i <count; i++) {
				System.out.println(country.get(i).getText()+"---->"+match.get(i).getText());
			}
		}}



