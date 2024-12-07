package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappHomePage {

    public HerokuappHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[@class='heading']")
    public WebElement header;

    @FindBy(tagName = "h2")
    public WebElement secondaryHeader;

    @FindBy(linkText = "A/B Testing")
    public WebElement abTestingLink;

    @FindBy(xpath = "//a[@href='/checkboxes']")
    public WebElement checkboxesLink;

    @FindBy(linkText = "Forgot Password")
    public WebElement forgotPasswordLink;










}
