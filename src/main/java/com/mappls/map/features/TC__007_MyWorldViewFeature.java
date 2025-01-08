package com.mappls.map.features;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__007_MyWorldViewPage;
import com.mappls.map.pages.TC__019_UserProfilePage;
import com.mappls.map.pages.TC__020_MapLayerPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class TC__007_MyWorldViewFeature {
	

	AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;
	TC__007_MyWorldViewPage mww;
	TC__019_UserProfilePage uf;
	BaseFeatures bf;
	BasePage bp;
	TC__019_UserProfileFeature upf;
	TC__020_MapLayerPage mp;
	TC__020_MapLayerFeature ml;
	

	public TC__007_MyWorldViewFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		mww = new TC__007_MyWorldViewPage(driver);
		uf = new TC__019_UserProfilePage(driver);
		bf = new BaseFeatures(driver);
		upf = new TC__019_UserProfileFeature(driver);
	    bp  = new BasePage(driver);
	    mp = new TC__020_MapLayerPage(driver);
	    ml = new TC__020_MapLayerFeature(driver);
	}

	public void worldViewMenu() {
        bf.visibility(mww.myworldViewMenu,"My World View In Menu");
        bf.visibility(mww.worldViewtext,"World view text");
        String text = mww.worldViewtext.getText();
		Reporter.log("found text : " +text, true);
		mww.myworldViewMenu.click();
		Reporter.log("My World View In Menu Clicked.", true);

	}

	public void myWorldViewListPlaceDetail() {

		try {
	        wait.until(ExpectedConditions.visibilityOf(mww.btmMainLayout));
	        Assert.assertTrue(mww.btmMainLayout.isDisplayed(), "Main layout is not displayed");
	        Reporter.log("Main layout is displayed", true);

	        if (mww.poiListLayout.isDisplayed()) {
	            Reporter.log("Points of interest list layout is displayed", true);

	            wait.until(ExpectedConditions.visibilityOf(mww.poiMainLayout));
	            Assert.assertTrue(mww.poiMainLayout.isDisplayed(), "POI main layout is not displayed");
	            mww.poiMainLayout.click();
	            Reporter.log("Item displayed related to world view is clicked.", true);

	            String detailOfReview = uf.reviewedplaceDesc.getText();
	            Reporter.log("Reviewed : " +detailOfReview, true);
	            
	            Assert.assertTrue(detailOfReview.toLowerCase().contains("reported") ||detailOfReview.toLowerCase().contains("posted") ||detailOfReview.toLowerCase().contains("reviewed"),"Detail of review does not contain 'reported' or 'posted' or 'reviewed'.");
                Reporter.log("Detail of review contains 'reported' or 'posted'.", true);
      
	            String dateR = uf.reviewDate.getText();
	            Reporter.log("On Date: " +dateR, true);
	        } else {
	            Assert.fail("Points of interest list layout is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        Assert.fail("An expected element was not found: " + e.getMessage());
	    } catch (Exception e) {
	        Assert.fail("An unexpected exception occurred: " + e.getMessage());
	    }
	}
 
	public void checkflag() {	
		try {
			wait.until(ExpectedConditions.visibilityOf(mww.flag));
			Assert.assertTrue(mww.flag.isDisplayed(), "flag button should be displayed");

			String flagText = mww.flag.getText().trim();
	        Reporter.log("Flag button text: " + flagText, true);

	        if (flagText.equalsIgnoreCase("Flagged")) {
	            Reporter.log("this is already been flagged. The flag process was successful.", true);
	            Assert.assertTrue(true, "Flag button text is 'Flagged'. Flag is successful.");
	        } else if (flagText.equalsIgnoreCase("Flag")) {
	            Reporter.log("Place flag process is not successful.", true);
	            Assert.fail("Place flag is not successful");
	        } else {
	            // If the text does not match either option, fail the test
	            Assert.fail("Flag button text is neither 'Flag' nor 'Flagged'.");
	        }
		} catch (AssertionError e) {
			Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
		}
	}
	
	
	public void clickFlag() {	
		try {
	        wait.until(ExpectedConditions.visibilityOf(mww.flag));
			Assert.assertTrue(mww.flag.isDisplayed(), "flag button should be displayed");

	        String flagText = mww.flag.getText().trim();
	        Reporter.log("Flag button text: " + flagText, true);
	        // Check the text of the button, ignoring case
	        if (flagText.equalsIgnoreCase("Flag")) {
	            Reporter.log("Place is not flagged yet. Proceeding with the flag.", true);
	            mww.flag.click();
	            Reporter.log("Clicked on flag.", true);
	        } else if (flagText.equalsIgnoreCase("Flagged")) {
	            Reporter.log("Listed item already been flagged. Proceeding with flag again.", true);
	            mww.flag.click();
	            Reporter.log("Clicked on flag to flagged again.", true);
	        } else {
	            Assert.fail("button text is neither 'Flag' nor 'Flagged'.");
	        }
	        bf.sleepWait(2);
	    } catch (Exception e) {
	        Assert.fail("Test failed due to an unexpected exception: " + e.getMessage());
	    }
	}

	public void myWorldViewFlagReport() {
		Reporter.log(mww.violationfield.getText(), true);
		mww.violationfield.click();
		bf.sleepWait(2);
		wait.until(ExpectedConditions.visibilityOf(mww.violationImageBoxTitle));
		bf.sleepWait(4);
		Reporter.log("Dialog box appears for: " + mww.violationImageBoxTitle.getText(), true);
		mww.optionOthers.click();
		Reporter.log("Selected option: " + mww.violationfield.getText(), true);
		bf.sleepWait(2);
		mww.violationDesc.click();
		mww.descText.sendKeys("Testing purpose");
		mww.doneBtn.click();
		Reporter.log("Done Button clicked.", true);
		String snackBarMsg = mww.snackBarMessage.getText();
		Reporter.log("SnackBar Message: " + snackBarMsg, true);
		Assert.assertEquals(snackBarMsg, "Request submitted successfully");
		mww.backBtn.click();
		bf.sleepWait(2);
	}

	public void RequiredLoginBox() {
		wait.until(ExpectedConditions.visibilityOf(mww.parentPanel));
		if (mww.parentPanel.isEnabled()) {
			String titleInfo = mww.title.getText();
			String descInfo = mww.description.getText();
			Reporter.log("Displayed Box Title: " + titleInfo, true);
			Reporter.log("Displayed Box Description: " + descInfo, true);
			Assert.assertEquals(descInfo, "Please sign in to participate in community activities.");
			mww.loginBtns.click();
			Reporter.log("Login Button Clicked.", true);
			bf.sleepWait(2);
		}

	}
	public void inviteCardVisibility() {
		wait.until(ExpectedConditions.visibilityOf(uf.inviteCard));
        Assert.assertTrue(uf.inviteCard.isEnabled(), "Invite card is not enabled");
		if (uf.inviteCard.isEnabled()) {	
			Reporter.log("Invite Card Message :" + uf.inviteCardText1.getText() + ","
					+ uf.inviteCardText2.getText(), true);
			wait.until(ExpectedConditions.visibilityOf(uf.contacts_display));
	        Assert.assertTrue(uf.contacts_display.isEnabled(), "Contacts display is not enabled");
			if (uf.contacts_display.isEnabled())
				Reporter.log("List of Possible contacts Displayed", true);
		} 
	}

	public void myWorldViewAddContact() {
		uf.shareContact.click();
		Reporter.log("Clicked share contact.", true);
		if (uf.sync_now.isDisplayed()) {
			uf.sync_now.click();
			Reporter.log("Sync now clicked.", true);
			bf.sleepWait(2);
			wait.until(ExpectedConditions.visibilityOf(uf.allow_button));
			uf.allow_button.click();
			Reporter.log("Allow clicked.", true);
			bf.toastMsg("Contacts synced successfully");
			wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
	        Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");
			if (uf.searchContact.isEnabled()) {
				inviteCardVisibility();
			}
		} else if (uf.contacts_display.isDisplayed()) {
			uf.sync.click();
			Reporter.log("Sync clicked.", true);
			bf.toastMsg("Contacts synced successfully");
			wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
	        Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");

			if (uf.searchContact.isEnabled()) {
				inviteCardVisibility();
			}
		}
	}

	
	public void myWorldViewShareLink() {
		uf.shareReview.click();
		Reporter.log("Clicked share.", true);
		upf.shareLinkTextFetch();
	}
	
	public void myWorldViewHelpful() {
		wait.until(ExpectedConditions.visibilityOf(mww.helpful));
		Assert.assertTrue(mww.helpful.isDisplayed(), "Helpful button should be displayed");
		String text = mww.helpful.getText();
		Reporter.log("Text : " +text , true );
		Assert.assertEquals(text.toLowerCase(), "Helpful".toLowerCase());
		Reporter.log("Helpful displayed.", true);
	}
	

	public void myWorldViewListedplacedetail() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
	}

	public void myWorldViewShareText() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
		myWorldViewShareLink();
	}
 
	public void myWorldViewFlagViolation() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
		clickFlag();
		myWorldViewFlagReport();
		mww.poiMainLayout.click();
		checkflag();
	}

	public void myWorldViewFlagWL() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
		clickFlag();
		bf.RequiredLoginBox("Flag a Post / Review");
	}

	public void myWorldViewContactSync() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewAddContact();
	}
	
	public void helpful() throws IOException, InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		upf.userMenu();
		upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
		upf.handleUpdate();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
		myWorldViewHelpful();		
	}	
	
	public void helpfulGuest() throws IOException, InterruptedException  {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		worldViewMenu();
		myWorldViewListPlaceDetail();
		myWorldViewHelpful();
		mww.helpful.click();
		bf.RequiredLoginBox("Make Review/Post as helpful");
	}
	 public void contactSyncGuest() throws IOException, InterruptedException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			worldViewMenu();
			wait.until(ExpectedConditions.visibilityOf(uf.shareContact));
	        Assert.assertTrue(uf.shareContact.isEnabled(), "Add contact is not enabled");
			uf.shareContact.click();
			bf.RequiredLoginBox("Login Required");
	 }
	 
	 public void FlagGuest() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			myWorldViewListPlaceDetail();
			clickFlag();
			RequiredLoginBox();
			bf.RequiredLoginBox("Flag a Post/Review");
	 }
	 
	 public void BackButton() throws IOException, InterruptedException {
		 bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			wait.until(ExpectedConditions.visibilityOf(mww.btmMainLayout));
		    Assert.assertTrue(mww.btmMainLayout.isDisplayed(), "Main layout is not displayed");
	        Reporter.log("Main layout is displayed", true);		 
		    wait.until(ExpectedConditions.visibilityOf(mww.myworldviewbackbtn));
		    Assert.assertTrue(mww.myworldviewbackbtn.isDisplayed(), "Back Button on toolbar is not displayed");
			mww.myworldviewbackbtn.click();

			wait.until(ExpectedConditions.visibilityOf(bp.hamburgerIconClick));
			  
		    Assert.assertTrue(bp.hamburgerIconClick.isDisplayed(), "Failed");
	 }
	 
	 public void toolbarVisibility() {
		     wait.until(ExpectedConditions.visibilityOf(mww.toolbarText));
		    Assert.assertTrue(mww.toolbarText.isDisplayed(), "Toolbar Text is not displayed");
		    String actualText = "My World View";
		    String foundText = mww.toolbarText.getText(); 
		    Assert.assertEquals(actualText.toLowerCase(),foundText.toLowerCase(),"text did not match");
		    Reporter.log("ToolBar text displayed :" +foundText , true); 
	 }
	 
	 public void menuContactVisibility() {
		  wait.until(ExpectedConditions.visibilityOf(mww.menu_contact));
		    Assert.assertTrue(mww.menu_contact.isDisplayed(), "Add Contact Icon is not displayed");
		    Reporter.log("Menu Contact is  displayed .", true);
	 }
	 
	 public void mapLayerButtonVisibility() {
		 wait.until(ExpectedConditions.visibilityOf(mww.mapLayerButton));
		    Assert.assertTrue(mww.mapLayerButton.isDisplayed(), "Map Layer Button is not displayed");
		    Reporter.log("Map Layer Button is displayed .", true);
	 }
	 
	 public void currentLocButtonVisibility() {
		 wait.until(ExpectedConditions.visibilityOf(mww.currentLocButton));
		    Assert.assertTrue(mww.currentLocButton.isDisplayed(), "Current Location Button is not displayed");
		    Reporter.log("Current Location Button is displayed" , true);
	 }
	 

