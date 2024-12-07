package test_ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsLink;

    @FindBy(xpath = "//a[text()='MacBook air']")
    private WebElement macBookAirLink;


    public void selectMacBookAir() {
        laptopsLink.click();
        macBookAirLink.click();
    }
}
