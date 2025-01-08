package com.mappls.map.features;

import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__009_ShareMyLocationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__009_ShareMyLocationFeature {
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__009_ShareMyLocationPage sl;

	public TC__009_ShareMyLocationFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
			
		sl = new TC__009_ShareMyLocationPage(driver);
	}
	
	private static final String USERNAME = "nidhi1234";
    private static final String PASSWORD = "Mvn@1234";
    private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful";

	
    public void isShareMyLocationVisible() {
    	bf.mapplsPermissions();
//    	bf.scrollUp(8);
    	
    	bf.swipeUpUntilElementDisplayed(sl.shareLocation, 8);
    	Assert.assertTrue(sl.shareLocation.isDisplayed(), "share location not display");
		
    	Reporter.log("share my location is present in the quick access menu", true);
    }
	
    
    public void isShareLocatioFunctionWorking() {
    	
    	bf.mapplsPermissions();
//    	bf.scrollUp(8);
    	
    	bf.swipeUpUntilElementDisplayed(sl.shareLocation, 8);
    	sl.shareLocation.click();
    	
    	Assert.assertTrue(bp.loginBTNMsg.isDisplayed(), "share location not display");
		
    	Reporter.log("share my location is present in the quick access menu and its functionality working properly", true);
    }
    
    
	public void shareLocationWithLogin() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin(USERNAME, PASSWORD, LOGIN_SUCCESS_MESSAGE);
		loginVerification();
		shareLocationLink();
	}
	
	public void loginVerification() {
		bf.sleepWait(5);
		bf.Hamburgerclick();
		bf.loginbtnHamburgerclick();
		bf.ProfileEditIconclick();
		String uname = bp.loginUName.getText();
		String uemail = bp.loginUMail.getText();
		String umobile = bp.loginUNumber.getText();
		String userId = bp.loginUserId.getText();
		
		boolean credentialMatched = USERNAME.equals(uname) || USERNAME.equals(uemail) || USERNAME.equals(umobile) || USERNAME.equals(userId);
		Assert.assertTrue(credentialMatched , "Username mismatched");
		Reporter.log("Login and verification successfully " , true);
		bf.sleepWait(5);
		
		driver.navigate().back();
		bf.sleepWait(4);
		driver.navigate().back();
		bf.sleepWait(4);
		
	}
	public void shareMyLocationClick() {
		bf.swipeUpUntilElementDisplayed(sl.shareLocation, 8);
		Assert.assertTrue(sl.shareLocation.isDisplayed(), "share location not display");
		sl.shareLocation.click();
		Reporter.log("clicked 'Share my location' ", true);
		bf.sleepWait(3);
	}
	public void shareLocationLink() {
		shareMyLocationClick();
		shareMyLocationBTN();
		if(sl.mplPrmsn.isDisplayed()) {
			
			driver.navigate().back();
		}
		continueBtn(); 
		if(sl.entityHdr.isDisplayed()) {
			
			driver.navigate().back();
		}
		Assert.assertTrue(sl.select8HourDuration.isDisplayed(),"select duration not display");
		sl.select8HourDuration.click();
		sl.selectContactBtn.click();
		
		Assert.assertTrue(sl.allowPermsn.isDisplayed(),"Failed");
		sl.allowPermsn.click();
		
//		Assert.assertTrue(sl.contactList.get(1).isDisplayed(),"select duration not display");
//		sl.contactList.get(1).click();
		
		sl.contactListSend.click();
		
		Assert.assertTrue(sl.sendButton.isDisplayed(),"select duration not display");
		sl.sendButton.click();
		bf.toastMsg("Your location has been shared");
	}
	
	public void shareMyLocationBTN() {
		sl.shareLocationButon.click();
		Reporter.log("clicked 'Share location Button' ", true);
		bf.sleepWait(3);
	}
	
	public void continueBtn() {
		Assert.assertTrue(sl.continueBtn.isDisplayed(),"continue button not displayed");
		if(sl.continueBtn.isDisplayed()) {
			sl.continueBtn.click();
			Reporter.log("clicked 'Continue Button' ", true);
			bf.sleepWait(3);
		}
		
	}
	
}
