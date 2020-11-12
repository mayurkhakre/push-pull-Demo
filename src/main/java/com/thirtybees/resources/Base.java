package com.thirtybees.resources;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {
	 public WebDriver driver;
	 public Properties prop;

	
	public WebDriver initialization() throws Exception {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName=System.getProperty("browser");
		if (browserName.contains("chrome"))//DONT WRITE == HERE COZ YOU CANT WRITE == WHEN U ARE EXTRACTING VALUE
		{                                          // FROM PROPERTY
			//System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/java/resources/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			
		}
		if (browserName.equalsIgnoreCase("IE")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		}
	
	public String getScreenshot(String testMethodName,WebDriver driver) throws Exception{
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	String destination= System.getProperty("user.dir")+"\\Screenshots\\"+testMethodName+".png";
	FileUtils.copyFile(source, new File(destination));
	return destination;
	}
}
