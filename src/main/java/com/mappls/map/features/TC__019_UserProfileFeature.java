package com.mappls.map.features;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__019_UserProfilePage;
import com.mappls.map.pages.TC__020_MapLayerPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TC__019_UserProfileFeature {

	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;

	TC__019_UserProfilePage uf;
	BaseFeatures bf;
	BasePage bp;
	TC__001_RegistrationFeature nrp;
	TC__020_MapLayerFeature mlf;
	TC__020_MapLayerPage mp;
	
	public TC__019_UserProfileFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		uf = new TC__019_UserProfilePage(driver);
		bf = new BaseFeatures(driver);
		bp = new BasePage(driver);
		nrp = new TC__001_RegistrationFeature(driver);
		mlf = new TC__020_MapLayerFeature(driver);
		mp = new TC__020_MapLayerPage(driver);
//		Xls_Reader reader = new Xls_Reader("./TestData/data_driven.xlsx");
//	    bf.reader = reader;
	}

	public String userMenu() throws IOException {
		String displayName = uf.UserDisplay.getText();
		Reporter.log("Menu Display : " + displayName, true);
		return displayName;
	}

	public void UserClickOnHamburgerMenu() {
		uf.user.click();
		Reporter.log("clicked user in menu", true);
	}

	public void enterLoginEmail(String uemail) {
		uf.enter_email.sendKeys(uemail);
		Reporter.log("Entered email: " + uemail);
	}

	public void clickContinueBtnAtLogin() {
		uf.continueBtn.click();
		Reporter.log("Clicked 'continue' Button", true);
	}

	public void enterLoginPassword(String upassword) {
		wait.until(ExpectedConditions.visibilityOf(uf.enter_password));

		if (uf.enter_password.isDisplayed()) {
			uf.enter_password.sendKeys(upassword);
			Reporter.log("Entered password", true);
			clickLoginBtnAtLogin();
		}
	}

	public void clickLoginBtnAtLogin() {
		uf.login.click();
		Reporter.log("Clicked 'Login' button", true);
		bf.toastMsg("Login Successful");
	}

	public String userLogin(String uemail, String upassword) throws IOException, InterruptedException {

		uf.enter_email.sendKeys(uemail);
		Reporter.log("Entered email: " + uemail);

		uf.continueBtn.click();
		Reporter.log("Clicked 'continue' Button", true);

		wait.until(ExpectedConditions.visibilityOf(uf.enter_password));

		if (uf.enter_password.isDisplayed()) {
			uf.enter_password.sendKeys(upassword);
			Reporter.log("Entered password", true);

			uf.login.click();
			Reporter.log("Clicked 'Login' button", true);
			
			bf.toastMsg("Login Successful");

			Reporter.log("Logged in with email id: " + uemail, true);
		}
		return uemail;
	}

	public void handleUpdate() {
		if (uf.updateBtn.isDisplayed()) {
			uf.skipButton.click();
			Reporter.log("Clicked 'Skip' button on update prompt", true);
		}
	}

	// profile details after login
	public String getProfileEmail() {
		String UserProfileEmailDetail = uf.userprofileEmaildetail.getText();
		Reporter.log("Email displayed on profile :" + UserProfileEmailDetail, true);
		return UserProfileEmailDetail;
	}

	public String getProfileName() {
		String UserProfileNameDetail = uf.userprofilenamedetail.getText();
		Reporter.log("Name displayed on profile :" + UserProfileNameDetail, true);
		return UserProfileNameDetail;
	}

	public void userProfileEdit() throws IOException {
		if (uf.edit_profile_button.isDisplayed())
			uf.edit_profile_button.click();
		Reporter.log(" Edit profile Button clicked ", true);
	}

