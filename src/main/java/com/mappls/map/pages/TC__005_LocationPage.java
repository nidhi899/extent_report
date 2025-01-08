package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__005_LocationPage {
	public TC__005_LocationPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
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
	

	
//	@FindBy()
//	public @Getter WebElement ;
}
