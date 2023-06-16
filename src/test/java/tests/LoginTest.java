package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage loginPage;
	@BeforeMethod
	public void setupConfig() {
		softAssert = new SoftAssert();
		loginPage = pageObjectManager.getLoginPage();
		logger = Logger.getLogger("LoginTest");
	}
	@Test
	public void testLogin() throws IOException {
		loginPage.maximizeWindow();
		loginPage.getUrl(readConfig.getApplicationUrl());
		logger.info("Login Page Opened");
		String actTitle = loginPage.getTitle();
		String expTitle = "Test Login | Practice Test Automation";
		softAssert.assertEquals(actTitle, expTitle);
		loginPage.enterUsername(readConfig.getUsername());
		logger.info("Entered Username");
		loginPage.enterPassword(readConfig.getPassword());
		logger.info("Entered Password");
		loginPage.clickLoginButton();
		logger.info("Clicked Login Button");
		String actualMessage = loginPage.getSucessMessage();
		String expMessage = "Logged In Successfully";
		logger.info("Logged In Sucessfully");
		softAssert.assertEquals(actualMessage, expMessage);
		String expTtitle1 = "Logged In Successfully | Practice Test Automation";
		String actTitle1 = loginPage.getTitle();
		softAssert.assertEquals(expTtitle1, actTitle1);
		logger.info("LoginTest Validation Done");
	}
	@AfterMethod
	public void close() {
		softAssert.assertAll();
	}
}
