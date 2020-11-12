package com.thirtybees.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
       static  ExtentReports extent;
  
  public static ExtentReports getObject(){
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("My End To End Project Report");
	reporter.config().setDocumentTitle("Test Results");
	extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Mayur Khakre");
	return extent;
  }

}
