package com.adactinhotelapp.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.adactinhotelapp.base.BasePage;

public class SearchHotelPage extends BasePage {

	public SearchHotelPage()
	{
			//PageFactory.initElements(driver, LoginPage.class);
			PageFactory.initElements(driver, this);
	}
}
