package com.mappls.map.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import com.google.common.io.Files;

public class MyTestListeners  implements ITestListener , IAnnotationTransformer
{
	public static int executionCount, passCount, failCount, skipCount=0;

	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		Reporter.log(result.getName()+" script exection starts at "+new Date(),true);

	}

	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName()+" script is passed",true);

	}

	public void onTestFailure(ITestResult result) {
		failCount++;
		Reporter.log(result.getName()+" script is failed",true);
		TakesScreenshot ts=(TakesScreenshot) DriverManager.driver;
		File scrFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./failed_screenshots/"+result.getName()+".png");
		try {
			Files.copy(scrFile, destFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Failed Screenshot has been taken",true);
	}

	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		Reporter.log(result.getName()+" script is skipped",true);

	}

	public void onStart(ITestContext context) 
	{
		Reporter.log("Framework execution starts at "+new Date(), true);
	}

	public void onFinish(ITestContext context)  {
		Reporter.log("Framework Execution Ends"+ new Date(),true);
		Reporter.log("Total script executed "+executionCount,true);
		Reporter.log("Total script passed "+passCount,true);
		Reporter.log("Total script failed "+failCount,true);
		Reporter.log("Total script skipped "+skipCount,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	
	
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) { //Class testClass, Constructor testConstructor,
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
