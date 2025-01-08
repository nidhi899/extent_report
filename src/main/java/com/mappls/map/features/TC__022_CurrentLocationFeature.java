package com.mappls.map.features;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.TC__022_CurrentLocationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__022_CurrentLocationFeature {

	TC__022_CurrentLocationPage cl;
	BaseFeatures bf;
	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	public TC__022_CurrentLocationFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		cl = new TC__022_CurrentLocationPage(driver);
		bf = new BaseFeatures(driver);

	}

	public void currentLocation() {
		try {
			wait.until(ExpectedConditions.visibilityOf(cl.currentLocationIcon));
			if (cl.currentLocationIcon.isDisplayed()) {
				Reporter.log("Current Location Button is visible.", true);
				cl.currentLocationIcon.click();
				Reporter.log("Current Location Button clicked", true);
				Assert.assertTrue(true, "Current Location Button clicked successfully");
			} else {
				Assert.fail("Current Location Button not found");
			}
		} catch (Exception e) {
			Assert.fail("Failed to interact with Current Location Button: " + e.getMessage());
		}
	}
}
