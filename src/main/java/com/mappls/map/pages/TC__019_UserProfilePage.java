package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__019_UserProfilePage extends BasePage {

	public TC__019_UserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//menu in hamburger
		@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_name\"]")
		public @Getter WebElement UserDisplay;

		@FindBy(id = "com.mmi.maps:id/text_view_name")
		public @Getter WebElement user;
		
		@FindBy(id = "com.mmi.maps:id/text_view_profile_data")
		public @Getter WebElement userDisplayData;
		
	// login locators
		@FindBy(id = "com.mmi.maps:id/edit_text_email")
		public @Getter WebElement enter_email;

		@FindBy(id = "com.mmi.maps:id/login_button")
		public @Getter WebElement continueBtn;

		@FindBy(id = "com.mmi.maps:id/login_btn_text")
		public @Getter WebElement continueBtnTxt;

		@FindBy(id = "com.mmi.maps:id/editTextPassword")
		public @Getter WebElement enter_password;

		@FindBy(id = "com.mmi.maps:id/place_login_button")
		public @Getter WebElement login;

		@FindBy(xpath = "(//android.widget.Toast)[1]")
		public @Getter WebElement toastMsg;

		@FindBy(id = "com.mmi.maps:id/text_view_skip")
		public @Getter WebElement skipButton;

		@FindBy(id = "com.mmi.maps:id/button_update_profile")
		public @Getter WebElement updateBtn;
		
		//// user profile

		@FindBy(id = "com.mmi.maps:id/user_name_text_view")
		public @Getter WebElement userprofilenamedetail;

		@FindBy(id = "com.mmi.maps:id/user_email_text_view")
		public @Getter WebElement userprofileEmaildetail;

		@FindBy(id = "com.mmi.maps:id/edit_profile_image_button")
		public @Getter WebElement edit_profile_button;

		@FindBy(id = "com.mmi.maps:id/edit_text_username")
		public @Getter WebElement username_field;

		@FindBy(id = "com.mmi.maps:id/textinput_error")
		public @Getter WebElement userIdErrorMsg;

		@FindBy(id = "com.mmi.maps:id/edit_text_email")
		public @Getter WebElement emailFieldId;

		@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/update_profile_toolbar\"]/android.widget.ImageButton ")
		public @Getter WebElement backButtonId;

		@FindBy(id = "com.mmi.maps:id/textinput_error")
		public @Getter WebElement userExistsMessageId;

		@FindBy(id = "com.mmi.maps:id/textinput_error")
		public @Getter WebElement errorMessageId;

		@FindBy(id = "com.mmi.maps:id/name_edit_text")
		public @Getter WebElement username;

		@FindBy(id = "com.mmi.maps:id/textinput_error")
		public @Getter WebElement userNameErrorMsg;

		@FindBy(id = "com.mmi.maps:id/location_edit_text")
		public @Getter WebElement editCity;

		@FindBy(id = "com.mmi.maps:id/city_selection_search_input")
		public @Getter WebElement enter_city;

		@FindBy(id = "com.mmi.maps:id/about_edit_text")
		public @Getter WebElement editAbout;

		@FindBy(xpath = "//android.widget.Button[@text=\"UPDATE\"]")
		public @Getter WebElement update_Button;

		@FindBy(id = "com.mmi.maps:id/parentPanel")
		public @Getter WebElement updateConfirm2;

		@FindBy(id = "android:id/message")
		public @Getter WebElement updateConfirm;

		@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
		public @Getter WebElement ok_Btn;

		@FindBy(id = "com.mmi.maps:id/share_profile_image_button")
		public @Getter WebElement shareBtnInProfile;
		

			//  user profile gender 
			
			@FindBy(id = "com.mmi.maps:id/male_radio_button")
			public @Getter WebElement maleRadioButton;

			@FindBy(id = "com.mmi.maps:id/female_radio_button")
			public @Getter WebElement femaleRadioButton;

			@FindBy(id = "com.mmi.maps:id/other_radio_button")
			public @Getter WebElement othersRadioButton;

			
			
			// samsung 13 
			@FindBy(id = "android:id/chooser_header")
			public @Getter WebElement chooserHead;

			@FindBy(id = "android:id/text1")
			public @Getter WebElement profileText;

			@FindBy(id = "android:id/sem_chooser_chip_button")
			public @Getter WebElement copy_Btn;

			// My saves
			@FindBy(id = "com.mmi.maps:id/text_view_val_contributions")
			public @Getter WebElement mysavescount;

			@FindBy(id = "com.mmi.maps:id/container_contributions")
			public @Getter WebElement mysaves;

			@FindBy(id = "com.mmi.maps:id/home_address_text_view")
			public @Getter WebElement contributionCount;

			@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
			public @Getter WebElement mySavesBack;

		// Followers
			@FindBy(id = "com.mmi.maps:id/container_followers")
			public @Getter WebElement followers;

			@FindBy(id = "com.mmi.maps:id/text_view_val_followers")
			public @Getter WebElement followerCount;

			@FindBy(id = "com.mmi.maps:id/button_share_profile")
			public @Getter WebElement Share_Profile;

			@FindBy(xpath = "//android.widget.Button[@text=\"SYNC\"]")
			public @Getter WebElement sync;

			@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Following\"]")
			public @Getter WebElement following;

			@FindBy(id = "com.mmi.maps:id/button_share_profile")
			public @Getter WebElement follower_Profile;

			@FindBy(xpath = "//android.widget.Button[@content-desc=\"Contacts\"]")
			public @Getter WebElement shareContact;

			@FindBy(id = "com.mmi.maps:id/sync_error_button")
			public @Getter WebElement sync_now;

			@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
			public @Getter WebElement allow_button;
			
			@FindBy(id="com.android.permissioncontroller:id/permission_deny_button")
			public @Getter WebElement deny_button;

			@FindBy(id = "com.mmi.maps:id/sc_contacts_rcv")
			public @Getter WebElement contacts_display;

			@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
			public @Getter WebElement shareContactBack;

			@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
			public @Getter WebElement backBtnToolbar;

			// journey
			@FindBy(id = "com.mmi.maps:id/text_view_journey")
			public @Getter WebElement journey;

			@FindBy(id = "com.mmi.maps:id/check_box_review")
			public @Getter WebElement reviewBtn;

			@FindBy(id = "com.mmi.maps:id/check_box_report")
			public @Getter WebElement postBtn;

			@FindBy(className = "androidx.recyclerview.widget.RecyclerView")
			public @Getter WebElement RecyclerView;

			@FindBy(className = "android.widget.LinearLayout")
			public @Getter WebElement LinearLayout;

			@FindBy(id = "com.mmi.maps:id/main_layout")
			public @Getter WebElement main_layout;

			@FindBy(id = "com.mmi.maps:id/review_text")
			public @Getter WebElement reviewText;

			@FindBy(id = "com.mmi.maps:id/item_world_view_rating_bar")
			public @Getter WebElement reviewRatingCount;

			@FindBy(id = "com.mmi.maps:id/review_date_text")
			public @Getter WebElement reviewDateText;

			@FindBy(id = "com.mmi.maps:id/item_world_view_action_like_txt")
			public @Getter WebElement helpAction;

			@FindBy(id = "com.mmi.maps:id/helpful_text_layout")
			public @Getter WebElement helpActionCountLayout;

			@FindBy(id = "com.mmi.maps:id/helpful_text")
			public @Getter WebElement helpActionCountText;

			@FindBy(id = "com.mmi.maps:id/item_world_view_action_share_txt")
			public @Getter WebElement shareAction;

			@FindBy(id = "com.mmi.maps:id/report_text")
			public @Getter WebElement reportText;

			@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/toolbar\"]/android.widget.ImageButton")
			public @Getter WebElement UserProfileBack;

			// emergency contact on profile
			@FindBy(id = "com.mmi.maps:id/image_button_accident")
			public @Getter WebElement profileEmergencyContact;

			@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/timeline_title\" and @text=\"Emergency Contact\"]")
			public @Getter WebElement profileEmergencyContactTitle;

			@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mmi.maps:id/timeline_sub_title\" and @text=\"Notify your loved ones in case of accident.\"]")
			public @Getter WebElement profileEmergencyContactSubTitle;

			// add Emergency contact page after clicking emergency contact on profile
			@FindBy(id = "com.mmi.maps:id/edit_text_name")
			public @Getter WebElement nameAEC;

			@FindBy(id = "com.mmi.maps:id/edit_text_mobile")
			public @Getter WebElement contactNoAEC;

			@FindBy(id = "com.mmi.maps:id/text_view_save_edit")
			public @Getter WebElement saveBtnAEC;
			
			@FindBy(id = "com.mmi.maps:id/add_contact")
			public @Getter WebElement addMoreContactEC;

			@FindBy(id = "com.mmi.maps:id/text_view_contact_name")
			public @Getter WebElement savedContactNameEC;

			@FindBy(id = "com.mmi.maps:id/text_view_contact_number")
			public @Getter WebElement savedContactNoEC;

			@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.mmi.maps:id/image_view_more\"])[1]")
			public @Getter WebElement actionEC;

			@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit\"]")
			public @Getter WebElement actionEditEC;

			@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Delete\"]")
			public @Getter WebElement actionDeleteEC;

			@FindBy(id = "com.mmi.maps:id/recycler_view_show_contact")
			public @Getter WebElement savedContactListEC;

			@FindBy(className = "android.view.ViewGroup")
			public @Getter WebElement savedContactListVG;

			@FindBy(className = "android.widget.ImageButton")
			public @Getter WebElement backBtnEC;

			// journey reviewed places detail
			@FindBy(id = "com.mmi.maps:id/report_details_container")
			public @Getter WebElement reviewedPlaceLayout;

			@FindBy(id = "com.mmi.maps:id/report_details_user_name")
			public @Getter WebElement reviewedplaceDesc;

			@FindBy(id = "com.mmi.maps:id/report_details_reported_date")
			public @Getter WebElement reviewDate;

			@FindBy(id = "com.mmi.maps:id/report_details_issue_desc")
			public @Getter WebElement issueDesc;

			@FindBy(id = "com.mmi.maps:id/helpful_text")
			public @Getter WebElement helpCount;

			@FindBy(id = "com.mmi.maps:id/item_world_view_action_like_txt")
			public @Getter WebElement helpful;

			@FindBy(id = "com.mmi.maps:id/item_world_view_action_share_txt")
			public @Getter WebElement shareReview;

			@FindBy(id = "android:id/chooser_header")
			public @Getter WebElement btmShtShareTextLayout;

			@FindBy(id = "android:id/profile_tabhost")
			public @Getter WebElement shareReviewTextTab;

			@FindBy(id = "android:id/text1")
			public @Getter WebElement btmShtshareText;

			@FindBy(id = "android:id/sem_chooser_chip_button")
			public @Getter WebElement sharetxtcopyBtn;
			
			@FindBy(id = "android:id/content_preview_text")
			public @Getter WebElement linkText;
			
			@FindBy(id = "com.android.intentresolver:id/copy")
			public @Getter WebElement linkcopy;
			//contact sync - invite option
			
			@FindBy(id = "com.mmi.maps:id/sc_searchview")
			public @Getter WebElement searchContact;
			
			@FindBy(id="com.mmi.maps:id/card_invite_all")
			public @Getter WebElement inviteCard;
			
			@FindBy(xpath="//android.widget.TextView[@text=\"Invite All\"]")
			public @Getter WebElement inviteCardText1;
			
			@FindBy(xpath="//android.widget.TextView[@text=\"your phonebook Contact\"]")
			public @Getter WebElement inviteCardText2;
			
			
			// welcome page 
			@FindBy(id="com.mmi.maps:id/header_title")
			public @Getter WebElement welcomeTitle;
		   
			@FindBy(id="com.mmi.maps:id/header_sub_title")
			public @Getter WebElement welcomePageSubTitle;

			@FindBy(id="com.mmi.maps:id/text_view_privacy_policy")
			public @Getter WebElement welcomePageDescription;
			
