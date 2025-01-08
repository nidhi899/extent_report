package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__006_CameraOffPage extends BasePage{
	

	public TC__006_CameraOffPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.mmi.maps:id/add_image_layout")
	public @Getter WebElement addImageLayout;
		
	@FindBy(id="com.mmi.maps:id/add_image_text")
	public @Getter WebElement addImageText;
	
	@FindBy(id="com.mmi.maps:id/design_bottom_sheet")
	public @Getter WebElement AddImageBtmSht;
	
	@FindBy(id="com.mmi.maps:id/linear_layout_mappls_cam")
	public @Getter WebElement mapplsCamCont;
	
	@FindBy(id="com.mmi.maps:id/text_view_title")
	public @Getter WebElement mapplsCamContText;
		
	@FindBy(id="com.mmi.maps:id/linear_layout_gallery")
	public @Getter WebElement galleryCont;
	@FindBy(id="com.mmi.maps:id/text_view_gallery")
	public @Getter WebElement galleryContText;

	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.android.permissioncontroller:id/permission_message\"]")
	public @Getter WebElement permissionBoxTitle;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	public @Getter WebElement WhileUsingAppOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]")
	public @Getter WebElement onlyThisTimeOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	public @Getter WebElement dontAllowOption;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	public @Getter WebElement allowOption;
	
	
	@FindBy(id="com.mmi.maps:id/image_view_take_picture")
	public @Getter WebElement clickPictureBtn;
	
//	@FindBy()
//	public @Getter WebElement ;
//	
//	@FindBy()
//	public @Getter WebElement ;
//	
//	@FindBy()
//	public @Getter WebElement ;
//	
//	@FindBy()
//	public @Getter WebElement ;
//	
//	@FindBy()
//	public @Getter WebElement ;
}
