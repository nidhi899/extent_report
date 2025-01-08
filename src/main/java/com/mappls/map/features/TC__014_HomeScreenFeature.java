package com.mappls.map.features;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
//import org.sikuli.api.Screen;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__014_HomeScreenPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;




public class TC__014_HomeScreenFeature {

	
	AppiumDriver<MobileElement> driver;
	TC__020_MapLayerFeature mf;
	BasePage bp;
	BaseFeatures bf;
	TC__014_HomeScreenPage hs;

	public TC__014_HomeScreenFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		hs = new TC__014_HomeScreenPage(driver);
		mf = new TC__020_MapLayerFeature(driver);

	}

	

	//	TC -1 
	public void uiVerification () {

		bf.mapplsPermissions();

		Assert.assertTrue(hs.s360View.isDisplayed(),  "not visible in home screen page");
		Reporter.log("360 is visible", true);


		Assert.assertTrue(hs.isSearchBarVisible.isDisplayed(),  "Search bar not visible in home screen page");
		Reporter.log("search bar is visible", true);


		Assert.assertTrue(hs.isMapLayerVisisble.isDisplayed(),  "map layer not visible in home screen page");
		Reporter.log("map layer is visible", true);

		Assert.assertTrue(hs.isCamVisible.isDisplayed(),  "cam option not visible in home screen page");
		Reporter.log("camera option is visible", true);

		Assert.assertTrue(hs.isPinVisible.isDisplayed(),  "mappls pin icon is not visible in home screen page");
		Reporter.log("pin is visible", true);

		Assert.assertTrue(hs.isLocationVisible.isDisplayed(),  "location not visible in home screen page");
		Reporter.log("location is visible", true);


		Assert.assertTrue(hs.isbtmSheetVisible.isDisplayed(),  "bottom sheet for quick access menu is not visible in home screen page");
		Reporter.log("bottom sheet for quick access menu is visible", true);


	}


	//	TC - 2
	public void topScreen() {
		bf.mapplsPermissions();


		Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(),  "hamburger menu icon is not visible in home screen page");
		Reporter.log("hamburger icon menu is visible", true);

		Assert.assertTrue(hs.isSearchBarVisible.isDisplayed(),  "Search bar not visible in home screen page");
		Reporter.log("search bar is visible", true);


		Assert.assertTrue(hs.isNavigationVisible.isDisplayed(),  "navigation icon is not visible in home screen page");
		Reporter.log("navigation is visible", true);

		Assert.assertTrue(hs.isWhatAndWhereBtnVisible.isDisplayed(),  "what and where is not visible in home screen page");
		Reporter.log("what and where is visible", true);

	}


	//	TC - 3
	public void centerScreen() throws InterruptedException, IOException, FindFailed {
		bf.mapplsPermissions();


		Assert.assertTrue(hs.isMapLayerVisisble.isDisplayed(),  "map layer not visible in home screen page");
		Reporter.log("map layer is visible", true);

		Assert.assertTrue(hs.isCamVisible.isDisplayed(),  "cam option not visible in home screen page");
		Reporter.log("camera option is visible", true);

		Assert.assertTrue(hs.isPinVisible.isDisplayed(),  "mappls pin icon is not visible in home screen page");
		Reporter.log("pin is visible", true);
		//		mf.mapLayerClick();				
		//		mf.maplayersVerfication(1 , "Default Map already selected with out login");

		
		
		
		
		
		
		
		File imgFile = new File("src/main/resources/images/location_Icon.png");
		if (!imgFile.exists()) {
		    throw new FileNotFoundException("Image not found at path: " + imgFile.getAbsolutePath());
		}

		try {
		    Screen sc = new Screen();
		    Pattern imagePattern = new Pattern(imgFile.getAbsolutePath()).similar(0.9); // Adjust similarity threshold
		    sc.wait(imagePattern, 10); // Wait for the image to appear
		    sc.click(imagePattern);    // Click the image if found
		    System.out.println("Image found and clicked successfully!");
		} catch (FindFailed e) {
		    System.err.println("FindFailed: Unable to find the image. Details: " + e.getMessage());
		    e.printStackTrace();
		    throw new RuntimeException("Image not found during test execution.");
		}
		
		
		
	}

	
//	TC - 4
	public void lowerSideElementsVerification() {
		bf.mapplsPermissions();
		
		Assert.assertTrue(hs.isLocationVisible.isDisplayed(),  "location not visible in home screen page");
		Reporter.log("location button is visible", true);

		
		Assert.assertTrue(hs.isbtmSheetVisible.isDisplayed(),  "bottom sheet for quick access menu is not visible in home screen page");
		Reporter.log("bottom sheet for quick access menu is visible", true);

	}
	
	
//	TC - 5
	public void leftElementsVerification() {
		bf.mapplsPermissions();
		Assert.assertTrue(hs.s360View.isDisplayed(),  "not visible in home screen page");
		Reporter.log("360 is visible", true);
	}

	
	
	
//	youarehere.jpg
	
	

}
