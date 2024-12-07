package testBase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class TestBase {

    /*
    This class will serve as a base class for all tests classes.
    This class will initialize our driver and shut it down when our test
    executions are finished.
     */

    public WebDriver driver;

   @BeforeMethod
    public void initializeDriver(){

        driver = DriverHelper.getDriver();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
