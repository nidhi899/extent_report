package tests;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__011_SettingsFeature;
import com.mappls.map.utils.DriverManager;
import com.mappls.map.utils.RetryAnalyzer;


public class TC__011_Settings extends DriverManager{
	
//241-258
	
	TC__011_SettingsFeature sf;
	
	//new
	//verify skip login skip button working properly
	@Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
	public void settingWithLoginSkipBTN() {
		sf = new TC__011_SettingsFeature(driver);
		sf.withLoginSettingsSkipBtn();
	} 

//	Check UI for Setting	
//	Verify the UI is proper in Setting	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void settingsUI() {
		sf =  new TC__011_SettingsFeature(driver);
		sf.checkSttngsUI();
	}
	
	
//	Verify Change Password option	
//	Verify that change Password is working or not	The Password we change should work when we try to login with new Password.
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class) //done
	public void settingsChangePsw() {
		sf =  new TC__011_SettingsFeature(driver);
		sf.changePassword();
	}
	
//	Check for Log Out option	
//	Verify logout functionality is working	When we log out from our account then guest user account should come.
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void sttngsLogout() {
		sf =  new TC__011_SettingsFeature(driver);
		sf.logOut();
	}
	
//	Verify Avoid feature in Navigation Settings	
//	Verify Avoid feature in Navigation Settings	When user avoid anything then it should work while navigation .e.g..Tolls
//	@Test(priority = 4) na
//	public void avoidFeature() {
//		sf =  new TC__011_SettingsFeature(driver);
	
	
	
//	Verify Units feature in Navigation Settings	
//	Verify Units feature in Navigation Settings	When user change the units then it should get changed in Navigation & place details as well
	@Test(priority = 4) //done
	public void unitFeature() {
		sf =  new TC__011_SettingsFeature(driver);
		sf.sttngsUnitFeature();
	}
	
	
//	Set Navigation Marker	
//	Verify that the user is able to tap on Set Navigation Marker and change the icon	The user should be able to change the icon of Navigation marker
//	@Test(priority = 6)
	public void navigationMarker() {
		sf =  new TC__011_SettingsFeature(driver);
		
	}	
	
//	Change colour of Navigation Marker	Verify that the user is able totap on Set Navigation Marker and change thecolour of the icon	The user should be able to changethe colour of the icon of Navigation marker
	
	
	
//	Voice Guidance	Verify that the user is able to use the toggle button to switch on/off the voice guidance	The user should be able to use the toggle button to switch on/off the voice guidance mode
	
	
	
//	Alerts for traffic (Voice Guidance)	Verify that the user is getting thevoice guidance commands for traffic alerts	The user shoud get turn by turn voice guided navigation with traffic alerts
	
	
	
//	Alerts for safety (Voice Guidance)	Verify that the user is getting thevoice guidance commands for safety alerts	The user shoud get turn by turn voice guided navigation with safety alerts
	
	
//	Alerts for navigation (Voice Guidance)	Verify that the user is getting the voice guidance commands for navigation alerts	The user shoud get turn by turn voice guided navigation with navigation alerts
	
	
	
//	Visual Alerts	
//	Verify that the user is able to use the toggle button to switch on/off the visual alerts	The user should be able to use the toggle button to switch on/off the visual alerts mode for traffic and safety alerts
//	@Test(priority = 6) na
//	public void isToggleSwitched() {
//		sf = new TC__011_SettingsFeature(driver);
//		
//	}
	
	
//	Alerts for traffic (Visual Alerts)	Verify that the user is able to view the visual alerts for traffic on navigation screen	The user should be able to view the Alerts for traffic on navigation screen
	
	
	
//	Alerts for safety (Visual Alerts)	Verify that the user is able to view the visual alerts for safety on navigation screen	The user should be able to view the Alerts for safety on navigation screen
	
	
	
//	Alerts for Navigation (Visual Alerts)	Verify that the user is able to view the visual alerts for navigation on navigation screen	The user should be able to view the Alerts for navigation on navigation screen
	
	
	
//	Home (Travel Setting)	Verify that the user is able to see the location of His/Her home on direction screen and can navigate to His / Her home from current location	The user should be able to see the location of His/Her home on direction screen and can navigate to His / Her home from current location
	
	
//	Work (Travel Setting)	Verify that the user is able to see the location of His/Her Work place on direction screen and can navigate to His / Her home from current location	The user should be able to see the location of His/Her Work on direction screen and can navigate to His / Her Work from current location
	
	
//	Check Play as Bluetooth phone call (ON/OFF)	Verify Voice for navigation while FM/Music is playing	While phone is connected with bluetooth and any instruction comes then music volume should get low (Voice overlap)

	
}
