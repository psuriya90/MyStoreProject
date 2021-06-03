/**
 * 
 */
package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.IndexPage;

/**
 * @author Sys
 *
 */
public class IndexPageTest extends BaseClass{
	
		IndexPage indexPage;
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchBrowser(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority=1,groups="Smoke")
	public void verifyLogo() {
		indexPage=new IndexPage();
		boolean flag=indexPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2,groups="Smoke")
	public void verifyTitle() {
		String actualTitle=indexPage.getMyStoreTitle();
		//String expectedTitle= prop.getProperty("mystoretitle");
		Assert.assertEquals(actualTitle, "My Store1");
	}

}
