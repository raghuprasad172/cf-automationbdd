package com.cfspl.nbfc.stepdefinitions;

import com.cfspl.nbfc.constants.IConstants;
import com.cfspl.nbfc.factory.DriverFactory;
import com.cfspl.nbfc.pages.generics.HomePage;
import com.cfspl.nbfc.pages.generics.LoginPage;
import com.cfspl.nbfc.util.FileUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Raghu Prasad
 */
public class LoginStepDefinition {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;
    private String loginPageTitle = "";
    private String homePageTitle = "";
    private boolean loginButtonIsDisplayed = false;

    @Given("agent is on login page")
    public void agent_is_on_login_page() {
        DriverFactory.getDriver().get(FileUtil.getPropertyValue(IConstants.envConfigFilePath, IConstants.testURL));
    }

    @When("agent gets the title of login page")
    public void agent_gets_the_title_of_login_page() {
        loginPageTitle = loginPage.getLoginPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedPageTitle) {
        Assert.assertEquals(loginPageTitle, expectedPageTitle);
    }


    @When("agent gets sign in with Google button is displayed or not")
    public void agent_gets_sign_in_with_google_button_is_displayed_or_not() {
        loginButtonIsDisplayed = loginPage.getLoginButtonIsDisplayed();
    }

    @Then("sign in with Google button should be displayed")
    public void sign_in_with_google_button_should_be_displayed() {
        Assert.assertTrue(loginButtonIsDisplayed);
    }
    @Given("agent clicks on sign in with google button")
    public void agent_clicks_on_sign_in_with_google_button() throws Exception {
        loginPage.clickOnSignInWithGoogle();
    }

    @When("agent enters username {string} into username textfield")
    public void agent_enters_username_into_username_textfield(String userName) {
        loginPage.enterUserName(FileUtil.getPropertyValue(IConstants.envConfigFilePath,IConstants.emailID));
    }

    @When("agent enters password {string} into password texfield")
    public void agent_enters_password_into_password_texfield(String password) {
        loginPage.enterPassword(FileUtil.getPropertyValue(IConstants.envConfigFilePath,IConstants.password));
    }

    @When("agent clicks on login button")
    public void agent_clicks_on_login_button() {
        homePage= loginPage.clickOnContinue();
    }

    @Then("agent should gets the title of home page")
    public void agent_should_gets_the_title_of_home_page() {
           homePageTitle= homePage.getHomePageTitle();
    }

    @Then("the home page title should be {string}")
    public void the_home_page_title_should_be(String homepageTitle) {
        Assert.assertEquals(homePageTitle,homepageTitle);
    }





}
