package com.banking.testcases;

import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	//public static WebDriver driver;
	//public  logger=logger.getLogger(TC_LoginTest_001.class);
	
	
	
		@Test
		public void Logintest() throws InterruptedException {	
			
			
			LoginPage lp= new LoginPage(driver);
			Thread.sleep(2000);
			lp.username(username);
			logger.info("usernagme Entered");
			Thread.sleep(2000);
			lp.password(password);
			logger.info("password Entered");
			Thread.sleep(2000);
			lp.button();
			logger.info("login button clicked");
			
			
			
		//driver.findElement(By.name("uid")).sendKeys("mngr414097");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rysenYj");
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
		}
}
		
		
		
	
	
	
	
	

