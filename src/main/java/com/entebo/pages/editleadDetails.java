package com.entebo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.entebo.genericLib.baseTest;

public class editleadDetails {
	
	@FindBy(xpath="(//input[@name='edit2'])[1]") private WebElement editBtn;
	
	public editleadDetails()
	{
		PageFactory.initElements(baseTest.driver, this);
	}
	public void clickeditBtn() {
		editBtn.click();
	}

}
