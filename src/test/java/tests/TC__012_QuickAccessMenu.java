package tests;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__012_QuickAccessMenuFeature;
import com.mappls.map.utils.DriverManager;


public class TC__012_QuickAccessMenu extends DriverManager{
//267-277

	TC__012_QuickAccessMenuFeature qc;
	
//	======================================================
//	Verify the UI is proper in Quick Access Menu
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1)
	public void quickAccessUIVerification() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.uiVerify();
	}
	
	
//	Verify that weather condition, temperature and AQI is displayed to the right of the text of Quick Access Menu
//	"Weather should be updated in 2 cases
//	1. When current location button is tapped
//	2. When map is changed to atleast 5km"
//	@Test(priority = 2) na
//	public void tempAQI() {	
//	}
	
//	Verify Report an issue by Category
//	When user reported any issue by selecting their category it should reported - Photo should upload ,Comes in Contribution (Only Map Issues)
	@Test(priority = 2)  //done
	public void reportIssueAndContributionVerification() throws ParseException {
		qc = new TC__012_QuickAccessMenuFeature(driver);
//		qc.reportedIssue();
		qc.fixMapAndVerification();
	}
	
	
//	Verify all the gadgets are visible on the Quick access menu	
//	All the gadgets mapped in the account must be displayed
//	@Test(priority = 4)  // need IOT Account - na
//	public void allGadgetsIsVisible() 
	
	
	
	
	
//	Verify Share location option on main screen.
//	Share my location option should be present on Quick Access Menu
	@Test(priority = 3)
	public void locationOptionMainScreen() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.isShareMyLocationVisible();
	}
	
//	Verify Get Mappls Pin button
//	Get Mappls Pin option should be appear.
	@Test(priority = 4)
	public void getMapplsPinButtonWOL() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.isGetMapplsPinVisibleWOL();
	}
	
//	Verify reported issue which where reported eariler by any user.
//	Reported issue should be shown on the map.
//	@Test(priority = 7) na
//	public void isReportedIssueAppear() {
//		
//	}
	
//	Verify reported issue where no event is reported ever.	
//	Message should appear "Sorry, no results found in this area. Try panning or zooming the map".
//	@Test(priority = 8)  na
//	public void isMsgVisible() {
//		
//	}
	
	
//	Verify User able to create issue on map
//	User by Report an issue should be shown on the map.
//	@Test(priority = 9) na
//	public void issueOnMap() {
//		
//	}
	
//	Verify Home 
//	User should able to set any location as home
	@Test(priority = 5)
	public void homeOption() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.setHomeAddressWithLogin();
	}
	
	
//	Verify Buy Gadget & activate Gadget option
//	User should able to buy new devices from this link.
//	@Test(priority = 11)
//	public void activateGadgetOption()
	
	
//	=============== new test cases
//	Verify Work 
//	User should abe to set any location as work
	@Test(priority = 6)
	public void workOption() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
//		qc.setWorkAddressWithOutLogin();
		qc.setWorkAddressWithLogin();
	}
	
	
	
	//post on map with login 
	//verify that without location map post button clicking and toast message appears for location validation
//	@Test(priority = 7) //done
	public void postWLAndWithOutLocation() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.postMapWithLogin();
	}
	
	
	//verify that map posted successfully with location
	@Test(priority = 8) //done
	public void postWithLoginAndLocation() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.postMapWithLoginAndLocation();
	}
	
	
	//verify that post on map with out login cancel login button working
//	@Test(priority = 9) //done
	public void postWithOutLogin() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.postMapWithLoginMsg();
	}
	
	//verify that posted map should be share and close
	@Test(priority = 10) //done
	public void postShareAndClose() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.postedShareAndClose();
	}
	
	
	//verify that after post map , continue button is working
	@Test(priority = 11) //done
	public void postAndContinue() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.postAndCntinue();
	}
	
	
	//verify that after post map, click on view post and check helpful count and share button
	@Test(priority = 12) //done
	public void postShareAndHelpful() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.shareAndHelpFulLike();
	}
	
	
	//verify that fix map with login
	@Test(priority = 13) //done
	public void fixMapWithLogin() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.fixMapWithLogin();
	}
	
	
	//verify that fix map with out login
	@Test(priority = 14) //done
	public void fixMapWithOutLogin() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.fixMapWithOutLogin();
	}
	
	
////	Verify Share location option with login on main screen.
////	Share my location option should be present on Quick Access Menu with login
//	@Test(priority = 15)
//	public void locationOptionMainScreenWL() {
//		qc = new TC__012_QuickAccessMenuFeature(driver);
//		qc.isShareMyLocationVisibleWL();
//	}
	
	//check view posted event and apply filter
	@Test(priority = 15) //done
	public void viewPostEventsByFilter() throws ParseException {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.viewPostedEvents();
	}
	
	
	
	//set home with out login
	//verify that user is able to click cancel login 
	@Test(priority = 16) //done
	public void setHomeWithOutLogin() throws ParseException {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.setHomeAddressWithOutLogin();
	}

	
	//set work without login
	//verify that user is able to click cancel login
	@Test(priority = 17) //done
	public void setWorkWithOutLogin() throws ParseException {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.setWorkAddressWithOutLogin();
	}
	
	
//	Verify Get Mappls Pin button with login
//	Get Mappls Pin option should be appear with login
	@Test(priority = 18) //done
	public void getMapplsPinButtonWL() {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.isGetMapplsPinVisibleWL();
	}
	
	
	//check posted map should be visible on view post event
	@Test(priority = 19) //done
	public void postMapAndViewPostedEvntVerification() throws ParseException {
		qc = new TC__012_QuickAccessMenuFeature(driver);
		qc.reportedIssue();
	}
	
}
