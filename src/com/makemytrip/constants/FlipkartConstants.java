package com.makemytrip.constants;

public class FlipkartConstants {
	
	private static String Config = "C:\\Users\\sures\\workspace\\Datadriven_Framework\\src\\com\\flipkart\\config\\config.properties";
	
	private static String ORpath = "C:\\Users\\sures\\workspace\\Datadriven_Framework\\src\\com\\flipkart\\ObjectRepository\\OR.properties";
	
	private static String Excelpath = "C:\\Users\\sures\\workspace\\Datadriven_Framework\\src\\com\\flipkart\\testdata\\Flipkart_textdata.xlsx";
	
	public static String configFilepath() {
		
		return Config;

	}
	public static String OR_filepath()
	{
		return ORpath;
	}
	
	public static String Excelpath()
	{
		return Excelpath;
	}

}
