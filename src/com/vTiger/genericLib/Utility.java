package com.vTiger.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility 
{
	public static final long IMPLICIT_WAIT=20;
	public static final  long EXPLICIT_WAIT=20;
	
	public static void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		
		sel.selectByValue(value);
			
	}
	
	public static void actMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(element).perform();
		
	}
	
	
}
