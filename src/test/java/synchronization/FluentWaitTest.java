package synchronization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import synchronization.pages.HomePage;
import synchronization.pages.InputsPage;
import utils.DriverHelper;

public class FluentWaitTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void test1() {

        HomePage hp = new HomePage(driver);
        hp.clickInputLink();
        InputsPage ip = new InputsPage(driver);
        String actualHeader = ip.getHeaderText();
        String expectedHeader = "Inputs";
        Assert.assertEquals(expectedHeader, actualHeader);
    }


}
