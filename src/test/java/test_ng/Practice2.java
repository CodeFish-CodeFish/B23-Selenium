package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class Practice2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Parameters({"number"})
    @Test(enabled = false)
    public void inputTest(String myNumber) {
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(myNumber);
    }


    @Parameters({"email", "password"})
    @Test
    public void loginTest(String myEmail, String password) {
        driver.get("https://facebook.com");
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        emailField.sendKeys(myEmail);
        passwordField.sendKeys(password);

    }


}
