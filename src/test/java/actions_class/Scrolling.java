package actions_class;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Scrolling {

    @Test
    public void scrollTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");

        WebElement eaglePicture =
                driver.findElement(By.xpath("//img[@src='https://picsum.photos/300/200?image=1024']"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(eaglePicture).perform();



    }







}
