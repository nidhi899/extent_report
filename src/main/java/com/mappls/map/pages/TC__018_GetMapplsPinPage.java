package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import lombok.Getter;

public class TC__018_GetMapplsPinPage {
	public TC__018_GetMapplsPinPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//android.widget.TextView[@text=\"6-character pin code for every doorstep\"]")
	public @Getter WebElement getPinClick;


	@FindBy(id="com.mmi.maps:id/text_view_get_eloc")
	public @Getter WebElement getPinBTN;

	@FindBy(id="com.mmi.maps:id/text_view_get_eloc_started")
	public @Getter WebElement getStartedBTN;	

	@FindBy(id="com.mmi.maps:id/create_mappls_pin_1")
	public @Getter WebElement createMapplsPinBTN;	

	@FindBy(id="com.mmi.maps:id/fragment_search_text")
	public @Getter WebElement searchBox;

	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement searchInput;

	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/auto_list_icon\"])[2]") 
	public @Getter List<MobileElement> suggestionPlaceList;

	//3rd approach
	@FindBy(id="(com.mmi.maps:id/text_view_show_mappls_pin")
	public @Getter WebElement showMapplsPinBTN;

	@FindBy(id="com.mmi.maps:id/text_view_mappls_pin")
	public @Getter WebElement getMapplsPin;

	@FindBy(id="com.mmi.maps:id/text_view_place_name")
	public @Getter WebElement getPlace;


	@FindBy(id="com.mmi.maps:id/text_view_place_address")
	public @Getter WebElement getPlaceAddress;
	//----------------------------

	//create pin 
	@FindBy(id="com.mmi.maps:id/create_mappls_pin_1")
	public @Getter WebElement createMapplsPinBUTTON;

	@FindBy(id="com.mmi.maps:id/add_edit_place_category_input")
	public @Getter WebElement categoryInput;

	@FindBy(id="com.mmi.maps:id/add_edit_place_sub_category_input")
	public @Getter WebElement subCategoryInput;

	@FindBy(id="com.mmi.maps:id/add_edit_place_name_input")
	public @Getter WebElement placeNameInput;

	@FindBy(className="android.widget.Button")
	public @Getter WebElement submitBTN;

	@FindBy(id="com.mmi.maps:id/add_edit_place_address_input")
	public @Getter WebElement enterAddress;

	@FindBy(id="com.mmi.maps:id/add_edit_place_map_image_overlay_text")
	public @Getter WebElement markLocationOnMap;

	@FindBy(id="com.mmi.maps:id/point_on_map_address_txt")
	public @Getter WebElement getAddressText;

	@FindBy(id="com.mmi.maps:id/choose_location_button")
	public @Getter WebElement doneBTN;

	@FindBy(id="com.mmi.maps:id/text_view_eloc_code")
	public @Getter WebElement mapplsPINGenerated;

	@FindBy(id="com.mmi.maps:id/image_view_cross")
	public @Getter WebElement closeIcon;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/title\"]") 
	public @Getter WebElement autoList;

	@FindBy(id="android.widget.TextView")
	public @Getter WebElement getAd;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_address\"]")
	public @Getter WebElement getFullAddress;

	@FindBy(id="com.mmi.maps:id/place_eloc")
	public @Getter WebElement pin;

	@FindBy(id="com.mmi.maps:id/fragment_home_search_txt")
	public @Getter WebElement homeSearch;

	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement homeSearchInput;

	@FindBy(id="com.mmi.maps:id/fragment_search_text")
	public @Getter WebElement searchBOXForPinVerify;

	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement searchInputForPinVerify;

	@FindBy(className="android.widget.RadioButton")
	public @Getter List<WebElement> ctSelection;

	@FindAll({ @FindBy(className = "android.widget.RadioButton")})
	public @Getter List<WebElement> categorySelection;
	
	
	@FindAll({ @FindBy(className = "android.widget.RadioButton")})
	public @Getter List<WebElement> subCategorySelection;
	
	@FindBy(id="com.mmi.maps:id/suggestion_listView")
	public @Getter WebElement suggestionListView;
	
	
	@FindBy(id="android.view.ViewGroup")
	public @Getter WebElement andrdVGrp;
	
//	=====================
	//android.widget.CheckedTextView[@resource-id="com.mmi.maps:id/design_menu_item_text" and @text="Get Mappls Pin"]

	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Get Mappls Pin\"]")
	public @Getter WebElement hmbrgrGetPin;

	@FindBy(id="com.mmi.maps:id/text_view_get_eloc")
	public @Getter WebElement hmGetMapplsPinBTN;

	@FindAll({@FindBy(className = "android.widget.RadioButton")})
	public @Getter List<WebElement> listName;
	
//	@FindBy(id="com.mmi.maps:id/suggestion_listView")
//	public @Getter WebElement suggestionListView;
	
	//=======================
	@FindAll({@FindBy(id = "com.mmi.maps:id/suggestion_listView")})
	public @Getter List<WebElement> listNames;

	
	
	
//	===========================================
	
	
	
	
//	=====================
	//android.widget.CheckedTextView[@resource-id="com.mmi.maps:id/design_menu_item_text" and @text="Get Mappls Pin"]

//	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Get Mappls Pin\"]")
//	public @Getter WebElement hmbrgrGetPin;


//	@FindAll({@FindBy(className = "android.widget.RadioButton")})
//	public @Getter List<WebElement> listName;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_share\"]")
	public @Getter WebElement elocShareIcon;
	
	//=======================
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_address\"]")
	public @Getter WebElement elocVerification;
	
	@FindAll({@FindBy(id = "com.google.android.gm:id/snippet")})
	public @Getter List<WebElement> sharedElocList;
	
	

//	=======================================================
	
	
//	@FindAll({@FindBy(id = "com.mmi.maps:id/suggestion_listView")})
//	public @Getter List<WebElement> listNames;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/mappls_pin\"]")
	public @Getter WebElement isMapplsPinHomeScreen;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"What is Mappls Pin?\"]")
	public @Getter WebElement mpHeaderTxt;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/text_view_get_eloc\"]")
	public @Getter WebElement getMPButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement mapplsPinBackBtn;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_replay_play\"]")
	public @Getter WebElement mapplsPinVidePlayButton;
	
	@FindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.youtube:id/watch_list\"]/android.view.ViewGroup[1]/android.view.ViewGroup")
	public @Getter WebElement mapplsPinVideo;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Enter fullscreen\"]")
	public @Getter WebElement isLandScapVideoPlay;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\"]")
	public @Getter WebElement shareBtmSheet;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Mappls - Maps + Technologies for better future\"]")
	public @Getter WebElement mmiYoutube;
	
	
}
