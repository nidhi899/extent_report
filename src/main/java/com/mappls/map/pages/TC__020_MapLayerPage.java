package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__020_MapLayerPage {
	public TC__020_MapLayerPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/earth_observation_text_view\"]")
	public @Getter WebElement earthObsClick;

	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public @Getter WebElement earthObservationData;

	@FindBy(id="com.mmi.maps:id/map_layer_button")
	public @Getter WebElement mpLayerIcon;

	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Image View to show layer selection\"]")
	public @Getter WebElement defaultMap;

	@FindBy(id="com.mmi.maps:id/close_iv")
	public @Getter WebElement closeBTN;

	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Map layer image\"])[2]")
	public @Getter WebElement satelliteMap;

	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Map layer image\"])[3]")
	public @Getter WebElement terrainMap;

	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Map layer image\"])[4]")
	public @Getter WebElement grayMap;

	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Map layer image\"])[5]")
	public @Getter WebElement sublimeGreayMap;

	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"Map layer image\"])[6]")
	public @Getter WebElement darkClassicMap;

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
	
	
//	
//	@FindBy(id="com.mmi.maps:id/btn_text")	
//	public @Getter WebElement isGMChecked;
//	
//	@FindBy(id="com.mmi.maps:id/btn_text")	
//	public @Getter WebElement isDSUBMChecked;
//	
//	@FindBy(id="com.mmi.maps:id/btn_text")	
//	public @Getter WebElement isDDARKMChecked;
//	
//	@FindBy(id="com.mmi.maps:id/btn_text")	
//	public @Getter WebElement isAMChecked;
//	
//	@FindBy(id="com.mmi.maps:id/btn_text")	
//	public @Getter WebElement isDAYMChecked;
	
	
	
	@FindBy(className="android.widget.Switch")	
	public @Getter WebElement toggleButton;
	
	
	
	@FindBy(id="com.mmi.maps:id/recycler_view_layer")	
	public @Getter WebElement weatherRecyclerView;
	
	
	
	@FindBy(id="com.mmi.maps:id/poi_list_card_content")	
	public @Getter WebElement poiCardList;
	
	@FindBy(className="com.mmi.maps:id/wms_description_text_view")	
	public @Getter WebElement wmsDesc;
	
	
//	======================new test cases regression
	
	
	@FindBy(id="com.mmi.maps:id/text_view_title")	
	public @Getter WebElement isMyMapVsble;
	
	//map post lists
	@FindAll({@FindBy(id="com.mmi.maps:id/txt_view_parent_name")})
	public @Getter List<WebElement> parentView;
	
	@FindBy(id="com.mmi.maps:id/text_view_header_title")	
	public @Getter WebElement verifyParentName;
	
	@FindBy(xpath="//android.widget.ImageButton")	
	public @Getter WebElement mapLayerBackBtn;

	
//	================================
	
	@FindBy(id="com.mmi.maps:id/text_view_layers_value")	
	public @Getter WebElement layers;
	
	
	@FindBy(id="com.mmi.maps:id/text_view_login_info")	
	public @Getter WebElement wolTxt;
	
	@FindAll({@FindBy(id="com.mmi.maps:id/text_view_label_of_row")})
	public @Getter List<WebElement> textViewLabelRow;
	
	
	@FindAll({@FindBy(id="com.mmi.maps:id/text_view_category_name")})
	public @Getter List<WebElement> trficSubTxtView;
	
	@FindAll({@FindBy(id="android.view.ViewGroup")})
	public @Getter List<WebElement> trfficAndroidView;
	
	@FindBy(xpath="//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_parent\"]")	
	public @Getter WebElement trafficSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[1]")	
	public @Getter WebElement trafficJamSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[2]")	
	public @Getter WebElement trafficAccidentSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[3]")	
	public @Getter WebElement trafficRDCloseSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[4]")	
	public @Getter WebElement trafficRDWorkSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[5]")	
	public @Getter WebElement traffiOthrIssuecSwitch;
	
	@FindBy(xpath="(//android.widget.Switch[@resource-id=\"com.mmi.maps:id/switch_events_multiple\"])[6]")	
	public @Getter WebElement trafficBreakDownSwitch;
	
	
	
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Posts\"]")	
	public @Getter WebElement postsTxt;
	
	
	@FindBy(id="com.mmi.maps:id/image_view_info_my_map")	
	public @Getter WebElement mapInfo;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"My Map\"]")	
	public @Getter WebElement mapInfoVerificaton;
	
	@FindBy(id="com.mmi.maps:id/image_view_info_layers")	
	public @Getter WebElement layerInfo;
	
	@FindBy(xpath="//android.view.View[@resource-id=\"primary\"]")	
	public @Getter WebElement layerInfoVerification;	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")	
	public @Getter WebElement earthObsBackBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Earth Observation Data\"]")	
	public @Getter WebElement earthObsBackVerification;
	
	
	
	
	
	
	
	
}


