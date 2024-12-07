package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappAbTestPage {


    public HerokuappAbTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3")
    public WebElement header;

    @FindBy(tagName = "p")
    public WebElement paragraph;



}
