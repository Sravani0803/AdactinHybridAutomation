package com.adactinhotelapp.testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.pages.SearchHotelPage;
import com.adactinhotelapp.utils.UtilKit;

public class ValidateLoginUsingPOMAndDataProvider extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap)
	{
		//intialize Login page 
		
		//LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		LoginPage loginPage=new LoginPage();
		loginPage.usernameTextbox(dataMap.get("username"));
		loginPage.passwordTextbox(dataMap.get("password"));
		loginPage.loginButton();
		
		//SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		searchHotelPage.validateTitle(dataMap.get("expTitle"));
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-101");
		
		return data;
	}

}
