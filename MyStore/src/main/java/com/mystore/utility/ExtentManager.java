package com.mystore.utility;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager{
	
	public static ExtentHtmlReporter eh;
	public static ExtentReports er;
	public static ExtentTest et;
	
	public static void setExtent() {
		eh= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
		eh.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		er= new ExtentReports();
		er.attachReporter(eh);
		/*er.setSystemInfo("Host Name", "My Host");
		er.setSystemInfo("Project Name", "MyStore");
		er.setSystemInfo("OS", "Windows 7");
		er.setSystemInfo("Tester", "Priya");*/
	}
	
	
	public static void endReport() {
		er.flush();
	}
}
