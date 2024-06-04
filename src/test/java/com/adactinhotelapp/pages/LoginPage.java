package com.adactinhotelapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage()
	{
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}
	
	//WebElements and Methods on WebElement
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	public void usernameTextbox(String text)
	{
		//usernameTextbox.sendKeys(text);
		
		type(usernameTextbox, text);
	}
	
	public void passwordTextbox(String text)
	{
		//passwordTextbox.sendKeys(text);
		type(passwordTextbox, text);
		
	}
	
	public void loginButton()
	{
		//loginButton.click();
		click(loginButton);
	}

}
