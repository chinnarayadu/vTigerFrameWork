package com.vTigerCRM.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vTiger.genericLib.Base;
import com.vTigerCRM.objectRepository.Contacts;

public class CreateContactTest extends Base
{
	Contacts contacts;
	@Test
	public void createContactTest()
	{
		home.getContactsLink().click();
		PageFactory.initElements(driver, Contacts.class);
		
		contacts = PageFactory.initElements(driver, Contacts.class);
		
		//contacts.createNewContact(lib.getExcelData("Contacts", 1, 0), lib.getExcelData("Contacts", 2, 1));
		
		//contacts.createNewContact(lib.getExcelData("Contacts", 1, 0), lib.getExcelData("Contacts", 1, 1));		
		
		contacts.createNewContact(lib.getExcelData("Contats", 1, 0), lib.getExcelData("Contacts", 1, 1));
		
	}
}
