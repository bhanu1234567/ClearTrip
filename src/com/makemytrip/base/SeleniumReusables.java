package com.makemytrip.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class SeleniumReusables extends DriverEngine{
	
	static Actions actions;
	static WebElement element;
	static WebDriverWait wait;
	
	public static  void getUrl(String Url) {
		driver.get(Url);
		log.log(LogStatus.INFO,"Url opened");
	}
	
	public static void ImplicitlyWait(int seconds)
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void mouseOverByXpath(String Xpath) 
	{
		 element = driver.findElement(By.xpath(Xpath));
		actions = new Actions(driver);
		if(element.isDisplayed()&&element.isEnabled())
		{
			actions.moveToElement(element).build().perform();
			
		}
		else
		{
			log.log(LogStatus.INFO, "Element not found or enabled");
		}
		
	}
	
	/*public void screenShot() {
		File sFile = 

	}
	*/
	public static void ClickElementByXpath(String xpath) {
	
		
		WebElement element = driver.findElement(By.xpath(xpath));
		
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
			//log.log(LogStatus.INFO, "click on the element");
		}
		else
		{
			log.log(LogStatus.INFO, "unable to click on the element");
			//System.out.println("Element not found");
		}
		
	}
	
	public static void getScreenShot(String name) throws IOException 
	{
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("C:\\Users\\sures\\workspace\\Datadriven_Framework\\screenShots\\"+name+".png"));

	}
	
	public static boolean isAlertPresent() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
	if(wait.until(ExpectedConditions.alertIsPresent())!= null)
	{
		return true;
	}
	else
	{
		return false;
	}

	}
	
	public static void alert(Alert a) {
		

	}
	
	public static void ClickById(String Id)
	{
		element = driver.findElement(By.id(Id));
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
		}
	}
	public static void ClickByclassname(String Classname)
	{
		element = driver.findElement(By.className(Classname));
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
		}
	}
	public static void ClickByCssSelector(String CssSelector)
	{
		element = driver.findElement(By.cssSelector(CssSelector));
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
		}
	}
	public static void ClickByLinktext(String LinkText)
	{
		element = driver.findElement(By.linkText(LinkText));
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
		}
	}
	public static void ClickByPartialLinktext(String partialLinkText)
	{
		element = driver.findElement(By.partialLinkText(partialLinkText));
		if(element.isDisplayed()&&element.isEnabled())
		{
			element.click();
		}
	}
	public static void SendkeysByCssSelector(String CssSelector,String Textdata) {
		
		element = driver.findElement(By.cssSelector(CssSelector));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}

	}
	public static void SendkeysByXpath(String Xpath,String Textdata) {
		
		element = driver.findElement(By.xpath(Xpath));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}

	}
public static void SendkeysById(String Id,String Textdata) {
		
		element = driver.findElement(By.id(Id));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}

	}
	public static void SendkeysByclassname(String Classname,String Textdata) {
		
		element = driver.findElement(By.className(Classname));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}
	
	}
	public static void SendkeysByLinkText(String LinkText,String Textdata) {
		
		element = driver.findElement(By.linkText(LinkText));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}
	
	}
	
	public static void SendkeysByPartialLinkText(String PartialLinkText,String Textdata) {
		
		element = driver.findElement(By.partialLinkText(PartialLinkText));
				if(element.isDisplayed()&&element.isEnabled())
				{
					element.sendKeys(Textdata);
				}

	}

}
