package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MRSRegisterNewPatientPage {

    public MRSRegisterNewPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "givenName")
    public WebElement firstNameField;

    @FindBy(name = "familyName")
    public WebElement lastNameField;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(id="gender-field")
    public WebElement gender;



    public void registerPatient(String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        nextButton.click();
        Select dd = new Select(gender);
        dd.selectByVisibleText("Female");
        nextButton.click();



    }


}
