package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.DriverHelper;


public class Practice1 {

    @Test(priority = 150)
    public void test1() {
        System.out.println("Running test1...");
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10, timeOut = 10000)
    public void test2() {
        System.out.println("Running test2...");
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 100, enabled = false)
    public void test3() {
        System.out.println("Running test3...");
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        String expectedHeader = "Welcome to the-internet";
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = header.getText();
        Assert.assertEquals(actualHeader, expectedHeader,
                "Failed to validate page header");

    }

    @Test(invocationCount = 4, description = "This test simply prints out text")
    public void test4() {
        System.out.println("Running test4...");
    }


    @BeforeClass
    public void beforeClassHook() {
        System.out.println("Before class hook");

        //java code to create user
    }

    @AfterClass
    public void afterClassHook() {
        System.out.println("After class hook");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test hook");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test hook");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method hook");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method hook");
    }

    @BeforeSuite
    public void before(){
        System.out.println("Before suite hook");
    }

    @AfterSuite
    public void after(){
        System.out.println("After suite hook");
    }




}
