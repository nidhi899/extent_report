package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import lombok.Getter;

public class BasePage {
	
	public BasePage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="com.android.permissioncontroller:id/permission_deny_button")
	public @Getter WebElement denyLocWhileUsingApp;
	
	//com.mmi.maps:id/md_buttonDefaultNegative
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/md_buttonDefaultNegative\"]")
	public @Getter WebElement LocPermissionCancel;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Refer a Friend\"]")
	public @Getter WebElement referAFriend;
	


  @FindBy(id = "com.mmi.maps:id/direction_content_simple_layout")
	public @Getter WebElement ln;
  
//loc off banner 
  @FindBy(id="com.mmi.maps:id/suggestion_info_layout")
  public @Getter WebElement locOffInfoBanner;
  
  @FindBy(xpath="//android.widget.TextView[@text=\"Switch on your location services to get better search results\"]")
  public @Getter WebElement locOffBAnnerTExt;
  
  @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Your current location\"]")
  public @Getter WebElement currentLoc;
  
  @FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/auto_list_item\" and @text=\"Choose On Map\"]")
  public @Getter WebElement chooseOnMAp;
  
  @FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/text_instruction_container\"])[3]")
  public @Getter WebElement txtCont;
  
//handling required login box
	@FindBy(id = "com.mmi.maps:id/parentPanel")
	public @Getter WebElement parentPanel;

	@FindBy(id = "com.mmi.maps:id/text_view_title")
	public @Getter WebElement title;

	@FindBy(id = "com.mmi.maps:id/text_view_description")
	public @Getter WebElement description;

	@FindBy(id = "android:id/button1")
	public @Getter WebElement loginButton;
	
	@FindBy(id="android:id/button2")
	public @Getter WebElement cancelButton;
	
	//visibility of map layer and current location button on various pages
		
	@FindBy(id="com.mmi.maps:id/maptype_layer_button")
	public @Getter WebElement MapLayerButton;
	
	@FindBy(id="com.mmi.maps:id/current_location_button")
	public @Getter WebElement CurrentLocationButton;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.permissioncontroller:id/permission_message\"]")
	public @Getter WebElement permissionBoxTitle;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	public @Getter WebElement WhileUsingAppOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]")
	public @Getter WebElement onlyThisTimeOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	public @Getter WebElement dontAllowOption;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.permissioncontroller:id/permission_message\"]")
	public @Getter WebElement allowLocationPermission;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	public @Getter WebElement allowOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	public @Getter WebElement DenyOption;
	
//	================14th oct
	@FindBy(id="com.mmi.maps:id/header_sub_title")
	public @Getter WebElement headerSubTitle;
	
	@FindBy(id="com.mmi.maps:id/header_skip_btn")
	public @Getter WebElement headerSkipBtn;
//	========================

	@FindBy(id="com.mmi.maps:id/edit_text_username")
	public @Getter WebElement loginUserId;
	
	@FindBy(id="com.mmi.maps:id/constraint_layout")
	public @Getter WebElement isUserProfileVisible;
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public @Getter WebElement allow;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/btn_continue\"]")
	public @Getter WebElement continueClick;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]") 
	public @Getter WebElement whileUsingApp;
	

	@FindBy(xpath = "(//android.widget.Toast)[1]")
    public @Getter WebElement toastMsg;
	
	@FindBy(xpath = "(//android.widget.Toast)[2]")
    public @Getter WebElement mySavesToastMsg;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_update_profile\"]")
    public @Getter WebElement updateProfile;
	
	
	//login edit verfication 
	@FindBy(id="com.mmi.maps:id/edit_profile_image_button")
	public @Getter WebElement loginEditBtn;
	
	
	@FindBy(id="com.mmi.maps:id/name_edit_text")
	public @Getter WebElement loginUName;
	
	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement loginUMail;
	
	@FindBy(id="com.mmi.maps:id/mobile_edit_text")
	public @Getter WebElement loginUNumber;
	
	//logout
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Settings\"]")
	public @Getter WebElement setting;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Logout\"]")
	public @Getter WebElement lgOutBTN;
	
	@FindBy(id="com.mmi.maps:id/md_buttonDefaultPositive")
	public @Getter WebElement cnLogOutBTN;
		
	@FindBy(id="com.mmi.maps:id/login_btn_text")
	public @Getter WebElement logingError;
	
	//login input field 	
	@FindBy(id="android:id/button1")
	public @Getter WebElement loginBTNMsg;	

	@FindBy(id="com.mmi.maps:id/login_btn_text")
	public @Getter WebElement continueBTN;	

	
	//==========================
	//login field
	
	@FindBy(id="com.mmi.maps:id/header_title")
	public @Getter WebElement headerTitle;
	
	
