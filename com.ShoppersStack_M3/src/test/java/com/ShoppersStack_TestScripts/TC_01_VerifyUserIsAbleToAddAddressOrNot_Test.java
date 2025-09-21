package com.ShoppersStack_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.BaseTest;
import com.ShoppersStack_POM.AddressForm_Page;
import com.ShoppersStack_POM.MyAddresses_Page;
import com.ShoppersStack_POM.MyProfile_Page;

public class TC_01_VerifyUserIsAbleToAddAddressOrNot_Test extends BaseTest {

	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(2000);
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();

		MyProfile_Page myProfile = new MyProfile_Page(driver);
		myProfile.getMyAddressesBtn().click();

		MyAddresses_Page myAddresses = new MyAddresses_Page(driver);
		myAddresses.getAddAddressBtn().click();

		AddressForm_Page addressForm = new AddressForm_Page(driver);
		addressForm.getOfficeRBtn().click();
		addressForm.getNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addressForm.getHouseTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addressForm.getStreetTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		addressForm.getLandmarkTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		webDriverUtility.selectByValue(addressForm.getCountryDropDown(),
				fileUtility.readDataFromPropertyFile("country"));
		webDriverUtility.selectByValue(addressForm.getStateDropDown(), fileUtility.readDataFromPropertyFile("state"));
		webDriverUtility.selectByValue(addressForm.getCityDropDown(), fileUtility.readDataFromPropertyFile("city"));

		addressForm.getPincodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addressForm.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addressForm.getAddAddressBtn().click();

		homePage.getCloseBtn().click();

		Thread.sleep(2000);
		webDriverUtility.captureWebPageScreenshot(driver);

	}

}
