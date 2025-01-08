package tests;

import org.testng.annotations.Test;
import com.mappls.map.features.TC__008_MySavesFeature;
import com.mappls.map.features.TC__010_AddPlacesFeature;
import com.mappls.map.utils.DriverManager;
import com.mappls.map.utils.RetryAnalyzer;

public class TC__008_MySaves  extends DriverManager {

	private TC__008_MySavesFeature mp;
	

	
//==============================================================================nov==================================================================
//===================================================================================================================================================
	
//	Verify that UI is proper in My Saves
//	UI for all screen should be properly visible and function should work properly
	@Test(priority = 1) 
	public void msUIVerification() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesWithOutLogin();
	}
	
	
//	Verify that My Saves is clickable (without login)	
//	"User is asked to Login to access this functionality. with cancel and login buttons available.
//	1. On clicking Cancel it should takes back to previous page.
//	2. On clicking Login, should take to the welcome page for login"
	@Test(priority = 2) 
	public void isMySavesClickable() {
		mp = new TC__008_MySavesFeature(driver);
		mp.loginAndCancel();
	}
	
	
	
	
//	Verify that the user is able to open My Saves (If User is Logged-in)	
//	"1.My Saves should be clickable and open new page with 
//	 -Heading(My Saves), back button, + icon
//	 -Home, Work, Contributions, Favourites, My Routes, Point On Map.(with icons)
//	 -CREATE LIST (on top-right corner)
//	 -Custom List (If available) with public & private options"
	@Test(priority = 3) 
	public void isUserAbleClickMySaveWL() {
		mp = new TC__008_MySavesFeature(driver);
		mp.msUIVerificationWL();
	}
	
	
//	Verify the existing data in my saves	
//	Old data should be displayed. For eg. Home, Work, Favourites, 
//	Contributions, Routes & Custom List
	@Test(priority = 4) 
	public void isExistingDataVisible() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySvesList();
	}
	
//	Verify saving a place to a list from its place details	
//	Place should get saved in the list
	@Test(priority = 5)  
	public void isPlaceSavedFromPlaceDetail() {
		mp = new TC__008_MySavesFeature(driver);
		mp.placeDetailSaveAddressWL();
	}
	
	
//	Verify that the user is able to Add Home via current location(If address is not set)	
//	"1. Set Home Text should be available below the Home in blue color
//	2. Home should be clickable and open Search page
//	3. Current location should be available and clickable on search page 
//	4. Place Name should change instead of Set Home Text
//	5. iToast message should be displayed (Home/work address saved successfully)"
	@Test(priority = 6) 
	public void isUserAbleToAddHomeViaCrrntLocation() {
		mp = new TC__008_MySavesFeature(driver);
		mp.currentLocation(0);
	}
	
//	Verify that the user is able to Add Home via choose on map(If address is not set)	
//	"1.Set Home Text should be available below the Home in blue color
//	2.Home should be clickable and open Search page
//	3.Choose on map should be available and clickable on search page 
//	4.Place Name should change instead of Set Home Text
//	5.Toast message should be displayed (Home/work address saved successfully)"
	@Test(priority = 7) 
	public void isUserAbleToAddHomeViaChooseMap() {
		mp = new TC__008_MySavesFeature(driver);
		mp.chooseOnMap(0);

	}
	
	
//	Verify that the user is able to Add Home via search any place(If address is not set)	
//	"1.Set Address Text should be available below the Home in blue color
//	2.Home should be clickable and open Search page
//	3.Search bar should be available and clickable on search page 
//	4.List of places should become
//	5.Place Name should change instead of Set Address Text
//	6.Toast message should be displayed (Home/work address saved successfully)"
	@Test(priority = 8) 
	public void isUserAbleToAddHomeViaSearch() {
		mp = new TC__008_MySavesFeature(driver);
		mp.setAddrsViaSearch(0);
	}
	
	
//	Verify the user is able to edit Home	
//	"1.Place Name should change instead of previous Address Text
//	2. Overflow button on Right with Edit & Delete and Cancel
	@Test(priority = 9) 
	public void isUserAbleToEditHome() {
		mp = new TC__008_MySavesFeature(driver);
		mp.homeAddrssEdit();
	}
	
	
	
//	Verify the user is able to delete Home	
//	"1.Delete pop-up message should come with cancel and delete button
//	2.Set Address should come instead of place name Text in blue color
//	3.iToast message should come - ""Deleted"""
	@Test(priority = 10) 
	public void isUserAbleToDeleteHome() {
		mp = new TC__008_MySavesFeature(driver);
		mp.homeDlt();
	}
	
	
