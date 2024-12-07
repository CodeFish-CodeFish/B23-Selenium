package com.luma.lumaTests;

import com.luma.pages.LumaLoginPage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class LumaTests extends TestBase {


    @Test(dataProvider = "dataFrLuma", dataProviderClass = DataProviderForLuma.class)
    public void validateLumaLoginFunctionality(String username, String password, String errorMessage){
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        LumaLoginPage loginPage = new LumaLoginPage(driver);
        loginPage.loginFunctionality(driver,username, password, errorMessage);
    }



}
