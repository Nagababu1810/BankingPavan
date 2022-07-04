package com.banking.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.utility.NewExcelLibrary;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider= "LoginTestData")
	public void login(String username,String password) throws InterruptedException {
		
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
		}
	
	
	
	@DataProvider(name="LoginTestData")
	public  Object[][] loginDDT() {
		
		Object[][] data=new Object[3][2];
		data[0][0]= "mngr420192";
		data[0][1]= "quhYbUt";
		data[1][0]= "mngr420192";
		data[1][1]= "quhYbUt";
		data[2][0]= "mngr420192";
		data[2][1]= "quhYbUt";
	
	return data;
	
	
	
	
	}

	

			
}
