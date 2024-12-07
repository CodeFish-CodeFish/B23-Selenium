package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MRSHomePage {

    public MRSHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h4")
    public WebElement successMsg;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    public WebElement registerPatient;

    public String getSuccessMsg() {
        String message = successMsg.getText().trim();
        return message;
    }

    public void clickRegisterPatient() {
        registerPatient.click();
    }


}
