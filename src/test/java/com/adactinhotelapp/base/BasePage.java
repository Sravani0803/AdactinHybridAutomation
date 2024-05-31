package com.adactinhotelapp.base;

import org.testng.Assert;

//this is parent for all page classes
public class BasePage extends BaseTest {
	
	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}

}
