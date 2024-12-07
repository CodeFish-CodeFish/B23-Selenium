package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    public SauceLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userName;

    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void userLoginFunctionality(){
        this.userName.sendKeys("standard_user");
        this.password.sendKeys("secret_sauce");
        this.loginButton.click();
    }


}
