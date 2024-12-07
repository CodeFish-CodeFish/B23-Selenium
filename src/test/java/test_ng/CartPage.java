package test_ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement ccField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;


    public void placeOrder(String name, String country, String city,
                           String cc, String month, String year) {
        placeOrderButton.click();
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        ccField.sendKeys(cc);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        purchaseButton.click();
    }
}
