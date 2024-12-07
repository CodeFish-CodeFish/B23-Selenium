package locators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice5 {


    @Test
    public void parentChildTest() {
        //instanciate webdriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement dropDownLink =
                driver.findElement(By.xpath("//li//a[@href='/dropdown']"));
        dropDownLink.click();

        WebElement header = driver.findElement(By.xpath("//div//div//h3"));
        String headerText = header.getText();
        System.out.println(headerText);

        if (headerText.equals("Dropdown List")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        WebElement footerLink =
                driver.findElement(By.xpath("//div[@id='page-footer']//div[@style='text-align: center;']"));
        System.out.println(footerLink.getText());
    }


}