//			profile page   ////followers 
		  
			@FindBy(id="com.mmi.maps:id/container_followers")
			public @Getter WebElement container_followers;
		
//			com.mmi.maps:id/text_view_val_followers
			@FindBy(id="com.mmi.maps:id/text_view_val_followers")
			public @Getter WebElement container_followersCount;

			@FindBy(xpath="//android.widget.TextView[@text=\"Followers\"]")
			public @Getter WebElement followersCardText;
		  
		  
		//  My saves 
		  
			@FindBy(id="com.mmi.maps:id/container_contributions")
			public @Getter WebElement container_contributions;

			@FindBy(id="com.mmi.maps:id/text_view_val_contributions")
			public @Getter WebElement container_contributionsCount;
		 
			@FindBy(xpath=" //android.widget.TextView[@text=\"Saves\"]")
			public @Getter WebElement savesCardText;
		//  GAdgets
		  
			@FindBy(id="com.mmi.maps:id/container_devices")
			public @Getter WebElement container_devices; 
			
			@FindBy(id="com.mmi.maps:id/text_view_val_devices")
			public @Getter WebElement container_devicesCount;
			
			@FindBy(xpath="//android.widget.TextView[@text=\"Gadgets\"]")
			public @Getter WebElement GadgetsCardText;
			
			////////////////////my personal timeline 
