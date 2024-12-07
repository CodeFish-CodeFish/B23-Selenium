package synchronization.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicContentPage {

    private WebDriver driver;

    public DynamicContentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(tagName = "h3")
    private WebElement header;

    public String getHeaderText() {
        //explicit wait
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOf(header));
        return pageHeader.getText();
    }


}
