package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;

	
	@FindBy(name="uid") public WebElement uname;
	@FindBy(xpath="//input[@name='password']") public WebElement pwd;
	@FindBy(xpath="//input[@name='btnLogin']") public WebElement btn;	
	
	
	
	public LoginPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	this.driver=driver;
		
	}
		
	public void username(String username) 
	{
		
		uname.sendKeys(username);
	}
	
	public void password(String password) {
		
		pwd.sendKeys(password);
	}
	
	public void button() {
		
		btn.click();
	}
	
	
}
