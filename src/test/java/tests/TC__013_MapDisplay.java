package tests;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__013_MapDisplayFeature;
import com.mappls.map.features.TC__014_HomeScreenFeature;
import com.mappls.map.features.TC__020_MapLayerFeature;
import com.mappls.map.utils.DriverManager;

public class TC__013_MapDisplay extends DriverManager{
//278-300
	
	TC__013_MapDisplayFeature mf;
	TC__014_HomeScreenFeature hsf;
	TC__020_MapLayerFeature mlf;
	
	
	  
//	Verify the UI is proper in Map Display	
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1)
	public void mapDisplayUI() {
		hsf = new TC__014_HomeScreenFeature(driver);
		hsf.uiVerification();
		
	}
	
	
//	2 MapmyIndia logo in bottom left of the Home screen	
//	Mappls logo should get display at the bottom left on the Home screen
	@Test(priority = 2) 
	public void isMapplsLogoVisible() {
		mf = new TC__013_MapDisplayFeature(driver);
		mf.mpplsLogogImg();
	}
	
	
//	3 Zoom in/out using swapping	
//	Swapping in should zoom in the map and Swapping out should zoom out the map
//	@Test(priority = 3) na
	public void zoomINAndOUT() {
		mf = new TC__013_MapDisplayFeature(driver);
//		mf.zoomIn();
	}
	
//	4 Double tap on the map should zoom in the map and Tap with two fingers should zoom out the map
//	@Test(priority = 4) NA
	public void isDblTapWorkingOnMap() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Map tiles and Labels in the app	5
//	Map tiles should get load within 2 seconds when starting the app
//	@Test(priority = 5) NA
	public void mapTiles() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
//	Change Map Layer from MapmyIndia Map to Hybrid Satellite Map	
//	Map layer should get change from MapmyIndia Map to Hybrid Satellite Map on the map
	@Test(priority = 3)
	public void hybridSatellite() throws InterruptedException {
		mlf = new TC__020_MapLayerFeature(driver);
		mlf.satelliteMap();
		
	}
	
	
//	Change Map Layer from Hybrid Satellite Map to MapmyIndia Map	
//	Map layer should get change from Hybrid Satellite Map to MapmyIndia Map on the map
//	@Test(priority = 7) na
	public void hybridMapToMapMyIndia() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Turn on/off Traffic layer on the map	
//	Traffic layer should get display on the map within 5 secs when it is open and vice versa.
//	@Test(priority = 8) na
	public void turnOnOff() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	My Save button should present on My layer	
//	My Save option with toggle should present on Map layer and list should be displyed on map
	@Test(priority = 4)
	public void isMySaveBtnPresent() {
		mf = new TC__013_MapDisplayFeature(driver);
		mf.isMySavesBtnPresent();
	}
	
	
	
//	Turn on/off Nearby Reports on the map	
//	Nearby Reports should get display on the map when it is open and vice versa.
//	@Test(priority = 10) na
	public void turnOnOffREport() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Verify the i button on My saves	
//	My saves legends should get display
//	@Test(priority = 11) not found
	public void verifyIButton() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Change the current location pointer to any other direction then click on Map comPass	
//	Direction of Map pointer should get shift to North
//	@Test(priority = 12) na
	public void currentLOcationPointer() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
//	Single tap on current location	
//	Current location marker should change to Follow me marker
//	@Test(priority = 13) na
	public void singleTapCrrntLocation() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
//	Again tap on current location	
//	Pedestrian Mode should get start
//	@Test(priority = 14) na
	public void againTapCurrentLocation() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Again tap on current location	
//	Map display should get Zoom out to 16 level
//	@Test(priority = 15) na
	public void againTapCrrntLocationMapDisplay() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Swap the map to different location	
//	Map pan should get start
//	@Test(priority = 16) na
	public void swapMap() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Mappls the map from current location and then close the app.	
//	When opening the app again, Map should be load on the location where it is closed
//	@Test(priority = 17) na
	public void closeMap() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Activate Follow me button and then close the app	
//	When opening the app again, Map should be load on Current location
//	@Test(priority = 18) na
	public void activateFollow() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
	
//	POI names on the map	
//	POI names should be display on the map properly
//	@Test(priority = 19) na
	public void poiNameOnMap() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
	
//	Category names and icons on the map	
//	Category names and icons should be display on the map properly
//	@Test(priority = 20) na
	public void catNameIcon() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Building numbers on the map	
//	Building numbers should be display on the map properly
//	@Test(priority = 21) na
	public void buildingNumber() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
//	Direction option on the home screen	
//	Direction page should get open with starting point as current location, Home and Work options and search history(if any).
	@Test(priority = 5)
	public void homeScreen() {
		mf = new TC__013_MapDisplayFeature(driver);
		mf.homeScreenDirection();
	}
	
	
//	Direction option on the home screen when current location is off	
//	Direction page should get open with empty starting point and a notification to turn on the location permission, Home and Work options and search history(if any).
//	@Test(priority = 23) NA
	public void crrntLocationOff() {
		mf = new TC__013_MapDisplayFeature(driver);
	}
	
	
	
}
