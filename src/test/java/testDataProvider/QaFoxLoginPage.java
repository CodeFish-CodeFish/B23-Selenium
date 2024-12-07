package testDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class QaFoxLoginPage {

    public QaFoxLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#input-email")
    WebElement username;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "input[class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
    WebElement errorMessage;

    public void setLogin(String username, String password, String errorMessage){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
        String actualMessage = this.errorMessage.getText();
        Assert.assertEquals(actualMessage, errorMessage);

    }



}
