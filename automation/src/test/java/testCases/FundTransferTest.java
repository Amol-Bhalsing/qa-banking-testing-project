package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import pageObjects.TransferPage;
import testBase.BaseTest;

public class FundTransferTest extends BaseTest {
    @Test
    public void verifyFundTransfer() {
        test = extent.createTest("Fund Transfer Test");

        try {
            logger.info("Starting Fund Transfer Test");

            // Step 1: Login
            LoginPage loginPage = new LoginPage(driver);
            logger.debug("LoginPage object created");

            loginPage.enterUsername("john");
            logger.debug("Entered username");

            loginPage.enterPassword("demo");
            logger.debug("Entered password");

            loginPage.clickLogin();
            logger.info("Clicked login");

            test.log(Status.INFO, "Login successful");

            // Step 2: Transfer Funds
            TransferPage transferPage = new TransferPage(driver);
            logger.debug("TransferPage object created");

            transferPage.clickTransferFunds();
            logger.info("Clicked on Transfer Funds");

            transferPage.enterAmount("100");
            logger.debug("Entered amount: 100");

            transferPage.clickTransferButton();
            logger.info("Clicked Transfer button");


         // Step 3: Assert success
            if (transferPage.verifySuccess()) {
                logger.info("✅ Fund transfer verified successfully.");
                test.log(Status.PASS, "✅ Fund transfer verified successfully.");
            } else {
                logger.error("❌ Fund transfer failed or success message not found.");
                test.log(Status.FAIL, "❌ Fund transfer failed or success message not found.");
                Assert.fail("Fund transfer failed or success message not found.");
            }

        } catch (Exception e) {
            logger.error("Test failed due to exception: " + e.getMessage());
            test.log(Status.FAIL, "Test failed due to: " + e.getMessage());
            Assert.fail();

        }
    }

}
