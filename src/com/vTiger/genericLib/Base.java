package com.vTiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTigerCRM.objectRepository.Home;
import com.vTigerCRM.objectRepository.Login;

/**
 * 
 * @author Chinnarayadu
 *
 */

public class Base 
{
	public FileLib lib = new FileLib();
	
	public WebDriver driver = null;
	
	public static WebDriver staticDriver;
	
	public WebDriverWait wait = null;
	
	public Login login;
	
	public Home home;
	@BeforeClass
	public void configBC()
	{
		/*Launch the browser*/
		if(lib.getPropertyKeyValue("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			
			staticDriver = driver;
			
			System.out.println("Browser is Launched is successfully-->PASS");
		}
		
		else if(lib.getPropertyKeyValue("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
			
			staticDriver = driver;
			
			System.out.println("Browser is Launched successfully-->PASS");
		}
		/*Maximize the driver*/
		
		driver.manage().window().maximize();
		
		/*Enter url*/
		driver.get(lib.getPropertyKeyValue("url"));
		
		/*Wait Statements*/
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, Utility.EXPLICIT_WAIT);

		/*Verify Login page*/
		String loginTitle = driver.getTitle();
		
		if(loginTitle.contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Login Page is displayed --> PASS");
		}
		else
		{
			System.out.println("Login Page not is displayed --> FAIL");
		}
	}
	
	@BeforeMethod
	public void configBM()
	{
		/*Login*/
		login = PageFactory.initElements(driver, Login.class);
		
		login.vTigerLogin(lib.getPropertyKeyValue("username"),lib.getPropertyKeyValue("password"));
		
		if(driver.getTitle().contains("Home"))
		{
			System.out.println("Home page is displayed-->PASS");
		}
		else
		{
			System.out.println("Home page is not displayed--FAIL");
		}
		
		home = PageFactory.initElements(driver, Home.class);
		
	}
	
	@AfterMethod
	public void configAM()
	{
		/* Sign out */
		home.vTigerLogout();
		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Logout is successful --> PASS");
		}
		else
		{
			System.out.println("Logout is not successful --> FAIL");
		}
	}
	
	@AfterClass
	public void configAC()
	{
		/* Close Browser */
		driver.quit();
		System.out.println(driver);
		if(driver == null)
		{
			System.out.println("Browser is closed successfully --> Pass");
		}
		else
		{
			System.out.println("Broser is not closed successfully --> FAIL");
		}
	}
}
	
		
		
		
		
		
		
	
	
	
	
	
	
	

