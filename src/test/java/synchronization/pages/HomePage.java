package synchronization.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Dynamic Content")
    private WebElement dynamicContentLink;

    @FindBy(linkText = "Inputs")
    private WebElement inputsLink;

    @FindBy(linkText = "Context Menu")
    private WebElement contextMenu;


    public void clickDynamicContentLink() {
        dynamicContentLink.click();
    }

    public void clickInputLink() {
        inputsLink.click();
    }

    public void clickContextClickLink() {
        WebElement contextMenuElement = BrowserUtils.waitForClickability(contextMenu, driver);
        contextMenuElement.click();
    }


}
