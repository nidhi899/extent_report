package com.mappls.map.features;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.TC__025_RealViewPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__025_RealViewFeature {


	TC__025_RealViewPage rl;
	BaseFeatures bf;
	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public TC__025_RealViewFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		rl = new TC__025_RealViewPage(driver);
		bf = new BaseFeatures(driver);

	}

	public void realView() {
		try {
			wait.until(ExpectedConditions.visibilityOf(rl.realView360));
			if (rl.realView360.isDisplayed()) {
				Reporter.log("RealView 360 is displayed.", true);
				rl.realView360.click();
				Reporter.log("RealView 360 is clicked", true);
				Assert.assertTrue(true, "RealView 360 button clicked successfully");
			} else {
				Assert.fail("RealView 360 button not found");
			}
		} catch (Exception e) {
			Assert.fail("Failed to interact with RealView 360 button: " + e.getMessage());
		}
	}
	//563
	public void RealViewIconDisplay() {
		bf.mapplsPermissions();
	    realView();
	}
	
}
