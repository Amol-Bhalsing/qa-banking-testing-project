package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends BasePage {
    public TransferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Transfer Funds")
    WebElement transferLink;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(id = "fromAccountId")
    WebElement fromAccount;

    @FindBy(id = "toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferBtn;

    @FindBy(xpath = "//h1[contains(text(),'Transfer Complete')]")
    WebElement successMsg;

    public void clickTransferFunds() {
        transferLink.click();
    }

    public void enterAmount(String amt) {
        amountField.sendKeys(amt);
    }

    public void clickTransferButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(transferBtn));

    	transferBtn.click();
    }

    public boolean verifySuccess() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(successMsg));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace(); // Helpful during test failure
            return false;
        }

    }

}