//	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/fragment_home_screen_toolbar\"]/android.widget.ImageButton")
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/fragment_home_screen_toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement hamburgerIconClick;
	
	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement loginTextClick;
	
	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement userName;
	
	@FindBy(id="com.mmi.maps:id/login_button")
	public @Getter WebElement continueLGBtn;
	
	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement enterpsw;
	
	@FindBy(id="com.mmi.maps:id/btn_text")	
	public @Getter WebElement loginBTN;	
	
	@FindBy(id="com.mmi.maps:id/fragment_home_search_txt")
	public @Getter WebElement homeSearch;
	
	@FindBy(id="com.mmi.maps:id/search_input")
	public @Getter WebElement homeSearchInput;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_account\"]")
	public @Getter WebElement account;
	
	@FindBy(id="com.mmi.maps:id/text_view_change_password")
	public @Getter WebElement changePSW;
	
	@FindBy(id="com.mmi.maps:id/text_view_logout")
	public @Getter WebElement logOut;
	
	@FindBy(id="com.mmi.maps:id/md_buttonDefaultPositive")
	public @Getter WebElement logOutYes;
	
	@FindBy(id="com.mmi.maps:id/md_buttonDefaultNegative")
	public @Getter WebElement logOutNo;
	
	@FindBy(id="com.mmi.maps:id/text_view_delete")
	public @Getter WebElement others;
	
	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement loginText;
	
	@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"])[2]/android.widget.ImageButton")
	public @Getter WebElement accountBackImage;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement settingsBackImage;
	
	
	@FindBy(id="com.mmi.maps:id/header_skip_btn")
	public @Getter WebElement skipBTN;
	
	@FindBy(id="com.mmi.maps:id/scroll_indicator_thumb")
	public @Getter WebElement btmSheet;
	

	@FindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.mmi.maps:id/geo_cam_button\"]")
	public @Getter WebElement geoCamIsVisible;

	
	@FindAll({@FindBy(id="com.mmi.maps:id/auto_list_item")})
	public @Getter List<WebElement> plcLst;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/auto_list_icon\"])[3]")
	public @Getter WebElement isAdrssVisble;
	
	
	@FindBy(id="com.mmi.maps:id/md_content")
	public @Getter WebElement plsWaitMsg;
	
	@FindBy(id="com.mmi.maps:id/snackbar_text")
	public @Getter WebElement snackBarMessage;
	
	@FindBy(className="android.widget.ImageButton")
	public @Getter WebElement clickBackbtn;
	
	@FindBy(id="com.mmi.maps:id/search_clear_btn")
	public @Getter WebElement closeSearch;
	
	
//	===============================================

//	===================gmail share
	@FindBy(xpath = "//android.widget.Spinner[@resource-id=\"com.google.android.gm:id/from_picker\"]/android.widget.LinearLayout/android.widget.ImageView")
	public @Getter WebElement fromMailId;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.google.android.gm:id/peoplekit_autocomplete_chip_group\"]/android.widget.EditText")
	public @Getter WebElement toMailId;
	
	@FindAll({@FindBy(id="com.google.android.gm:id/spinner_account_address") }) 
	public @Getter List<WebElement> fromMailIdList;

	                 
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Send\"]")
	public @Getter WebElement fromMailIdSendBtn;
	
//	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gmail, 12 notifications\"]")
//	public @Getter WebElement openGmail;
	
	
	@FindAll({@FindBy(id="com.sec.android.app.launcher:id/home_icon") }) 
	public @Getter List<WebElement> openGmail;
	
	
//	@FindBy(id = "(//android.widget.ImageView[@resource-id=\"com.google.android.apps.messaging:id/conversation_icon\"])[1]")
//	public @Getter WebElement openGmail;
	
	
//	=======
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public @Getter WebElement gmailMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/hub_drawer_label_title\" and @text=\"Sent\"]")
	public @Getter WebElement gmailSentButton;
	
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.google.android.gm:id/subject\"])[1]")
	public @Getter WebElement openSentMail;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"https://mappls.com/pom/23.\"]")
	public @Getter WebElement clickSentLink;

	
	@FindBy(xpath = "//android.widget.EditText[contains(@text, 'I want you to check out a place on Mappls!')]")
	public @Getter WebElement gmailSharedLinkCopiedTxtClick;
	
	
	
//	//android.view.View[@content-desc="https://mappls.com/pom/23. 355298914341333%2C85. 35844602161774"]

//========== verify excel link google search
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Google\"]")
	public @Getter WebElement googleClick;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.googlequicksearchbox:id/googleapp_hint_text\"]")
	public @Getter WebElement googleSearch;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.google.android.googlequicksearchbox:id/googleapp_search_box\"]")
	public @Getter WebElement googleSearchEnterTxt;
	
	
	
//	=========================
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gmail\"]")
	public @Getter WebElement gmailOpen;
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/navigation_bar_item_icon_view\"])[2]")
	public @Getter WebElement gmailChatBox;
	
//	@FindBy(xpath = "//android.widget.TextView[@resource-id='group_name']")
//	public @Getter WebElement gmailHangoutShare;
	
	@FindAll({@FindBy(xpath="//android.widget.TextView[@resource-id='group_name']") }) 
	public @Getter List<WebElement> gmailHangoutShare;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.google.android.gm:id/compose_rich_edit_text\"]")
	public @Getter WebElement gchatEnterLink;
	
