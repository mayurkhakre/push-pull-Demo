package com.thirtybees.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.thirtybees.Test.LandingpageTest;

public class Listeners extends Base implements ITestListener 
{
	
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	public static Logger log= LogManager.getLogger(LandingpageTest.class.getName());
	
	public void onFinish(ITestResult result) {
		
	}

	public void onStart(ITestResult result) {
		
				}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		System.out.println("This test case "+testMethodName+" failed");
		try 
		{
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e)
		{
			log.fatal("Failed to get driver instance");
			//System.out.println("Failed to get driver instance");
			
			e.printStackTrace();
		} 
		try
		{
			extenttest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), result.getMethod().getMethodName());
			
		} 
		catch (Exception e) 
		{
		   log.error("Failed to call screenshot Method");
			//System.out.println("Failed to call screenshot Method");
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println("This test case "+testMethodName+" was skipped");
	}

	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		String testMethodName = result.getMethod().getMethodName();
		System.out.println("This test case "+testMethodName+" Started");
	}

	public void onTestSuccess(ITestResult result) {
		//String testMethodName = result.getMethod().getMethodName();
		//System.out.println("This test case "+testMethodName+" wsa passed successfully");
		extenttest.get().log(Status.PASS,"Test Passed");
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
