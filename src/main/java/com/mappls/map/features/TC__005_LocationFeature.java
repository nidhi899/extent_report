package com.mappls.map.features;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__005_LocationPage;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__005_LocationFeature extends DriverManager{

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	Actions ac;
	WebDriverWait wait;
	BaseFeatures bf;
	TC__005_LocationPage lp;


	public TC__005_LocationFeature(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;	
		this.wait = new WebDriverWait(driver, 40);   

		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		ac = new Actions();
		lp = new TC__005_LocationPage(driver);
	}

	public void locationOff() {
	    bf.visibilitys(bp.whileUsingApp);
		bp.whileUsingApp.click();
		
		wait.until(ExpectedConditions.visibilityOf(lp.allowLocationPermission));
		Assert.assertTrue(lp.allowLocationPermission.isDisplayed(), "Allow Mappls MapmyIndia to send you notifications? is not displayed.");
		Assert.assertNotNull(lp.allowLocationPermission, "Allow Mappls MapmyIndia to send you notifications? is not displayed.");
		String permissionText = lp.allowLocationPermission.getText();
		Reporter.log("Text Displayed : " + permissionText, true);
		Assert.assertEquals(permissionText,"Allow Mappls MapmyIndia to send you notifications?", "Title does not match the expected message.");

		allowOption();
		dontallowOption();
		
	}
	
	public void location() {
		wait.until(ExpectedConditions.visibilityOf(lp.permissionBoxTitle));
		Assert.assertTrue(lp.permissionBoxTitle.isDisplayed(), "Allow Mappls MapmyIndia to access this device’s location? is not displayed.");
		Assert.assertNotNull(lp.permissionBoxTitle, "Allow Mappls MapmyIndia to access this device’s location? is null.");
		String permissionTitleText = lp.permissionBoxTitle.getText();
		Reporter.log("Title Text Displayed : " + permissionTitleText, true);
		Assert.assertEquals(permissionTitleText,"Allow Mappls MapmyIndia to access this device’s location?", "Title does not match the expected message.");

		WhileUsingAppOption();
		
		OnlyThisTimeOption();
		
		DenyOption();
	}

	public void WhileUsingAppOption() {
		wait.until(ExpectedConditions.visibilityOf(lp.WhileUsingAppOption));
		Assert.assertTrue(lp.WhileUsingAppOption.isDisplayed(), "While using the app is not displayed.");
		Assert.assertNotNull(lp.WhileUsingAppOption, "While using the app is null.");
		String whileUsingAppOption = lp.WhileUsingAppOption.getText();
		Reporter.log("Option 1 Displayed : " + whileUsingAppOption, true);
		Assert.assertEquals(whileUsingAppOption,"While using the app", "Option 1 does not match the expected message.");
}
	
	public void OnlyThisTimeOption() {
		wait.until(ExpectedConditions.visibilityOf(lp.onlyThisTimeOption));
		Assert.assertTrue(lp.onlyThisTimeOption.isDisplayed(), "Only this time is not displayed.");
		Assert.assertNotNull(lp.onlyThisTimeOption, "Only this time is null.");
		String onlythistimeText = lp.onlyThisTimeOption.getText();
		Reporter.log("Option 2 Displayed : " + onlythistimeText, true);
		Assert.assertEquals(onlythistimeText,"Only this time", "Option 2 does not match the expected message.");

	}
	
	public void DenyOption() {
		wait.until(ExpectedConditions.visibilityOf(lp.dontAllowOption));
		Assert.assertTrue(lp.dontAllowOption.isDisplayed(), "Don’t allow is not displayed.");
		Assert.assertNotNull(lp.dontAllowOption, "Don’t allow is not displayed.");
		String dontAllowOption = lp.dontAllowOption.getText();
		Reporter.log("Option 3 Displayed : " +dontAllowOption , true);	
		Assert.assertEquals(dontAllowOption,"Don’t allow", "Option 3 does not match the expected message.");

	}
	
	public void allowOption() {
		wait.until(ExpectedConditions.visibilityOf(lp.allowOption));
		Assert.assertTrue(lp.allowOption.isDisplayed(), " Allow is not displayed.");
		Assert.assertNotNull(lp.allowOption, " Allow is not displayed.");
		String allowText = lp.allowOption.getText();
		Reporter.log("Option Displayed : " + allowText, true);
		Assert.assertEquals(allowText,"Allow", "Allow does not match the expected message.");

	}
	
   public void dontallowOption() {
	   wait.until(ExpectedConditions.visibilityOf(lp.DenyOption));
		Assert.assertTrue(lp.DenyOption.isDisplayed(), "Don’t allow is not displayed.");
		Assert.assertNotNull(lp.DenyOption, "Don’t allow is not displayed.");
		String denyText = lp.DenyOption.getText();
		Reporter.log("Option Displayed : " + denyText, true);
		Assert.assertEquals(denyText,"Don’t allow", "Don’t allow does not match the expected message.");		
	 
	}
}