//	Verify the user is able to set Work	
//	"1.Set Address Text should be available below the Work in blue color
//	2.Home should be clickable and open Search page
//	3.Current location should be available and clickable on search page 
//	4.Place Name should change instead of Set Address Text
//	5.Toast message should be displayed (Home/work address saved successfully)"
	@Test(priority = 11) 
	public void isUserAbleToAddWork() {
		mp = new TC__008_MySavesFeature(driver);
		mp.isUserAddWork();
//		mp.chooseOnMap(1);
	}
	
	
//	Verify that the user is able to Add Home via choose on map(If address is not set)	
//	"1.Set Address Text should be available below the Work in blue color
//	2.Work should be clickable and open Search page
//	3.Choose on map should be available and clickable on search page 
//	4.Place Name should change instead of Set Address Tex
//	5.Toast message should be displayed (Home/work address saved successfully)"
	@Test(priority = 12) 
	public void isUserAbleToAddWorkViaChooseMap() {
		mp = new TC__008_MySavesFeature(driver);
		mp.chooseOnMap(1);
	}

	
//	Verify that the user is able to Add work via search any place(If address is not set)	
//	"1.Set Address Text should be available below the Work in blue color
//	2.Work should be clickable and open Search page
//	3.Search bar should be available and clickable on search page 
//	4.List of places should become
//	5.Place Name should change instead of Set Address Tex
//	6.Toast message should be displayed (work address saved successfully)"
	@Test(priority = 13) 
	public void isUserAbleToAddWorkViaSearch() {
		mp = new TC__008_MySavesFeature(driver);
		mp.setAddrsViaSearch(1);
	}
	
//	Verify the user is able to edit Work	"
//	1.Place Name should change instead of previous Address Text
//	2. Overflow button on Right with Edit & Delete option
//	3.On clicking Work, Place Detail Page should be open"
	@Test(priority = 14) 
	public void isUserAbleToEditWork() {
		mp = new TC__008_MySavesFeature(driver);
		mp.workAddrssEdit();
	}
	
	
//	Verify direction page should open after clicking on Home/Work	
//	If user has saved any place as Home or Work after a click they should be directed to the Direction page.
	@Test(priority = 15)  
	public void isDirectionPageOpenAfterClickedHomeOrWork() {
		mp = new TC__008_MySavesFeature(driver);
		mp.isDirectionPageRedirectedViaHomeOrWork(1);
	}
	
	
//	Verify the user is able to delete Work	
//	"1.Delete pop-up message should come with cancel and delete button
//	2.Set Address should come instead of place name Text in blue color
//	3.iToast message should come - ""Deleted"""
	@Test(priority = 16) 
	public void isUserAbleToDeleteWork() {
		mp = new TC__008_MySavesFeature(driver);
		mp.workDlt();
	}
	
	
//	Verify saving a place to favourites from its place details	
//	Selected place should get saved in favourites
	@Test(priority = 17) //done - discuss
	public void isFavSavedFromItsPlaceDetails() {
		mp = new TC__008_MySavesFeature(driver);
		mp.isFavSavedFrmPlcDetailPge();
	}
	
//	Verify deleting a place from favourites list	
//	"1.Selected location gets deleted with pop up message from the Favourites list & Count Updated
//	2.iToast message shown""Deleted Successfully"""
	@Test(priority = 18) 
	public void isFavListDltable() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesFavCount();
	}
	
//	Verify saving a route from navigation screen	
//	Route should get saved in the Routes list
//	@Test(priority = 19) // unable to handle start navigation window
	public void isRouteSavedFromNavigation() {
		mp = new TC__008_MySavesFeature(driver);
		mp.isRoutAdded();
	}
	//-----------------------------------------------
	
	
//	Verify deleting a route from the routes list	
//	1.Place Deleted with iToast message"Route Deleted Successfully"
	@Test(priority = 20) 
	public void isRoutesDltable() {
		mp = new TC__008_MySavesFeature(driver);
//		mp.mySavesRoutesCount();
		mp.isRoutDltAble();
	}
	
	
//	Verify editing a route from the routes list	
//	User should be able to edit the name of Route with toast message "Edited Successfully".
	@Test(priority = 21)
	public void isRouteEditAble() {
		mp = new TC__008_MySavesFeature(driver);
		mp.routeEditable();
	}
	
//	Verify newly added place in the list
//	New added place should get updated in the contributions list
	@Test(priority = 22) 
	public void isNewlyAddedPlcPresentInContributionList() {
		TC__010_AddPlacesFeature ap = new TC__010_AddPlacesFeature(driver);
		ap.contriCountByAddingPlc();
			
	}
	
	
//	Verify map issues in the list	
//	"1.""Place Count"" should be Appear
//	2. On Clicking : Contribution List opens(Map Issues, Added place, edited place)"
	@Test(priority = 23, retryAnalyzer = RetryAnalyzer.class) //done
	public void isPlaceCount() {
		mp = new TC__008_MySavesFeature(driver);
		mp.insideContributionList();
	}
	
