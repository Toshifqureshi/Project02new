package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	/**
	 * this Method reads data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String propertyFile(String key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(CommonFilePath.propertyFilePath);
		Properties pobj= new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
		
		
	}

}
