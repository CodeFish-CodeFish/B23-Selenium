package locators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorPractice4 {

    @Test
    public void test1() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("iphone" + Keys.ENTER);

        List<WebElement> links = driver.findElements(By.partialLinkText("iPhone"));

        for (WebElement el : links) {
            System.out.println(el.getText());
        }


    }


}
