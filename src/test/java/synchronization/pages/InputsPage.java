package synchronization.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class InputsPage {

    private WebDriver driver;

    public InputsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(tagName = "h4")
    private WebElement header;


    public String getHeaderText() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Could not locate element, will check again")
                .ignoring(NoSuchElementException.class);

        WebElement headerElement = fluentWait.until(ExpectedConditions.visibilityOf(header));
        return headerElement.getText();
    }


}
