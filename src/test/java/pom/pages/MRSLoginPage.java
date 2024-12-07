package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MRSLoginPage {


    public MRSLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "Pharmacy")
    public WebElement pharmacyLocation;

    @FindBy(id = "loginButton")
    public WebElement loginButton;


    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        pharmacyLocation.click();
        loginButton.click();
    }

}
