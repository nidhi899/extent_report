package tests;

import org.testng.annotations.Test;

import com.mappls.map.features.BaseFeatures;
import com.mappls.map.features.TC__001_RegistrationFeature;
import com.mappls.map.features.TC__002_LoginFeature;
import com.mappls.map.features.TC__023WhatAndWhereFeature;
import com.mappls.map.utils.Actions;
import com.mappls.map.utils.DriverManager;

//import map.mappls.map.features.NearByFeatures;

public class TC__023_WhatAndWhere extends DriverManager {
//540-554
	
	TC__001_RegistrationFeature   newUser;
	Actions ac;
	TC__002_LoginFeature lf;
	BaseFeatures bpf;
	TC__023WhatAndWhereFeature wwf;
	
	
	
	
//	Check UI for What and where	
//	Verify the UI is proper in Search	
//	UI of the Search should be properly visible in the search bar and the functions should work properly
	@Test(priority = 1) 
	public void wwUI() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.newarByUI();
		
	}
	
//	Check for  the what and where icon option on search bar	
//	Verify that user is able to see what and where icon 	
//	The What and where button should be clickable and after clicking search near page should open
	@Test(priority = 2)
	public void isUserAbleToClickNearByIcon() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isNearByIconClickable();
	}
	
//	Check for  the what and where icon option on search bar	
//	Verify that the what and where button is clickable	
//	The What and where button should be clickable and after clicking search near page should open
	@Test(priority = 3)
	public void isUserAbleToClickWhatAndWhere() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isNearByIconClickable();
	}
	
//	Check The Search Near Page 	
//	Verify the Search Near page written in bold ,with the current location below it ,back button and Pencil icon. 	
//	The user should be able to click on the back button, which should take them to the home page.
	@Test(priority = 4)
	public void searchNearPageUIFunctionalityVerification() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isNearBySearchUIWorking();
	}
	
	
//	Check the pencil icon on Search Near Page.	
//	Verify the pencil icon is clickable 	
//	"User should able to click on the pencil icon to edit.
//	After clicking on pencil icon there should be option for current location and choose on map.
//	Both the button should be clickable and user should be able the change the location on Search near page."
	@Test(priority = 5)
	public void isNearBySearchPencilEditable() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isPencilIconClickable();
	}
	
	
//	Check the "Search what are you in mood for?" option
//	Verify that Search what are you in food for is clickable.	
//	User should be able to search any nearby place and  result should appear according to the location set in search Near.
	@Test(priority = 6)
	public void isSearchWhatMoodClickable() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isWhtAreYouMoodClickable();
	}
	
	
//	Check for the below list available 	
//	Verify the all the available list is clickable 	
//	User should be able to see all the list below and After clicking on any one of them it should display the result
	
	// list is clickable verify to clicking on any one of them
	@Test(priority = 7) 
	public void isUserAbleToClickBelowList() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.isSuggstAddrssClickable();
	}
	
	
	
//	Check for the icon showing on Home screen	
//	Verify Icon for Searched list.	
//	If User click on any of the provided list of Nearby categories,like nearby coffee then all the available coffee shop should display on map with their icon.
//	@Test(priority = 8) na
//	public void eight() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		wwf.isNearByIconClickable();
//	}
	
	
	
//	Check for Current location /place marker while searching NearBy or any place	
//	Current location Pointer when searching NearBy Places	
//	When Searching for NearBy Places, Current location or place marker pointer should also display on the map
//	@Test(priority = 9) na
//	public void nine() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		wwf.isNearByIconClickable();
//	}
	
	
//	Check the place detail page For What and where place.	
//	Verify the Place Detail page of what and where is working properly	
//	After selecting any of the result for nearby category,User should be able to see the place detail page of  that category
	
	//Verify the place detail page with any unique identity like name 
	@Test(priority = 8) 
	public void isUserAbleToSeePlaceDetailPage() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.placeDetailPage();
	}
	
	
//	Check for the Location and distance 	
//	Verify the Result is showing according to the Location	
//	If the Location is set to Current ,the Result should appear nearby that and if the location is set to some another place ,result should display of that area 
//	@Test(priority = 11) na
//	public void eleven() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//	}
	
	
	
//	Check for the EV Charging filter from below Nearby List	
//	Verify the filter button on the right corner of EV charging Near page 	
//	"User should be able to click on the filter button.
//	Every filter from each category should be clickable and result should display on the Home page.
//	There should be RESET button on the Top right corner and it should work properly.
//	After choosing the desired Filter user should get the Apply Button on below which should be clickable."
	
	//select any one filter then apply after that reset the filter. 
	//verify the changes on applying the filter and reset. 
	@Test(priority = 9)
	public void isEVChargingFunctioningProperly() {
		wwf = new TC__023WhatAndWhereFeature(driver);
//		wwf.evCharging();
		wwf.applyAnyOneFilterAndReset();
	}
	
//	Check for the RESET button	
//	Verify the RESET button funtioning properly.	
//	After selecting the different filters if  user wants to reset it or remove all the filter they have chosen ,then after tapping on the RESET button all the filter should get removed.
//	@Test(priority = 10) na
//	public void thirteen() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		
//	}
	
	
//	Check for the Apply button	
//	Verify the Apply button working properly.	
//	After selecting the desired filter User should be able to tap on Apply button and result should reflect on the home page of Map.
	
	// Apply any one filter and verify the changs in the sheet. ( Map view is not possible)
	@Test(priority = 10)
	public void isApplyButtonWorking() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.applyAnyOneFilter();
	}
	
	
	
//	Check for the Search this area option	
//	Verify the Search this area option activates.	
//	"After clicking on any of the suggested category, User should get the search this area option on home page, after panning the map where categories results are displaying .
//	After tapping on Search this area button ,result should display of that particular area"
//	@Test(priority = 15) na
//	public void fifteen() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		wwf.isNearByIconClickable();
//	}
	
	
	//new test case
	//Verify that the back button on the "Point on Map" page navigates correctly after using the Nearby icon, Edit icon, and Choose on Map option.
	@Test(priority = 11)
	public void isChoosMapPOMBackBtnWorking() {
		wwf = new TC__023WhatAndWhereFeature(driver);
		wwf.chooseMapBackFunctionality();
	}
	
	//When the user selects a filter, clicks the apply button, and then reopens the filter menu, the previously selected filter should remain selected.
	@Test(priority = 12) 
	public void verifyEvFilterApplyBtnWorking() {
		wwf =  new  TC__023WhatAndWhereFeature(driver);
		wwf.evChargingApplyBtn();
	}
	
	
	//Verify that when the apply button is clicked without selecting any filter in the EV-Charging section, the result count remains unchanged.
	@Test(priority = 13) 
	public void verifyEvFilterApdplyBtnWorking() {
		wwf =  new  TC__023WhatAndWhereFeature(driver);
		wwf.applyBtnWihOutFilter();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	====================================
//	@Test(priority = 1)
//	public void nearByTestByClickGivenCategory() throws InterruptedException {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		ac = new Actions();
//		wwf.getNearBySearch();
//		ac.swipeUp();
//		wwf.verifyNearBy();
//	}
//
//
//
//	@Test(priority = 2)
//	public void nearByTestByEnteredCategory() {
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		wwf.searchNearbyByEnteredPlace();
//	}
//
//	//	@Test(priority = 3)
//	public void testNearByTestByEditClick() {
//		
//		wwf = new TC__023WhatAndWhereFeature(driver);
//		
////		paf.mapplsPermissions();
//		//		np.searchNearbyByEditPlc();
//	}
	
	
	
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	

