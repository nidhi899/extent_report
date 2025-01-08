package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__021_PointOnMapPage {
	
	public TC__021_PointOnMapPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	 @FindBy(id="com.mmi.maps:id/search_input")
	 public @Getter WebElement searchInput;
	 
	 
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement ppBackBtn;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/current_location_button\"]")
	public @Getter WebElement crrntLocationOverFlow;

	@FindBy(id="com.mmi.maps:id/maptype_layer_button")
	public @Getter WebElement mpLayerIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_place_title\"]")
	public @Getter WebElement placeDetail;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_action_share\"]")
	public @Getter WebElement shareIcon;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_action_save\"]")
	public @Getter WebElement saveIcon;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_action_report\"]")
	public @Getter WebElement postIcon;


	//======================================================================

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_auto_mode\"]")
	public @Getter WebElement autoModes;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_day_mode\"]")
	public @Getter WebElement dayModes;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_night_mode\"]")
	public @Getter WebElement nightMode;

	//===============================btn enabled disabled
	@FindBy(id="com.mmi.maps:id/switch_2d_3d")
	public @Getter WebElement switchElement3D;

	@FindBy(id="com.mmi.maps:id/switch_visual")
	public @Getter WebElement visualTraffic;
	
	//================================================


	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_forward_arrow_layer\"]")
	public @Getter WebElement myLayersClick;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_login\"]")
	public @Getter WebElement login;


	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement enterUserId;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/login_button\"]")
	public @Getter WebElement continueBTN;

	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement enterPSW;

	@FindBy(id="com.mmi.maps:id/btn_text")	
	public @Getter WebElement loginBTN;

	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_forward_arrow_report_event\"]")
	public @Getter WebElement postClick;


	//updated
	@FindBy(id="com.mmi.maps:id/recycler_view_layer")	
	public @Getter WebElement recyclerView;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[1]")	
	public @Getter WebElement home;
	

	
	
	//============================
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_place_title\"]")	
	public @Getter WebElement pointMapTxt;
	
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[1]")	
	public @Getter WebElement homfffffe;
	
	
	@FindBy(id="com.mmi.maps:id/text_view_title")	
	public @Getter WebElement popUpWindowLoginHdr;
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button2\"]")	
	public @Getter WebElement cancelLogin;
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")	
	public @Getter WebElement loginBtnPopUpWindow;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_title\"]")	
	public @Getter WebElement enterLablHeaderTxt;
	
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"android:id/input\"]")	
	public @Getter WebElement enterLabelName;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")	
	public @Getter WebElement labelDoneBtn;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")	
	public @Getter WebElement ppBackArrowClick;
//	
//	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/subTitle\"]")	
	public @Getter WebElement psotSbmittdDesc;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/viewBtn\"]")	
	public @Getter WebElement viewPostButton;
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/shareBtn\"]")	
	public @Getter WebElement shareBtn;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/content_preview_text\"]")	
	public @Getter WebElement getLinkTxt;
	
	
	@FindBy(xpath="//android.widget.Button[@text=\"QUICK SHARE\"]")	
	public @Getter WebElement quickShare;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_title\"]")	
	public @Getter WebElement nearestLocation;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/item_value_nearest_location\"]")	
	public @Getter WebElement nearestLocationAdrss;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/item_icon\"]")	
	public @Getter WebElement nrstLocationClick;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/bottom_place_head\"]")	
	public @Getter WebElement btmSheet;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_card_missing_place_sub_title\"]")
	public @Getter WebElement missingPlc;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/place_directions_button\"]")
	public @Getter WebElement directionBtn;

	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Add a Place\"]")	
	public @Getter WebElement addPlcHeader;
	
	
	@FindBy(id="com.mmi.maps:id/add_edit_place_name_input")	
	public @Getter WebElement enterPlcName;
	
	
	@FindBy(xpath="//android.widget.Button[@text=\"SUBMIT\"]")	
	public @Getter WebElement submitBtn;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_congrats\"]")	
	public @Getter WebElement plcAddedMsg;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_cross\"]")	
	public @Getter WebElement clickPlcCloseIcon;
	
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/list_details_place_name")})
	public @Getter List<WebElement> contributionList;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")	
	public @Getter WebElement nearstLoctnIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/snackbar_text\"]")	
	public @Getter WebElement savePlcExixtAlrtMsg;
	
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input\"]")	
	public @Getter WebElement nearstLoctnSerchInput;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_name\"]")	
	public @Getter WebElement nearstLoctnBtmSheet;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Nearby\"]")	
	public @Getter WebElement nearByIcon;
	
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"Testtt\"]")	
//	public @Getter WebElement hocccme;
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")	
//	public @Getter WebElement nrstLoctn;
	
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"Testtt\"]")	
//	public @Getter WebElement hocccme;
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")	
//	public @Getter WebElement nrstLoctn;
	
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"Testtt\"]")	
//	public @Getter WebElement hocccme;
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")	
//	public @Getter WebElement nrstLoctn;
	
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"Testtt\"]")	
//	public @Getter WebElement hocccme;
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")	
//	public @Getter WebElement nrstLoctn;
	
	
//	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/list_details_pin_name\" and @text=\"Testtt\"]")	
//	public @Getter WebElement hocccme;
	
	
	
	
	
}
