package com.vTigerCRM.testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo 
{
	int Count = 1;
	@DataProvider
	public Object[][] dataProviderMethod()
	{
		Object[][] obj = new Object[3][3];
		obj[0][0] = "prodID_01";
		obj[0][1] = "Mouse";
		obj[0][2] = "500";
		
		obj[1][0] = "prodID_02";
		obj[1][1] = "Speakar";
		obj[1][2] = "2500";
		
		obj[2][0] = "prodId_03";
		obj[2][1] = "Mobile";
		obj[2][2] = "8000";
		return obj;
		
	}
	
	
	@Test(dataProvider = "dataProviderMethod")
	public void adToCartTest(String pid, String pname, String price)
	{
		System.out.println(Count++ +" "+pid+" "+pname+" "+price);
	}
}
