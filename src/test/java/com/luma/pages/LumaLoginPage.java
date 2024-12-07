package com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LumaLoginPage {


    public LumaLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    WebElement username;

    @FindBy(css = "input[name='login[password]']")
    WebElement password;

    @FindBy(xpath = "//button[@class='action login primary']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement errorMessage;

    public void loginFunctionality(WebDriver driver, String username, String password, String errorMessage){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        BrowserUtils.scrollByAmountDynamic(driver, 0, 500);
        this.loginButton.click();
        String actualErrorMessage = this.errorMessage.getText().trim();
        Assert.assertEquals(actualErrorMessage, errorMessage, "Failed to validate the error message");

    }

}
