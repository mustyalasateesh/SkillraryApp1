package genericLibraries;
//sateesh
//excel utility
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook wb;
	/*
	 * this method is used to initialize excel
	 * @param excelPath
	 */
   public void excelIntialization(String excelPath){
	   FileInputStream fis=null;
	   try {
		fis=new FileInputStream(excelPath);
	} catch (FileNotFoundException e) 
	   {
		e.printStackTrace();
	   }
	   
	  
		try {
			wb=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException e) 
		{
		e.printStackTrace();
		} catch (IOException e)
		{
		
			e.printStackTrace();
		}
	
   }
   /*
    * this method is used to read data from excel
    * @param sheetName
    * @param  expectedTest
    * @return
    */
   
   
   public Map<String, String> readFromExcel(String sheetName,String expectedTest)

   {
	   Map<String, String> map=new HashMap<String, String>();
	   DataFormatter df=new DataFormatter();
	   
	   Sheet sh=wb.getSheet(sheetName);
	   
	   for(int i=0;i<=sh.getLastRowNum();i++)
	   {	 
		   if(df.formatCellValue(sh.getRow(i).getCell(1)).equals(expectedTest))
		   {
			   for(int j=i;j<=sh.getLastRowNum();j++)
			   {
				   map.put(df.formatCellValue(sh.getRow(j).getCell(2)),
						   df.formatCellValue(sh.getRow(j).getCell(3)));
				   
				   if(df.formatCellValue(sh.getRow(j).getCell(2)).equals("####"))
				   {
					   break;   
				   }
			   }
			   break;
			   
		   }
		   
	   }
			   
		   return map;
   }
   /*
    * this method is used close the excel
    */
   public void closeExcel()
   {
	   try {
		wb.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	   
   
   
   
   
   
   
   
   
}
