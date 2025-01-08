package tests;


import org.testng.annotations.Test;

import com.mappls.map.features.TC__009_ShareMyLocationFeature;
import com.mappls.map.utils.DriverManager;

public class TC__009_ShareMyLocation extends DriverManager{
//223-231
	
	
	TC__009_ShareMyLocationFeature msf;
	
	
//	Check for Share Location option	
//	Verify Share location option on main screen.	
//	Share my location option should be present on home screen (Quick access)
	@Test(priority = 1) //done
	public void isShareLocationVisible() {
		msf = new TC__009_ShareMyLocationFeature(driver);
		msf.isShareMyLocationVisible();
	}
	
	
	
//	Check UI for share my location	
//	Verify the UI is proper in Share my location	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 2) //done
	public void isShareLocationFn() {
		msf = new TC__009_ShareMyLocationFeature(driver);
//		msf.shareLocationWithLogin();
		msf.isShareLocatioFunctionWorking();
	}
	
	
//	Share your location to a user	
//	Verify that user can share thier location to other user.	
//	Shared location should be shared to other user with Approx Distance and time within 5 sec and the other user should receive an notification
	@Test(priority = 3) // done
	public void shareLocationCntct() {
		msf = new TC__009_ShareMyLocationFeature(driver);
		msf.shareLocationWithLogin();
	}
	
	
//	Open a shared location of other user (Email, SMS, InApp)	
//	Verify user able to share their location by (Email, SMS, InApp)
//	Upon clicking the received shared link, it should display the shared location of the user who has sent it
//	@Test(priority = 4)
//	public void tt14() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
	
	
	
	
//	Share On/Off status should update instantly	
//	Verify On/Off is updating 5sec.
//	When we On/Off sharing location then it should update within 5 sec.
//	@Test(priority = 5)
//	public void tt144() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
	
	
	
//	Direction of Share my location (anroid, IOS & Web)	
//	Verify that route should be plotted for direction to the user who have shared the location	
//	When tapped on direction route should be plotted to the user who has shared the location and vice versa if both user share the location
//	@Test(priority = 6)
//	public void tt16() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
	
	
//	Distance of the shared user	
//	Verify that distance is coming when we share location.	
//	Distance should come while sharing the location
//	@Test(priority = 7)
//	public void tt17() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
	
	
//	Shares list in the senders Gadget	
//	Verify the shares list in the lower part of the screen	
//	When shared to multiple persons, shares list should be displayed in the lower part of the screen
//	@Test(priority = 8)
//	public void tt18() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
	
	
//	Check for the Invites below the Shares list
//	Verify the Invites list when location is shared to someone who is not registered to Mappls app	
//	Invites list should be displayed below the Shares list and invitation should be send to the receiver
//	@Test(priority = 9)
//	public void tt19() {
//		msf = new TC__009_ShareMyLocationFeature(driver);
//		
//	}
}
