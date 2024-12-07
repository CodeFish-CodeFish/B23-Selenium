package pom.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.pages.HerokuappAbTestPage;
import pom.pages.HerokuappForgotPasswordPage;
import pom.pages.HerokuappHomePage;

import java.time.Duration;

public class HerokuAppTest {
    WebDriver driver;


    @Before // hook, will run before every @Test in this class
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }


    @Test
    public void test1() {
        HerokuappHomePage homePage = new HerokuappHomePage(driver);
        String headerText = homePage.header.getText();
        Assert.assertEquals("Welcome to the-internet", headerText);

        String secondaryHeaderText = homePage.secondaryHeader.getText();
        Assert.assertEquals("Available Examples", secondaryHeaderText);
    }

    @Test
    public void test2() {
        HerokuappHomePage homePage = new HerokuappHomePage(driver);
        homePage.abTestingLink.click();
        HerokuappAbTestPage abTestPage = new HerokuappAbTestPage(driver);
        String headerText = abTestPage.header.getText();
        String expectedHeaderText = "A/B Test Control";
        Assert.assertEquals(expectedHeaderText, headerText);

        String paragraphText = abTestPage.paragraph.getText();
        Assert.assertTrue(paragraphText.contains("testing"));
    }

    @Test
    public void test3() {

        HerokuappHomePage homePage = new HerokuappHomePage(driver);
        homePage.forgotPasswordLink.click();

        HerokuappForgotPasswordPage forgotPasswordPage =
                new HerokuappForgotPasswordPage(driver);
        String headerText = forgotPasswordPage.header.getText();
        String expectedHeaderText = "Forgot Password";
        Assert.assertEquals(expectedHeaderText, headerText);
        forgotPasswordPage.emailTextField.sendKeys("test@test.com");
        forgotPasswordPage.retrievePwdButton.click();

        String secondHeaderText = forgotPasswordPage.secondHeader.getText();
        String expectedSecondHeader = "Internal Server Error";
        Assert.assertEquals(expectedSecondHeader, secondHeaderText);


    }


}
