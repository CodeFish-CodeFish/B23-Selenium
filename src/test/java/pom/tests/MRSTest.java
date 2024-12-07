package pom.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.pages.MRSHomePage;
import pom.pages.MRSLoginPage;
import pom.pages.MRSRegisterNewPatientPage;


import java.time.Duration;

public class MRSTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }


    @Test
    public void loginTest() {
        MRSLoginPage loginPage = new MRSLoginPage(driver);
        loginPage.login("admin", "Admin123");

        MRSHomePage homePage = new MRSHomePage(driver);
        String expectedMessage = "Logged in as Super User (admin) at Pharmacy.";
        String actualMessage = homePage.getSuccessMsg();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void registerPatientTest() {
        MRSLoginPage loginPage = new MRSLoginPage(driver);
        loginPage.login("admin", "Admin123");

        MRSHomePage homePage = new MRSHomePage(driver);
        homePage.clickRegisterPatient();

        MRSRegisterNewPatientPage newPatientPage = new MRSRegisterNewPatientPage(driver);
        newPatientPage.registerPatient("Sarah", "Connor");
    }


}
