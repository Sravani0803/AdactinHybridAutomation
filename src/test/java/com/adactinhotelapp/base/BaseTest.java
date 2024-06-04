package com.adactinhotelapp.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.adactinhotelapp.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//this is parent for all TestScripts
public class BaseTest {
	
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void fileSetUp() throws IOException
	{
		
		System.out.println();
		fis1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configProp=new Properties();
		configProp.load(fis1);
		
		reports=ExtentManager.getReports();
				
		
	}
	
	
	@BeforeMethod
	public void setUp(ITestContext context)
	{
		
		 test=reports.createTest(context.getCurrentXmlTest().getClasses().get(0).getName());
				
		//launch browser based on browser value in config properties 
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			test.info("Chrome browser launched");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			test.info("firefox browser launched");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			test.info("edge browser launched");
		}
		
		driver.get(configProp.getProperty("url"));
		
		test.info("app launched using url "+configProp.getProperty("url"));
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}

}
