package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappForgotPasswordPage {

    public HerokuappForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    public WebElement header;

    @FindBy(id = "email")
    public WebElement emailTextField;

    @FindBy(className = "radius")
    public WebElement retrievePwdButton;

    @FindBy(tagName = "h1")
    public WebElement secondHeader;


}
