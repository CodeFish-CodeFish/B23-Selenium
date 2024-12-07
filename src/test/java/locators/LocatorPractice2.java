package locators;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice2 {

    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        //navigate to website
        driver.get("https://the-internet.herokuapp.com/");
        // maximize browser to fit the screen
        driver.manage().window().maximize();

        //synchronization of browser and code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //retrieve current url
        String url = driver.getCurrentUrl();
        System.out.println("Current URL is: " + url);

        String title = driver.getTitle();
        System.out.println("Current page title is: " + title);
    }


    @Test
    public void test2() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement header = driver.findElement(By.className("heading"));
        String headerText = header.getText();
        System.out.println(headerText);

    }


}
