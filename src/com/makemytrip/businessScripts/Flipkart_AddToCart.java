package com.makemytrip.businessScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.makemytrip.Listeners.RetryListener;
import com.makemytrip.Utilities.PropertiesReusables;
import com.makemytrip.base.SeleniumReusables;
import com.makemytrip.constants.FlipkartConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Flipkart_AddToCart extends SeleniumReusables {
	
	@Test(retryAnalyzer = RetryListener.class)
	public void Flipkart_AddToCartFlow() throws IOException {
		log4j = Logger.getLogger(Flipkart_AddToCart.class);
		PropertiesReusables prconfig = new PropertiesReusables(FlipkartConstants.configFilepath()); //Loading config.properties file
		SeleniumReusables.getUrl(prconfig.getProperty("url"));//Launching URL
		log4j.info("url opened");
		PropertiesReusables prOR = new PropertiesReusables(FlipkartConstants.OR_filepath());		//Loading OR.properties file
		SeleniumReusables.ClickElementByXpath(prOR.getProperty("Login_Close_xpath"));//if pop for Signin is highlighted that should be closed.
		log.log(LogStatus.INFO, "Click on the close");
		log4j.info("click on close");
		SeleniumReusables.mouseOverByXpath(prOR.getProperty("Electronics_mouseover_xpath"));//Moving to mouseover action on Electronics
		log.log(LogStatus.INFO, "mouse move to the element");
		log4j.info("mouse move to the element");
		//log.log(LogStatus.INFO, "");	
		
	}
	

}