//	Verify adding a new point on map and save	
//	"1. Open List
//	2. Name with Latlong and overflow button"
	@Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)   
	public void isUserAbleToAddPointMap() {
		mp = new TC__008_MySavesFeature(driver);
		mp.pointOnMapSaveAndShare();
	}
	
//	Verify deleting a point on map from the list	
//	1.Pop-up message should be appear with "Deleted Successfully"
	@Test(priority = 25) 
	public void isUserAbleToDltPointMapFrmList() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesPointMapCount();
	}
	
//	Verify creating a new list with privacy as public	
//	List should get created and the list should be visible to all the followers/users
	@Test(priority = 26)  
	public void isUserAbleToCreateNewListWPublic() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesCreateListPublically();
		
	}
	
	
//	Verify creating a new list with privacy as private	
//	List should get created and the list should not be visible to any followers/users
	@Test(priority = 27) 
	public void isUserAbleToCreateNewListWPrivate() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesCreateListPrivatly();
	}
	
	
	
//	Verify editing a list name	
//	"1.Update List Page Opens 
//	2.enables user to edit the list name"
	@Test(priority = 28)  //done
	public void isListEditable() {
		mp = new TC__008_MySavesFeature(driver);
		mp.mySavesCreateListPubliclyEdit();
		
	}
	
	
	
//	Verify deleting a list name	
//	1.Delete Created List with iToaast message"Deleted Successfully"
	@Test(priority = 29) 
	public void isListDltable() {
		mp = new TC__008_MySavesFeature(driver);
//		mp.mySavesCreateListPrivatlyEdit();
		mp.delteList();
		
	}

}






























//@Test(priority = 2)
//public void setHomeWLEditDltSet() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.homeWithLogin();
//}
//
//
//@Test(priority = 3)
//public void setWorkWLEditDltSet() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.workWithLogin();
//}
//
//@Test(priority = 4)
//public void contributionCount() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesContrbution();
//}
//
//
//@Test(priority = 5) //done
//public void addNewContribution() {
//	mp = new TC__008_MySavesFeature(driver);
////	mp.mySavesAddNewContribution();
//}
//
//@Test(priority = 6)
//public void favouriteCountDlte() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesFavCount();
//}
//
//@Test(priority = 7) //6.1
//public void addFavouriteCount() {
//	mp = new TC__008_MySavesFeature(driver);
////	mp.mySavesAddNewFavCount();
//}
//
//@Test(priority = 8)
//public void routesCount() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesRoutesCount();
//}
//
//@Test(priority = 9)
//public void pointOnMapDelete() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesPointMapCount();
//}
//
//
////@Test(priority = 10)
//public void pointOnMapShare() {
//	mp = new TC__008_MySavesFeature(driver);
////	mp.poinOnMapCopLink();
//}
//
//@Test(priority = 11)
//public void pointOnMapAddNew() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.pointOnMapSaveAndShare();
//}
//
//
//@Test(priority = 12)
//public void createListPublicly() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesCreateListPublically(); 
//}
//
//
//@Test(priority = 13) //error 
//public void createListPrivatly() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesCreateListPrivatly();
//}
//
////add new test cases ----
//
////User is asked to Login to access this functionality. with cancel and login buttons available.
////1. On clicking Cancel it should takes back to previous page.
////2. On clicking Login, should take to the welcome page for login
//@Test(priority = 14)
//public void mySavesClickableWOLAndCancel() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.cancelLogin();
//}
//
//
//@Test(priority = 15) 
//public void mySavesClickableWOLAndLogin() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.goWithLogin();
//}
//
//
//
////Old data should be displayed. 
////For eg. Home, Work, Favourites, Contributions, Routes & Custom List
////@Test(priority = 16)
////public void mySavehsListsVisible() {
////	mp = new TC__008_MySavesFeature(driver);
////	mp.mySvesList();
////}
////
//
//
////Check Set Home option via current location
//@Test(priority = 17)
//public void homeAddrssCrrntLoction() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.currentLocation(0);
//}
//
////Check Set Work option via current location
//@Test(priority = 18)
//public void workAddrssCrrntLoction() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.currentLocation(1);
//}
//
//
////Check Set Home option via choose on map
//@Test(priority = 19)
//public void homeAddrssChooseMap() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.chooseOnMap(0);
//}
//
////Check Set Work option via choose on map
//@Test(priority = 20)
//public void workAddrssChooseMap() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.chooseOnMap(1);
//}
//
////Check for New List Edit option
//@Test(priority = 21)
//public void privateListEditAndDlte() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesCreateListPrivatlyEdit();
//}
//
////Check for New List Edit option
//@Test(priority = 22)
//public void publicListEditAndDlte() {
//	mp = new TC__008_MySavesFeature(driver);
//	mp.mySavesCreateListPubliclyEdit();
//}