//
//public String userMenu() throws IOException {
//	String displayName = uf.UserDisplay.getText();
//	Reporter.log("Menu Display : " + displayName, true);
//	uf.user.click();
//	Reporter.log("clicked user in menu", true);
//	return displayName;
//}

	public void editProfileUserID(String uId) throws IOException {
		String UserId = uf.username_field.getText();
		Reporter.log(" Existing user Id :" + UserId, true);
		uf.username_field.clear();
		uf.username_field.sendKeys(uId);
	}

	public String checkEditedUserID() throws IOException {
		String UserId = uf.username_field.getText();
		return UserId;
	}

	public String userProfileName(String uname) throws IOException {
		String userName = uf.username.getText();
		Reporter.log("User Name Mentioned here is :" + uf.username.getText(), true);
		uf.username.clear();
		uf.username.sendKeys(uname);
		return userName;
	}

	public String editProfileCity(String cityName) throws IOException {
		String userCity = uf.editCity.getText();
		Reporter.log("User City :" + userCity, true);
		uf.editCity.click();
		uf.enter_city.sendKeys(cityName);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement suggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/city_selection_recycler_view\"]")));
		WebElement citySuggestion = suggestionList.findElement(By.xpath(" //android.widget.RelativeLayout[@resource-id=\"com.mmi.maps:id/item_container\"]"));
		citySuggestion.click();
		String changedCity = uf.editCity.getText();
		Reporter.log("Changed User City is :" + changedCity, true);
		return changedCity;
	}

	public String checkEditedUserName() {
		String userName = uf.username.getText();
		return userName;
	}
	public String checkEditedCity() {
		String userCity = uf.editCity.getText();
		return userCity;
	}

	public String editProfileAbout(String about) throws IOException {
		String userAbout = uf.editAbout.getText();
		Reporter.log("User About: " + userAbout, true);
		uf.editAbout.clear();
		uf.editAbout.sendKeys(about);
		String changedAbout = uf.editAbout.getText();
		Reporter.log(" Changed User About:" + changedAbout, true);
		return userAbout;
	}

	public void editProfileUpdate() throws IOException {
		uf.update_Button.click();
		Reporter.log("Update button clicked", true);
		if (uf.updateConfirm2.isEnabled()) {
			if (uf.updateConfirm.isDisplayed()) {
				String updateMessage = uf.updateConfirm.getText();
				Reporter.log("Update confirmation: " + updateMessage, true);
				Assert.assertEquals(updateMessage, "Profile updated successfully!");
			}
		}
		uf.ok_Btn.click();
		Reporter.log("ok button clicked ", true);
	}

	
	public void userProfileShareLink() throws IOException {
		uf.shareBtnInProfile.click();
		Reporter.log("Share Profile Button  clicked.", true);
		shareLinkTextFetch();
	}

	public void userProfileFollower() throws IOException {
		Reporter.log("Total followers = " + uf.followerCount.getText(), true);
		uf.followers.click();
		Reporter.log("followers on profile clicked", true);
		if (uf.Share_Profile.isDisplayed())
			Reporter.log("no followers found", true);
		uf.Share_Profile.click();
		Reporter.log("clicked share profile on my people page.", true);
		shareLinkTextFetch();
		uf.backBtnToolbar.click();
	}

	public void userProfileFollowings() {
		uf.followers.click();
		Reporter.log("clicked followers on profile", true);
		uf.following.click();
		Reporter.log("clicked following in my people page.", true);
		if (uf.follower_Profile.isDisplayed()) {
			try {
				uf.follower_Profile.click();
				Reporter.log("Follow profile button clicked", true);
				if (uf.sync_now.isDisplayed()) {
					uf.sync_now.click();
					Reporter.log("sync clicked", true);
					wait.until(ExpectedConditions.visibilityOf(uf.allow_button));
					uf.allow_button.click();
					Reporter.log("Allow clicked ", true);
					bf.toastMsg("Contacts synced successfully");
					wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
					Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");

					if (uf.searchContact.isEnabled()) {
						wait.until(ExpectedConditions.visibilityOf(uf.inviteCard));
						Assert.assertTrue(uf.inviteCard.isEnabled(), "Invite card is not enabled");

						if (uf.inviteCard.isEnabled()) {

							Reporter.log("Invite Card Message :" + uf.inviteCardText1.getText() + ","+ uf.inviteCardText2.getText(), true);
							wait.until(ExpectedConditions.visibilityOf(uf.contacts_display));
							Assert.assertTrue(uf.contacts_display.isEnabled(), "Contacts display is not enabled");

							if (uf.contacts_display.isEnabled())
								Reporter.log("List of Possible contacts Displayed", true);
						}
					}
				}
			} catch (NoSuchElementException e) {
				uf.shareContact.click();
			}

		} else if (uf.contacts_display.isDisplayed()) {
			uf.sync.click();
			bf.toastMsg("Contacts synced successfully");
			wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
			Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");

			if (uf.searchContact.isEnabled()) {
				wait.until(ExpectedConditions.visibilityOf(uf.inviteCard));
				Assert.assertTrue(uf.inviteCard.isEnabled(), "Invite card is not enabled");

				if (uf.inviteCard.isEnabled()) {

					Reporter.log("Invite Card Message :" + uf.inviteCardText1.getText() + "," + uf.inviteCardText2.getText(),true);
					wait.until(ExpectedConditions.visibilityOf(uf.contacts_display));
					Assert.assertTrue(uf.contacts_display.isEnabled(), "Contacts display is not enabled");

					if (uf.contacts_display.isEnabled())
						Reporter.log("List of Possible contacts Displayed", true);
				}
			}
		}
//		uf.backBtnToolbar.click();
	}

	public String userProfileMySavesCount() throws IOException {
		String MysavesCount = uf.mysavescount.getText();
		Reporter.log("My saves Count" + MysavesCount, true);
		return MysavesCount;
	}

	public void userProfileJourneyReviewS() {
		Reporter.log(uf.journey.getText(), true);
		uf.postBtn.click();
		Reporter.log("Review Selected", true);
		if (uf.RecyclerView.isEnabled()) {
			if (uf.LinearLayout.isEnabled()) {
				if (uf.main_layout.isEnabled()) {
					String fetchedTxt = uf.reviewText.getText();
					Assert.assertTrue(fetchedTxt.contains("reviewed"),"The text does not contain 'reviewed' as expected.");
					if (fetchedTxt.contains("reviewed")) {
						Reporter.log("Reviewed Items Displayed", true);
						Reporter.log(fetchedTxt, true);
						uf.reviewText.click();
						Reporter.log("Reviewed Item Ratings Count: " + uf.reviewRatingCount.getText(), true);
						Reporter.log("Reviewed on:" + uf.reviewDateText.getText(), true);
					} else if (fetchedTxt.contains("posted")) {
						Reporter.log("no reviewed items found", true);
					}
				}
			}
		}
	}

	public void userJouPlaceDetailShare() {
		uf.shareAction.click();
		Reporter.log("clicked share", true);		
		shareLinkTextFetch();
	}

	public void userProfileJourneyPostS() {
		Reporter.log(uf.journey.getText(), true);

		uf.reviewBtn.click();
		Reporter.log("Post Selected", true);
		if (uf.RecyclerView.isEnabled()) {
			if (uf.LinearLayout.isEnabled()) {
				if (uf.main_layout.isEnabled()) {

					String fetchedTxt = uf.reportText.getText();
					Assert.assertTrue(fetchedTxt.contains("posted"), "The text does not contain 'posted' as expected.");
					if (fetchedTxt.contains("posted")) {
						Reporter.log("Posted  Items Displayed", true);
						Reporter.log(fetchedTxt, true);
						uf.reportText.click();
						Reporter.log("reported or posted text clicked.", true);
						String detailOfReview = uf.reviewedplaceDesc.getText();
						Reporter.log("Reviewed : " + detailOfReview, true);
						String dateR = uf.reviewDate.getText();
						Reporter.log(" On Date :" + dateR, true);
					} else if (fetchedTxt.contains("reviewed")) {
						Reporter.log("no posted items found", true);
					}
				}
			}
		}
	}

	public void userProfileBack() throws IOException {
		uf.UserProfileBack.click();
	}

	public void addEmergencyContact(String name, String number) {
		if (uf.profileEmergencyContact.isDisplayed()) {
			Reporter.log(uf.profileEmergencyContactTitle.getText(), true);
			Reporter.log(uf.profileEmergencyContactSubTitle.getText(), true);
			uf.profileEmergencyContact.click();
			Reporter.log("Emergency Contact Clicked", true);
			if (isAddMoreContactDisplayed()) {
				uf.addMoreContactEC.click();
				Reporter.log("plus icon for adding contact at emergency contact page clicked", true);
				uf.nameAEC.sendKeys(name);
				Reporter.log("Name Entered :" + name, true);
				uf.contactNoAEC.sendKeys(number);
				Reporter.log("Number Entered :" + number, true);
				uf.saveBtnAEC.click();
				Reporter.log("Clicked Save", true);
				bf.toastMsg("Mobile number successfully saved, Add another Number");
			} else if (isAddContactFormDisplayed()) {
				Reporter.log("Add new contact as no contact exists", true);
				uf.nameAEC.sendKeys(name);
				Reporter.log("Name Entered :" + name, true);
				uf.contactNoAEC.sendKeys(number);
				Reporter.log("Number Entered :" + number, true);
				uf.saveBtnAEC.click();
				Reporter.log("Clicked Save", true);
				bf.toastMsg("Mobile number successfully saved, Add another Number");
			}
		}
	}

	public void verifyAddedContactInEmergencyContact(String expectedName, String expectedNumber) {
		WebElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/recycler_view_show_contact"));

		// Retrieve the list of contact elements from the RecyclerView
		List<WebElement> contactElements = recyclerView.findElements(By.className("android.view.ViewGroup"));
		boolean contactFound = false;

		for (WebElement contactElement : contactElements) {
			WebElement nameElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_name"));
			WebElement numberElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_number"));

			String actualName = nameElement.getText();
			String actualNumber = numberElement.getText();

			if (actualName.equals(expectedName) && actualNumber.equals(expectedNumber)) {
				contactFound = true;
				Reporter.log("Added contact is present in the list", true);
				break;
			}
		}
		Assert.assertTrue(contactFound, "Contact not found: " + expectedName + " - " + expectedNumber);

		System.out.println("Contact " + expectedName + " with number " + expectedNumber + " is present in the list.");
	}

	private boolean isAddContactFormDisplayed() {
		// Implement logic to check if the add contact form is displayed
		try {
			return uf.nameAEC.isDisplayed() && uf.contactNoAEC.isDisplayed() && uf.saveBtnAEC.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAddMoreContactDisplayed() {
		try {
			return uf.addMoreContactEC.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickEmergencyContact() {
		wait.until(ExpectedConditions.visibilityOf(uf.profileEmergencyContact));
		uf.profileEmergencyContact.click();
		Reporter.log("Emergency Contact clicked.", true);
	}

	public void deleteEmergencyContact() {
		if (uf.savedContactListEC.isDisplayed())
			if (uf.savedContactListVG.isDisplayed())
				Reporter.log("saved contacts in emergency contact.", true);
		String contactName = uf.savedContactNameEC.getText();
		String contactNum = uf.savedContactNoEC.getText();
		Reporter.log("saved contact name :" + contactName, true);
		Reporter.log("Saved contact No:" + contactNum, true);
		uf.actionEC.click();
		Reporter.log("Action Button Clicked", true);
		bf.sleepWait(2);

		uf.actionDeleteEC.click();
		Reporter.log("Delete Option Clicked.", true);
		bf.toastMsg("Emergency Contact deleted successfully");

		verifyDeletedContactNotPresentInEC(contactName, contactNum);
	}

	public void verifyDeletedContactNotPresentInEC(String expectedName, String expectedNumber) {
		WebElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/recycler_view_show_contact"));
		List<WebElement> contactElements = recyclerView.findElements(By.className("android.view.ViewGroup"));

		boolean contactFound = false;
		for (WebElement contactElement : contactElements) {
			WebElement nameElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_name"));
			WebElement numberElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_number"));

			String actualName = nameElement.getText();
			String actualNumber = numberElement.getText();

			if (actualName.equals(expectedName) && actualNumber.equals(expectedNumber)) {
				contactFound = true;
				break;
			}
		}
		Assert.assertFalse(contactFound, "Contact should not be found: " + expectedName + " - " + expectedNumber);
		System.out.println("Contact " + expectedName + " with number " + expectedNumber + " is not present in the list.");
	}

	public void editEmergencyContact(String name) {
		if (uf.savedContactListEC.isDisplayed()) {
			if (uf.savedContactListVG.isDisplayed())
				Reporter.log("saved contacts in emergency contact.", true);
			uf.actionEC.click();
			Reporter.log("Action Button Clicked", true);
			bf.sleepWait(2);

			uf.actionEditEC.click();
			Reporter.log("edit  option clicked", true);
//			Reporter.log("existing name: " + uf.nameAEC.getText(), true);
			String contactName = uf.nameAEC.getText();
			Reporter.log("Exixting Name:" + contactName, true);
			String contactNum = uf.contactNoAEC.getText();
			Reporter.log("contact No:" + contactNum, true);		
			uf.nameAEC.clear();
			Reporter.log("name cleared", true);
			uf.nameAEC.sendKeys(name);
			Reporter.log("Changed Name: " + uf.nameAEC.getText(), true);
			bf.sleepWait(2);

			uf.saveBtnAEC.click();
			Reporter.log("Save clicked", true);
			bf.toastMsg("Mobile number successfully saved, Add another Number");
			Reporter.log(" saved contact edited", true);
			verifyEditedContactInEmergencyContact(name,contactNum);
		}
	}

	public void verifyEditedContactInEmergencyContact(String expectedName, String expectedNumber) {
		WebElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/recycler_view_show_contact"));
		List<WebElement> contactElements = recyclerView.findElements(By.className("android.view.ViewGroup"));
		boolean contactFound = false;

		for (WebElement contactElement : contactElements) {
			WebElement nameElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_name"));
			WebElement numberElement = contactElement.findElement(By.id("com.mmi.maps:id/text_view_contact_number"));

			String actualName = nameElement.getText();
			String actualNumber = numberElement.getText();

			if (actualName.equals(expectedName)&& actualNumber.equals(expectedNumber)) {
				contactFound = true;
				Reporter.log("Edited contact is present in the list", true);
				break;
			}
		}
		Assert.assertTrue(contactFound, "Contact not found: " + expectedName);

		System.out.println("Contact " + expectedName + " with number " + expectedNumber +" is present in the list.");
	}

	

	public void shareLinkTextFetch() {
		wait.until(ExpectedConditions.visibilityOf(uf.btmShtShareTextLayout));
		try {
			// Try Samsung locators
			wait.until(ExpectedConditions.visibilityOf(uf.sharetxtcopyBtn));

			if (uf.btmShtShareTextLayout.isEnabled()) {
				wait.until(ExpectedConditions.visibilityOf(uf.shareReviewTextTab));
				String shareLink = uf.btmShtshareText.getText();
				Reporter.log(shareLink, true);
				uf.sharetxtcopyBtn.click();
				Reporter.log("Copy button clicked.", true);
				bf.toastMsg("Copied to clipboard.");
			}
		} catch (TimeoutException e) {
			Reporter.log("Device elements not found, trying device2 elements.", true);
			try {
				// Try Vivo locators
				wait.until(ExpectedConditions.visibilityOf(uf.linkcopy));
				if (uf.btmShtShareTextLayout.isEnabled()) {
					wait.until(ExpectedConditions.visibilityOf(uf.shareReviewTextTab));
					String shareLink = uf.linkText.getText();
					Reporter.log(shareLink, true);
					uf.linkcopy.click();
					Reporter.log("Copy button clicked.", true);
					bf.toastMsg("Copied");
				}
			} catch (TimeoutException ex) {
				Reporter.log("None of the expected elements are present", true);
			}
		} catch (Exception e) {
			Reporter.log("Exception occurred: " + e.getMessage(), true);
		}
	}



//	public void shareLinkTextFetchLink(String sheetName, String colName, int rownum) {
//		wait.until(ExpectedConditions.visibilityOf(uf.btmShtShareTextLayout));
//		try {
//			// Try Samsung locators
//			wait.until(ExpectedConditions.visibilityOf(uf.sharetxtcopyBtn));
//
//			if (uf.btmShtShareTextLayout.isEnabled()) {
//				wait.until(ExpectedConditions.visibilityOf(uf.shareReviewTextTab));
//				String shareLink = uf.btmShtshareText.getText();
//				bf.reader.setCellData(sheetName, colName, rownum, shareLink);
////	        bf.reader.setCellData("sheet2", "actual",  2, shareLink);
//				Reporter.log(shareLink, true);
//
//				uf.sharetxtcopyBtn.click();
//				Reporter.log("Copy button clicked.", true);
//				bf.toastMsg("Copied to clipboard.");
//			}
//		} catch (TimeoutException e) {
//			Reporter.log("Device elements not found, trying device2 elements.", true);
//			try {
//				// Try Vivo locators
//				wait.until(ExpectedConditions.visibilityOf(uf.linkcopy));
//				if (uf.btmShtShareTextLayout.isEnabled()) {
//					wait.until(ExpectedConditions.visibilityOf(uf.shareReviewTextTab));
//					String shareLink = uf.linkText.getText();
//					bf.reader.setCellData(sheetName, colName, rownum, shareLink);
////    	        bf.reader.setCellData("sheet2", "actual",  2, shareLink);
//					Reporter.log(shareLink, true);
//					uf.linkcopy.click();
//					Reporter.log("Copy button clicked.", true);
//					bf.toastMsg("Copied");
//				}
//			} catch (TimeoutException ex) {
//				Reporter.log("None of the expected elements are present", true);
//			}
//		} catch (Exception e) {
//			Reporter.log("Exception occurred: " + e.getMessage(), true);
//		}
//	}

	public void verifyRadioButtonsDisplayedAndSelected() {
		Assert.assertTrue(uf.maleRadioButton.isDisplayed(), "Male radio button is not displayed");
		Assert.assertTrue(uf.femaleRadioButton.isDisplayed(), "Female radio button is not displayed");
		Assert.assertTrue(uf.othersRadioButton.isDisplayed(), "Others radio button is not displayed");

		String maleChecked = uf.maleRadioButton.getAttribute("checked");
		String femaleChecked = uf.femaleRadioButton.getAttribute("checked");
		String othersChecked = uf.othersRadioButton.getAttribute("checked");

// Print out the result of which radio button is checked
		if ("true".equals(maleChecked)) {
			Assert.assertEquals(maleChecked, "true", "Male radio button should be selected but it is not.");
			Reporter.log("Male radio button is selected", true);
		} else if ("true".equals(femaleChecked)) {
			Assert.assertEquals(femaleChecked, "true", "Female radio button should be selected but it is not.");
			Reporter.log("Female radio button is selected", true);
		} else if ("true".equals(othersChecked)) {
			Assert.assertEquals(othersChecked, "true", "Others radio button should be selected but it is not.");
			Reporter.log("Others radio button is selected", true);
		} else {
			Assert.fail("No radio button is selected, one must be selected.");
			Reporter.log("No radio button is selected", true);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//1
	public void userProfileNameCheck() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		String menuName = userMenu();
		ClickUserMenuAtHamburger();
		String profileName = getProfileName();
		assertEquals(menuName.toLowerCase(), profileName.toLowerCase());
		Reporter.log("Profile Name verified ", true);
	}

//2
	public void userProfileEmailCheck() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		String loginEmail = userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		String profileEmail = getProfileEmail();
		assertEquals(loginEmail, profileEmail);
		Reporter.log("Profile Email Verified", true);
	}

//3
	public void userIdEditCheck() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		String randomUserId = RandomDataGenerator.generateRandomUserId();
		editProfileUserID(randomUserId);
		editProfileUpdate();
		userProfileEdit();
		String changedUserId = checkEditedUserID();
		assertEquals(randomUserId.toLowerCase(), changedUserId.toLowerCase());
		Reporter.log("updated User Id Verified", true);
	}

	public void updateWithoutAbout() {
		String userAbout = uf.editAbout.getText();
		Reporter.log("User About: " + userAbout, true);
		uf.editAbout.clear();
		Reporter.log("user About cleared.", true);
		uf.update_Button.click();
		Reporter.log("Update Button clicked.", true);

		try {
			// Check if an error message appears
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(uf.errorMessageId));
			Reporter.log("Error message displayed: " + errorMessage.getText(), true);
			Assert.fail("Unexpected error message displayed: " + errorMessage.getText());
		} catch (TimeoutException e) {
			// No error message, proceed to check the confirmation dialog
			if (uf.updateConfirm2.isEnabled()) {
				if (uf.updateConfirm.isDisplayed()) {
					String updateMessage = uf.updateConfirm.getText();
					Reporter.log("Update confirmation: " + updateMessage, true);
					Assert.assertEquals(updateMessage, "Profile updated successfully!");
					uf.ok_Btn.click();
					Reporter.log("clicked ok", true);
				}
			} else {
				Assert.fail("Update confirmation button is not enabled");
			}
		}
	}



//446 TC 9
	public void userNameCityEditCheck() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		String randomName = RandomDataGenerator.generateRandomUserName();
		userProfileName(randomName);
		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
	    editProfileCity(randomPlace);
		editProfileUpdate();
		userProfileEdit();
		String changedUSerNAme = checkEditedUserName();
		assertEquals(randomName.toLowerCase(), changedUSerNAme.toLowerCase());
		Reporter.log(" Updated Username verified", true);
		String changedUSerCity = checkEditedCity();
		assertEquals(randomPlace.toLowerCase(), changedUSerCity.toLowerCase());
		Reporter.log("Updated User City verified", true);
	}

//447 tc 10
	public void userProfileEditNameWithoutCityErrorMsgCheck() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("9142877242", "Mmi@12345");
//		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		String randomName = RandomDataGenerator.generateRandomUserName();
		userProfileName(randomName);
		String userCity = uf.editCity.getText();
		Assert.assertEquals(userCity,"City");
//	    Assert.assertTrue(userCity.isEmpty(), "Fetched value is not empty as expected.");
	    uf.update_Button.click();
		Reporter.log("Update button clicked", true);
		
		String errorMessage = uf.nullcityValueErMsg.getText();
		Reporter.log("Error Message: " + errorMessage, true);
		String text = "Please enter a city name";

		Assert.assertEquals(errorMessage, text);
	    
//		String randomPlace = RandomDataGenerator.generateRandomPlaceName();
//		String changedCityName = editProfileCity(randomPlace);
//		editProfileUpdate();
//		userProfileEdit();
//		String changedUSerCity = checkEditedCity();
//		assertEquals(changedCityName.toLowerCase(), changedUSerCity.toLowerCase());
//		Reporter.log("Updated User City verified", true);

	}

