package synchronization.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantityField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discountField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement nameField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zipField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visaCardRadioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement masterCardRadioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement americanExpressCardRadioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumberField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expireDateField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy(tagName = "strong")
    private WebElement successMsg;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement totalField;

    @FindBy(id = "ctl00_MainContent_fmwOrder_RegularExpressionValidator1")
    private WebElement quantityError;

    @FindBy(id = "ctl00_MainContent_fmwOrder_RequiredFieldValidator2")
    private WebElement customerNameError;

    @FindBy(id = "ctl00_MainContent_fmwOrder_RequiredFieldValidator3")
    private WebElement streetError;

    public void fillOrdersForm(String quantity, String name, String street, String city, String state, String zip, String cardNumber, String expireDate, int cardType) {
        WebElement quantityEl = BrowserUtils.waitForVisibility(quantityField, driver);
        quantityEl.sendKeys(quantity);
        nameField.sendKeys(name);
        streetField.sendKeys(street);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zip);

        switch (cardType) {
            case 1:
                visaCardRadioButton.click();
                break;
            case 2:
                masterCardRadioButton.click();
                break;
            case 3:
                americanExpressCardRadioButton.click();
                break;
            default:
                visaCardRadioButton.click();
        }


        cardNumberField.sendKeys(cardNumber);
        expireDateField.sendKeys(expireDate);
    }

    public void processButtonClick() {
        processButton.click();
    }

    public String getSuccessMsg() {
        WebElement successMsgEl = BrowserUtils.waitForVisibility(successMsg, driver);
        return successMsgEl.getText().trim();
    }

    public String getTotalValue() {
        return totalField.getAttribute("value");
    }

    public String getQuantityErrorMsg() {
        WebElement quantityErrorEl = BrowserUtils.waitForVisibility(quantityError, driver);
        return quantityErrorEl.getText().trim();
    }

    public String getErrorMsg(String type) {
        String errorMsg;
        switch (type) {
            case "customerName":
                errorMsg = customerNameError.getText().trim();
                break;
            case "street":
                errorMsg = streetError.getText().trim();
                break;

            default:
                errorMsg = customerNameError.getText().trim();
        }
        return errorMsg;
    }

    public void fillDiscount(String value) {
        discountField.clear();
        discountField.sendKeys(value);
    }


}
