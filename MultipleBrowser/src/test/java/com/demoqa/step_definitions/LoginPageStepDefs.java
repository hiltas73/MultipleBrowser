package com.demoqa.step_definitions;

import com.demoqa.pages.LoginPage;
import com.demoqa.utilities.BrowserUtils;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.demoqa.utilities.Driver.getDriver;

public class LoginPageStepDefs {
    LoginPage login=new LoginPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @When("user goes to Book Store Page Without Login")
    public void userGoesToBookStorePageWithoutLogin(){
        String url = ConfigurationReader.getProperty("env");
        getDriver().get(url);


    }
    @And("user clicks to loginSubmodule Button")
    public void user_clicks_to_login_submodule_button() {
        wait.until(ExpectedConditions.elementToBeClickable(login.loginSubmodule));
        BrowserUtils.scrollToElement(login.loginSubmodule);
        login.loginSubmodule.click();
    }
    @And("user enters correct Username")
    public void user_enters_correct_username() {
        BrowserUtils.sleep(2);
        wait.until(ExpectedConditions.visibilityOf(login.inputUsername));
        String userName = ConfigurationReader.getProperty("username");
        login.inputUsername.sendKeys(userName);
    }
    @And("user enters correct Password")
    public void user_enters_correct_password() {
        String password = ConfigurationReader.getProperty("password");
        login.inputPassword.sendKeys(password);
    }
     @And("user click login Button")
    public void userClickLoginButton() {
        BrowserUtils.scrollToElement(login.loginButton);
        login.loginButton.click();
    }
    @Then("user should land on Dashboard")
    public void user_should_land_on_dashboard() {
        String actualUserName = login.actualUser.getText();
        String expectedUserName = "deneme1234";
        Assert.assertEquals(expectedUserName,actualUserName);
    }


    @And("user enters invalid username")
    public void userEntersIncorrectUsername() {
        String invalidUserName = ConfigurationReader.getProperty("invalidusername");
        login.inputUsername.sendKeys(invalidUserName);
    }

    @And("user enters invalid password")
    public void userEntersIncorrectPassword() {
        String invalidPassword = ConfigurationReader.getProperty("invalidpassword");
        login.inputPassword.sendKeys(invalidPassword);
    }

    @Then("user should not land on Dashboard")
    public void userShouldNotLandOnDashboard() {
        String actualMessage = login.actualMessage.getText();
        String expectedMessage = "Invalid username or password!";
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