//		@Test(priority = 1) Check UI for My World View	UI for all screen should be properly visible and function should work properly
		public void myWorldViewUI() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			toolbarVisibility();
			menuContactVisibility();
			mapLayerButtonVisibility();
			currentLocButtonVisibility();
		    myWorldViewListPlaceDetail();
		    bf.visibility(mww.helpful,"Helpful");
		    bf.visibility(mww.flag,"Flag");
		    bf.visibility(mww.share,"Share");
		    Reporter.log("Options found in the bottom layout are : 1 " +mww.helpful.getText()+"   2 "+mww.flag.getText()+"   3 "+mww.share.getText()+"  ",true);
		}
		
//		@Test(priority = 2)Verify that back button is working properly	User should be able to use back button ,it should be clickable
		public void myWorldViewBackButton() throws IOException, InterruptedException{
			BackButton();
		}
		
//		@Test(priority = 3)
		public void myWorldViewcontactsync() throws IOException, InterruptedException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewAddContact();
		}
		
		 public void testRecyclerViewContactText(String expectedText) {
		        MobileElement recyclerView = driver.findElement(By.id("com.mmi.maps:id/sc_contacts_rcv"));
    		    Reporter.log("Contact  to be searched is : " +expectedText, true);

		        List<MobileElement> viewGroups = recyclerView.findElements(By.xpath("//android.view.ViewGroup"));
		        boolean textFound = false;
		        for (MobileElement viewGroup : viewGroups) {
		       
		            MobileElement linearLayout = viewGroup.findElement(By.xpath(".//android.widget.LinearLayout"));

		            MobileElement textView = linearLayout.findElement(By.id("com.mmi.maps:id/ci_name_tv"));

		            if (textView.getText().equals(expectedText)) {
		                textFound = true;		                
		    		    Reporter.log("Searched Contact is Displayed : " +textView.getText(), true);
		                break;
		            }
		        }
		        Assert.assertTrue(textFound, "The expected text '" + expectedText + "' was not found in the RecyclerView.");
		    }
		
