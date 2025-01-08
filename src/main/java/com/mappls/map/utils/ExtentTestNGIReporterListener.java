package com.mappls.map.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentTestNGIReporterListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final String SCREENSHOTS_FOLDER = "failed_screenshots";

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "QA Team");

        // Ensure screenshots folder exists
        File screenshotsFolder = new File(SCREENSHOTS_FOLDER);
        if (!screenshotsFolder.exists()) {
            screenshotsFolder.mkdirs();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Screenshot capture
        TakesScreenshot ts = (TakesScreenshot) DriverManager.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String filePath = SCREENSHOTS_FOLDER + "/" + result.getMethod().getMethodName() + ".png";
        File dest = new File(filePath);
        try {
            Files.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.get().fail("Screenshot",
		        MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }
    
    public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) { //Class testClass, Constructor testConstructor,
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
