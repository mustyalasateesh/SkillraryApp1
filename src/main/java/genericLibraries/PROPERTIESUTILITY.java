package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
 * this class contains reusable methods to read data from properties
 * @author sateesh
 */
public class PROPERTIESUTILITY 
{
	private Properties property ;
	/**
	 * This method is used to initilize properties file 
	 * @param filepath 

	 */
	public void propertiesInitialization(String filePath)
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(filePath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		property=new Properties();
		try
		{
			property.load(fis);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();	
		}
	}
	
	/*
	 * this method is used to fetch the data from properties file
	 * @param key
	 * @return
	 */
	public String readFromproperties(String key) {
		return property.getProperty(key);
		
	}

}
