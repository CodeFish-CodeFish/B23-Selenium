package locators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorPractice3 {

    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement header = driver.findElement(By.xpath("//h1"));
        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement el : links) {
            System.out.println(el.getText());
        }

        System.out.println("=====================");
        List<WebElement> elements = driver.findElements(By.id("codefish"));
        System.out.println("Elements count is "+ elements.size());

        WebElement invalidElement = driver.findElement(By.name("temirlan"));






    }


}
