package com.mappls.map.features;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import com.mappls.map.dataGenerator.RandomDataGenerator;
import com.mappls.map.pages.BasePage;
import com.mappls.map.pages.TC__008_MySavesPage;
import com.mappls.map.pages.TC__010_AddPlacesPage;
import com.mappls.map.pages.TC__018_GetMapplsPinPage;
import com.mappls.map.utils.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TC__010_AddPlacesFeature extends DriverManager{

	
	
	
	AppiumDriver<MobileElement> driver;
	BasePage bp;
	BaseFeatures bf;
	TC__010_AddPlacesPage ap;
	TC__018_GetMapplsPinFeature gp;
	TC__018_GetMapplsPinPage gpage;
	TC__008_MySavesFeature mf;
	TC__008_MySavesPage mp;
	
	public TC__010_AddPlacesFeature(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		bp = new BasePage(driver);
		bf = new BaseFeatures(driver);
		ap = new TC__010_AddPlacesPage(driver);
		gp = new TC__018_GetMapplsPinFeature(driver);
		gpage = new TC__018_GetMapplsPinPage(driver);
		mf = new TC__008_MySavesFeature(driver);
		mp = new TC__008_MySavesPage(driver);
		
			
		
	}
//	================================================
	
//	TC - 1
	public void verifyUI() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		Assert.assertEquals(ap.addPlcLoginWindowTitle.getText(), "Add a place");
		Reporter.log("'Add a place' visible", true);
		
		
		Assert.assertEquals(ap.addPlcLoginWindowDesc.getText(),
			    "Please sign in to add a place.\nSigning in allows you to publish added places post moderation.");

		
		Reporter.log("'Please sign in to add a place.\\nSigning in allows you to publish added places post moderation.' visible", true);
	}
	
	
	
//	TC - 2
	public void catAndSubCat() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		addPlaceClick();
//		=================
		Assert.assertTrue(ap.categoryInput.isDisplayed(), "Failed");
		Reporter.log("Category is visible", true);
		ap.categoryInput.click();
		List<MobileElement> categorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int listSize = categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(listSize);
			categorySelection.get(randomIndex).click();
			System.out.println("Clicked on random category selection.  - "+randomIndex);
		}
		//for subcategory selection
		Assert.assertTrue(ap.subCategoryInput.isDisplayed(), "Failed");
		Reporter.log("sub Category is visible", true);
		ap.subCategoryInput.click();
		List<MobileElement> subCategorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int subCategorySize = subCategorySelection.size();
		if (subCategorySize >= 1) {
			Random rand = new Random();
			int randomSubCategoryIndex = rand.nextInt(subCategorySize);
			subCategorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
	}
	
	
//	TC - 3
//	Check first screen of Add a Place	"1-Top of the screen should show Status bar-Time wifi/Mobile Network,
//	2-In Title bar should show- back button, Title(Heading), submit button"
	public void topNavElements() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		addPlaceClick();
		
		//add place heading
		Assert.assertEquals(ap.addPlacePageHeading.getText(), "Add a Place");
		Reporter.log("Add a Place heading is visible", true);
		
		//back button
		Assert.assertTrue(ap.backBtn.isDisplayed(), "Failed");
		Reporter.log("back button is visible", true);
		
		//submit button
		Assert.assertEquals(ap.submitBtn.getText(), "SUBMIT");
		Reporter.log("submit button is visible", true);
		
	}
	
//	TC - 4
	public void isLocationVisisble() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		addPlaceClick();
		
		Assert.assertEquals(ap.markLocation.getText(), "Mark location on map*");
		Reporter.log("Mark location on map* is visible", true);
		
		ap.markLocation.click();
	
		Assert.assertTrue(ap.floatingCrrntLOcation.isDisplayed(), "Failed");
		Reporter.log("floating current location icon is visible on map", true);
		
	}
	
	
