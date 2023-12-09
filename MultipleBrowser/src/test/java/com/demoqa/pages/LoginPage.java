package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    public WebElement loginSubmodule;
    @FindBy(xpath = "//input[@id='userName']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[@id='login']")
    public WebElement loginButton;
    @FindBy(xpath = "//label[@id='userName-value']")
    public WebElement actualUser;
    @FindBy(xpath = "//p[@id='name']")
    public WebElement actualMessage;
}
