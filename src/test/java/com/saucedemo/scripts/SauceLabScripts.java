package com.saucedemo.scripts;

import com.saucedemo.pages.SauceHomePage;
import com.saucedemo.pages.SauceLoginPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testBase.TestBase;
import utils.ConfigReader;

import java.time.Duration;

public class SauceLabScripts extends TestBase {


    @Test(priority = 2)
    public void testSauceLab() throws InterruptedException {
        // Test case to perform positive scenario for login and product selection.

        // Login feature
        driver.get("https://www.saucedemo.com/");
        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.userLoginFunctionality();

        // Dropdown and product selection
        SauceHomePage homePage = new SauceHomePage(driver);
        homePage.priceLowToHighAndChooseProduct();

    }

    @Test(priority = 1)
    public void test2(){

       driver.get("https://www.google.com/");

    }

}
