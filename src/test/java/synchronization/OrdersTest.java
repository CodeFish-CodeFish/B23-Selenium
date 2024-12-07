package synchronization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import synchronization.pages.AllOrdersPage;
import synchronization.pages.OrderPage;
import synchronization.pages.OrdersLoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class OrdersTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
    }

    @Test
    public void test1() {
        OrdersLoginPage olp = new OrdersLoginPage(driver);
        String username = ConfigReader.readProperty("username");
        String password = ConfigReader.readProperty("password");
        olp.login(username, password);
    }

    @Test
    public void test2() {
        OrdersLoginPage olp = new OrdersLoginPage(driver);
        String username = ConfigReader.readProperty("username");
        String password = ConfigReader.readProperty("password");
        olp.login(username, password);
        AllOrdersPage allOrdersPage = new AllOrdersPage(driver);
        allOrdersPage.clickOrderLink();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrdersForm("2", "John Doe",
                "1 N State", "Chicago",
                "IL", "60606",
                "4444555577779999", "01/2027", 3);

        System.out.println(orderPage.getTotalValue());

        orderPage.processButtonClick();
        String actualSuccessMessage = orderPage.getSuccessMsg();
        String expectedSuccessMessage = "New order has been successfully added.";
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

    @Test
    public void test3() {
        OrdersLoginPage olp = new OrdersLoginPage(driver);
        String username = ConfigReader.readProperty("username");
        String password = ConfigReader.readProperty("password");
        olp.login(username, password);
        AllOrdersPage allOrdersPage = new AllOrdersPage(driver);
        allOrdersPage.clickOrderLink();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.processButtonClick();
        String actualQuantityError = orderPage.getQuantityErrorMsg();
        String expectedQuantityError = "Quantity must be greater than zero.";
        Assert.assertEquals(expectedQuantityError, actualQuantityError);

        String actualStreetError = orderPage.getErrorMsg("street");
        String expectedStreetError = "Field 'Street' cannot be empty.";
        Assert.assertEquals(expectedStreetError, actualStreetError);


        orderPage.fillDiscount("50");
        BrowserUtils.takeScreenshot(driver);


    }


}

