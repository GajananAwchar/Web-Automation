package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {
	private HomePage homePage;
	private LoginPage loginPage;
	@BeforeMethod
	public void setupConfig() {
		softAssert = new SoftAssert();
		homePage = pageObjectManager.getHomePage();
		logger = Logger.getLogger("Home Page Test");
		loginPage = pageObjectManager.getLoginPage();
	}

	@Test(priority = 0)
	public void testLogin() throws IOException {
		loginPage.maximizeWindow();
		loginPage.getUrl(readConfig.getApplicationUrl());
		loginPage = pageObjectManager.getLoginPage();
		logger = Logger.getLogger("LoginTest");
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
	@Test(priority = 3)
	public void logoutTest() throws IOException {
		homePage.clickLogoutBtn(); 
		logger.info("Clicked on Logout Btn");
		String actTitle = homePage.getTitle();
		String expTitle = "Test Login | Practice Test Automation";
		softAssert.assertEquals(actTitle, expTitle);
		logger.info("Logged out Sucessfully");
		softAssert.fail();
	}
	@Test(priority = 2)
	public void verifyMenuItems() {
		int actSize = homePage.getMenuItemsSize();
		int expSize = 5;
		softAssert.assertEquals(actSize, expSize);
		logger.info("verified MenuItemsSize");
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String actTitle = homePage.getTitle();
		String expTitle = "Logged In Successfully | Practice Test Automation ";
		softAssert.assertEquals(actTitle, expTitle);
		logger.info("verified HomePage Title");
	}
	 @Test(enabled = false)
	 public void skipTestSample() {
		 System.out.println("Test Skipped");
	 }
}
