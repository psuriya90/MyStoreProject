/**
 * 
 */
package com.mystore.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.mystore.base.BaseClass;

/**
 * @author Sys
 *
 */
public class ActionDriver extends BaseClass {
	
	public static void click(WebDriver driver,WebElement locatorName) {
		Actions action=new Actions(driver);
		action.moveToElement(locatorName).click().build().perform();
	}
	
	public static void scrollByVisibilityOfElement(WebDriver driver,WebElement locatorName) {
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();", locatorName);
	}

	public static boolean findElement(WebDriver driver,WebElement locatorName) {
		boolean flag=false;
		try {
			System.out.println("Begins::findElement() method::");
			flag=locatorName.isDisplayed();
		}catch(Exception e) {
			flag=false;
			System.out.println("findElement() method::"+e.getMessage());
		}finally {
			if(flag) {
				System.out.println("findElement() method:: Successfully found element>>"+flag);
			}else {
				System.out.println("findElement() method:: Element not found>>"+flag);
			}
		}
		System.out.println("Ends::findElement() method::");
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver driver,WebElement locatorName) {
		System.out.println("Begins:: isDisplayed() method");
		boolean flag=false;
		flag=findElement(driver,locatorName);
		System.out.println("isDisplayed() findElement() method::"+flag);
		if(flag) {
			flag=locatorName.isDisplayed();
			System.out.println("isDisplayed() method::"+flag);
			if(flag) {
				System.out.println("The element is displayed");
			}else {
				System.out.println("The element is not displayed");
			}
		}else {
			System.out.println("isDisplayed() findElement()::>>The element is not displayed");
		}
		System.out.println("Ends:: isDisplayed() method");
		return flag;
	}
	
	public static boolean isSelected(WebDriver driver,WebElement locatorName) {
		System.out.println("Begins:: isSelected() method");
		boolean flag=false;
		flag=findElement(driver,locatorName);
		System.out.println("isSelected() findElement() method::"+flag);
		if(flag) {
			flag=locatorName.isSelected();
			System.out.println("isSelected() method::"+flag);
			if(flag) {
				System.out.println("The element is selected");
			}else {
				System.out.println("The element is not selected");
			}
		}else {
			System.out.println("isSelected() findElement()::>>The element is not selected");
		}
		System.out.println("Ends:: isSelected() method");
		return flag;
	}
	
	public static boolean isEnabled(WebDriver driver,WebElement locatorName) {
		System.out.println("Begins:: isEnabled() method");
		boolean flag=false;
		flag=findElement(driver,locatorName);
		System.out.println("isEnabled() findElement() method::"+flag);
		if(flag) {
			flag=locatorName.isEnabled();
			System.out.println("isEnabled() method::"+flag);
			if(flag) {
				System.out.println("The element is enabled");
			}else {
				System.out.println("The element is not enabled");
			}
		}else {
			System.out.println("isEnabled() findElement()::>>The element is not enabled");
		}
		System.out.println("Ends:: isEnabled() method");
		return flag;
	}
	
	public static boolean type(WebElement locatorName,String text) {
		System.out.println("Begins::type() method");
		boolean flag=false;
		try {
		  flag=locatorName.isDisplayed();
		  System.out.println("type() method>>"+flag);
		  if(flag) {
			  locatorName.clear();
			  locatorName.sendKeys(text);
		  }
		}catch(Exception e) {
			flag=false;
			 System.out.println("type() method::"+e.getMessage());
		}finally {
			if(flag) {
				System.out.println("type() method>> entered value");
			}else {
				System.out.println("type() method>> Unable to enter value");
			}
		}
		System.out.println("Ends::type() method");
		return flag;
	}
	
	public static boolean selectBySendkeys(WebElement locatorName, String value) {
		boolean flag=false;
		try {
			System.out.println("Begins::selectBySendkeys() method");
			locatorName.sendKeys(value);
			flag=true;
		}catch(Exception e) {
			System.out.println("selectBySendkeys() method::");
			flag=false;
		}finally {
			if(flag) {
				System.out.println("selectBySendkeys() method>> Selected value from dropdown");
			}else {
				System.out.println("selectBySendkeys() method>> Not selected value from dropdown");
			}
	}
		System.out.println("Ends::selectBySendkeys() method");
		return flag;
	}
	
	public static boolean selectByIndex(WebElement locatorName, int index) {
		boolean flag=false;
		try {
			System.out.println("Begins::selectByIndex() method");
			Select s=new Select(locatorName);
			s.selectByIndex(index);
			flag=true;
		}catch(Exception e) {
			System.out.println("selectByIndex() method::");
			flag=false;
		}finally {
			if(flag) {
				System.out.println("selectByIndex() method>> Option selected by index");
			}else {
				System.out.println("selectByIndex() method>> Option is not selected by index");
			}
	}
		System.out.println("Ends::selectByIndex() method");
		return flag;
	}
	
	public static boolean selectByValue(WebElement locatorName, String value) {
		boolean flag=false;
		try {
			System.out.println("Begins::selectByValue() method");
			Select s=new Select(locatorName);
			s.selectByValue(value);
			flag=true;
		}catch(Exception e) {
			System.out.println("selectByValue() method::");
			flag=false;
		}finally {
			if(flag) {
				System.out.println("selectByValue() method>> Option selected by value");
			}else {
				System.out.println("selectByValue() method>> Option is not selected by value");
			}
	}
		System.out.println("Ends::selectByValue() method");
		return flag;
	}
	
	public static boolean selectByVisibleText(WebElement locatorName, String visibleText) {
		boolean flag=false;
		try {
			System.out.println("Begins::selectByVisibleText() method");
			Select s=new Select(locatorName);
			s.selectByVisibleText(visibleText);
			flag=true;
		}catch(Exception e) {
			System.out.println("selectByVisibleText() method::");
			flag=false;
		}finally {
			if(flag) {
				System.out.println("selectByVisibleText() method>> Option selected by VisibleText");
			}else {
				System.out.println("selectByVisibleText() method>> Option is not selected by VisibleText");
			}
	}
		System.out.println("Ends::selectByVisibleText() method");
		return flag;
	}
	
	public static boolean jsClick(WebDriver driver,WebElement locatorName) {
		boolean flag=false;
		try {
			System.out.println("Begins::jsClick() method");
			JavascriptExecutor je=(JavascriptExecutor)driver;
			je.executeScript("arguments[0].click()", locatorName);
			flag=true;
		}catch(Exception e) {
			System.out.println("jsClick() method::");
			flag=false;
		}
		System.out.println("Ends::jsClick() method"+flag);
		return flag;
	}
	
	public static void implicitWait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void pageLoadTimeOut(WebDriver driver,int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	public static void fluentWait(WebElement locatorName,int time) {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				// Check for condition in every 5 seconds
				.pollingEvery(Duration.ofSeconds(5))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(time))
				.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(locatorName));
	}
	
	public static String screenShot(WebDriver driver,String filename) {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		  String destination = System.getProperty("user.dir")+"\\Screenshot\\"+filename+"_"+dateName+".png";
		  File finalDestination= new File(destination);
		  try {
		   FileUtils.copyFile(source, finalDestination);
		  } catch (Exception e) {
			  e.getMessage();
		  }
		  return destination;
		 }
	
	
}
