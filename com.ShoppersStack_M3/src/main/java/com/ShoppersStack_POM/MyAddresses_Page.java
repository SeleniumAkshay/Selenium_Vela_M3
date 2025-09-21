package com.ShoppersStack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddresses_Page {
	
	public MyAddresses_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiButton-startIcon')])[2]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "(//button[text()='Yes'])[1]")
	private WebElement yesBtn;

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

}
