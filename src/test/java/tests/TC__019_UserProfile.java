package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mappls.map.features.TC__019_UserProfileFeature;
import com.mappls.map.utils.DriverManager;

public class TC__019_UserProfile extends DriverManager {

	private TC__019_UserProfileFeature upf;

//438-459

	@Test(priority = 1)
	public void userProfileUI() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileUI();
	}

// 439
	@Test(priority = 2)
	public void userProfileNewUser() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.newUserProfile();
	}

// 440	
	@Test(priority = 3)
	public void userProfileNewUserLogin() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.newUserProfilePage();
	}

// 441	
	@Test(priority = 4)
	public void userProfileOldUserLogin() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.oldUserProfileLogin();
	}
//442   ///////////add validation , The get count should be integer
	@Test(priority = 5)
	public void userProfileFollowersSavesAndGadgets() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.followerSavesAndGadgetCount();
	}

// 443	////////remove share drawer
	@Test(priority = 6)
	public void userProfileJourney() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileJourney();
	}

//// 444	
//	@Test(priority = 7)
//	public void userProfilePersonalTimeline() throws IOException, InterruptedException {
//		upf = new TC__019_UserProfileFeature(driver);
//		upf.MyPersonalTimeline();
//	}

// 445		 ///////device issue 
	@Test(priority = 8)
	public void userProfileShareProfileData() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileSharecheck();
	}

// 446 ////add city edit part 
	@Test(priority = 9)
	public void userProfileEditUserName() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userNameCityEditCheck();
	}

// 447  On clicking on update button display an error message below City : "please enter ther city name"	////////////////////execute with new user
	@Test(priority = 10)
	public void userProfileEditCity() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileEditNameWithoutCityErrorMsgCheck();
	}

//// 448	Edit Profile
//
////	Verify OTP Verification for Mobile number,Email address
////	User should be able to add and Change Mobile number/Email address by OTP verification.
////	@Test(priority = 11)
//	public void userProfileEditEmail() throws IOException, InterruptedException {
//		////////
//		upf = new TC__019_UserProfileFeature(driver);
//		upf.changeEmailUserProfile();
//	}

//// 449	Edit Profile
//	@Test(priority = 12)
//	public void userProfilePreFilledEmail() throws IOException, InterruptedException {
//		upf = new TC__019_UserProfileFeature(driver);
//		upf.editEmailUserProfile();
//	}

// 450	Edit Profile /////add  for email id part
	@Test(priority = 13)
	public void userProfileEmptyMobileFieldOnClick() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.emptyMobileFiledOnClick();
	}

// 451	Edit Profile
	@Test(priority = 14)
	public void userProfileBlankOtp() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.verifyBlankOtp();
	}

// 452	Edit Profile
	@Test(priority = 15)
	public void userProfileWrongOtp() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.verifyErrorMessageForWrongOtp();
	}

// 453	Edit Profile ///////validate it with the timer
	@Test(priority = 16)
	public void userProfileResendButton() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.verifyOTPScreen();
	}

//// 454	Share profile
//	@Test(priority = 17)
//	public void userProfileShare() throws IOException, InterruptedException {
//		upf = new TC__019_UserProfileFeature(driver);
//		upf.userProfileSharecheck();
//	}

// 455	Check Back Button
	@Test(priority = 18)
	public void userProfileBackButton() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.UserProfileBackButton();
	}

// 456	Check Helpful and share Button on Report/////Device issue
	@Test(priority = 19)
	public void userProfileHelpfulAndShareOnReport() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileJourneyHelpAndShareOnReport();
	}
//
//// 457	Check Like and Edit Button on any review done by oneself
//	@Test(priority = 20)
//	public void userProfileLikeAndEditOnReview() throws IOException, InterruptedException {
//		upf = new TC__019_UserProfileFeature(driver);
//		upf.likeEditOnReview();
//	}

// 458	Check Map Layer button on Post and Review detail page //// TC ia failing Verify the map layer 
	@Test(priority = 21)
	public void userProfileMapLayerOnPostAndReport() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.mapLayerOnPostAndReport();
	}

// 459	Check contact list 
	@Test(priority = 22)  
	public void userProfileContactList() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.UserProfileContactList();
	}
//	21 new test case sheet Check  for emergency contact
	@Test(priority = 23)
	public void userProfileEmergencyContact() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileEmergencyCont();
	}  
//22 new test case sheet ::edit saved contact////verify with list 
	@Test(priority = 24)
	public void userProfileEditEmergencyContact() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileEditSavedEmergencyCont();
	}
	//23 new test case sheet:: delete saved contact ////verify with list 
	@Test(priority = 25)
	public void userProfileDeleteEmergencyContact() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.userProfileDeleteSavedEmergencyCont();
	}
	
	//24
	@Test(priority = 26)
	public void userProfileUpdateEmptyUserNameErrorMEssage() throws IOException, InterruptedException {
		upf = new TC__019_UserProfileFeature(driver);
		upf.updateWithoutUserName();
	}
	
	//25
		@Test(priority = 26)
		public void userProfileUpdateEmptyUserIDErrorMEssage() throws IOException, InterruptedException {
			upf = new TC__019_UserProfileFeature(driver);
			upf.updateWithoutUserId();
		}
}
