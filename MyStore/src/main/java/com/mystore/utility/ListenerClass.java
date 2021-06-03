/**
 * 
 */
package com.mystore.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.action.ActionDriver;
import com.mystore.base.BaseClass;



/**
 * @author Sys
 *
 */
public class ListenerClass extends ExtentManager implements ITestListener {

	/**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	  @Override
	  public void onTestStart(ITestResult result) {
	    // not implemented
		  System.out.println("onTestStart:: "+result.getName());
		  et=er.createTest(result.getName());
		  et.createNode(result.getName());
		  
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  @Override
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		  System.out.println("onTestSuccess:: "+result.getName());
		  et=er.createTest(result.getName());
		  et.log(Status.PASS, "Test case" +result.getName()+" is success");
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		  System.out.println("onTestFailure:: "+result.getName());
		  et=er.createTest(result.getName());
		  if(result.getStatus()==ITestResult.FAILURE) {
			  try {
				  et.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - Test case is failed",ExtentColor.RED));
				  et.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test case throws exception", ExtentColor.ORANGE));
				  String imgPath= ActionDriver.screenShot(BaseClass.getDriver(), result.getName());
				  et.addScreenCaptureFromPath(imgPath);
			  }catch(IOException e) {
				  e.printStackTrace();
			  }
		  }
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
		  System.out.println("onTestSkipped:: "+result.getName());
		  et=er.createTest(result.getName());
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
		  System.out.println("onTestFailedButWithinSuccessPercentage:: "+result.getName());
		  et=er.createTest(result.getName());
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	    System.out.println("onTestFailedWithTimeout:: "+result.getName());
		et=er.createTest(result.getName());
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  @Override
	  public void onStart(ITestContext context) {
	    // not implemented
		  System.out.println("onStart:: "+context.getName());
		  et=er.createTest(context.getName());
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  @Override
	  public void onFinish(ITestContext context) {
	    // not implemented
		  System.out.println("onFinish:: "+context.getName());
		  et=er.createTest(context.getName());
	  }

}
