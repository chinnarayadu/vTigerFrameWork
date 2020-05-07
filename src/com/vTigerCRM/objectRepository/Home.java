package com.vTigerCRM.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vTiger.genericLib.Base;
import com.vTiger.genericLib.Utility;

public class Home 
{
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	public WebElement getUserIcon() 
	{
		return userIcon;
	}

	public WebElement getSignOutLink() 
	{
		return signOutLink;
	}

	public WebElement getContactsLink() 
	{
		return contactsLink;
	}
	
	/*business logic*/
	public void vTigerLogout()
	{
		Utility.actMoveToElement(Base.staticDriver, userIcon);
		signOutLink.click();
		
	}
	
	
	
}
