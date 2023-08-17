package com.hrm.ObjectRepository;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.GenericUtility.ExcelUtility;
import com.hrm.GenericUtility.FileUtility;
import com.hrm.GenericUtility.JavaUtility;
import com.hrm.GenericUtility.WebdriverUtility;

public class Employeepage extends WebdriverUtility   {
@FindBy(xpath="//button[contains(text(),'Add Employee')]")
private WebElement addempbtn;

@FindBy(xpath="//input[@type=\"search\"]")
private WebElement searchtbx;

@FindBy(name="employee_companyid")
private WebElement compid;

@FindBy(name="employee_firstname")
private WebElement firstname;

@FindBy(name="employee_lastname")
private WebElement lastname;

@FindBy(name="employee_middlename")
private WebElement middlename;

@FindBy(name="branches_datefrom")
private WebElement datefrom;

@FindBy(name="branches_recentdate")
private WebElement recentdate;

@FindBy(name="employee_department")
private WebElement department;

@FindBy(name="employee_branches")
private WebElement branch;

@FindBy(name="employee_position")
private WebElement position;

@FindBy(name="employee_contact")
private WebElement contact;

@FindBy(name="employee_hdmf_pagibig")
private WebElement hdmf;

@FindBy(name="employee_gsis")
private WebElement gsis;

@FindBy(xpath="(//input[@name=\"employee_file201\"])[1]")
private WebElement empfile;

@FindBy(xpath="(//input[@name=\"employee_image\"])[1]")
private WebElement empimg;

@FindBy(xpath="//button[@name=\"emplo\"]")
private WebElement savebtn;

@FindBy(xpath="//table/tbody/tr/td[3]")
private WebElement empFNtable;

@FindBy(xpath="//i[@class=\"fa fa-edit\"]")
private WebElement editemp;

public  Employeepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddempbtn() {
	return addempbtn;
}

public WebElement getSearchtbx() {
	return searchtbx;
}

public WebElement getCompid() {
	return compid;
}

public WebElement getFirstname() {
	return firstname;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getMiddlename() {
	return middlename;
}

public WebElement getDatefrom() {
	return datefrom;
}

public WebElement getRecentdate() {
	return recentdate;
}

public WebElement getDepartment() {
	return department;
}

public WebElement getBranch() {
	return branch;
}

public WebElement getPosition() {
	return position;
}

public WebElement getContact() {
	return contact;
}

public WebElement getHdmf() {
	return hdmf;
}

public WebElement getGsis() {
	return gsis;
}

public WebElement getEmpfile() {
	return empfile;
}

public WebElement getEmpimg() {
	return empimg;
}

public WebElement getSavebtn() {
	return savebtn;
}

public WebElement getEmpFNtable() {
	return empFNtable;
}


public WebElement getEditemp() {
	return editemp;
}

// business libraries 
public void employeeCreation(HashMap<String, String> map, String FIRSTNAME, WebDriver driver,String BRANCHNAME,String CORPORATENAME ) throws Throwable {
	addempbtn.click();
	for(Entry<String, String> set:map.entrySet())
	{ 
		driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
	}
	firstname.sendKeys(FIRSTNAME);
	select(CORPORATENAME, department);
	select(BRANCHNAME, branch);
	FileUtility flib=new FileUtility();
	flib.fileupload(empfile);
	flib.imageupload(empimg);
	savebtn.click();
}
public void employeeCreationwithoutFN(HashMap<String, String> map, WebDriver driver,String BRANCHNAME,String CORPORATENAME ) throws Throwable {
	addempbtn.click();
	JavaUtility jlib=new JavaUtility();
	for(Entry<String, String> set:map.entrySet())
	{ 
		driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+jlib.getRandomno());
	}
	select(CORPORATENAME, department);
	select(BRANCHNAME, branch);
	FileUtility flib=new FileUtility();
	flib.fileupload(empfile);
	flib.imageupload(empimg);
	savebtn.click();
}
public void searchEmployee(String empname) {
	searchtbx.sendKeys(empname);
}
public void editEmployeewithbranchdepartmentposition(WebDriver driver, String Emptobesearch,String position) throws Throwable {
	
ExcelUtility elib=new ExcelUtility();
	boolean display = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+Emptobesearch+"')]")).isDisplayed();
	if (display) {
		editemp.click();
		WebElement dep = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::select[@name='employee_department']"));
		String depname =elib.readdatafromExcel("Sheet1", 1, 0);
		select(depname, dep);
		WebElement branch = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::select[@name='employee_branches']"));
		String branchname = elib.readdatafromExcel("Sheet2", 1, 0);
		select(branchname, branch);
		Thread.sleep(2000);
	    WebElement pos = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-body']/descendant::input[@name=\"employee_position\"]"));
	    pos.clear();
	    pos.sendKeys(position);
	    Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::input[@name=\"employee_file201\"]"));
		FileUtility flib=new FileUtility();
		flib.fileupload(element1);
		WebElement element2 = driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::input[@name=\"employee_image\"]"));
		flib.imageupload(element2);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='"+Emptobesearch+"']/ancestor::div[@class='modal-content']/descendant::button[@type='submit']")).click();

}
}
}