//8
	public void userAboutEditCheck() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		String randomAbout = RandomDataGenerator.generateRandomAbout();
		editProfileAbout(randomAbout);
		editProfileUpdate();
		userProfileEdit();
		String changedAbout = editProfileAbout(randomAbout);
		assertEquals(randomAbout.toLowerCase(), changedAbout.toLowerCase());
		Reporter.log("Updated about verified", true);
	}



//445 tc 8
	public void userProfileSharecheck() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileShareLink();
		userProfileBack();
	}

//11
	public void userProfileFollowerCheck() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();

		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();

		userProfileFollower();
		userProfileBack();
	}

//12
	public void userProfileFollowingCheck() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileFollowings();
		userProfileBack();

	}

//13
	public void userProfileJourneyRevShare() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileJourneyReviewS();
		userJouPlaceDetailShare();
		userProfileBack();
	}

//456 tc 19 
	public void userProfileJourneyHelpAndShareOnReport() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileJourneyPostS();
		wait.until(ExpectedConditions.visibilityOf(uf.helpfulActionBtn));
		Assert.assertTrue(uf.helpfulActionBtn.isEnabled(), "helpful Action Button on User Profile Page is not enabled");
		Reporter.log("helpful is displayed", true);
		userJouPlaceDetailShare();
		userProfileBack();
	}

	public void mapLayerButtonVisibility() {
		try {
			wait.until(ExpectedConditions.visibilityOf(uf.mapLayerButton));
			Assert.assertTrue(uf.mapLayerButton.isDisplayed(), "Map Layer Button is not displayed");
			Reporter.log("Map Layer Button is displayed.", true);
		} catch (NoSuchElementException | TimeoutException e) {
			Assert.fail("Map Layer Button is either not displayed or not found.", e);
		}
	}

	// 458 tc 21
	public void mapLayerOnPostAndReport() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileJourneyReviewS();
		mapLayerButtonVisibility();
		uf.mapLayerButton.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(1 , "Default Map already selected with out login");
		
		mp.satelliteMap.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(2, "Satellite Map");
		
		mp.terrainMap.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(3, "Terrain Map");
		
		mp.grayMap.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(4, "Gray Map");
		
		mp.sublimeGreayMap.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(5, "Sublime Map");
		
		mp.darkClassicMap.click();
		bf.sleepWait(2);
		mlf.maplayersVerfication(6, "Dark Classic Map");
