package xpaths;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aveda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String component="STYLING"; // dynamic not work
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.aveda.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement makeup = driver.findElement(By.xpath("//div[@class=\"site-header__menu-desktop\"]/descendant::a[text()='HAIR CARE']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(makeup).perform();
	   
	   List<WebElement> prods = driver.findElements(By.xpath("//a[text()='HAIR CARE']/ancestor::div[@class='site-header__menu-desktop']/descendant::div[@id='node-90']"));
	 for(WebElement p:prods) {
		String i = p.getText();
		System.out.println(i);
	 }
	 
	 driver.close();
	}

}
