package xpaths;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bigbasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebElement sbc = driver.findElement(By.xpath("//a[contains(text(),'Shop by')]"));
       
	}

}
