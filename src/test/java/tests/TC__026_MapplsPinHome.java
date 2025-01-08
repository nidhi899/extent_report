package tests;

import org.testng.annotations.Test;
import com.mappls.map.features.TC__026_MapplsPinHomeFeature;
import com.mappls.map.utils.DriverManager;



//import map.mappls.map.features.GetMapplsPinFeatures;

public class TC__026_MapplsPinHome extends DriverManager{
	
	
//574-586
	
	TC__026_MapplsPinHomeFeature mpf;
	
//	Check for Mappls pin on Home page	
//	Verify the Mappls Pin available on home page	
//	Mappls Pin button should be on the Home Screen
	@Test(priority = 1)
	public void mapplsPinHomePage() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.isMapplsPinOnHomePage();
	}
	
	
//	Check for Mappls pin button on Home page	
//	Verify that the Mappls pin button is clickable	
//	Mappls Pin button should be clickable and after clicking show Mappls Pin page should open
	@Test(priority = 2)
	public void isMapplsPinBtnClickable() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.isShowMapplsPinPageOpen();
	}
	
//	Check for Mappls pin on Home page	
//	Verify the UI is proper on home page	
//	UI for all screens (Search, Show Mappls Pin, Move map to adjust and Create mappls pin, current location button, compass) should be properly visible and function should work properly
	@Test(priority = 3)
	public void homePageUI() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.verifyMapplsPinPageUI();
	}
	
	
//	Check for Show Mappls Pin button	
//	Verify that the Show Mappls Pin button is clickable and functional	
//	On clicking Show Mappls Pin should open a page showing Nearby Mappls Pin. Drag the map to any place to view Mappls pin available at any place.
	@Test(priority = 4)
	public void showMapplsPin() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.isShowMapplsPinClickable();
	}
	
	
//	Check for Search button	
//	Verify that Search is clickable and functional	
//	"on searching any place, result, Auto-suggested or text search should be availabe. User should be able to click on any of the result  from the list and Show Mappls Pin and Create Mappls Pin should be available.
//	Check Choose on map option ."
	@Test(priority = 5)
	public void isSearchBtnWorking() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.isSearchClickable();
	}
	
	
//	Check for Create Mappls Pin button (without login)	
//	Verify that Create Mappls Pin is clickable and functional	
//	"User is asked to Login to access this functionality. with cancel and login buttons available.
//	1. On clicking Cancel it should takes back to previous page.
//	2. On clicking Login, should take to the welcome page for login. Toast message of Login successful.And after logging to again same page to show /create Mappls pin page"
	@Test(priority = 6)
	public void isMapplsBtnClickableWOL() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.verifyMapplsPinWOL();
	}
	
	
//	Check for Create Mappls Pin button (with login)
//	Verify that Create Mappls Pin is clickable and functional	
//	Create Mappls Pin page opens up
	@Test(priority = 7)
	public void mapplsPinBtnWL() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.verifyMapplsPinWL();
	}
	
	
//	Verify Create Mappls Pin	
//	Click on 'Create Mappls Pin' button to create an Mappls Pin	
//	Category, Name and Address fields should get display then after clicking on Submit button, Mappls Pin should get created Successfully.
	@Test(priority = 8)
	public void isMapplsPinCreated() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.createMapplsPinWLAndVerification();
	}
	
//	Verify Share Mappls 
//	Pin	Mappls Pin sharing	
//	After successful creation of Mappls Pin, sharing options like email, whatsapp, X, hangout should get appear then select one and share it.
	@Test(priority = 9)
	public void shareMapplsPin() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.isUserAbleShareMapplsPin();
	}
	
	
//	Verify Spread the accomplishment	
//	Mappls Pin feature sharing	
//	After successful creation of Mappls Pin, spreading accomplishment about the feature by options like email, whatsapp, X, hangout should get appear then select one and share it.
	@Test(priority = 10)
	public void spreadAccomplishmentMaileShare() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.mapplsAccomplished();
	}
	
	
//	Verify the UI for sharing and Spread the accomplishment	
//	Verify that UI should be proper and updated	
//	UI should be proper After successful creation of Mappls Pin, spreading accomplishment about the feature by options like email, whatsapp, X, hangout should get appear then select one and share it.
	@Test(priority = 11)
	public void verifySharingPin() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.spreadAccmplishmntUI();
	}
	
//	QR should be working	
//	QR code and downloading option	
//	Scan the generated QR code, Place details page of that Mappls Pin should get open
//	@Test(priority = 12) na
	public void isQRWorking() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		
	}
	
	
//	Verify add another place button on congratulations page
//	Verify that user is directed to show mappls pin page 	
//	User is directed to show mappls pin page to again continue with Mappls pin flow.
	@Test(priority = 12)
	public void verifyAnotherMapplsPin() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.againCreateMapplsPin();
	}
	
	
	
	//new 
	//mappls pin back button 
	//verify homw page is visible
	@Test(priority = 13)
	public void mapplsPinBackButton() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.againCreateMapplsPin();
	}
	
	
	//new
	//verify create mappls pin page back button working
	@Test(priority = 14)
	public void createMapplsPinPageBackButton() {
		mpf = new TC__026_MapplsPinHomeFeature(driver);
		mpf.createMpplPinPageBackBtnFunctionality();
	}
	
//	================================
//	
//	
////	 Quick access : login while creating pin
//		@Test(priority = 1)
//		public void getPinQAWOL() throws InterruptedException {
//			mpf = new TC__026_MapplsPinHomeFeature(driver);
//			mpf.getPinQuickAccessMenuLoginCredential();
//		}	
//
//	//  Quick access : simple hamburger login
//		@Test(priority = 2)
//		public void getPinQAWL() throws InterruptedException {
//			mpf = new TC__026_MapplsPinHomeFeature(driver);
//			mpf.qcSimpleLogin();
//		}
//		
//	//  hamburger menu : login while creating pin
//		@Test(priority = 3)
//		public void getPinHMWOL() throws InterruptedException {
//			mpf = new TC__026_MapplsPinHomeFeature(driver);
//			mpf.getPinHmMenuLoginCredential();
//		}
//		  
//
//		
////		hamburger menu : simple login
//		@Test(priority = 4)
//		public void getPinHMWL() throws InterruptedException {
//			mpf = new TC__026_MapplsPinHomeFeature(driver);
//			mpf.hambrgrSimpleLogin();
//		}
//

		
	}