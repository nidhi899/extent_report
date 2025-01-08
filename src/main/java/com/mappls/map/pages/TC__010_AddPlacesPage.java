package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__010_AddPlacesPage {

	public TC__010_AddPlacesPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Add a Place\"]")
	public @Getter WebElement addPlaceClick;
	
	@FindBy(id="com.mmi.maps:id/add_edit_place_category_input")
	public @Getter WebElement categoryInput;

	@FindBy(id="com.mmi.maps:id/add_edit_place_sub_category_input")
	public @Getter WebElement subCategoryInput;
	
	@FindBy(id="com.mmi.maps:id/add_edit_place_map_image_overlay_text")
	public @Getter WebElement markLocationOnMap;
	
	@FindBy(id="com.mmi.maps:id/choose_location_button")
	public @Getter WebElement doneBTN;
	
	@FindBy(id="com.mmi.maps:id/add_edit_place_name_input")
	public @Getter WebElement placeNameInput;

	@FindBy(className="android.widget.Button")
	public @Getter WebElement submitBTN;
	
	@FindBy(id="com.mmi.maps:id/add_edit_place_address_input")
	public @Getter WebElement enterAddress;
	
	@FindBy(id="com.mmi.maps:id/text_view_eloc_code")
	public @Getter WebElement mapplsPINGenerated;
	
	@FindBy(id="com.mmi.maps:id/image_view_cross")
	public @Getter WebElement closeIcon;
	
	@FindBy(id="com.mmi.maps:id/fragment_home_search_txt")
	public @Getter WebElement search;
	
	@FindBy(id="com.mmi.maps:id/fragment_search_text") 
//	@FindBy(id="com.mmi.maps:id/fragment_home_search_txt") 
	public @Getter WebElement searchBOXForPinVerify;

	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement searchInputForPinVerify;
	
	
	
//	===============================
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_title\"]")
	public @Getter WebElement addPlcLoginWindowTitle;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_description\"]")
	public @Getter WebElement addPlcLoginWindowDesc;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Add a Place\"]")
	public @Getter WebElement addPlacePageHeading;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement backBtn;
	
	@FindBy(xpath="//android.widget.Button[@text=\"SUBMIT\"]")
	public @Getter WebElement submitBtn;
	
	
	
	
	
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/add_edit_place_map_image_overlay_text\"]")
	public @Getter WebElement markLocation;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement floatingCrrntLOcation;
//	
//	@FindBy(xpath="//android.widget.TextView[@text=\"Add a Place\"]")
//	public @Getter WebElement addPlacePageHeading;
//	
//	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
//	public @Getter WebElement backBtn;
//	
//	@FindBy(xpath="//android.widget.Button[@text=\"SUBMIT\"]")
//	public @Getter WebElement submitBtn;
	
	
//	 share link
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement emailOkBtn;
	
	
	@FindBy(id="com.google.android.gm:id/welcome_tour_got_it")
	public @Getter WebElement welcomTour;
	
	@FindBy(id="com.google.android.gm:id/action_done")
	public @Getter WebElement takeMeToGmail;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public @Getter WebElement gAllow;
	
	@FindBy(id="com.google.android.gm:id/dismiss_button")
	public @Getter WebElement dismissBtn;
	
	
	
	@FindBy(id="com.google.android.gm:id/og_apd_internal_image_view")
	public @Getter WebElement profileLogo;
	
	@FindAll({@FindBy(id="com.google.android.gm:id/og_primary_account_information") }) 
	public @Getter List<WebElement> primryAccount;
	
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_display_name\" and @text=\"Samsung Galaxy A03s\"]")
	public @Getter WebElement smsngMailIsVisible;
	
	//========================
	@FindBy(id="com.google.android.gm:id/subject")
	public @Getter WebElement writeSubject;
	
	@FindAll({@FindBy(id="com.google.android.gm:id/subject") }) 
	public @Getter List<WebElement> uniqueSubject;
	

//	@FindAll({@FindBy(id="com.google.android.gm:id/viewified_conversation_item_view") }) 
//	public @Getter List<WebElement> sentList;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"https://mappls.com/profile/\"]")
	public @Getter WebElement clickRecivdLinkUserProfile;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/user_email_text_view\"]")
	public @Getter WebElement userEmailGet;
//	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/peoplekit_listview_contact_name\" and @text=\"galaxya03stesting@gmail.com\"]")
	public @Getter WebElement sendToMailSuggtnListClick;
		
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public @Getter WebElement emailHamburgerMenu;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/hub_drawer_label_title\" and @text=\"Spam\"]")
	public @Getter WebElement spamClick;
//	
//	
//	@FindBy(id="com.mmi.maps:id/edit_text_username")
//	public @Getter WebElement loginUName;
//	
//	@FindBy(id="com.mmi.maps:id/edit_text_email")
//	public @Getter WebElement loginUMail;
//	
//	@FindBy(id="com.mmi.maps:id/mobile_edit_text")
//	public @Getter WebElement pointMapRecievedLinkClick;

	@FindAll({@FindBy(id="com.google.android.gm:id/snippet") }) 
	public @Getter List<WebElement> pointMapRecievedLinkClick;
	
	
	
	
	
}
