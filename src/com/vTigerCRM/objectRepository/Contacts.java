package com.vTigerCRM.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts 
{
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTF;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	 
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCreateContactImg() 
	{
		return createContactImg;
	}

	public WebElement getFirstNameTF() 
	{
		return firstNameTF;
	}

	public WebElement getLastNameTF() 
	{
		return lastNameTF;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	//Business logic to create contact
	public void createNewContact(String firstName,String lastName)
	{
	
		createContactImg.click();
		firstNameTF.sendKeys(firstName);
		lastNameTF.sendKeys(lastName);
		saveButton.click();
	}

}
