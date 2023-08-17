package xpaths;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class macc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(op);
		driver.get("https://www.maccosmetics.in/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement shopnow = driver.findElement(By.xpath("//a[@class='js-elc-button button--underline']/ancestor::div[@class=\"hero-block__content-over-media horizontal-align-center justify-center text-align--center mobile-flex-hidden \"]/descendant::span[text()='SHOP NOW']"));
		//driver.findElement(By.xpath("//div[@id=\"onetrust-close-btn-container\"]")).click();
		shopnow.click();
		driver.close();
		
	}

}
