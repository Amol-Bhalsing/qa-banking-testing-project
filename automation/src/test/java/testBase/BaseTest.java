package testBase;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ExtentManager;

import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import utilities.ScreenshotUtil;

//Log4j2 Imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    public WebDriver driver;
    public ExtentReports extent = ExtentManager.getReportObject();
    public ExtentTest test;
    public Logger logger;

    @BeforeMethod
    public void setup() {
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//Log4j

    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            try {
            	test.fail("Test Failed. Screenshot attached.", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                test.fail("Failed to attach screenshot: " + e.getMessage());
            }
        }
        driver.quit();
        extent.flush();

    }

}