//		@Test(priority = 4)Verify the Search contacts search box is working properly	User should be able to search his contact by typing a name in the search box
		public void myWorldViewSearchContact() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();	
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewAddContact();
			wait.until(ExpectedConditions.visibilityOf(mww.searchContact));
		    Assert.assertTrue(mww.searchContact.isDisplayed(), "Search Contact is not displayed");
		    mww.searchContact.sendKeys("Muskan");
		    wait.until(ExpectedConditions.visibilityOf(mww.contactList));
		    Assert.assertTrue(mww.contactList.isDisplayed(), "Contact  List is not displayed");
		    testRecyclerViewContactText("Muskan");
		    
		}
		
		public void denyContactPermission() {
			if (uf.sync_now.isDisplayed()) {
				uf.sync_now.click();
				Reporter.log("Sync now clicked.", true);
				bf.sleepWait(2);
				bf.visibility(mww.controllerbox,"Permission box");			
				bf.visibility(mww.permissionMessage,"Allow Contacts Message");
			    String message = mww.permissionMessage.getText(); 
                Reporter.log("Actual Message :" +message ,true);
				String expected = "Allow Mappls MapmyIndia to access your contacts?";
				Reporter.log("Expected message :" +expected,true);
				Assert.assertEquals(message, expected, "The permission message does not match the expected text.");				
				bf.visibility(uf.allow_button,"Allow Option");
				bf.visibility(uf.deny_button,"Deny Option");
		        uf.deny_button.click();
		        Reporter.log("Dont allow clicked.", true);	        
		        bf.visibility(mww.contactPermissionTitle,"Contact Permission");
				Reporter.log("title : "+mww.contactPermissionTitle.getText(),true);
				bf.visibility(mww.contactPermissionDesc,"contact permission description");
				Reporter.log("descripton : "+mww.contactPermissionDesc.getText(),true);
				bf.visibility(mww.cancelButton,"Cancel option");
				bf.visibility(mww.continueButton,"Continue option");
				Reporter.log("options found :  1 "+mww.cancelButton.getText()+"   2 "+mww.continueButton.getText(),true);
				mww.cancelButton.click();
				
		        bf.visibility(uf.sync_now,"Sync Now Option");
		    	
			}else if (uf.contacts_display.isDisplayed()) {
				uf.sync.click();
				Reporter.log("Sync clicked.", true);
				bf.toastMsg("Contacts synced successfully");
				wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
		        Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");

				if (uf.searchContact.isEnabled()) {
					inviteCardVisibility();
				}
			}

		}
		public void contactPermission() {
			if (uf.sync_now.isDisplayed()) {
				uf.sync_now.click();
				Reporter.log("Sync now clicked.", true);
				bf.sleepWait(2);
				wait.until(ExpectedConditions.visibilityOf(mww.controllerbox));
		        Assert.assertTrue(mww.controllerbox.isEnabled(), "Permission box is not enabled");

				wait.until(ExpectedConditions.visibilityOf(mww.permissionMessage));
		        Assert.assertTrue(mww.permissionMessage.isEnabled(), "Allow Contacts Message is not enabled");
                String message = mww.permissionMessage.getText(); 
                Reporter.log("Actual Message :" +message ,true);
				String expected = "Allow Mappls MapmyIndia to access your contacts?";
				Reporter.log("Expected message :" +expected,true);
				Assert.assertEquals(message, expected, "The permission message does not match the expected text.");

				wait.until(ExpectedConditions.visibilityOf(uf.allow_button));
		        Assert.assertTrue(uf.allow_button.isEnabled(), "Allow Button is not enabled");

				uf.allow_button.click();
				Reporter.log("Allow clicked.", true);

				bf.toastMsg("Contacts synced successfully");
				
			}else if (uf.contacts_display.isDisplayed()) {
				uf.sync.click();
				Reporter.log("Sync clicked.", true);
				bf.toastMsg("Contacts synced successfully");
				wait.until(ExpectedConditions.visibilityOf(uf.searchContact));
		        Assert.assertTrue(uf.searchContact.isEnabled(), "Search contact is not enabled");

				if (uf.searchContact.isEnabled()) {
					inviteCardVisibility();
				}
			}
		}
			