//	==================review rating page verification
	@FindBy(xpath = "//android.widget.RatingBar[@resource-id=\"com.mmi.maps:id/place_rating_bar\"]")
	public @Getter WebElement reviewPageBtmSheet;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_name\"]")
	public @Getter WebElement reviewPlcName;
	
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/place_address\"]")
	public @Getter WebElement reviewPagePlcAddress;
	
	
	
	@FindBy(xpath = "//android.widget.RatingBar[@resource-id=\"com.mmi.maps:id/place_rating_bar\"]")
	public @Getter WebElement reviewPageVerification;
	
	
	
//	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.google.android.gm:id/compose_rich_edit_text\"]")
//	public @Getter WebElement sendLinkHnOut;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate Up\"]")
	public @Getter WebElement gmailClose;
	
	
	
//	whatsapp share 
	
	@FindAll({@FindBy(id="android:id/text1") }) 
	public @Getter List<WebElement> whtsppClick;
	
	
	@FindAll({@FindBy(id="com.whatsapp:id/contactpicker_row_name") }) 
	public @Getter List<WebElement> contactpickerName;
	
	
	@FindBy(id = "com.whatsapp:id/send")
	public @Getter WebElement wtspSend;
	
	//clear chat in whatsapp
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	public @Getter WebElement wtspSendThreeDot;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.whatsapp:id/title\" and @text=\"More\"]")
	public @Getter WebElement whtspMore;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.whatsapp:id/title\" and @text=\"Clear chat\"]")
	public @Getter WebElement clearWtspChat;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	public @Getter WebElement clearWtspChatAlertBox;
	
	
//	@FindAll({@FindBy(xpath="//android.widget.ListView[@resource-id='android:id/list']/android.view.ViewGroup") }) 
//	public @Getter List<WebElement> whtspLinkClick;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.whatsapp:id/message_text\"]")
	public @Getter WebElement whtspSentLinkClick;
	
	
//	user profile share
	@FindBy(id = "com.mmi.maps:id/share_profile_image_button")
	public @Getter WebElement userProfileShare;
	
	
	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/message_chip_container\"])[2]")
	public @Getter WebElement userProfileGchatSharedClick;
	

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/user_email_text_view\"]")
	public @Getter WebElement getUsrTxt;
	
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/navigation_bar_item_icon_view\"])[2]")
	public @Getter WebElement gchatClick;
	
	
	@FindBy(id="com.mmi.maps:id/fragment_dropped_pin_action_share")
	public @Getter WebElement shareBTN;
	
	
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement profileBackArrwIcon;
	
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.whatsapp:id/conversation_text_row\"]")
	public @Getter WebElement userPefleWhtspSentLinkClick;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Gmail\"]")
	public @Getter WebElement gmailShare;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Chat\"]")
	public @Getter WebElement gmailChat;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Gmail\"]")
	public @Getter WebElement gmailOnly;

	@FindAll({@FindBy(id="com.google.android.gm:id/account_view_subtitle") }) 
	public @Getter List<WebElement> gmailList;

	@FindAll({@FindBy(id="com.google.android.gm:id/subtext") }) 
	public @Getter List<WebElement> gmailSendList;


	@FindBy(id = "com.google.android.gm:id/compose_rich_edit_text")
	public @Getter WebElement getLink;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Post message\"]")
	public @Getter WebElement postMsg;

//	                 (//android.widget.TextView[@resource-id="com.google.android.gm:id/message_text_bubble"])[2]             - current
//	                 (//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/message_bubble_container\"])[2]  - old
	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/message_bubble_container\"])[2]") 
	public @Getter WebElement clickSharedLink;

	@FindBy(id = "com.mmi.maps:id/fragment_dropped_pin_place_title")
	public @Getter WebElement pageRedirctVerfictn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/fragment_dropped_pin_place_title\"]")
	public @Getter WebElement linkVerification;
	
	
	@FindBy(xpath = "//android.widget.Spinner[@resource-id=\"com.google.android.gm:id/from_picker\"]/android.widget.LinearLayout/android.widget.ImageView")
	public @Getter WebElement dropDwn;
	
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/message_text_bubble\" and @text=\"I want you to check out a place on Mappls!\r\n"
			+ "https://mappls.com/pom/23.35569998333561%2C85.35916330001601\"]")
	public @Getter WebElement expectedLink;
	
	//
//	@FindBy(id="com.google.android.gm:id/subtext") 
	@FindAll({@FindBy(id="com.google.android.gm:id/subtext") }) 
	public @Getter List<MobileElement> emailNameList;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/subtext\" and @text=\"muskan.kumari@mapmyindia.com\"]")
	public @Getter WebElement specificMailClick;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Login Successful\"]")
	public @Getter WebElement loginTstMsg;
	
}
