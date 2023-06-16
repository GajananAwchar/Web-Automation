package tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class TestJenkins extends BaseClass {
	@Test
	public void launchurl() {
		seleniumFunctions.openUrl("https://www.google.com/");
		String actTitle = seleniumFunctions.getTItle();
		String expTitle = "Google";
		logger.info("Login Page Opened");
		softAssert.assertEquals(actTitle, expTitle, "Title Not Matching");
		logger.info("Test Passed");
		softAssert.assertAll();

	}
}