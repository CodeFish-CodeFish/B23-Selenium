package js_alerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SimpleAlert {

    @Test
    public void alertTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlertButton =
                driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertButton.click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        System.out.println(result.getText());

        Assert.assertEquals("You successfully clicked an alert", result.getText());

    }

    @Test
    public void confAlertTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirmAlert =
                driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmAlert.click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();// press OK button
        //TODO add assertion here

        jsConfirmAlert.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert1.dismiss(); // press Cancel button on alert
        //TODO add assertion here


    }


    @Test
    public void promptAlertTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement promptAlertButton =
                driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

        promptAlertButton.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Temirlan");
        alert.accept();

        //TODO add assertion for text that we type in

    }



}
