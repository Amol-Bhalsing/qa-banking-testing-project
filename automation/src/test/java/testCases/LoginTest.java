package testCases;

import org.testng.Assert;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import testBase.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        test = extent.createTest("Login With Valid Credentials");
        logger.info("🔐 Starting valid login test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");
        logger.info("Entered valid username");

        loginPage.enterPassword("demo");
        logger.info("Entered valid password");

        loginPage.clickLogin();
        logger.info("Clicked login button");

        if (driver.getTitle().contains("ParaBank")) {
            logger.info("✅ Login successful with valid credentials");
            test.log(Status.PASS, "✅ Login successful with valid credentials");
        } else {
            logger.error("❌ Login failed with valid credentials");
            test.log(Status.FAIL, "❌ Login failed with valid credentials");
            Assert.fail("Login failed with valid credentials");
        }
    }

    @Test
    public void loginWithInvalidCredentials() {
        test = extent.createTest("Login With Invalid Credentials");
        logger.info("🔐 Starting invalid login test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalid");
        logger.info("Entered invalid username");

        loginPage.enterPassword("wrongpass");
        logger.info("Entered invalid password");

        loginPage.clickLogin();
        logger.info("Clicked login button");

        if (driver.getPageSource().contains("error")) {
            logger.info("✅ Error displayed as expected for invalid login");
            test.log(Status.PASS, "✅ Error displayed as expected for invalid login");
        } else {
            logger.error("❌ No error message for invalid login");
            test.log(Status.FAIL, "❌ No error message for invalid login");
            Assert.fail("No error message appeared for invalid login");
        }

    }
}
