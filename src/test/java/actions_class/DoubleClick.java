package actions_class;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClick {

    @Test
    public void doubleClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton =
                driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));


        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();


    }


}
