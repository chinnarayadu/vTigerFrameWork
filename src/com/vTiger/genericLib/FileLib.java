
package com.vTiger.genericLib;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib 
{
	public String getPropertyKeyValue(String key)
	{
		Properties prop = null;
		
		try 
		{
			FileInputStream ip = new FileInputStream("./TestData/commonData.properties");
			prop= new Properties();
			prop.load(ip);
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	public String getExcelData(String sheetName,int rowindex,int cellIndex)
	{
		Sheet sh = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./TestData/POM.xlsx");
			
			Workbook wb = WorkbookFactory.create(ip);
			
			sh = wb.getSheet("Contacts");
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		return  sh.getRow(rowindex).getCell(cellIndex).getStringCellValue();
		
	}
}