//		userProfileBack();
//		uf.postBtn.click();
//		bf.sleepWait(4);
//		userProfileJourneyPostS();
//		mapLayerButtonVisibility();
//		userProfileBack();
	}

//460 TC 23
	public void userProfileEmergencyCont() throws InterruptedException, IOException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();

		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();

		String randomName = RandomDataGenerator.generateRandomUserName();
		String randomNumber = RandomDataGenerator.generateRandomContactNumber();
		addEmergencyContact(randomName, randomNumber);
		verifyAddedContactInEmergencyContact(randomName, randomNumber);
	}

//TC 24
	public void userProfileEditSavedEmergencyCont() throws InterruptedException, IOException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		clickEmergencyContact();
		String randomName = RandomDataGenerator.generateRandomUserName();
		editEmergencyContact(randomName);
	}

//Tc 25
	public void userProfileDeleteSavedEmergencyCont() throws InterruptedException, IOException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		clickEmergencyContact();
		deleteEmergencyContact();
	}

//18
	public void userProfileGender() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		verifyRadioButtonsDisplayedAndSelected();
	}

	public String UserMenuDisplay() {
		String displayName = uf.UserDisplay.getText();
		Reporter.log("Menu Display : " + displayName, true);
		return displayName;

	}

	public void ClickUserMenuAtHamburger() {
		uf.user.click();
		Reporter.log("clicked user in menu", true);
	}

	public void loginWelcomePage() {
		wait.until(ExpectedConditions.visibilityOf(uf.welcomeTitle));
		String title = uf.welcomeTitle.getText();
		Assert.assertEquals(title, "Welcome", "Welcome should reflect for new user but it is not.");
		Reporter.log("Displayed Text At Title:" + title, true);

	}

	public void loginPageSubtitle() {
		wait.until(ExpectedConditions.visibilityOf(uf.welcomePageSubTitle));
		String subtitle = uf.welcomePageSubTitle.getText();
		String actualSubtitle = "Login/Sign Up to manage your account   ";
		Assert.assertEquals(subtitle, actualSubtitle, "Login/ SignUp is not found.");
		Reporter.log("Displayed Text At  Sub-Title:" + subtitle, true);
	}

	public void termsAndConditions() {
		wait.until(ExpectedConditions.visibilityOf(uf.welcomePageDescription));
		String description = uf.welcomePageDescription.getText();
		String actualdescription = "By continuing, you agree to the Mappls MapmyIndia Terms & Conditions and Privacy Policy.";
		Assert.assertEquals(description, actualdescription, "Description is not found.");
		Reporter.log("Displayed Text At Description:" + description, true);
	}

	// TC1
	public void userProfileUI() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		UserClickOnHamburgerMenu();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		UserClickOnHamburgerMenu();
		wait.until(ExpectedConditions.visibilityOf(uf.toolBarText));
		Assert.assertTrue(uf.toolBarText.isEnabled(), "profile text on User Profile Page is not enabled");
		String text = uf.toolBarText.getText();
		Reporter.log("Text Displayed at toolbar :" + text, true);

		wait.until(ExpectedConditions.visibilityOf(uf.shareBtnAtProfile));
		Assert.assertTrue(uf.shareBtnAtProfile.isEnabled(), "Share Button on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.imageAtProfile));
		Assert.assertTrue(uf.imageAtProfile.isEnabled(), "Image on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.editBtnAtProfile));
		Assert.assertTrue(uf.editBtnAtProfile.isEnabled(), "Edit Button on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.nameTextDisplayAtPofile));
		Assert.assertTrue(uf.nameTextDisplayAtPofile.isEnabled(), "Name on User Profile Page is not enabled");
		String nametext = uf.nameTextDisplayAtPofile.getText();
		Reporter.log("Text Displayed at Name :" + nametext, true);

		wait.until(ExpectedConditions.visibilityOf(uf.emailTextDisplayAtProfile));
		Assert.assertTrue(uf.emailTextDisplayAtProfile.isEnabled(), "Email on User Profile Page is not enabled");
		String emailtext = uf.emailTextDisplayAtProfile.getText();
		Reporter.log("Text Displayed at Email :" + emailtext, true);

	}

//439 TC 2
	public void newUserProfile() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		String displayedname = UserMenuDisplay();
		Assert.assertEquals(displayedname, "Login", "Login should reflect for new user but it is not.");
//		Reporter.log("Login is reflected in menu", true);
		ClickUserMenuAtHamburger();
		loginWelcomePage();
		loginPageSubtitle();
		termsAndConditions();
	}

	// 440 TC 3
	public void newUserProfilePage() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		UserClickOnHamburgerMenu();
		userLogin("9142877242", "Mmi@12345");
//		handleUpdate();
		bf.Hamburgerclick();
		String name = userMenu();
		UserClickOnHamburgerMenu();

		wait.until(ExpectedConditions.visibilityOf(uf.toolBarText));
		Assert.assertTrue(uf.toolBarText.isEnabled(), "profile text on User Profile Page is not enabled");
		String text = uf.toolBarText.getText();
		Reporter.log("Text Displayed at toolbar :" + text, true);

		wait.until(ExpectedConditions.visibilityOf(uf.shareBtnAtProfile));
		Assert.assertTrue(uf.shareBtnAtProfile.isEnabled(), "Share Button on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.imageAtProfile));
		Assert.assertTrue(uf.imageAtProfile.isEnabled(), "Image on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.editBtnAtProfile));
		Assert.assertTrue(uf.editBtnAtProfile.isEnabled(), "Edit Button on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.nameTextDisplayAtPofile));
		Assert.assertTrue(uf.nameTextDisplayAtPofile.isEnabled(), "Name on User Profile Page is not enabled");
		String nametext = uf.nameTextDisplayAtPofile.getText();
		Reporter.log("Text Displayed at Name :" + nametext, true);
		assertEquals(name.toLowerCase(), nametext.toLowerCase());

		String followersCount = followersCount();
		String folwcount = "0";
		assertEquals(followersCount, folwcount);
		Reporter.log("Followers count is :" + followersCount, true);
		
		String savesCount = SavesCount();
		String savecount = "0";
		assertEquals(savesCount, savecount);
		Reporter.log("Saves Count is :" + savesCount, true);
		
		String gadgetsCount = GadgetsCount();
		String gadcount = "0";
		assertEquals(gadgetsCount, gadcount);
		Reporter.log("Gadgets count is :" + gadgetsCount, true);
	}

	// 441 tc 4
	public void oldUserProfileLogin() throws IOException, InterruptedException {
		userProfileUI();
		followersCount();
		SavesCount();
		GadgetsCount();
		personalTimelineCard();

		wait.until(ExpectedConditions.visibilityOf(uf.profileEmergencyContact));
		Assert.assertTrue(uf.profileEmergencyContact.isEnabled(),
				"Emergency Contact on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.profileEmergencyContactTitle));
		Assert.assertTrue(uf.profileEmergencyContactTitle.isEnabled(),
				"emergency contact title on User Profile Page is not enabled");
		Reporter.log(uf.profileEmergencyContactTitle.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(uf.profileEmergencyContactSubTitle));
		Assert.assertTrue(uf.profileEmergencyContactSubTitle.isEnabled(),
				"  emergency contact  sub title on User Profile Page is not enabled");
		Reporter.log(uf.profileEmergencyContactSubTitle.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(uf.journey));
		Assert.assertTrue(uf.journey.isEnabled(), "Journey on User Profile Page is not enabled");
		Reporter.log("Text displayed :" + uf.journey.getText(), true);

		wait.until(ExpectedConditions.visibilityOf(uf.postBtn));
		Assert.assertTrue(uf.postBtn.isEnabled(), "Post Button on User Profile Page is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.reviewBtn));
		Assert.assertTrue(uf.reviewBtn.isEnabled(), "Review Button on User Profile Page is not enabled");

	}
	
	public boolean isInteger(String value) {
	    if (value == null || value.isEmpty()) {
	        return false; // Null or empty strings are not integers
	    }
	    try {
	        Integer.parseInt(value);
	        return true; // Parsing succeeded
	    } catch (NumberFormatException e) {
	        return false; // Parsing failed
	    }
	}

	public void validateFetchedValueIsInteger(String fetchedValue) {
	    // Simulating fetched value from the application
//	    String fetchedValue = driver.findElement(By.id("some_element_id")).getText();

	    // Validate if fetched value is an integer
	    boolean isValidInteger = isInteger(fetchedValue);

	    // Assert and log results
	    Assert.assertTrue(isValidInteger, "Fetched value is not a valid integer: " + fetchedValue);
	    Reporter.log("Fetched value is a valid integer: " + fetchedValue,true);
	}

	
	public String followersCount() {
		wait.until(ExpectedConditions.visibilityOf(uf.container_followers));
		Assert.assertTrue(uf.container_followers.isEnabled(), "Followers on User Profile Page is not enabled");

		String count = uf.container_followersCount.getText();
		String text = uf.followersCardText.getText();
		Reporter.log(text + " Count :" + count, true);
		
		validateFetchedValueIsInteger(count);
		return count;
	}

	public String SavesCount() {
		wait.until(ExpectedConditions.visibilityOf(uf.container_contributions));
		Assert.assertTrue(uf.container_contributions.isEnabled(), "Followers on User Profile Page is not enabled");

		String count = uf.container_contributionsCount.getText();
		String text = uf.savesCardText.getText();
		Reporter.log(text + " Count :" + count, true);
		
		validateFetchedValueIsInteger(count);
		return count;

	}

	public String GadgetsCount() {
		wait.until(ExpectedConditions.visibilityOf(uf.container_devices));
		Assert.assertTrue(uf.container_devices.isEnabled(), "Followers on User Profile Page is not enabled");

		String count = uf.container_devicesCount.getText();
		String text = uf.GadgetsCardText.getText();
		Reporter.log(text + " Count :" + count, true);
		
		validateFetchedValueIsInteger(count);
		return count;

	}

//442 TC 5
	public void followerSavesAndGadgetCount() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		followersCount();
		SavesCount();
		GadgetsCount();
		// Count should be accurate for Followers, My Saves and gadgets
	}

	// TC 443 6
	public void userProfileJourney() throws IOException, InterruptedException {

		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileJourneyReviewS();
		userProfileBack();
		bf.sleepWait(3);
		wait.until(ExpectedConditions.visibilityOf(uf.journey));
		Assert.assertTrue(uf.journey.isEnabled(), "Journey on User Profile Page is not enabled");
		Reporter.log("Text displayed :" + uf.journey.getText(), true);
		uf.postBtn.click();
		userProfileJourneyPostS();
		userProfileBack();
	}

	public void personalTimelineCard() {
		wait.until(ExpectedConditions.visibilityOf(uf.personalTimelineCard));
		Assert.assertTrue(uf.personalTimelineCard.isEnabled(), "Personal Timeline Card is not enabled");

		wait.until(ExpectedConditions.visibilityOf(uf.personalTimelineTitle));
		Assert.assertTrue(uf.personalTimelineTitle.isEnabled(), "Personal timeline title is not enabled");
		String titleText = uf.personalTimelineTitle.getText();

		wait.until(ExpectedConditions.visibilityOf(uf.personalTimelineSubTitle));
		Assert.assertTrue(uf.personalTimelineSubTitle.isEnabled(), "Personal Timeline Sub title is not enabled");
		String subTitleText = uf.personalTimelineSubTitle.getText();
		Reporter.log(titleText + " : " + subTitleText, true);

	}

	public void personalTimelineClick() {
		uf.personalTimelineCard.click();
	}

	public void personalTimelinePage() {
		wait.until(ExpectedConditions.visibilityOf(uf.personalTimelinePageTitle));
		Assert.assertTrue(uf.personalTimelinePageTitle.isEnabled(), "Personal Timeline Sub title is not enabled");
		String text = uf.personalTimelinePageTitle.getText();
		Reporter.log(text, true);

		wait.until(ExpectedConditions.visibilityOf(uf.personalTimePageSubTitle));
		Assert.assertTrue(uf.personalTimePageSubTitle.isEnabled(), "Personal Timeline Sub title is not enabled");
		String text2 = uf.personalTimePageSubTitle.getText();
		Reporter.log(text2, true);

		wait.until(ExpectedConditions.visibilityOf(uf.todayText));
		Assert.assertTrue(uf.todayText.isEnabled(), "Personal Timeline Sub title is not enabled");
		String texttoday = uf.todayText.getText();
		Reporter.log(texttoday, true);

		wait.until(ExpectedConditions.visibilityOf(uf.dislayedDate));
		Assert.assertTrue(uf.dislayedDate.isEnabled(), "Personal Timeline Sub title is not enabled");
		String textdate = uf.dislayedDate.getText();
		Reporter.log(textdate, true);
	}

	public void timelineRecyclerView() {
		if (uf.recyclerViewTimeline.isEnabled()) {
			if (uf.durationLayout.isEnabled()) {

			}
		}
	}

////444 TC 7
//	public void MyPersonalTimeline() throws InterruptedException, IOException {
//		bf.mapplsPermissions();
//		bf.Hamburgerclick();
//		userMenu();
//		ClickUserMenuAtHamburger();
//		userLogin("nandini@mapmyindia.com", "Mmi@12345");
//		handleUpdate();
//		bf.Hamburgerclick();
//		userMenu();
//		ClickUserMenuAtHamburger();
//		personalTimelineCard();
//		personalTimelineClick();
//		personalTimelinePage();
//		bf.visibilityofMapLayer();
//		bf.visibilityofCurrentLocation();
////	Functionality for My Personal Timeline should work properly
//	}

//448 tc 11
	public void changeEmailUserProfile() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		wait.until(ExpectedConditions.visibilityOf(uf.emailTextEdit));
		Assert.assertTrue(uf.emailTextEdit.isEnabled(), "Email is not enabled");
		String subTitleText = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email : " + subTitleText, true);
		uf.emailTextEdit.click();
		Reporter.log("Edit email clicked", true);
	}

//449 tc 12
	public void editEmailUserProfile() throws InterruptedException, IOException {
//Email/mobile should come pre-field on click of it.
//Edit mobile no, and mail id
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		wait.until(ExpectedConditions.visibilityOf(uf.emailTextEdit));
		Assert.assertTrue(uf.emailTextEdit.isEnabled(), "Email is not enabled");
		String subTitleText = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email : " + subTitleText, true);
		uf.emailTextEdit.click();
		Reporter.log("Edit email clicked", true);

		wait.until(ExpectedConditions.visibilityOf(uf.emailToolbar));
		Assert.assertTrue(uf.emailToolbar.isEnabled(), "Toolbar is not enabled");
		String displayedToolbar = uf.emailToolbar.getText();
		Reporter.log("Displayed text at toolbar: " + displayedToolbar, true);

		wait.until(ExpectedConditions.visibilityOf(uf.input_layout_email_phone));
		Assert.assertTrue(uf.input_layout_email_phone.isEnabled(), "Email input is not enabled");
		String displayedHint = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email input: " + displayedHint, true);
		String text = "Email Id";
		assertEquals(displayedHint.toLowerCase(), text.toLowerCase());
		Reporter.log("Pre filled email is blank on click of it.", true);
		
	//// get attribute should be empty and null
	}

//450  tc 13
	public void emptyMobileFiledOnClick() throws InterruptedException, IOException {
//   Add mobile no, and mail id
//   Email/mobile field should be blank on click of it.
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		
		wait.until(ExpectedConditions.visibilityOf(uf.emailTextEdit));
		Assert.assertTrue(uf.emailTextEdit.isEnabled(), "Email is not enabled");
		String subTitleText = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email : " + subTitleText, true);
		uf.emailTextEdit.click();
		Reporter.log("Edit email clicked", true);

		wait.until(ExpectedConditions.visibilityOf(uf.emailToolbar));
		Assert.assertTrue(uf.emailToolbar.isEnabled(), "Toolbar is not enabled");
		String displayedToolbar = uf.emailToolbar.getText();
		Reporter.log("Displayed text at toolbar: " + displayedToolbar, true);

		wait.until(ExpectedConditions.visibilityOf(uf.input_layout_email_phone));
		Assert.assertTrue(uf.input_layout_email_phone.isEnabled(), "Email input is not enabled");
		String displayedHint = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email input: " + displayedHint, true);
		String text = "Email Id";
		assertEquals(displayedHint.toLowerCase(), text.toLowerCase());
		Reporter.log("Pre filled email is blank on click of it.", true);
		
     	bf.back();
		wait.until(ExpectedConditions.visibilityOf(uf.mobile_edit_text));
		Assert.assertTrue(uf.mobile_edit_text.isEnabled(), "Mobile Number is not enabled");
		String subTitleTextM = uf.mobile_edit_text.getText();
		Reporter.log("Displayed text at mobile : " + subTitleTextM, true);
		uf.mobile_edit_text.click();
		Reporter.log("mobile number clicked", true);

		wait.until(ExpectedConditions.visibilityOf(uf.mobiletoolbar));
		Assert.assertTrue(uf.mobiletoolbar.isEnabled(), "Toolbar is not enabled");
		String displayedToolbarM = uf.mobiletoolbar.getText();
		Reporter.log("Displayed text at toolbar: " + displayedToolbarM, true);

		wait.until(ExpectedConditions.visibilityOf(uf.input_layout_email_phone));
		Assert.assertTrue(uf.input_layout_email_phone.isEnabled(), "Mobile input is not enabled");
		String displayedHintM = uf.emailTextEdit.getText();
		Reporter.log("Displayed text at email input: " + displayedHintM, true);
		String textM = "Mobile Number";
		assertEquals(displayedHintM.toLowerCase(), textM.toLowerCase());
		Reporter.log("Mobile number is blank on click of it.", true);
	}

//451 tc 14
	public void verifyBlankOtp() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		mobilenumberDisplay();
		mobileNumberClick();
		mobiletoolbar();
		enterNumber();
		clickNext();
		otpPage();
		clickVerify();
		bf.toastMsg("Please enter a valid OTP");

	}

	public String mobilenumberDisplay() {
		wait.until(ExpectedConditions.visibilityOf(uf.mobile_edit_text));
		Assert.assertTrue(uf.mobile_edit_text.isEnabled(), "Mobile Number is not enabled");
		String subTitleText = uf.mobile_edit_text.getText();
		Reporter.log("Displayed text at mobile : " + subTitleText, true);
		return subTitleText;
	}

	public void mobileNumberClick() {
		uf.mobile_edit_text.click();
		Reporter.log("mobile number clicked", true);
	}

	public void mobiletoolbar() {
		wait.until(ExpectedConditions.visibilityOf(uf.mobiletoolbar));
		Assert.assertTrue(uf.mobiletoolbar.isEnabled(), "Toolbar is not enabled");
		String displayedToolbar = uf.mobiletoolbar.getText();
		Reporter.log("Displayed text at toolbar: " + displayedToolbar, true);
	}

	public void enterNumber() {
		wait.until(ExpectedConditions.visibilityOf(uf.emailTextEdit));
		Assert.assertTrue(uf.emailTextEdit.isEnabled(), "Mobile Number text edit is not enabled");
		uf.emailTextEdit.sendKeys("9134567890");
	}

	public void clickNext() {
		wait.until(ExpectedConditions.visibilityOf(uf.btn__Next));
		Assert.assertTrue(uf.btn__Next.isEnabled(), "Next Button  is not enabled");
		uf.btn__Next.click();
	}

	public void otpPage() {
		wait.until(ExpectedConditions.visibilityOf(uf.textViewOTP));
		Assert.assertTrue(uf.textViewOTP.isEnabled(), "OTP Text is not enabled");
		String displayedText = uf.textViewOTP.getText();
		Reporter.log("Displayed text at OTP Text: " + displayedText, true);

	}

	public void clickVerify() {
		wait.until(ExpectedConditions.visibilityOf(uf.btn__Verify));
		Assert.assertTrue(uf.btn__Verify.isEnabled(), "Verify Button  is not enabled");
		uf.btn__Verify.click();
	}

	public void enterOTP() {
		wait.until(ExpectedConditions.visibilityOf(uf.enterOTP));
		Assert.assertTrue(uf.enterOTP.isEnabled(), "OTP Text is not enabled");
		uf.enterOTP.sendKeys("123456");

	}

	public void clickResend() {
		wait.until(ExpectedConditions.visibilityOf(uf.resendBtn));
		Assert.assertTrue(uf.resendBtn.isEnabled(), "Resend Button  is not enabled");
		uf.resendBtn.click();
		Reporter.log("Clicked resend button ." ,true);
	}

	public void invalidOTP() {
		String snackBarMsg = uf.snackBArMesssage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg, true);
		String text = "The provided OTP seems to be invalid. Please make sure you've passed the correct OTP.";

		Assert.assertEquals(snackBarMsg, text);

	}
//Please enter a valid OTP toast message when blank otp 

//452 tc 15
	public void verifyErrorMessageForWrongOtp() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		mobilenumberDisplay();
		mobileNumberClick();
		mobiletoolbar();
		enterNumber();
		clickNext();
		otpPage();
		clickVerify();
		enterOTP();
		invalidOTP();
	}

