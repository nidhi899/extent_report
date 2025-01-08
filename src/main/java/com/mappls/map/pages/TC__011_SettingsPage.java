package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__011_SettingsPage {
	
	public TC__011_SettingsPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_name\"]")
	public @Getter WebElement loginTxt;

	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
	public @Getter WebElement isRgistrPageVisible;

	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Settings\"]")
	public @Getter WebElement settingTxt;

	@FindBy(xpath="//android.widget.TextView[@text=\"Settings\"]")
	public @Getter WebElement sttngsPageHeader;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Settings\"]")
	public @Getter WebElement hamBurgerMenuSetting;
	
	@FindBy(id="com.mmi.maps:id/header_title")
	public @Getter WebElement changePswUI;
	
	@FindBy(id="com.mmi.maps:id/text_view_change_password")
	public @Getter WebElement changePSW;

	@FindBy(id="com.mmi.maps:id/header_skip_btn")
	public @Getter WebElement skipBTN;
	
	@FindBy(xpath="(//android.widget.TextView[@text=\"Account\"])[2]")
	public @Getter WebElement accountInterface;
	
	
	//======password
	@FindBy(id="com.mmi.maps:id/editTextOldPassword")
	public @Getter WebElement oldPSW;

	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement newPassword;
	
	
//	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/editTextReEnterPassword\"]")
//	public @Getter WebElement confirmPSW;
	
	@FindBy(id="com.mmi.maps:id/editTextReEnterPassword")
	public @Getter WebElement confirmPSW;
	
	@FindBy(id="(//android.widget.ImageButton[@content-desc=\"Show password\"])[1]")
	public @Getter WebElement showPswBtn1;
	
	@FindBy(id="(//android.widget.ImageButton[@content-desc=\"Show password\"])[2]")
	public @Getter WebElement showPswBtn2;

	@FindBy(id="(//android.widget.ImageButton[@content-desc=\"Show password\"])[3]")
	public @Getter WebElement showPswBtn3;
	
	
	
	
	@FindBy(id="com.mmi.maps:id/buttonContinue")
	public @Getter WebElement continueBTN;
	
	
	@FindBy(id="com.mmi.maps:id/md_buttonDefaultPositive")
	public @Getter WebElement afterChangePSWLoginBtn;
	
	


	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement aftrChngPswLoginPopUp;

	@FindBy(xpath="(//android.widget.TextView[@text=\"Account\"])[2]")
	public @Getter WebElement accntPageHeader;

	@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"])[2]/android.widget.ImageButton")
	public @Getter WebElement accntPageBckIcon;

	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
	public @Getter WebElement sttngsBckIcon;
			
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_unit\"]")
	public @Getter WebElement unitTxt;
	
	

	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/miles_per_hour_button\"]")
	public @Getter WebElement milesBtn;
			
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.mmi.maps:id/km_per_hour_button\"]")
	public @Getter WebElement kmBtn;
	
	@FindAll({@FindBy(id = "com.mmi.maps:id/text_view_distance")})
	public @Getter List<WebElement> viewDistnceList;
	
	
			
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement homesrchBack;
			
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement againBck;
				
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement unitBckIcon;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/fragment_home_direction\"]")
	public @Getter WebElement navigationIcon;

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/directions_back_button\"]")
	public @Getter WebElement navigationCrrntLocatnBckIcon;
			
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_stop_label\" and @text=\"Select location\"]")
	public @Getter WebElement clickSelctLoctn;

	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement slctLctnBckIcon;
			
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.mmi.maps:id/search_input\"]")
	public @Getter WebElement entrLoctn;
	
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_visual_alert\"]")
	public @Getter WebElement visualAlrts;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/poi_action_btn\" and @text=\"Save\"]")
	public @Getter WebElement untilSaveAppear;
//			
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_distance\"]")
	public @Getter WebElement plcDetailPageDistanceUnit;
//
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/collapsed_toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement plcDetailPageBck;
//			
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/search_icon\"]")
	public @Getter WebElement searchInputBackIcon;


	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/direction_distance_text_view\"]")
	public @Getter WebElement navPageUnit;
	
	@FindAll({@FindBy(id = "com.mmi.maps:id/auto_list_item")})
	public @Getter List<WebElement> navAddrsList;
	
	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/directions_back_button\"]")
	public @Getter WebElement navPageBack;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_general_setting\"]")
	public @Getter WebElement gnralSttng;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_map_settings\"]")
	public @Getter WebElement mapSetting;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_unit\"]")
	public @Getter WebElement unitOption;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_navigation_settings\"]")
	public @Getter WebElement navMenuOption;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_set_navigation_marker\"]")
	public @Getter WebElement navMarkerOption;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_show_current_speed_limit\"]")
	public @Getter WebElement showCrrntSpeed;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_over_speeding_alarm\"]")
	public @Getter WebElement overSpeadAlarm;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_lane_guidance\"]")
	public @Getter WebElement laneGuidance;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_junction_view\"]")
	public @Getter WebElement junctionView;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_voice_guidance\"]")
	public @Getter WebElement voiceGuidance;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_visual_alert\"]")
	public @Getter WebElement visualAlarts;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_bluetooth_voice_over_phone_call\"]")
	public @Getter WebElement playVoiceDrngCall;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_play_voice_over_bluetooth\"]")
	public @Getter WebElement playVoiceOvrBltooth;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_about\"]")
	public @Getter WebElement about;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_account\"]")
	public @Getter WebElement account;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_learn_more\"]")
	public @Getter WebElement learnMore;
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_privacy_policy\"]")
	public @Getter WebElement privacyAndPolicy;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_term_and_condition\"]")
	public @Getter WebElement trmsAndCondition;
		
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_build\"]")
	public @Getter WebElement build;
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_build_version\"]")
	public @Getter WebElement getBuild;
		
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
	
	
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
		
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
	
	
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
		
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
	
	
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
		
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
	
	
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
		
//	@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
//	public @Getter WebElement isRgistrPageVisible;
	
	
		
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_content\"]")
	public @Getter WebElement mdCntnt;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultPositive\"]")
	public @Getter WebElement mdCntntLogin;
}