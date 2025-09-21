package com.ShoppersStack_TestScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.BaseTest;
import com.ShoppersStack_POM.MyAddresses_Page;
import com.ShoppersStack_POM.MyProfile_Page;

public class TC_02_VerifyUserIsAbleToDeleteAddressOrNot_Test extends BaseTest {

	@Test
	public void deleteAddress() throws InterruptedException, IOException {

		Thread.sleep(2000);
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();

		MyProfile_Page myProfile = new MyProfile_Page(driver);
		myProfile.getMyAddressesBtn().click();

		MyAddresses_Page myAddresses = new MyAddresses_Page(driver);
		Thread.sleep(2000);
		myAddresses.getDeleteBtn().click();
		myAddresses.getYesBtn().click();

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		webDriverUtility.captureWebPageScreenshot(driver);

	}

}
