package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import lombok.Getter;

public class TC__026_MapplsPinHomePage {
	
	public TC__026_MapplsPinHomePage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/mappls_pin\"]")
	public @Getter WebElement isHomePageMapplPinPresesnt;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_show_mappls_pin\"]")
	public @Getter WebElement isShowMpplsPinPageOpen;
	
	//...
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_search_text\"]")
	public @Getter WebElement searchere;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_pin\"]")
	public @Getter WebElement movePinIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/create_mappls_pin_1\"]")
	public @Getter WebElement createMpplPinBtn;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement crrntLocation;
	               
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mmi.maps:id/mappls_pin_recycler_view\"]/android.view.ViewGroup[1]")
	public @Getter WebElement nearByPlc;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input\"]")
	public @Getter WebElement enterPlcSearch;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_show_mappls_pin\"]")
	public @Getter WebElement againShowMpplPin;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/create_mappls_pin_1\"]")
	public @Getter WebElement createMpplPinBySearch;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement bySearchBckButton;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Choose On Map\"]")
	public @Getter WebElement viaSearchChooseMap;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_title\"]")
	public @Getter WebElement loginWindowPopUp;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_description\"]")
	public @Getter WebElement loginWindowPopUpDesc;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button2\"]")
	public @Getter WebElement loginWindowPopUpCancelBtn;
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement loginWindowPopUpLoginBtn;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/header_sub_title\"]")
	public @Getter WebElement loginPage;
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Create Mappls Pin\"]")
	public @Getter WebElement createMpplPinPageForm;
	
	
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Category*\"]")
	public @Getter WebElement isCategoryVisible;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_add_place_name\"]")
	public @Getter WebElement isNameVisible;
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Address*\"]")
	public @Getter WebElement isAddrssFieldVisible;
	
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_share\"]")
	public @Getter WebElement mapplsPinShareImg;
	
	//
	@FindBy(xpath="(//android.widget.TextView[@resource-id=\"android:id/text1\"])[1]")
	public @Getter WebElement gmailShare;
	
	
	@FindBy(xpath="//com.android.internal.widget.RecyclerView[@resource-id=\"android:id/resolver_list\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]")
	public @Getter WebElement gmailShare2;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text2\" and @text=\"Chat\"]")
	public @Getter WebElement gChatShare;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Messages\"]")
	public @Getter WebElement msgShare;
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Send to\"]")
	public @Getter WebElement sentToPage;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\"]")
	public @Getter WebElement bottomShareOption;
	
	@FindBy(id="com.google.android.gm:id/subtext") 
	public @Getter List<MobileElement> emailNameList;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_bar_title\"]")
	public @Getter WebElement chatPageHeaderTitle;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Post message\"]")
	public @Getter WebElement sentBtn;
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Now\"]")
	public @Getter WebElement sentNowTxt;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_spread_eloc\"]")
	public @Getter WebElement mpplsAccomplished;
	
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_facebook\"]")
	public @Getter WebElement fb;
//	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_twitter\"]")
	public @Getter WebElement twitter;
//	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_instagram\"]")
	public @Getter WebElement instagram;
//	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_more_share\"]")
	public @Getter WebElement moreShare;
//	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/from_account_name\"]")
	public @Getter WebElement frmAccntName;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.google.android.gm:id/peoplekit_autocomplete_chip_group\"]/android.widget.EditText")
	public @Getter WebElement sentToEmailId;
	
	
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\"Send\"]")
	public @Getter WebElement mailSentButton;
	
	
	@FindBy(xpath="//android.webkit.WebView[@resource-id=\"com.google.android.gm:id/wc_body\"]")
	public @Getter WebElement gmailSentBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/from_account_name\"]")
	public @Getter WebElement gmailSubject;
	
	//
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_congrats\"]")
	public @Getter WebElement congartulations;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_eloc_linc\"]")
	public @Getter WebElement mapplsCpyIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_eloc_code\"]")
	public @Getter WebElement mapplsPin;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_qr_code\"]")
	public @Getter WebElement mapplsQR;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_download\"]")
	public @Getter WebElement mapplsDownloadIcon;
	
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_cross\"]")
	public @Getter WebElement mapplsPinCloseIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_eloc\"]")
	public @Getter WebElement mapplsPinForAdded;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_get_another_eLoc\"]")
	public @Getter WebElement getAnotherMapplsPinBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_feel_free_to_share\"]")
	public @Getter WebElement feelFreeToShareTxt;
	
	
	//==========
	
	
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
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.gm:id/peoplekit_listview_contact_method\"]")
	public @Getter WebElement confrmMailId;
	
	//=======================
	@FindAll({@FindBy(id = "com.mmi.maps:id/suggestion_listView")})
	public @Getter List<WebElement> listNames;
	
	
	//=============
//	new 
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement searchHereBckBtn;
	

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement createMpplPinPageBackBtn;
	
	
	
	
	//==============
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/create_mappls_pin_1\"]")
	public @Getter WebElement createMpplPinButtonTxt;
	
}
