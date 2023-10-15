package com.PractiseExcersise;

import org.testng.annotations.Test;

public class ReadDataCmdLine {
	@Test
	public void cmdlineRead()
	{
		String Bvalue = System.getProperty("browser");
		System.out.println(Bvalue);
		
		String urlvalue = System.getProperty("url");
		System.out.println(urlvalue);
		
		String passvalue = System.getProperty("password");
		System.out.println(passvalue);
		
		String uvalue = System.getProperty("username");
		System.out.println(uvalue);
	}

}
