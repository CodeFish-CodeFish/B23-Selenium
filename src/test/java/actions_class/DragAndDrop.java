package actions_class;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void test1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        WebElement draggable1 =
                driver.findElement(By.xpath("//span[text()='Draggable 1']"));

        WebElement dropHere = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable1).moveToElement(dropHere).release().build().perform();

        WebElement draggable2 =
                driver.findElement(By.xpath("//span[text()='Draggable 2']"));

        actions.dragAndDrop(draggable2, dropHere).perform();
    }


}
