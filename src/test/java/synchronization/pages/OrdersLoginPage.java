package synchronization.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrdersLoginPage {

    private WebDriver driver;

    public OrdersLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement usernameField;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement passwordField;

    @FindBy(id = "ctl00_MainContent_login_button")
    private WebElement enterButton;

    public void login(String username, String password) {
        WebElement usernameFieldElement = BrowserUtils.waitForVisibility(usernameField, driver);
        usernameFieldElement.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();

    }


}
