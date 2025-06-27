package testCases;

import org.testng.Assert;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class DataDrivenLoginTest extends BaseTest {
    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void verifyLogin(String username, String password) {
        test = extent.createTest("Login Test with Data: " + username + "/" + password);
        logger.info("🔑 Attempting login with: " + username + " / " + password);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        logger.debug("Entered username: " + username);

        loginPage.enterPassword(password);
        logger.debug("Entered password: " + password);

        loginPage.clickLogin();
        logger.info("Clicked login button");

        if (username.equals("john") && password.equals("demo")) {
            if (driver.getTitle().contains("ParaBank")) {
                logger.info("✅ Login successful for valid credentials");
                test.log(Status.PASS, "✅ Login successful for valid credentials");
            } else {
                logger.error("❌ Expected title not found for valid login");
                test.log(Status.FAIL, "❌ Expected title not found for valid login");
                Assert.fail("Login should have succeeded but did not.");
            }
        } else {
            if (driver.getPageSource().toLowerCase().contains("error")) {
                logger.info("✅ Error displayed correctly for invalid credentials");
                test.log(Status.PASS, "✅ Error displayed correctly for invalid credentials");
            } else {
                logger.error("❌ No error message displayed for invalid credentials");
                test.log(Status.FAIL, "❌ No error message displayed for invalid credentials");
                Assert.fail("Login should have failed, but error not displayed.");
            }
        }
        logger.info("✅ Test finished for user: " + username);

    }

}
