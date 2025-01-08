package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__001_RegistrationPage {
	
	public TC__001_RegistrationPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	//used
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/buttonContinueText\"]")
	public @Getter WebElement enterFullNameTxt;
	
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.mmi.maps:id/fragment_home_screen_toolbar\"]/android.widget.ImageButton")
	public @Getter WebElement hamburgerIconClick;

	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement userLogin;

	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement enterUserPhoneNumber;

	@FindBy(id="com.mmi.maps:id/login_btn_text")
	public @Getter WebElement continueBtnLocator;

	@FindBy(id="com.mmi.maps:id/editTextUsername")
	public @Getter WebElement enterUserFullName;

	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement enterPsw;

	@FindBy(id="com.mmi.maps:id/editTextReEnterPassword")
	public @Getter WebElement reEnterPsw;

	//registration
	@FindBy(id="com.mmi.maps:id/buttonContinueText")
	public @Getter WebElement continueBtn;

	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement getUserName;

	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.mmi.maps:id/design_menu_item_text\" and @text=\"Settings\"]") 
	public @Getter WebElement settings;
	
	//=====================updated=======================
	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement nrpLoginClk;
	
	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement enterNewUsr;
	
	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement existPsw;
	
	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement userName;
	
	@FindBy(id="com.mmi.maps:id/login_button")
	public @Getter WebElement continueBTN;
	
	@FindBy(id="com.mmi.maps:id/inputUsername")
	public @Getter WebElement enterNewName;
	
	
	@FindBy(id="com.mmi.maps:id/editTextPassword")
	public @Getter WebElement enterpsw;
	
	@FindBy(id="com.mmi.maps:id/btn_text")
	public @Getter WebElement loginBTN;
	
	@FindBy(id="com.mmi.maps:id/edit_profile_image_button")
	public @Getter WebElement loginEditBtn;
	
	@FindBy(id="com.mmi.maps:id/edit_text_username")
	public @Getter WebElement loginUName;
	
	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement loginUMail;
	
	@FindBy(id="com.mmi.maps:id/mobile_edit_text")
	public @Getter WebElement loginUNumber;
	
//	@FindBy(id="com.mmi.maps:id/login_button")
//	public @Getter WebElement enterNewNamr;
//	@FindBy(id="com.mmi.maps:id/login_button")
//	public @Getter WebElement enterNewNamr;
	
	
	
	@FindBy(id="com.mmi.maps:id/text_view_skip")
	public @Getter WebElement skipBtn;
	
	//update profile
	@FindBy(id="com.mmi.maps:id/button_update_profile")
	public @Getter WebElement update;
	
	
	@FindBy(id="com.mmi.maps:id/edit_text_email")
	public @Getter WebElement enterMobile;
	
	@FindBy(id="com.mmi.maps:id/btn_next")
	public @Getter WebElement nextBTN;

	
	
	@FindBy(id="com.mmi.maps:id/edit_text_otp")
	public @Getter WebElement enterOTP;
	
	@FindBy(id="com.mmi.maps:id/btn_verify")
	public @Getter WebElement verfyBTN;
	
	@FindBy(id="com.mmi.maps:id/user_name_text_view")
	public @Getter WebElement upName;
	
	
	@FindBy(id="com.mmi.maps:id/text_view_name")
	public @Getter WebElement hmUName;
	
	@FindBy(id="com.mmi.maps:id/text_view_update_profile")
	public @Getter WebElement updateProfile;
	
	@FindBy(id="com.mmi.maps:id/text_view_change_password")
	public @Getter WebElement deleteAcount;
	
	@FindBy(xpath="(//*[@class='android.widget.EditText'])[1]")
	public @Getter WebElement enterMailForDltion;
	
	@FindBy(xpath="(//*[@class='android.widget.EditText'])[2]")
	public @Getter WebElement enterPswForDltion;
	
	@FindBy(xpath="//*[contains(@text, 'Go Ahead')]")
	public @Getter WebElement goAheadBtn;
	
	@FindBy(xpath="//*[@text='Don't Delete']")
	public @Getter WebElement cancelDltBtn;
	
	
	//for new test cases
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/buttonContinueText\"]")
	public @Getter WebElement continueBtnTxt;

	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.mmi.maps:id/header_skip_btn\"]")
	public @Getter WebElement rgisterSkipBtn;

}
