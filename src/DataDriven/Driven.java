package DataDriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Driven
{
	public Object[][]dataProviderMethod() throws Exception
			{
		FileInputStream ip = new FileInputStream("./TestData/Datadriven.xlsx");
		
		Workbook wb = WorkbookFactory.create(ip);
		
		Sheet sh = wb.getSheet("Products");
		
		int rw = sh.getLastRowNum();
		
		short cll = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rw][cll];
		
		for(int i=1;i<=rw;i++)
		{
			for(int j=0;j<cll;j++) 
			{
				data[i-1] [j] = sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		 
		return data;
		
		
			}
}
	