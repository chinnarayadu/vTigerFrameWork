package com.vTigerCRM.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//Generate getter methods
	public WebElement getUserNameTF() 
	{
		return userNameTF;
	}

	public WebElement getPasswordTF() 
	{
		return passwordTF;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
	//Business Logic
	public void vTigerLogin(String userName, String password)
	{
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginButton.click();
		
	}
}
