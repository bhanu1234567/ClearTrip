package com.makemytrip.base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverEngine {
	
	public static WebDriver driver;
	public static ExtentReports er;
	public static ExtentTest log;
	public static Logger log4j;
	@BeforeSuite
	@Parameters("browser")
	public void openBrowser(@Optional("chrome")String browser) {
		
		PropertyConfigurator.configure("Log4j.properties");
		 er = new ExtentReports("C:\\Users\\sures\\workspace\\Datadriven_Framework\\Reports\\Flipkart_AddToCart.html");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sures\\workspace\\Datadriven_Framework\\Drivers\\chromedriver.exe");
			
			driver = new ChromeDriver();
			//maximize();
		}

		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			
			driver = new FirefoxDriver();
			log.log(LogStatus.INFO, "firefox browser opened");
			//maximize();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "");
			
			driver = new InternetExplorerDriver();
			log.log(LogStatus.INFO, "ie browser opened");
			//maximize();
		}
		else
		{
			System.out.println("Browser not Opened");
		}
		
	}
	/*public static void maximize() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);

	}*/
	
	@BeforeMethod
	public void methodname(Method method) {
		
		String methodName =method.getName();
		//System.out.println(methodName);
		log=er.startTest(method.getName());	
		//log4j = Logger.getLogger(getClass());
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result,Method m) throws IOException {
		String name = m.getName();
		if(result.getStatus()==result.FAILURE)
		{
			SeleniumReusables.getScreenShot(name);
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		
		log4j = Logger.getLogger(getClass());
	}
	
	
	@AfterSuite
	public static void close() {
		log.log(LogStatus.INFO, "browser closed");
		er.endTest(log);
		er.flush();
		driver.close();
		driver.quit();
	}
	
	
	
	
	

}
