package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	public static WebDriver driver;

	
	@FindBy(linkText="New Customer") public WebElement clklink;
	@FindBy(xpath="//input[@onkeyup='validatecustomername();']") public WebElement Entername;
	@FindBy(xpath="//input[@name='rad1']") public WebElement clkrobtn;
	@FindBy(id="dob") public WebElement dob;
	@FindBy(name="addr") public WebElement enteradd;
	@FindBy(name="city") public WebElement entercity;
	@FindBy(xpath="//input[@name='state']") public WebElement enterstate;
	@FindBy(xpath="//input[@name='pinno']") public WebElement enterpin;
	@FindBy(xpath="//input[@name='telephoneno']") public WebElement enterpho;
	@FindBy(xpath="//input[@name='emailid']") public WebElement enteremail;
	@FindBy(xpath="//input[@name='password']") public WebElement enterpwd;
	@FindBy(xpath="//input[@name='sub']") public WebElement subdetails;
	//@FindBy(xpath="//input[@name='name']") public WebElement entcustname;
	
	
	public AddCustomerPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void newcustlink() {
		clklink.click();
	}
	
	
	public void Entercustname() {
		Entername.sendKeys("nagababu");
	}
	public void Enteruname() {
		clkrobtn.click();
	}
	
	public void Enterdob() {
		dob.sendKeys("18101991");
	}
	
	public void Enteraddress() {
		enteradd.sendKeys("kkd");
	}
	
	public void Entercity() {
		entercity.sendKeys("kkd");
	}
	
	public void Enterstate() {
		enterstate.sendKeys("ap");
	}
	
	
	public void Enterpin() {
		enterpin.sendKeys("533001");
	}
	
	public void Entermobile() {
		enterpho.sendKeys("9059506469");
	}
	
	public void Enteremail() {
		enteremail.sendKeys("mdd@gmail.com");
	}
	
	public void Enterpass() {
		enterpwd.sendKeys("123456");
	}
	
	public void Enterdetails() 
	{
		subdetails.click();
		
	}
	
}
