package com.banking.testcases;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import com.banking.pageobjects.AddCustomerPage;
import com.banking.pageobjects.LoginPage;

public class TC_AddcutTest_003 extends BaseClass{

	@Test
	public void addcustomer() throws InterruptedException {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.username(username);
		lp.password(password);
		lp.button();
		
		Thread.sleep(4000);
		
		AddCustomerPage ap= new AddCustomerPage(driver);
		
		ap.newcustlink();
		
		ap.Enteruname();
		
		ap.Enterdob();
		
		ap.Enteraddress();
		
		ap.Entercity();
		
		ap.Enterstate();
		
		ap.Enterpin();
		
		ap.Entermobile();
		
		ap.Enteremail();
		
		ap.Enterpass();
		
		ap.Enterdetails();
		
		
	
		
	}
	
}