//	TC - 5
	public void contriCountByAddingPlc() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		
		
		mf.mySavesClick();
		String text = mp.mySavesListText.get(2).getText();
		String[] parts = text.split(" ");
		String numberString = parts[0];
		int totalCount  = Integer.parseInt(numberString);
		
		System.out.println("Before add a place total contribution count :- " + totalCount );
		
		bf.back();
		bf.Hamburgerclick();
		addPlaceClick();
		
		addAPlaceForm();
		gp.markLocationClick();   
		gp.markLocationDoneBtnClick();
		bf.toastMsg("Trying to fetch your location. Please wait.");
		gp.markLocationDoneBtnClick();
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		bf.sleepWait(4);
		gp.placeNameInputClick();
		gp.submitBtn();
		
		
		ap.closeIcon.click();
		bf.Hamburgerclick();
		mf.mySavesClick();
		
		
		String text1 = mp.mySavesListText.get(2).getText();
		String[] parts1 = text1.split(" ");
		String numberString1 = parts1[0];
		int totalCount1  = Integer.parseInt(numberString1);
		
		
		bf.sleepWait(4);
		
		Assert.assertTrue(totalCount1>totalCount , "Contribution count should match the expected number");
	    Reporter.log("contribution count verified by matching contribution list size",true);
		
		
	}
	
	
	
//	TC - 6
	public void addPlcVerificationAutoSuggest() throws MalformedURLException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("9934445588", "Mvn@1234", "Login Successful");
		
		bf.Hamburgerclick();
		
		addPlaceClick();
		
		addAPlaceForm();
		gp.markLocationClick();   
		gp.markLocationDoneBtnClick();
		bf.toastMsg("Trying to fetch your location. Please wait.");
		gp.markLocationDoneBtnClick();
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		bf.sleepWait(4);
		gp.placeNameInputClick();
		gp.submitBtn();
		
		String getPin = ap.mapplsPINGenerated.getText();
		System.out.println("get generated pin : " + getPin);
		driver.quit();
//		========================================================
		
//		login with another account
		DesiredCapabilities	caps = new DesiredCapabilities();
		caps.setCapability("udid", "0002203R600009E8");
		
//		caps.setCapability("udid", "0002203R600009E8");
        caps.setCapability("deviceName", "realme C11 2021");
		
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("appPackage", "com.mmi.maps");
		caps.setCapability("appActivity", "com.mmi.maps.ui.activities.HomeScreenActivity");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();

        // Initialize AndroidDriver
        driver = new AndroidDriver<MobileElement>(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        app launched
        
        BaseFeatures bf = new BaseFeatures(driver);
        BasePage bp = new BasePage(driver);
        TC__010_AddPlacesPage ap = new TC__010_AddPlacesPage(driver);
        
        
        
        bf.mapplsPermissions();
        bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		
		bp.homeSearch.click();
		bf.homeSearchInputClick(getPin);
		
		//auto suggest verification
		WebElement suggestionListView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));

		List<WebElement> suggestionItems = suggestionListView.findElements(By.className("android.view.ViewGroup"));
		List<WebElement> getAddressText = suggestionListView.findElements(By.id("com.mmi.maps:id/auto_list_item_address"));

		Assert.assertTrue(!suggestionItems.isEmpty() && !getAddressText.isEmpty(), "No suggestions found.");
		Reporter.log("suggestions list found ", true);
		String isAddressMatched = getAddressText.get(0).getText();
		
		
		Assert.assertNotEquals(isAddressMatched, address, "Test failed because addresses are equal");
		Reporter.log("Address mismatch as expected: " + isAddressMatched, true);

//		Assert.assertEquals(isAddressMatched, address);
//		Reporter.log("address matched by mappls pin : " + isAddressMatched, true);
		
		
		
	}
	
	
	
		
	
	
	
	public void elocationGmailShare() throws MalformedURLException {
		TC__018_GetMapplsPinFeature gp = new TC__018_GetMapplsPinFeature(driver);
		TC__018_GetMapplsPinPage gpage = new TC__018_GetMapplsPinPage(driver);
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
//		bf.loginbtnHamburgerclick();
		bf.sleepWait(3);
		
		bf.visibilitys(gpage.hmbrgrGetPin);
		gpage.hmbrgrGetPin.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' on Hamburger menu.", true);
			
		
		
		bf.visibilitys(gpage.hmGetMapplsPinBTN);
		gpage.hmGetMapplsPinBTN.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' Button.", true);
		
		bf.visibilitys(gpage.getStartedBTN);
		gpage.getStartedBTN.click();
		Reporter.log("Clicked on 'Get Started' button.", true);
			
		bf.visibilitys(gpage.createMapplsPinBUTTON);
		gpage.createMapplsPinBUTTON.click();
		Reporter.log("click create mappls pin button", true);

		
		bf.visibilitys(gpage.categoryInput);
		gpage.categoryInput.click();
		Reporter.log("click category drop-down", true);

		
		int listSize = gpage.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gpage.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		

		bf.visibilitys(gpage.subCategoryInput);
		gpage.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);

		int subCategorySize = gpage.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gpage.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		
		
