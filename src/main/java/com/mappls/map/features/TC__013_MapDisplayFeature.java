
package com.mappls.map.features;

import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__013_MapDisplayPage;
import com.mappls.map.pages.TC__020_MapLayerPage;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__013_MapDisplayFeature extends DriverManager{
	
	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__013_MapDisplayPage mdp;
	TC__020_MapLayerPage mp;
	Actions ac;
	
	public TC__013_MapDisplayFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		mdp = new TC__013_MapDisplayPage(driver);
		ac = new Actions();
		mp = new TC__020_MapLayerPage(driver);
				
	}
	
	
	public void mpplsLogogImg() {
		bf.mapplsPermissions();
		Assert.assertTrue(mdp.mpplsLogoImg.isDisplayed(),"Mappls logo image is not display");
	    Reporter.log("Mappls logo image is display", true);
	}
	
	
	
	public void isMySavesBtnPresent() {
		bf.mapplsPermissions();
		mp.mpLayerIcon.click();
		
		bf.swipeUpUntilElementDisplayed(mdp.myLayerMySave, 3);
		
		Assert.assertEquals(mdp.myLayerMySave.getText(), "Home, Work, My Saves, My Gadgets etc");
		Reporter.log("Home, Work, My Saves, My Gadgets etc is available", true);
		
		
		mdp.myLayerMySave.click();
		
		
		Assert.assertEquals(mdp.myLayerPageTitle.getText(), "My Layers");
		Reporter.log("My Layers is present", true);
		
		
		Assert.assertTrue(mdp.myLayerMySavesPresent.isDisplayed(),"Failed to display my saves in map layer");
		Reporter.log("my saves is present", true);
		
		Assert.assertTrue(mdp.myLayerMySavesToggle.isDisplayed(),"Failed to display my saves with toggle in map layer");
		Reporter.log("my saves toggle is present", true);
	}
	
	
	public void homeScreenDirection() {
		bf.mapplsPermissions();
		mdp.homeScreenDirection.click();
		
		
		Assert.assertEquals(mdp.urCrrntLoction.getText(), "Your current location");
		Reporter.log("direction page redirected and Your current location is present by default", true);
	
		Assert.assertEquals(mdp.home.getText(), "Home");
		Reporter.log("Home option is available", true);
		
		Assert.assertEquals(mdp.work.getText(), "Work");
		Reporter.log("work option is available", true);
		
		
		
	}
	
	

	
}
