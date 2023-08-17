package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProject_SelectQuery {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		String expected="congress4";
		Connection con=null;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		try {

	driver.get("http://rmgtestingserver:8084/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("congress4");
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("DR.G parameshwar321");
	//driver.findElement(By.xpath("//input[@name=\"teamSize\"]")).sendKeys("134");
	WebElement options = driver.findElement(By.name("status"));
	Select s=new Select(options);
	List<WebElement> alloptions = s.getOptions();
	WebElement actual = driver.findElement(By.xpath("//option[@value='On Going']"));
	for(WebElement opt:alloptions) {
		String optnmae = opt.getText();
		
		if (optnmae.equals(actual)) {
			s.selectByValue(optnmae);
		}}
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = con.createStatement();
	ResultSet result = state.executeQuery("select* from project;");
	boolean flag=false;
	while (result.next()) {
		String actual1 = result.getString(4);
		if (actual1.equalsIgnoreCase(expected)) {
			flag=true;
			break;
		}  
		
	}
	if (flag) {
		System.out.println("project created succesfully");
	}
	}
		catch (Exception e) {
		// TODO: handle exception
	}
		finally {
			con.close();
		}
		driver.close();
		}
	

}