//		mark location

		bf.visibilitys(gpage.markLocationOnMap);
		gpage.markLocationOnMap.click();
		Reporter.log("click mark location on map", true);


		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);

		bf.toastMsg("Trying to fetch your location. Please wait.");

		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);
		
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);

		System.out.println("eloc address :- " + address);
		
//		place name input click
		Random rand = new Random();
		int rmIndex = rand.nextInt(120);
		bf.visibilitys(gpage.placeNameInput);
		gpage.placeNameInput.click();
		gpage.placeNameInput.sendKeys("Ranchi office" + rmIndex);
		Reporter.log("Clicked on the input field for the place name and enter name : "+"'Testing purpose'", true);
		
		
		bf.visibilitys(gpage.submitBTN);
		gpage.submitBTN.click();
		Reporter.log("Clicked on the 'Submit' button.", true);
		bf.sleepWait(3);
		
		bf.visibilitys(gpage.mapplsPINGenerated);
		gpage.elocShareIcon.click();
		
		bf.gshare();
		bf.sleepWait(6);
		
		String uniqueSubject = RandomDataGenerator.generateRandomPassword();
		ap.writeSubject.sendKeys(uniqueSubject);
		bf.sleepWait(3);
//		bp.fromMailIdSendBtn.click();
		
		WebElement sent = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
		bf.visibilitys(sent);
		sent.click();
		
		System.out.println("mail sent");
		
		
		bf.sleepWait(3);
//		closeApp("com.mmi.maps", "com.mmi.maps.ui.activities.HomeScreenActivity");
		
		driver.quit();
		
//		appLaunched("com.google.android.gm","com.google.android.gm.ConversationListActivityGmail");
//
//		
//		bf = new BaseFeatures(driver);
//		ap = new TC__010_AddPlacesPage(driver);
//		
//		bf.sleepWait(3);
//		ap.welcomTour.click();
//		
//		
//		
//		bf.visibilitys(ap.smsngMailIsVisible);
//		ap.takeMeToGmail.click();
//		ap.gAllow.click();
//		ap.dismissBtn.click();
//		
//		bf.sleepWait(11);
//		
//		String xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/subject' and @text='" + uniqueSubject + "']";
//		
//		WebElement isRecvdMailVisible = driver.findElement(By.xpath(xpath));
//		bf.visibilitys(isRecvdMailVisible);
//		System.out.println("recieved mail is visible :-" + isRecvdMailVisible.getText());
//
//		for (WebElement icon : ap.uniqueSubject) {
//			if (icon.getText().equalsIgnoreCase(uniqueSubject)) {
//				System.out.println("received mail is display "+icon.getText().equalsIgnoreCase(uniqueSubject));
//				icon.click(); 
//				break;
//			}
//		}
//
//		gpage.sharedElocList.get(1).click();
//		
//		String sharedEloc = gpage.elocVerification.getText();
//		System.out.println("current user name :-"+sharedEloc);
//		Assert.assertEquals(sharedEloc, address);
//		Reporter.log("User id matched ",true);
		
//		gpage.elocVerification.getText();
		
		
	}
	
