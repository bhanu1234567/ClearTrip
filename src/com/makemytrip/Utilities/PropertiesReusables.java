package com.makemytrip.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReusables {
	
	 String filepath;
	 FileInputStream fip;
	 Properties pr;
	 
	
	
	public PropertiesReusables(String filepath) throws IOException
	{
		this.filepath = filepath;
		fip = new FileInputStream(filepath);
		pr= new Properties();
		pr.load(fip);
	}
	
	public String getProperty(String key) {
		
		String value = pr.getProperty(key);
		return value;
	}

}
