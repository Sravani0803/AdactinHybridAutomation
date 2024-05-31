package com.adactinhotelapp.testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.pages.SearchHotelPage;

public class ValidateLoginUsingPOM extends BaseTest {
	
	@Test
	public void validateLoginTest()
	{
		//intialize Login page 
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox("reyaz0806");
		loginPage.passwordTextbox("reyaz123");
		loginPage.loginButton();
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotelPage.validateTitle("Adactin.com - Search Hotel");
		
		
		
	}

}