//	TC - 8
	public void isLinkCorrectFormat() {
		TC__018_GetMapplsPinFeature gp = new TC__018_GetMapplsPinFeature(driver);
		TC__018_GetMapplsPinPage gpage = new TC__018_GetMapplsPinPage(driver);
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
//		bf.loginbtnHamburgerclick();
		bf.sleepWait(3);
		
		bf.visibilitys(gpage.hmbrgrGetPin);
		gpage.hmbrgrGetPin.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' on Hamburger menu.", true);
			
		
		
		bf.visibilitys(gpage.hmGetMapplsPinBTN);
		gpage.hmGetMapplsPinBTN.click();
		Reporter.log("Clicked on the 'Get Mappls Pin' Button.", true);
		
		bf.visibilitys(gpage.getStartedBTN);
		gpage.getStartedBTN.click();
		Reporter.log("Clicked on 'Get Started' button.", true);
			
		bf.visibilitys(gpage.createMapplsPinBUTTON);
		gpage.createMapplsPinBUTTON.click();
		Reporter.log("click create mappls pin button", true);

		
		bf.visibilitys(gpage.categoryInput);
		gpage.categoryInput.click();
		Reporter.log("click category drop-down", true);

		
		int listSize = gpage.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gpage.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		

		bf.visibilitys(gpage.subCategoryInput);
		gpage.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);

		int subCategorySize = gpage.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gpage.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		
		
//		mark location

		bf.visibilitys(gpage.markLocationOnMap);
		gpage.markLocationOnMap.click();
		Reporter.log("click mark location on map", true);


		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);

		bf.toastMsg("Trying to fetch your location. Please wait.");

		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);
		
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);

		System.out.println("eloc address :- " + address);
		
//		place name input click
		Random rand = new Random();
		int rmIndex = rand.nextInt(120);
		bf.visibilitys(gpage.placeNameInput);
		gpage.placeNameInput.click();
		gpage.placeNameInput.sendKeys("Ranchi office" + rmIndex);
		Reporter.log("Clicked on the input field for the place name and enter name : "+"'Testing purpose'", true);
		
		
		bf.visibilitys(gpage.submitBTN);
		gpage.submitBTN.click();
		Reporter.log("Clicked on the 'Submit' button.", true);
		bf.sleepWait(3);
		
		bf.visibilitys(gpage.mapplsPINGenerated);
		gpage.elocShareIcon.click();
		
		Assert.assertTrue(false,"Failed to display share bottom sheet");
		Reporter.log("gmail share display in the bottom sheet of the screen");
		
	}
	
	
	
	
	
	
	
	
