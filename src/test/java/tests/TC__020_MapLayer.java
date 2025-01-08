package tests;

import org.testng.annotations.Test;

import com.mappls.map.features.BaseFeatures;
import com.mappls.map.features.TC__020_MapLayerFeature;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;



public class TC__020_MapLayer extends DriverManager {
	TC__020_MapLayerFeature ml;
	BaseFeatures paf;
	Actions ac;
	
	
	
	
	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1)
	public void isMapLayerButtonVisible() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.isMLButtonClickable();		
	}
	
	
//	map layer button with valid credential or guest user
	@Test(priority = 2)
	public void withValidCredentialOrGuestUserMLButton() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.withLoginMLButtonClick();
	}
	

//	Map layer screen should open with Traffic, Community, Safety, 
//	Swachh Bharat, Polluting Activity and UNICEF School Closure
//	with count (if toggle button is on), tap to customize the 
//	category of alerts, Visual Traffic and , Map type (2D,3D). and 
//	POC MapmyIndia Street Map and Hybrid Satellite Map
	
	@Test(priority = 3)
	public void isMLFunctionalityWorking() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.isMLWorking(0);
	}
	
	
//	Elements of Map Layers such as,Traffic (6),
//	Community (11), Safety (12), Swachh Bharat (3), 
//	Polluting Activity (4) and UNICEF School Closure (1), 
//	Tap to customize the category of alerts, Visual Traffic, 
//	My Saves, Map Type including 2D and 3D should be visible 
//	and POC MapmyIndia Street Map and Hybrid Satellite Map - NA
	@Test(priority = 4)
	public void isMLFunctionalityWorkingWL() {
		ml = new TC__020_MapLayerFeature(driver);
		
		ml.isMLWorking(1);
		
	}
	
	@Test(priority = 5)
	public void isMLFunctionalityWorkingIOTWL() {
		ml = new TC__020_MapLayerFeature(driver);
		
		ml.isMLWorking(2);
		
	}
	
	//My saves button should not be highlighted on map layer 
	@Test(priority = 6) 
	public void mySavesWOLMapLayer() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mySavesMLWOL();
	}
	
	
	//Verify that Open app without any login credentials.
	//My Gadgets button should not be visible on map layer. 
	@Test(priority = 7) 
	public void myGadgets() {
	ml = new TC__020_MapLayerFeature(driver);
	ml.myGadgetMLWOL();
	}
	
	
	
	//User should get the by default Mapmyindia Map 
	//Verify that user Open app without any login credentials.
	@Test(priority = 8)
	public void defualtMapWOL() throws InterruptedException {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapLayerDefaultMap();
	}
	
	
	
	//Verify that user Tap on Map layer options(MapMyIndia map/Hybride Satellite Map)
    //The view of the Map will changes to satellite Map and vice versa.
	@Test(priority = 9)
	public void mlSatelliteMapWOL() throws InterruptedException {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapLayerSatelliteMap();
	}
	
	
	//map layer close button should be clickable
	@Test(priority = 10)
	public void mlCloseButton() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapLayerCloseButtonClick();
	}
	
	
	//Verfiy that user is able to click on traffic events
	//Traffic events should be clickable and open new sub category events
	@Test(priority = 11) 
	public void trafficEvent() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapLayerTrafficEventClickable();
	}
	
	
	//Verfiy that user is able to tap on toggle to On and Off traffic events
	//Sub Category of Taffic events toggle should be clickable
	@Test(priority = 12) 
	public void trafficEventSwitch() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.trafficSubCatToggleClick();
	}
	
	//Verify that user is able to tap on toggle to OFF the traffic events
	//Every sub category of traffic events toggle should be off
	@Test(priority = 13)
	public void trafficSwitchOff() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.trafficEvrySubCatToggleOff();
	}
	
	//Verify that user is able to tap on back button
	//Back button functionality should work
	@Test(priority = 14)
	public void trafficBackBtn() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.backButton();
	}
	
	//Verfiy that user is able to click on safety events
	//Safety events should be clickable and open new sub category events
	@Test(priority = 15)
	public void safetyEvntSwitch() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.safetyEvnt();
	}
	
	
	
	//Verfiy that user is able to tap on toggle to On and Off safety event
	//Safety events toggle should be clickable and toggle On and Off all the sub category
	@Test(priority = 16) 
	public void saftyTggleEachEvnt() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.safetyTggleAllEvntSwitch();
	}
	
	
	//Verify that user is able to tap on toggle to OFF of any safety events
	//Every sub category of Safety events toggle should be off
	@Test(priority = 17)
	public void saftyEvntSubCatClick() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.saftyEvntClickAnySubCat();
	}
	
	
	//Verify that user is able to tap on back button
	//Back button functionality should work
	@Test(priority = 18)
	public void saftyEvntBackBtn() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.saftyEvntBackBtn();
	}
	
	
	//Verfiy that user is able to click on community events
	//Community events should be clickable and open new sub category events
	@Test(priority = 19)
	public void communityEvnt() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.communityEvntToggle();
	}
	
	//Verfiy that user is able to tap on toggle to On and Off community event
	//Community events toggle should be clickable and toggle On and Off all the sub category
	@Test(priority = 20)
	public void communityEvntTggleSwitch() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.communityEvntToggleOnnAndOff();
	}
	
	//TC - 21
	//Verify that user is able to tap on toggle to OFF of any community events
	//Every sub category of Community events toggle should be off
	@Test(priority = 21)
	public void communityEvntSubCatSwitch() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.communityEvntSubCatToggleOff();
	}
 	
	
	
	
	//Verify that user is able to tap on back button
	//Back button functionality should work
	@Test(priority = 22)
	public void communityEvntBackBtn() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.communityEvntBackBtn();
	}
	
	//Verify that user is able to tap on toggle ON
	//Toggle On functionality should work
	@Test(priority = 23)
	public void toggleOn() throws InterruptedException {
		ml = new TC__020_MapLayerFeature(driver);
		ml.threeDViewsEnableAndDisabled();	
	}

	//Verify that user is able to tap on toggle Off
	//Toggle Off functionality should work
	@Test(priority = 24)
	public void toggleOnOff() throws InterruptedException {
		ml = new  TC__020_MapLayerFeature(driver);
		ml.visualTrafficEnableAndDisabled();
	}
	
	//Verify that user is able to tap on "i" button beside My map
	//Help/ Information Icon (i) should be clickable for information about My map
	@Test(priority = 25)
	public void myMapInfo() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapInfoAndVerfication();
	}
	
	
	
	
	//Verify that user is able to tap on "i" button beside Layers
	//Help/ Information Icon (i) should be clickable for information about Layers
	@Test(priority = 26)
	public void myLayerInfo() {
		ml = new TC__020_MapLayerFeature(driver);
		ml.mapLayerIndoAndVerification();
	}
	
	
	
	
	//Verify that user is able to tap on 3D
	//3D view should show on the map
	@Test(priority = 27)
	public void threeDToggleOnAndOff() throws InterruptedException {
		ml = new TC__020_MapLayerFeature(driver);
		ml.threeDViewsEnableAndDisabled();	
	}

}