//	5
		public void myWorldViewContactPermission() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			menuContactVisibility();
			mww.menu_contact.click();
			contactPermission();			
		}
		
//		 6
		public void myWorldViewMapplsNotification() throws IOException, InterruptedException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			uf.shareContact.click();
			Reporter.log("Clicked share contact.", true);
			denyContactPermission();		
			contactPermission();
		}
		
//	7
		public void myWorldViewMMIMap() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			mapLayerButtonVisibility();
			mww.mapLayerButton.click();
			bf.sleepWait(2);
			ml.maplayersVerfication(1 , "Default Map already selected");
		}
		
//		8
		public void myWorldViewHybridSatellite() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			mapLayerButtonVisibility();
			mww.mapLayerButton.click();
			mp.satelliteMap.click();
			bf.sleepWait(2);
			ml.maplayersVerfication(2, "Satellite Map");
		}
//	 9
		public void myWorldView3DMAp() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			mapLayerButtonVisibility();
			mww.mapLayerButton.click();
			wait.until(ExpectedConditions.visibilityOf(mww.threeDContainer));
		    Assert.assertTrue(mww.threeDContainer.isDisplayed(), "3 D Container is not displayed");
			String text = mww.ThreeDText.getText();
			Reporter.log("text Displayed at 3 D Container: " +text, true);
			wait.until(ExpectedConditions.visibilityOf(mww.switchToggle));
		    Assert.assertTrue(mww.switchToggle.isDisplayed(), "3 D Container Switch is not displayed");
		    
		    mww.switchToggle.click();
			boolean isSelected = mww.switchToggle.getAttribute("checked").equals("true");
			if (isSelected) {
			    Reporter.log("3D View is selected.", true);
			    Assert.assertTrue(isSelected, "3D View should be selected, but it is not.");
			} else {
			    Reporter.log("3D View is not selected.", true);
			    Assert.fail("3D View is not selected.");
			}
			
		}
		
