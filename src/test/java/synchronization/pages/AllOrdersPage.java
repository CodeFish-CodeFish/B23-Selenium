package synchronization.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AllOrdersPage {

    private WebDriver driver;

    public AllOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Order']")
    private WebElement orderLink;

    public void clickOrderLink() {
        WebElement orderLinkEl = BrowserUtils.waitForClickability(orderLink, driver);
        orderLinkEl.click();
    }

}
