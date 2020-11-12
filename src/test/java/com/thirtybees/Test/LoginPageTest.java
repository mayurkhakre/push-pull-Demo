package com.thirtybees.Test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.thirtybees.resources.Base;

public class LoginPageTest extends Base {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(LandingpageTest.class.getName());
	
	@Test
	public void test01(){
		log.info("Test case started");
		System.out.println("My test case");
		log.info("Test case end");
		log.error("This is error");
		
	}

	
}
