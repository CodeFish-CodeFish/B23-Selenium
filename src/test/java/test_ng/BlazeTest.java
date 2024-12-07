package test_ng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.DriverHelper;

public class BlazeTest {

    @Parameters({"name", "country", "city", "cc", "month", "year"})
    @Test
    public void test1(String name, String country, String city,
                      String cc, String month, String year) {
        WebDriver driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("blaze_url"));
        HomePage hp = new HomePage(driver);
        hp.selectMacBookAir();
        ProductPage pp = new ProductPage(driver);
        pp.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.placeOrder(name, country, city, cc, month, year);
    }


}