//	================================
	
	
	
	
	
	
	
	
//	================================================
	
	public void addPlaceClick() {
		ap.addPlaceClick.click();	
		Reporter.log("add place click",true);	
		bf.sleepWait(3);
	}

	public void addAPlaceWithOutLogin() throws InterruptedException {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		boolean isLoggedIn = bp.loginBTNMsg.isDisplayed();
		Assert.assertTrue(isLoggedIn, "Failed");
		Reporter.log("login first to add places and generate mappls pin" , true);
	}


	public void addPlaceWithLoginCredential() {
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		addPlaceClick();
		bf.mapplsLogin("nidhi1234", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		addPlaceClick();
		addAPlaceForm();


		gp.markLocationClick();   
		gp.markLocationDoneBtnClick();
		bf.toastMsg("Trying to fetch your location. Please wait.");
		gp.markLocationDoneBtnClick();
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);
		bf.sleepWait(4);
		gp.placeNameInputClick();
		gp.submitBtn();
		String mapplsPIN = gpage.mapplsPINGenerated.getText();
		System.out.println("Got the generated map pin: " + mapplsPIN);
		gp.closeIconClick();
		bf.homeSearchClick();
		bf.homeSearchInputClick(mapplsPIN);
		
		
		WebElement suggestionListView = driver.findElement(By.id("com.mmi.maps:id/suggestion_listView"));

		List<WebElement> suggestionItems = suggestionListView.findElements(By.className("android.view.ViewGroup"));
		List<WebElement> getAddressText = suggestionListView.findElements(By.id("com.mmi.maps:id/auto_list_item_address"));

		Assert.assertTrue(!suggestionItems.isEmpty() && !getAddressText.isEmpty(), "No suggestions found.");
		Reporter.log("suggestions list found ", true);
		String isAddressMatched = getAddressText.get(0).getText();
		Assert.assertEquals(isAddressMatched, address);
		Reporter.log("address matched by mappls pin : " + isAddressMatched, true);
	}
	
	


	public void addAPlaceForm()  {
		//for category selection
		ap.categoryInput.click();
		List<MobileElement> categorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int listSize = categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(listSize);
			categorySelection.get(randomIndex).click();
			System.out.println("Clicked on random category selection.  - "+randomIndex);
		}
		//for subcategory selection
		ap.subCategoryInput.click();
		List<MobileElement> subCategorySelection = driver.findElements(By.className("android.widget.RadioButton"));
		int subCategorySize = subCategorySelection.size();
		if (subCategorySize >= 1) {
			Random rand = new Random();
			int randomSubCategoryIndex = rand.nextInt(subCategorySize);
			subCategorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
	}


	
	
	
	//share add a place mappls pin 
	public void elocationAddPlcGmailShare() throws MalformedURLException {
		TC__018_GetMapplsPinFeature gp = new TC__018_GetMapplsPinFeature(driver);
		TC__018_GetMapplsPinPage gpage = new TC__018_GetMapplsPinPage(driver);
		
		bf.mapplsPermissions();
		bf.Hamburgerclick();
		bf.simpleHamburgerLogin("9934445588", "Mvn@1234", "Login Successful");
		bf.Hamburgerclick();
		
		ap.addPlaceClick.click();
		
		
		Reporter.log("Clicked on the 'Add a Place' on Hamburger menu.", true);
			
		gpage.categoryInput.click();
		Reporter.log("click category drop-down", true);

		
		int listSize = gpage.categorySelection.size();
		if (listSize >= 1 && listSize <= 16) {
			Random rand = new Random();
			int rmIndex = rand.nextInt(listSize);
			gpage.categorySelection.get(rmIndex).click();
			Reporter.log("Clicked on random category selection.  - "+rmIndex, true);
		}
		

		bf.visibilitys(gpage.subCategoryInput);
		gpage.subCategoryInput.click();
		Reporter.log("click sub-category drop-down", true);

		int subCategorySize = gpage.categorySelection.size();
		if (subCategorySize >= 1) {
			Random rmSub = new Random();
			int randomSubCategoryIndex = rmSub.nextInt(subCategorySize);
			gpage.categorySelection.get(randomSubCategoryIndex).click();
			System.out.println("Clicked on random subcategory selection. - " + randomSubCategoryIndex);
		}
		
		
//		mark location

		bf.visibilitys(gpage.markLocationOnMap);
		gpage.markLocationOnMap.click();
		Reporter.log("click mark location on map", true);


		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);

		bf.toastMsg("Trying to fetch your location. Please wait.");

		bf.visibilitys(gpage.doneBTN);
		gpage.doneBTN.click();
		Reporter.log("click mark location done button ", true);
		
		String address = gpage.enterAddress.getText();
		Reporter.log("Got the address: " + address, true);

		System.out.println("eloc address :- " + address);
		
//		place name input click
		Random rand = new Random();
		int rmIndex = rand.nextInt(120);
		bf.visibilitys(gpage.placeNameInput);
		gpage.placeNameInput.click();
		gpage.placeNameInput.sendKeys("Ranchi office" + rmIndex);
		Reporter.log("Clicked on the input field for the place name and enter name : "+"'Testing purpose'", true);
		
		
		bf.visibilitys(gpage.submitBTN);
		gpage.submitBTN.click();
		Reporter.log("Clicked on the 'Submit' button.", true);
		bf.sleepWait(3);
		
		bf.visibilitys(gpage.mapplsPINGenerated);
		gpage.elocShareIcon.click();
		Reporter.log("eloc share icon clicked", true);
		
		//gmail share
		bp.gmailShare.click();
		Reporter.log("Gmail share clicked", true);
		
		
//		bf.gshare();
//		String uniqueSubject = RandomDataGenerator.generateRandomPassword();
//		ap.writeSubject.sendKeys(uniqueSubject);
//		bf.sleepWait(3);
//		
//		WebElement sent = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
//		bf.visibilitys(sent);
//		sent.click();
		
		
		
		
	}

}