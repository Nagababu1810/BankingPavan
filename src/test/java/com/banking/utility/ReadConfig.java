package com.banking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;


	public ReadConfig()
	{
	File src= new File("./Configuration\\Config.properties");
	try {
	FileInputStream fis= new FileInputStream(src);
	pro= new Properties();
	
		pro.load(fis);
	} catch (IOException e) {
		System.out.println("Exception is "+e.getMessage());
	}
	
	}
	
	public String getApplicationurl()
	{
		
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getusername() 
	{
		
		String uname=pro.getProperty("username");

		return uname;
	}
	
	public String getpassword() {
		
		String password=pro.getProperty("password");
		
		return password;
	}
	
	public String getchropath() {
		
			String chropath=pro.getProperty("chropath");
		return  chropath;
	
	}
	
	public String getedgepath() {
		
		String edgepath=pro.getProperty("edgepath");
		
		return edgepath;
	}
	
	
public String getfirefoxpath() {
		
		String edgepath=pro.getProperty("firefoxpath");
		
		return edgepath;
	}
}
	
	

