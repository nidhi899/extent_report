package tests;

import org.testng.annotations.Test;

import com.mappls.map.features.BaseFeatures;
import com.mappls.map.features.TC__018_GetMapplsPinFeature;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;


public class TC__018_GetMapplPin extends DriverManager{
//431-437
	
	
	BaseFeatures bf;
	Actions ac;
	TC__018_GetMapplsPinFeature gp;
	
	
//	Verify the UI is proper in Get Mappls Pin	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1)
	public void mapplsPinUIVerification() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.mapplsPinUIVerification();
		
	}
	
	
//	On 'What is Mappls Pin?' page, 
//	Play the video(only for first time).	Video should get play in both landscape and portrait mode.
//	@Test(priority = 2)
	public void isVideoPlay() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.isMapplsPinVideoLandscap();
		
	}
	
	
//	Check Play Video Option	
//	Verify that Video should get play in youtube.
	@Test(priority = 2) 
	public void isVideoPlayINYoutube() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.isMapplsPinVideoPlayINYoutube();
	}
	
	
	
	
//	Click on Show Mappls Pin button	
//	Mappls Pin page should be display if it exist and if not then create Mappls Pin option should be appear.
	@Test(priority = 3)
	public void isMapplsPinButtonVisible() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.isShowMapplsPinClickable();
	}
	
	
//	Click on 'create Mappls Pin' button to create an Mappls Pin
//	Category, Name and Address fields should get display then after clicking on Submit button, Mappls Pin should get created Successfully.
	@Test(priority = 4)
	public void createMapplsPinPageUIVerification() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.createMpplPinUI();
	}
	
//	Mappls Pin sharing	
//	After successful creation of Mappls Pin, sharing options like email, whatsapp, hangout should get appear then select one and share it.
	@Test(priority = 5)
	public void createdMpplsPinGmailShare() {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.isUserAbleToShareCreatedPin();
	}
	
	
	//NA
//	QR code and downloading option	
//	Scan the generated QR code, Place details page of that Mappls Pin should get open
	
	

//	=====================================================
	
//new
//  Quick access : login while creating pin
	@Test(priority = 6)
	public void getPinQAWOL() throws InterruptedException {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.getPinQuickAccessMenuLoginCredential();
	}	

//  Quick access : simple hamburger login
	@Test(priority = 7)
	public void getPinQAWL() throws InterruptedException {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.qcSimpleLogin();
	}
	
//  hamburger menu : login while creating pin
	@Test(priority = 8)
	public void getPinHMWOL() throws InterruptedException {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.getPinHmMenuLoginCredential();
	}
	  

	
//	hamburger menu : simple login
	@Test(priority = 9)
	public void getPinHMWL() throws InterruptedException {
		gp = new TC__018_GetMapplsPinFeature(driver);
		gp.hambrgrSimpleLogin();
	}
	
	
}

	

