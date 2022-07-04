package com.banking.utility;

//Listenrs class is reporting the extentreports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentSparkReporter htmlSparkReporter;
	public Logger logger;
	
	public void onStart(ITestContext testContext) {
		
		String TimeStamp= new SimpleDateFormat("yyyy_mm_dd_hh_ss").format(new Date());
		String  repName="Test-Report-"+TimeStamp+".html";
		
		htmlSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"./test-output/"+repName);
		htmlSparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlSparkReporter.config().setDocumentTitle("Automation Report");
		htmlSparkReporter.config().setReportName("Functional Testcases");
		htmlSparkReporter.config().setTheme(Theme.DARK);
		
		
		extent= new ExtentReports();
		
		extent.attachReporter(htmlSparkReporter);
		extent.setSystemInfo("windows", "os");
		extent.setSystemInfo("selenium", "4.1.1");
		extent.setSystemInfo("Tester","Nagababu");
		extent.setSystemInfo("browser","chrome");
	}
	
	public void onTestSucess(ITestResult result) {
		
		test=extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));//send the passed information
	}
	
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));//send the passed information
		
		
		String Screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		File f= new File(Screenshotpath);
		
		if(f.exists()) 
		{
			
			try {
				test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(Screenshotpath));
			}
			catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	
	}
	
	


