package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__002_LoginPage {

	
	public TC__002_LoginPage(WebDriver driver)
	{		
		PageFactory.initElements(driver, this);
	}
	
		
		@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.mmi.maps:id/text_view_name\"]")
		public @Getter WebElement loginTxt;
		
		@FindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.mmi.maps:id/inputPhoneNumber\"]")
		public @Getter WebElement isRgistrPageVisible;
}
	

