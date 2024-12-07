package actions_class;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class BasicActions {


    @Test
    public void clickTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebElement contextMenuLink = driver.findElement(By.linkText("Context Menu"));

        Actions actions = new Actions(driver);
        actions.click(contextMenuLink).perform();

        Thread.sleep(2000);
        driver.navigate().back();// goes to previous page

        WebElement hoversLink = driver.findElement(By.linkText("Hovers"));
        actions.click(hoversLink).perform();
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        actions.click(dropdownLink).perform();
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement infiniteScrollLink =
                driver.findElement(By.xpath("//a[@href='/infinite_scroll']"));
        actions.click(infiniteScrollLink).perform();

    }

    @Test
    public void contextClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement contextMenuLink = driver.findElement(By.linkText("Context Menu"));
        Actions actions = new Actions(driver);
        contextMenuLink.click();

        WebElement rectangle = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(rectangle).perform();
    }

    @Test
    public void rightClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        WebElement rightClickMeButton =
                driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));

        actions.contextClick(rightClickMeButton).perform();

        List<WebElement> menuOptions =
                driver.findElements(By.cssSelector(".context-menu-item"));

        for (WebElement item : menuOptions) {
            System.out.println(item.getText());
        }


    }


}