//		    ==click 	
			@FindBy(id="com.mmi.maps:id/image_button_device_activity")
			public @Getter WebElement personalTimelineCard;
				
		//  ===My Personal Timeline
			@FindBy(id="com.mmi.maps:id/timeline_title")
			public @Getter WebElement personalTimelineTitle;
			
		//   ===Opens activity section for this gadget
			@FindBy(id="com.mmi.maps:id/timeline_sub_title")
			public @Getter WebElement personalTimelineSubTitle;
			
		//  after click 
		  
			@FindBy(xpath="//android.widget.TextView[@text=\"My Personal Timeline\"]")
			public @Getter WebElement personalTimelinePageTitle;
		  
			@FindBy(id="com.mmi.maps:id/top_layout")
			public @Getter WebElement personalTimePageSubTitle;
		  
			@FindBy(id="com.mmi.maps:id/today_txt")
			public @Getter WebElement todayText;
		  
			@FindBy(id="com.mmi.maps:id/timeline_selected_date_text_view")
			public @Getter WebElement dislayedDate;
		  
		//   if the recycler view is displayed === 
			@FindBy(id="com.mmi.maps:id/recycler_view_device_timeline")
			public @Getter WebElement recyclerViewTimeline;
		  
			@FindBy(id="com.mmi.maps:id/duration_layout")
			public @Getter WebElement durationLayout;
		  
			@FindBy(xpath="//android.widget.TextView[@text=\"Duration\"]")
			public @Getter WebElement duration;
		  
			@FindBy(id="com.mmi.maps:id/timeline_total_duration_txt")
			public @Getter WebElement durationText;

			@FindBy(xpath="//android.widget.TextView[@text=\"Distance:\"]")
			public @Getter WebElement distance;
			
			@FindBy(id="com.mmi.maps:id/timeline_total_distance_txt")
			public @Getter WebElement distanceText;
		  
			@FindBy(xpath="//android.widget.TextView[@text=\"Trail\"]")
			public @Getter WebElement personalTimelineTrail;

			@FindBy(id="com.mmi.maps:id/timeline_address_txt")
			public @Getter WebElement addressTrail;
		  
			@FindBy(id="com.mmi.maps:id/timeline_start_end_time")
			public @Getter WebElement personalTimelinetimeduration;
			
			//edit email in profile
		 
			@FindBy(id="com.mmi.maps:id/input_layout_email")
			public @Getter WebElement input_layout_email;
		  
			@FindBy(id="com.mmi.maps:id/edit_text_email")
			public @Getter WebElement edit_text_email;
		//  ahter click of email 
		//  com.mmi.maps:id/edit_text_email	
		//  ===Please enter a valid Email ID
			@FindBy(id="com.mmi.maps:id/textinput_error")
			public @Getter WebElement textinput_error;
		  
			@FindBy(id="com.mmi.maps:id/btn_next")
			public @Getter WebElement btn_next;
		
		
		@FindBy(id="com.mmi.maps:id/item_world_view_action_like_txt")
		public @Getter WebElement helpfulActionBtn;
			
			//ui for user profile
			//user profile UI
			// == class name
			@FindBy(xpath="//android.widget.TextView[@text=\"Profile\"]")
			public @Getter WebElement toolBarText;
			
			@FindBy(id="com.mmi.maps:id/share_profile_image_button")
			public @Getter WebElement shareBtnAtProfile;
			

			@FindBy(id="com.mmi.maps:id/user_profile_image_view")
			public @Getter WebElement imageAtProfile;
			@FindBy(id="com.mmi.maps:id/edit_profile_image_button")
			public @Getter WebElement editBtnAtProfile;
			
			@FindBy(id="com.mmi.maps:id/user_name_text_view")
			public @Getter WebElement nameTextDisplayAtPofile;
			
			@FindBy(id="com.mmi.maps:id/user_email_text_view")
			public @Getter WebElement emailTextDisplayAtProfile;
			
			@FindBy(id="com.mmi.maps:id/maptype_layer_button")
			public @Getter WebElement mapLayerButton;
			
			@FindBy(id="com.mmi.maps:id/edit_text_email")
			public @Getter WebElement emailTextEdit;
			
			@FindBy(id="com.mmi.maps:id/input_layout_email_phone")
			public @Getter WebElement input_layout_email_phone;
			
			@FindBy(id="com.mmi.maps:id/btn_next")
			public @Getter WebElement btn__Next;
			
			@FindBy(id="com.mmi.maps:id/mobile_edit_text")
			public @Getter WebElement mobile_edit_text;
			
			@FindBy(xpath="//android.widget.TextView[@text=\"Mobile Number\"]")
			public @Getter WebElement mobiletoolbar;
			
			@FindBy(xpath="//android.widget.TextView[@text=\"Edit Profile\"]")
			public @Getter WebElement emailToolbar;
			
			@FindBy(id="com.mmi.maps:id/text_view_otp")
			public @Getter WebElement textViewOTP;
			
			@FindBy(id="com.mmi.maps:id/btn_verify")
			public @Getter WebElement btn__Verify;
			
			@FindBy(id="com.mmi.maps:id/edit_text_otp")
			public @Getter WebElement enterOTP;
			
			@FindBy(id="com.mmi.maps:id/text_view_otp_timer")
			public @Getter WebElement otpTimer;
			
			@FindBy(id="com.mmi.maps:id/text_view_resend")
			public @Getter WebElement resendBtn;
			
			@FindBy(id="com.mmi.maps:id/snackbar_text")
			public @Getter WebElement snackBArMesssage;
			
			@FindBy(id="com.mmi.maps:id/ci_alias_tv")
			public @Getter WebElement nameContact;
			
			@FindBy(id="com.mmi.maps:id/helpful_text")
			public @Getter WebElement helptextCountVisibility;

			@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/textinput_error\"]")
			public @Getter WebElement nullcityValueErMsg;

}
