package synchronization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import synchronization.pages.DynamicContentPage;
import synchronization.pages.HomePage;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitWaitTest {
    private WebDriver driver;

    //hook
    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/");
        HomePage hp = new HomePage(driver);
        hp.clickDynamicContentLink();
        DynamicContentPage dcp = new DynamicContentPage(driver);
        String actualHeader = dcp.getHeaderText();
        String expectedHeader = "Dynamic Content";
        Assert.assertEquals(expectedHeader, actualHeader);
    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Codefish"));
    }

    @Test
    public void test3(){
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.clickContextClickLink();
    }








}
