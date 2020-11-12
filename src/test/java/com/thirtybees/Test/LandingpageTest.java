package com.thirtybees.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.thirtybees.resources.Base;

public class LandingpageTest extends Base {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(LandingpageTest.class.getName());
	SoftAssert sa = new SoftAssert();

	@Test
	public void test01(){
		log.info("Test case started 2");
		System.out.println("My test case 2");
		log.info("Test case end 2");
		log.error("This is error 2");
		
	}
	
}
