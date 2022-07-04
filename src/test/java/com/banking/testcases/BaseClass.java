package com.banking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.banking.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public ReadConfig readconfig= new ReadConfig();
	
	
	public static Logger logger;
	
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties p;
	public static String projectpath=System.getProperty("user.dir");
	
	
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	
	
	//@BeforeClass
	public  void init() throws IOException 

	{
		
		//fis= new FileInputStream(projectpath+"//data.properties");
		//p= new Properties();
		//p.load(fis);
		//System.out.println("read the data file");
		
		//fis= new FileInputStream(projectpath+"//Log4jConfig.properties");
		//System.out.println("Log4Jfile readed");
		//PropertyConfigurator.configure(fis);
		
	}
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) 
	{
		
		logger=Logger.getLogger(BaseClass.class.getClass());
		PropertyConfigurator.configure("Log4jConfig.properties");
		
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver",readconfig.getchropath());
		//System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		
		//driver= new ChromeDriver();
		
		
		
		if(browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",readconfig.getchropath());
			driver= new ChromeDriver();
			
			//System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
			//driver= new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			driver= new FirefoxDriver();
			//driver.get(p.getProperty("https://www.demo.guru99.com/V4/"));
			//driver.manage().window().maximize();
		}
		else if(browser.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver",readconfig.getedgepath());
			driver= new EdgeDriver();
			//driver.get("https://www.demo.guru99.com/V4/");
			//driver.manage().window().maximize();
		}
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver","C:\\SeleniumResources\\IEdriverServer.exe");
			driver= new InternetExplorerDriver();
			//driver.get("https://www.demo.guru99.com/V4/");
			//driver.manage().window().maximize();
		}
		
		driver.get(readconfig.getApplicationurl());
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		//WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\SeleniumResources\\geckodriver.exe");
		//driver= new ChromeDriver();
		//driver= new FirefoxDriver();
		
		
		
	}
	
	@AfterMethod
	public void teardown() 
	{
		driver.close(); 
		

	}

public void captureScreen(WebDriver driver,String ScreenshotName) throws IOException 
{
	String destination =System.getProperty("user.dir")+"./Screenshots/"+ScreenshotName +".png";
	File filedestination= new File(destination);
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		//FileUtils.copyFile(src, destination);
	FileHandler.copy(src, filedestination);	
	
}
	


}

