package com.mappls.map.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class TC__025_RealViewPage {
	
	public TC__025_RealViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.mmi.maps:id/real_view_button")
	public @Getter WebElement realView360;

//	
//	@FindBy()
//	public @Getter WebElement ;
//	
//	@FindBy()
//	public @Getter WebElement ;
}
