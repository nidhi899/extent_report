package com.mappls.map.features;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__020_MapLayerPage;
import com.mappls.map.pages.TC__024_EarthObsDataPage;
import com.mappls.map.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__024_EarthObsDataFeature extends DriverManager{

	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__024_EarthObsDataPage ep;
	TC__020_MapLayerFeature mf;
	TC__020_MapLayerPage mp;

	public TC__024_EarthObsDataFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		ep = new TC__024_EarthObsDataPage(driver);
		mf = new TC__020_MapLayerFeature(driver);
		mp = new TC__020_MapLayerPage(driver);
		
	
	}
	
	
	public void isEarthObsDataClickable() throws InterruptedException {
		bf.mapplsPermissions();
		mf.mapLayerClick();
		Reporter.log("clicked on map layer icon", true);
		
		Assert.assertEquals(ep.earthObsTxt.getText(), "Earth Observation Data");
		Reporter.log("'Earth Observation Data' is present in map layer", true);
		
		mf.earthObservationClick();
		Reporter.log("clicked on earth observation data", true);
		
		Assert.assertEquals(ep.getTxt.getText(), "Earth Observation Data");
		Reporter.log("Earth observation Data is clickale", true);
		
	}
	
	
	public void earthObsBackBtn() throws InterruptedException {
		
		isEarthObsDataClickable();
		
		
		Assert.assertTrue(ep.backBtn.isDisplayed(), "Failed");
		Reporter.log("earth observation back button is visible", true);
		
		
		
		Assert.assertTrue(ep.floatingLocationIcon.isDisplayed(), "Failed");
		Reporter.log("floating location icon is visible", true);
		
		//scroll categories
		
		bf.swipeUpUntilElementDisplayed(ep.waterSpread, 3);
		
		ep.waterSpread.click();
		Reporter.log("Clicked on water spread", true);
		
		Assert.assertEquals(ep.wtrSpreadCategoyTitle.getText(), "Water Spread");
		
		for(WebElement elements : ep.wtrSpreadLists) {
			Reporter.log("water spread lists : "+elements.getText(), true);
		}
		
		ep.wtrSpreadBckBtn.click();
		
		Assert.assertEquals(ep.getTxt.getText(), "Earth Observation Data");
		Reporter.log("water spread back button is working", true);
		
//		=============weather
		bf.swipeUpUntilElementDisplayed(ep.weather, 3);
		ep.weather.click();
		Reporter.log("Clicked on weather", true);
		Assert.assertEquals(ep.weatherTitle.getText(), "Weather");
		
		bf.swipeUpUntilElementDisplayed(ep.weatherNightList, 3);
		
		for(WebElement elements : ep.weatherCtaLists) {
			Reporter.log("weather lists : "+elements.getText(), true);
		}
		
		ep.weatherNightList.click();
		
		Assert.assertEquals(ep.weatherHedrTxt.getText(), "Weather");
		
		Reporter.log("weather page redirected", true);
		
		
		Assert.assertEquals(ep.srfceAirTemp.getText(), "Surface Air Temperature - Night");
		Reporter.log("'Surface Air Temperature - Night' data is present in the bottom sheet of the screen", true);
		
		
		
		
		
			
		
	}
	
	
	
	
	
	
	public void allCategoryIconVisibility() throws InterruptedException {
		
		
		mf.earthObservationList();
		
		mf.commonLocators(1, "Night Light Data");
		
		mf.commonLocators(2, "Digital Elevation Model");
		
		mf.commonLocators(3, "Weather");
		
		mf.commonLocators(4, "Landuse & Landcover");
		
		mf.commonLocators(5, "Water Spread");
		
		mf.commonLocators(6, "Satellite Image");
		
		mf.commonLocators(7, "Vegetation Indices");
		
		mf.commonLocators(8, "Weather Forecast");
		
		mf.commonLocators(9, "SAR Backscatter Image");
		
		mf.commonLocators(10, "Soil Moisture & Temperature Data");
		
		
		
	}
	
	public void earthObsDataClickCatAndSubCat() throws InterruptedException {
		
		bf.mapplsPermissions();
		mf.mapLayerClick();
		mf.earthObservationClick();
		
		
		mf.commonLocatorsClick(1, "Night Light Data");
		
		mf.commonLocatorsClick(2, "Digital Elevation Model");
		
		mf.commonLocatorsClick(3, "Weather");
		
		mf.commonLocatorsClick(4, "Landuse & Landcover");
		
		mf.commonLocatorsClick(5, "Water Spread");
		
		mf.commonLocatorsClick(6, "Satellite Image");
		
		mf.commonLocatorsClick(7, "Vegetation Indices");
		
		mf.commonLocatorsClick(8, "Weather Forecast");
		
		mf.commonLocatorsClick(9, "SAR Backscatter Image");
		
		mf.commonLocatorsClick(10, "Soil Moisture & Temperature Data");
		
		
		
	}


}