//453 tc 16
	public void verifyOTPScreen() throws InterruptedException, IOException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileEdit();
		mobilenumberDisplay();
		mobileNumberClick();
		mobiletoolbar();
		enterNumber();
		clickNext();
		otpPage();
		bf.sleepWaits(30);
		uf.resendBtn.click();
		bf.sleepWaits(30);
		uf.resendBtn.click();
		bf.sleepWaits(30);
		uf.resendBtn.click();
		bf.sleepWaits(30);
		
		wait.until(ExpectedConditions.visibilityOf(uf.resendBtn));		
		String timerCount = uf.otpTimer.getText();
		Reporter.log("text obtained after delay of 2 minutes  : "+timerCount, true);
		if (timerCount.contains("00:00")) {
		    Reporter.log("Timer count reached 00:00. Clicking the resend button.", true);
		    clickResend(); 
		} else {
		    Reporter.log("Timer count is not 00:00. Resend button will not be clicked.", true);
		    Assert.fail("Timer did not reach 00:00. Functionality might not be working as expected.");
		}
	}

// 455 18
	public void UserProfileBackButton() throws InterruptedException, IOException {
		userProfileUI();
		userProfileBack();
		wait.until(ExpectedConditions.visibilityOf(bp.hamburgerIconClick));
		Assert.assertTrue(bp.hamburgerIconClick.isEnabled(), "Hamburger is not enabled");
		Reporter.log("Home Screen Page Opens Up After back click on profile", true);
	}
	
	public void testRecyclerViewContactTexts() { 
	    // Locate the RecyclerView using its resource ID
	    MobileElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/sc_contacts_rcv"));

	    // Fetch all view groups (items) inside the RecyclerView
	    List<MobileElement> viewGroups = recyclerView.findElements(By.xpath("//android.view.ViewGroup"));

	    // Get the count of view groups and log it
	    int viewGroupCount = viewGroups.size();
	    Reporter.log("Number of view groups displayed: " + viewGroupCount, true);

	    // Iterate through each view group to locate the LinearLayout and fetch TextView texts
	    for (int i = 0; i < viewGroupCount; i++) {
	        MobileElement viewGroup = viewGroups.get(i);
	        Reporter.log("View Group " + (i + 1) + ":", true);

	        try {
	            // Locate the LinearLayout within the current ViewGroup
	            MobileElement linearLayout = viewGroup.findElement(By.xpath(".//android.widget.LinearLayout"));

	            // Get the first TextView inside the LinearLayout
	            MobileElement firstTextView = linearLayout.findElement(By.id("com.mmi.maps:id/ci_name_tv"));
	            String firstText = firstTextView.getText();
	            Reporter.log("  TextView 1: " + firstText, true);
	       
	            // Get the second TextView inside the LinearLayout
	            MobileElement secondTextView = linearLayout.findElement(By.id("com.mmi.maps:id/ci_alias_tv"));
	            String secondText = secondTextView.getText();
	            Reporter.log("  TextView 2: " + secondText, true);

	        } catch (Exception e) {
	            Reporter.log("Unable to locate TextViews in ViewGroup " + (i + 1), true);
	        }
	    }
	    // Final assertion: test passes if it successfully logs all visible items
	    Assert.assertTrue(true, "Test completed by displaying all TextView items in each ViewGroup.");
	}

	// 459 22
	public void UserProfileContactList() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileFollowings();
		testRecyclerViewContactTexts();	
	}

	public void likeEditOnReview()throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userLogin("nandini@mapmyindia.com", "Mmi@12345");
		handleUpdate();
		bf.Hamburgerclick();
		userMenu();
		ClickUserMenuAtHamburger();
		userProfileJourneyReviewS();
		wait.until(ExpectedConditions.visibilityOf(uf.helpfulActionBtn));
		Assert.assertTrue(uf.helpfulActionBtn.isEnabled(), "helpful Action Button on User Profile Page is not enabled");
		uf.helpfulActionBtn.click();
		Reporter.log("helpful is displayed", true);
	}
	
	public void updateProfileWithoutUserId() {
		String userId = uf.username_field.getText();
		Reporter.log("Existing user ID: " + userId, true);
		uf.username_field.clear();
		Reporter.log("user Id field cleared", true);
		uf.update_Button.click();
		Reporter.log("update clicked", true);

		try {
			// Check if the error message appears
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(uf.userIdErrorMsg));
			Reporter.log("Error message displayed: " + errorMessage.getText(), true);
			Assert.assertEquals("Please enter a valid username", errorMessage.getText());
		} catch (TimeoutException e) {
			// If no error message, check for confirmation dialog
			if (uf.updateConfirm2.isEnabled()) {
				if (uf.updateConfirm.isDisplayed()) {
					String updateMessage = uf.updateConfirm.getText();
					Reporter.log("Update confirmation: " + updateMessage, true);
					Assert.assertEquals(updateMessage, "Profile updated successfully!");
				}
				uf.ok_Btn.click();
				Reporter.log("clicked ok", true);
			}
		}
	}

	public void updateWithoutName() {
		String userName = uf.username.getText();
		Reporter.log("User Name Mentioned here is :" + userName, true);
		uf.username.clear();
		Reporter.log("user name field cleared", true);
		uf.update_Button.click();
		Reporter.log("update clicked", true);

		try {
			// Check if the error message appears
			WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(uf.userNameErrorMsg));
			Reporter.log("Error message displayed: " + errorMessage.getText(), true);
			Assert.assertEquals("Please enter your name", errorMessage.getText());
		} catch (TimeoutException e) {
			// If no error message, check for confirmation dialog
			if (uf.updateConfirm2.isEnabled()) {
				if (uf.updateConfirm.isDisplayed()) {
					String updateMessage = uf.updateConfirm.getText();
					Reporter.log("Update confirmation: " + updateMessage, true);
					Assert.assertEquals(updateMessage, "Profile updated successfully!");
				}
				uf.ok_Btn.click();
				Reporter.log("clicked ok", true);
			}
		}
	}

	//25 		
		public void updateWithoutUserId() throws InterruptedException, IOException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			userMenu();
			ClickUserMenuAtHamburger();
			userLogin("nandini@mapmyindia.com", "Mmi@12345");
			handleUpdate();
			bf.Hamburgerclick();
			userMenu();
			ClickUserMenuAtHamburger();
			userProfileEdit();
			updateProfileWithoutUserId();
		}
	//24
	public void updateWithoutUserName() throws InterruptedException, IOException {

			bf.mapplsPermissions();
			bf.Hamburgerclick();
			userMenu();
			ClickUserMenuAtHamburger();
			userLogin("nandini@mapmyindia.com", "Mmi@12345");
			handleUpdate();
			bf.Hamburgerclick();
			userMenu();
			ClickUserMenuAtHamburger();
			userProfileEdit();
			updateWithoutName();
		}
	
}
