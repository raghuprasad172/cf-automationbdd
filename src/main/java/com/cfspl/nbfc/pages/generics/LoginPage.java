package com.cfspl.nbfc.pages.generics;

import com.cfspl.nbfc.factory.DriverFactory;
import com.cfspl.nbfc.util.ActionUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.cfspl.nbfc.factory.DriverFactory.wait;

/**
 * @author Raghu Prasad
 */
public class LoginPage {

    private WebDriver driver;
    private ActionUtil actionUtil = new ActionUtil();
    protected By signInWithGoogle = By.xpath("//p[text()='Sign in with Google']/ancestor::button");

    protected By emailOrPhone = By.id("identifierId");
    protected By enterYourPassword = By.name("Passwd");

    protected By continueButton = By.xpath("//span[text()='Continue']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        return DriverFactory.getDriver().getTitle();
    }

    public boolean getLoginButtonIsDisplayed() {
        return driver.findElement(signInWithGoogle).isDisplayed();
    }

    public void clickOnSignInWithGoogle() throws Exception {
        //wait.until(ExpectedConditions.elementToBeClickable(signInWithGoogle));
        Thread.sleep(4000);
        driver.findElement(signInWithGoogle).click();
    }

    public void enterUserName(String userName) {
        actionUtil.switchToChildWindow(DriverFactory.getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(emailOrPhone));
        driver.findElement(emailOrPhone).sendKeys(userName, Keys.ENTER);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(enterYourPassword));
        driver.findElement(enterYourPassword).sendKeys(password, Keys.ENTER);

    }

    public HomePage clickOnContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
        actionUtil.switchToParentWindow(DriverFactory.getDriver());
        return new HomePage(driver);
    }


}
