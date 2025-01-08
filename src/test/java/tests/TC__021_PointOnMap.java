package tests;


import org.testng.annotations.Test;

import com.mappls.map.features.TC__021_PointOnMapFeature;
import com.mappls.map.utils.DriverManager;

public class TC__021_PointOnMap extends DriverManager{
	
	TC__021_PointOnMapFeature pf;
//491-496

	
//	Check the point on map
//	Verify that user is able to long press on the map tile	
//	User should be able to see the screen with back button, overflow button,and Place detail card should open with ETA detail,direction,share,save,Post,Nearest Location,Add a missing place fuctionality.
	@Test(priority = 1) //done
	public void isUserAbleToLongPress() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.isUserAbleToLongPressOnMap();
		
	}
	
//	Check for tap on save button	
//	Verify user is able to see alert  popup window for saved place.	
//	User should be able to enter label name,on tap on add button user should see a alert for "Point saved in list "Point on Map"User should be able to see saved place in Point On Map List from my saves.
	@Test(priority = 2) //done
	public void alertWindow() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.isUserAbleToEnterLblName();
	}
	
	
	
	
	
	
//	Check for tap on save button	
//	Verify user is able to see popup alert window	
//	Alert popup should hide and user should back to the Point On Map page
	@Test(priority = 3) //done
	public void popupWindowHide() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.savePointPlcPopupHide();
	}
	
	
//	Check for tap on Report Button	
//	Verify that the Report button function is working properly and user is able to report at any desired location	
//	After tapping on Next button user should be able to report any kind of issue at any location and finally confirmation message should appear "Posted Successfully. Would you like to share?, with 3 options for Share, View and No and also i toast message should appear "Your post has been submitted successfully" 
	@Test(priority = 4) //done
	public void isReportBtnWorking() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.isPostButtonClickable();
	}
	
//	Check for tap on Nearest Location	
//	Verify Nearest Location function is working properly	
//	Tapping on Nearest Location address card of the nearest location should be displayed
	@Test(priority = 5) //done
	public void isNearestLocationWorking() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.nearestLocation();
	}
	
	
	
//	Check for Add  A Missing Place	
//	Verify that user is able to add a missing place.	
//	"Add A Place should be clickable and open add a place screen. 
//	After adding a place, that place should be saved on a contributon of my saves"
	@Test(priority = 6) //done
	public void isAddPlaceClicksble() {
		pf = new TC__021_PointOnMapFeature(driver);
		pf.isUserAbleToAddMissingPlc();
	}
	
	
}
