package js_alerts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertPractice {
    public WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
    }

    @Test
    public void validatePopTexts() throws InterruptedException {

        driver.findElement(By.xpath("//h5[contains(.,'Normal alert')]//following-sibling::button")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        String expectedJsText = "Oops, something went wrong!";
        String actualJsText = alert.getText();

        //Assertion
        Assert.assertEquals("Failed to validate JS alert text",expectedJsText, actualJsText);
        alert.accept();


        driver.findElement(By.xpath("//h5[contains(.,'SweetAlert')]//following-sibling::button")).click();
        Thread.sleep(3000);
        WebElement secondAlertText = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        String actualSecondPopUpText = secondAlertText.getText();
        String expectedSecondPopUpText = "Something went wrong!";

        //Assertion
        Assert.assertEquals("Failed to validate second pop up window text",expectedSecondPopUpText, actualSecondPopUpText);

        driver.findElement(By.xpath("//button[.='OK']")).click();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
