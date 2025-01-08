package com.mappls.map.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__003_ForgotPswPage {
	
	public TC__003_ForgotPswPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}

	//used
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/textForgotPassword\"]")
	public @Getter WebElement forgotPswLink;
	
//	forgot psw page ui -
	@FindBy(xpath="//android.widget.Image[@text=\"logo\"]")
	public @Getter WebElement mapplsLogo;

	@FindBy(xpath="//android.widget.TextView[@text=\"Forgot Password?\"]")
	public @Getter WebElement forgotPswTxt;
	
	
	@FindBy(xpath="//android.view.View[@text=\"Email / Mobile number\"]")
	public @Getter WebElement mailOrMobileInputField;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Back to \"]")
	public @Getter WebElement backTo;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Sign In\"]")
	public @Getter WebElement signIn;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Reset\"]")
	public @Getter WebElement resetBtn;
	
	
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.google.android.apps.messaging:id/conversation_list_spam_popup_positive_button\"]")
	public @Getter WebElement spamPrtoctionPermission;

	
	@FindAll({@FindBy(id="com.google.android.apps.messaging:id/conversation_snippet") }) 
	public @Getter List<WebElement> msgList;
	
	
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.apps.messaging:id/conversation_icon\"])[1]")
	public @Getter WebElement openOtp;
	
	
	
	@FindBy(xpath = "//android.view.View[@text=\"Enter One Time Password\"]")
	public @Getter WebElement enterOTP;
	
	@FindBy(className = "android.widget.EditText")
	public @Getter WebElement enterOtpField;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.apps.messaging:id/conversation_name\" and @text=\"CP-MMIOTP\"]")
	public @Getter WebElement mapplsMsg;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Verify\"]")
	public @Getter WebElement verifyOtp;
	
	
	@FindBy(xpath = "//android.view.View[@text=\"Password\"]")
	public @Getter WebElement password;
	
	@FindBy(xpath = "//android.view.View[@text=\"Confirm password\"]")
	public @Getter WebElement confirmPsw;
	
	
	@FindBy(xpath = "//android.widget.Button[@text=\"Submit\"]")
	public @Getter WebElement submitBtn;
	
	@FindBy(xpath = "//android.view.View[@resource-id=\"guidelines\"]")
	public @Getter WebElement pswGuidlines;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/autofill_save_no\"]")
	public @Getter WebElement pswNotSave;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Your password has been changed successfully.\"]")
	public @Getter WebElement pswChanged;
	
	
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"text\"]")
	public @Getter WebElement getMobileTxt;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please enter a valid email / phone number\"]")
	public @Getter WebElement alrtMsg;
	
	//==============
	@FindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
	public @Getter WebElement signInLink;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Enter One Time Password\"]")
	public @Getter WebElement resetClickNxtPage;
	
	//email launched 
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/welcome_tour_got_it\"]")
	public @Getter WebElement gotItClick;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_display_name\" and @text=\"Nidhi kumari\"]")
	public @Getter WebElement mailUserName;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]")
	public @Getter WebElement takeToMeClick;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
	public @Getter WebElement closeDesc;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/subject\" and @text=\"One Time Password for Mappls App\"]")
	public @Getter WebElement mailMapplsApp;
	
	@FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Show contact information for Mappls App\"])[2]")
	public @Getter WebElement mapplsMapDealLaterRemove;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]")
	public @Getter WebElement getOTPViaMail;
	
	
//	===========================
	
	
//	@FindBy(xpath = "com.google.android.gm:id/snippet")
//	public @Getter WebElement mailMsg;
	
	
	@FindAll({@FindBy(id="com.google.android.gm:id/snippet") }) 
	public @Getter List<WebElement> mailMsg;
	
//	@FindAll({@FindBy(id="com.google.android.apps.messaging:id/conversation_snippet") }) 
//	public @Getter List<WebElement> msgList;
	
	
	
	
	
	
}
