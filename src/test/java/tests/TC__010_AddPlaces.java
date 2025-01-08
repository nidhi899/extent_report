package tests;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__010_AddPlacesFeature;
import com.mappls.map.utils.DriverManager;



public class TC__010_AddPlaces extends DriverManager{
	//232-240

	TC__010_AddPlacesFeature ap;
	
	
	
//	Verify the UI is proper in Add a Place
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1) 
	public void verifyAddPlaceUI() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.verifyUI();
	}
	
	
	
//	Verify Two type of Add a place section	
//	Residential and business category should show and functionality also work.
	@Test(priority = 2)
	public void apCatAndSubCat() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.catAndSubCat();
	}
	
//	Check first screen of Add a Place	"1-Top of the screen should show Status bar-Time wifi/Mobile Network,
//	2-In Title bar should show- back button, Title(Heading), submit button"
	@Test(priority = 3)
	public void addPlacesUIVerification() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.topNavElements();
	}
	
//	TC - 4
//	Verify the Map Veiw of the Screen (Maek location on map)	
//	Map tile with floating buttton(Current location button) should show in this screen.
	@Test(priority = 4)
	public void addPlaceLocationVerification() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.isLocationVisisble();
	}
	
//	Verify adding a new place	
//	New place should get added & updated in the contributions list
	@Test(priority = 5)
	public void newPlcContributionCount() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.contriCountByAddingPlc();
	}
	
	
//	Verify the added place is searchable	
//	The added place should be searchable in Autosuggest & Textsearch list(The only one who added)
	@Test(priority = 6)
	public void addPlcWithVerification() throws MalformedURLException {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.addPlcVerificationAutoSuggest();
	}
	
	
//	Verify relevant sharing options are given
//	User should be able to share the link
	@Test(priority = 7) //eloc share
	public void addPlcLinkGmailShare() throws MalformedURLException {
		ap = new TC__010_AddPlacesFeature(driver);
//		ap.elocationGmailShare();
		ap.elocationAddPlcGmailShare();
	}
	
//	Verify the sharing link generated is in correct format
//	Link format should be https://mappls.com//mmi000
//	@Test(priority = 8) //hold
	public void linkFormatVerification() {
		ap = new TC__010_AddPlacesFeature(driver);
		ap.isLinkCorrectFormat();
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	==========================================
	

//	@Test(priority = 1)
//	public void addPlacesWithLoginAndPinVerification() throws InterruptedException {
//		ap = new TC__010_AddPlacesFeature(driver);
//		ap.addAPlaceWithOutLogin();
//	}
//
//	@Test(priority = 2)
//	public void addPlacesWithOutLogin() throws InterruptedException {
//		ap = new TC__010_AddPlacesFeature(driver);
//		ap.addPlaceWithLoginCredential();
//
//
//	}
}
