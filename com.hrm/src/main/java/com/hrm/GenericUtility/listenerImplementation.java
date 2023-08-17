package com.hrm.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		 test = report.createTest(Methodname);
		Reporter.log(Methodname+"---> Test script Execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname=result.getMethod().getMethodName();
		test.log(Status.PASS, Methodname+"----> Passed");
		Reporter.log(Methodname+"--->Test script is passed");
	}

	public void onTestFailure(ITestResult result) {
		String res = result.getMethod().getMethodName();
		String FailedScript=res+new JavaUtility().getSystemdateInformat();
		 EventFiringWebDriver edriver=new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+res+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, res+"---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(res+"----> Test script is failed");
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"----->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--->Test script is skipped");
	}

	public void onStart(ITestContext context) {
	
	ExtentSparkReporter ereport=new ExtentSparkReporter("./Extentreporter/report.html");
	ereport.config().setDocumentTitle("TYSS-sdet-50");
	ereport.config().setTheme(Theme.DARK);
	ereport.config().setReportName("Human Resource Management");
	
	
    report=new ExtentReports();
	report.attachReporter(ereport);
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("Base-browser", "chrome");
	report.setSystemInfo("Base-url", "");
	report.setSystemInfo("reporter Name", "Koushik MN");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
