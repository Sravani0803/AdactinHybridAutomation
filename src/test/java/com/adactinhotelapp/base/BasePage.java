package com.adactinhotelapp.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

//this is parent for all page classes
public class BasePage extends BaseTest {
	
	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
		test.info("Assertion passed ...Both titles are equal ..");
	}
	
	public void type(WebElement element,String text)
	{
		element.sendKeys(text);
		test.info("Entered text "+text+" into textbox "+element);
		getScreenShot();
		
	}
	
	public void click(WebElement element)
	{
		element.click();
		//test.info("Clicked element "+element);
		test.log(Status.INFO, "Clicked element "+element);
		getScreenShot();
	}
	
	public  void getScreenShot()
	{
		File screenshotsFolder=new File(System.getProperty("user.dir")+"\\screenshots");
		screenshotsFolder.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		String screenShotPath=screenshotsFolder+"\\"+date+".png";
		File reportsFile=new File(screenShotPath);
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, reportsFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotPath);
	}

}