//	 10
		public void myWorldViewReviewDetailPage()throws IOException, InterruptedException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewListPlaceDetail();
		}
		
		public boolean isNotDisplay(WebElement element) {
			try {
				return element.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}

		public void help() {
			boolean isElementFound = false;
			String initialCount ="0";

//						for (int i = 0; i < 1; i++) {
			if (bf.isElementVisible(mww.helpfulText)) {
				isElementFound = true;
				System.out.println("element found : "+ isElementFound );

				initialCount = mww.helpfulText.getText();
				int beforeClick = Integer.parseInt(initialCount);
				Reporter.log("Initial helpful text count: " + initialCount,true);

				// Click the helpful button
				mww.helpful.click();
				// Verify the count increased by 1
				String newCount = mww.helpfulText.getText();
				int aftrClick = Integer.parseInt(newCount);

//				Assert.assertTrue(beforeClick < aftrClick,"Failed" );
				Reporter.log("before : " + beforeClick + " after : "+ aftrClick, true);
			    if(beforeClick < aftrClick) {
			    	Reporter.log("Clicked by me", true);
			    } else if(beforeClick > aftrClick){
			    	Reporter.log("dfgpppppppppppppppppppphjk", true);
			    } else if (!bf.isElementVisible(mww.helpfulText)) {
			    	mww.helpful.click();
					// Get the count and verify it is 1
					String newCounts = mww.helpfulText.getText();
					int crrntCont = Integer.parseInt(newCounts);
					bf.sleepWait(3);
					Assert.assertEquals(1,crrntCont,"count does not match");
					Reporter.log("passhhhhhhhhhhhhhhhhhhhh", true);
			    }		
			} else {

					bf.sleepWait(1);
					mww.helpful.click();
					// Get the count and verify it is 1
					String newCount = mww.helpfulText.getText();
					int crrntCont = Integer.parseInt(newCount);
					bf.sleepWait(3);
					Assert.assertEquals(1,crrntCont,"count does not match");
					Reporter.log("pass", true);

				}
//			}


			//         String value = "1";
			//         if (newCount == value) {
			//             Reporter.log("Helpful text appeared with count 1.",true);
			//             mww.helpful.click();
			//         } else {
			//        	 Reporter.log("Test case failed: Helpful text count is not 1 after making it visible.",true);
			//         }
		}

		public void help2() {
		    boolean isElementFound = false;
		    String initialCount = "0";

		    if (bf.isElementVisible(mww.helpfulText)) {
		        isElementFound = true;
		        System.out.println("element found: " + isElementFound);

		        initialCount = mww.helpfulText.getText();
		        int beforeClick = Integer.parseInt(initialCount);
		        Reporter.log("Initial helpful text count: " + initialCount, true);

		        // Click the helpful button
		        mww.helpful.click();
		        bf.sleepWait(2);

		        // Verify if the helpful text is still visible
		        if (bf.isElementVisible(mww.helpfulText)) {
		            // If still visible, get the updated count
		            String newCount = mww.helpfulText.getText();
		            int afterClick = Integer.parseInt(newCount);
		            Reporter.log("before: " + beforeClick + " after: " + afterClick, true);

		            if (beforeClick < afterClick) {
		                Reporter.log("Clicked by me and count increased", true);
		            } else if (beforeClick > afterClick) {
		                Reporter.log("Count decreased unexpectedly", true);
		            } else {
		                Reporter.log("Count did not change after click", true);
		            }
		        } else {
		            Reporter.log("Helpful text disappeared after click", true);
		            Assert.fail("Helpful text is no longer visible after clicking the button");
		        }
		    } else {
		        Reporter.log("Helpful text not found initially", true);

		        bf.sleepWait(1);
		        mww.helpful.click();
		        bf.sleepWait(2);

		        // Check if the helpful text becomes visible after clicking
		        if (bf.isElementVisible(mww.helpfulText)) {
		            String newCount = mww.helpfulText.getText();
		            int currentCount = Integer.parseInt(newCount);
		            Assert.assertEquals(1, currentCount, "Count does not match after initial click");
		            Reporter.log("Helpful text appeared after click with count: " + currentCount, true);
		        } else {
		            Reporter.log("Helpful text is still not visible after clicking", true);
		            Assert.fail("Helpful text did not appear after clicking the button");
		        }
		    }
		}


  
//		11
		public void myWorldViewLike() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("9142877242", "Mmi@12345");
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewListPlaceDetail();
			help2();			
		}
		
		
//		12
		public void myWorldViewUnlike() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();			
			upf.userLogin("9142877242", "Mmi@12345");
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewListPlaceDetail();
			help2();
		
		}
		
//		 13
		public void myWorldViewFlag() throws IOException, InterruptedException {
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewListPlaceDetail();
			clickFlag();
			myWorldViewFlagReport();
			mww.poiMainLayout.click();
			checkflag();
		}
		
//	 14
		public void myWorldViewFollow() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewAddContact();
		}
		
//		15
		public void myWorldViewUnfollow() throws IOException, InterruptedException{
			bf.mapplsPermissions();
			bf.Hamburgerclick();
			upf.userMenu();
			upf.UserClickOnHamburgerMenu();
			upf.userLogin("nandini@mapmyindia.com", "Mmi@12345");
			upf.handleUpdate();
			bf.Hamburgerclick();
			worldViewMenu();
			myWorldViewAddContact();
		}
}
