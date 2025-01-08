package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__004_SkipLoginFeature;
import com.mappls.map.utils.DriverManager;

public class TC__004_SkipLogin extends DriverManager {
//55-95
	private TC__004_SkipLoginFeature slf;

//	Check if Guest User can add contact via My World View
	@Test(priority = 1)
	public void SkipLoginAtContactMyWorldView() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.guestContactWorldViewSkip();
	}

//	Check if Guest User can like via My World View
	@Test(priority = 2)
	public void SkipLoginLikeMyWorldView() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.guestLikeWorldViewSkip();
	}

//	Check if Guest User can flag via My World View
	@Test(priority = 3)
	public void SkipLoginFlagMyWorldView() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.guestFlagWorldViewSkip();
	}

//	Check My Saves
	@Test(priority = 4)
	public void SkipLoginMySaves() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.mySavesSkip();
	}

//	Check My Gadgets
	@Test(priority = 5)
	public void SkipLoginMyGadgets() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.myGadgetsSkip();
	}

//	Check Share My Location
	@Test(priority = 6)
	public void SkipLoginMyLocation() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.shareMyLocationSkip();
	}

//	Check Get Mappls pin
	@Test(priority = 7)
	public void SkipLoginGetMApplsPin() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.getMapplsPinSkip();
	}

//	Check Add a Place
	@Test(priority = 8)
	public void SkipLoginAddAPlace() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.addAPlaceSkip();
	}

//	Check Set Home on quick access menu
	@Test(priority = 9)
	public void SkipLoginSetHomeQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.setHomeQuickAccessMenuSkip();
	}

//	Check Set Work on quick access menu
	@Test(priority = 10)
	public void SkipLoginSetWorkQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.setWorkQuickAccessMenuSkip();
	}

//	Check report an issue on quick access menu
	@Test(priority = 11)
	public void SkipLoginReportanIssueQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.reportIssueAccessMenuSkip();
	}

//	Check Share My Location on quick access menu
	@Test(priority = 12)
	public void SkipLoginShareMyLocQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.shareMyLocationQuickAccessMenuSkip();
	}

//	Check Get Mappls Pin on quick access menu
	@Test(priority = 13)
	public void SkipLoginGetMapplsPinQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.getMapplsPinQuickAccessMenuSkip();
	}

//	Check Like via Review By users
	@Test(priority = 14)
	public void SkipLoginLikeViaReview() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.likeReviewByUserSkip();
	}

//	Check Flag via Review By User
	@Test(priority = 15)
	public void SkipLoginFlagViaReview() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.flagReviewByUserSkip();
	}

//	Check Add Review on place detail page 70
	@Test(priority = 16)
	public void SkipLoginAddReviewPlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.addReviewOnPlaceDetailPageSkip();
	}

//	Check reporting through Point on Map
	@Test(priority = 17)
	public void SkipLoginReportPointOnMap() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.addReportPointOnMapSkip();
	}

//	Check Save on Place Detail screen
	@Test(priority = 18)
	public void SkipLoginSavePlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.savePlaceDetailPageSkip();
	}

//	Check Report on Place Detail screen
	@Test(priority = 19)
	public void SkipLoginReportPlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.reportPlaceDetailPageSkip();
	}

//	Check Review on place detail page
	@Test(priority = 20)
	public void SkipLoginReviewPlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.reviewPlaceDetailPageSkip();
	}

//	Check Suggest an edit on Place Detail screen
	@Test(priority = 21)
	public void SkipLoginSuggestAnEditPlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.suggestAnEditPlaceDetailPageSkip();
	}

//	Check Like on Issues Reported Here 76
	@Test(priority = 22)
	public void SkipLoginLikeIssuesReportedHere() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.likeOnIssuesPlaceDetailPageSkip();
	}

//	Check Flag on Issues Reported Here 77
	@Test(priority = 23)
	public void SkipLoginFlagIssuesReportedHere() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.flagOnIssuesPlaceDetailPageSkip();
	}

//	Check Add an Image on place detail screen
	@Test(priority = 24)
	public void SkipLoginAddImagePlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.addAnImagePlaceDetailPageSkip();
	}

//	Check Set as Home on place detail screen
	@Test(priority = 25)
	public void SkipLoginSetAsHomePlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.setAsHomePlaceDetailPageSkip();
	}

//	Check Set as Work on place detail screen
	@Test(priority = 26)
	public void SkipLoginSetAsWorkPlaceDetailPage() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.setAsWorkPlaceDetailPageSkip();
	}

//	Check Add a missing place via Nearby Categories
	@Test(priority = 27)
	public void SkipLoginAddMisingPlaceViaNearbyCategories() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.addMissingPlaceViaNearbyCategoriesSkip();
	}

//	Check Save route on navigation screen
	@Test(priority = 28)
	public void SkipLoginSaveRouteNavigation() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.saveRouteOnNavigationScreenSkip();
	}

//	Check Add a missing place by searching
	@Test(priority = 29)
	public void SkipLoginAddMisingPlaceViaSearch() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.addMissingPlaceBySearchSkip();
	}

//	Check Add a missing place via Nearby category
	@Test(priority = 30)
	public void SkipLogin() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);

		slf.addMissingPlaceViaNearbyCategoriesSkip();
	
	}
//	Check Save via Point on map
	//////85
	@Test(priority = 31)
	public void SkipLoginSaveViaPointOnMap() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.saveViaPointOnMap();
	}

//	Check Set as Home/Work via Point on map
	@Test(priority = 32)
	public void SkipLoginSetAsWorkViaPointOnMap() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.workViaPointOnMap();
	}
//
////	check share your Current Location via current location
//	@Test(priority = 33)
//	public void SkipLoginShareCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.shareCurrentLocationViaCurrentLocation();
//	}
//
////	Check Set as home via current location
//	@Test(priority = 34)
//	public void SkipLoginSetAsHomeViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.setAsHomeViaCurrentLocation();
//	}
//
////	Check Set as work via current location
//	@Test(priority = 35)
//	public void SkipLoginSetAsWorkViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.setAsWorkViaCurrentLocation();
//	}
//
////	Check Report issue here via current location
//	@Test(priority = 36)
//	public void SkipLoginReportViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.reportIssueHereViaCurrentLocation();
//	}
//
////	Check Share live location via current loaction
//	@Test(priority = 37)
//	public void SkipLoginShareLiveLocationViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.shareLiveLocationViaCurrentLocation();
//	}
//
////	Check Add a place via current location
//	@Test(priority = 38)
//	public void SkipLoginAddAPlaceViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.addPlaceViaCurrentLocation();
//	}
//
////	Check add a missing place of nearby parking via current location
//	@Test(priority = 39)
//	public void SkipLoginAddMissingPlaceViaCurrentLocation() throws IOException, InterruptedException {
//		slf = new TC__004_SkipLoginFeature(driver);
//		slf.addMissingPlaceViaCurrentLocation();
//	}

//	Check home via search
	@Test(priority = 40)
	public void SkipLoginHomeSearch() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.homeViaSearchSkip();
	}

//	Check Work via search
	@Test(priority = 41)
	public void SkipLoginWorkSearch() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.workViaSearchSkip();
	}

	@Test(priority = 42)
	public void SkipLoginFixMapQuickAccessMenu() throws IOException, InterruptedException {
		slf = new TC__004_SkipLoginFeature(driver);
		slf.fixMapQuickAccessMenuSkip();
	}
}
