/**
 * 
 */
package com.mystore.base;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.action.ActionDriver;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Sys
 *
 */
public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare ThreadLocal Driver for parallel testing
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	
	public static WebDriver getDriver() {
		//get driver from threadlocalmap
		return driver.get();
	}
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop=new Properties();
			System.out.println("Begins::loadConfig() method");
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fis);
			System.out.println("Ends::loadConfig() method");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void launchBrowser(String browser) {
		WebDriverManager.chromedriver().setup();
		//String browser= prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//set browser to threadlocalmap
			driver.set(new ChromeDriver());
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			//set browser to threadlocalmap
			driver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			//driver= new InternetExplorerDriver();
			//set browser to threadlocalmap
			driver.set(new InternetExplorerDriver());
		}
		ActionDriver.implicitWait(getDriver(), 10);
		ActionDriver.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
