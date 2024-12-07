package windowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {

    @Test
    public void multiWindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement twitterLink = driver.findElement(By.xpath("//a[contains(.,'Follow On Twitter')]"));
        twitterLink.click();
        Thread.sleep(2000);
        WebElement facebookLink = driver.findElement(By.xpath("//a[contains(.,'Like us On Facebook ')]"));
        facebookLink.click();
        Thread.sleep(2000);
        WebElement linkedInLink = driver.findElement(By.xpath("//a[contains(.,'Follow us On Linkedin')]"));
        linkedInLink.click();
        Thread.sleep(2000);

        String facebookTitle = "LambdaTest | Facebook";

        Set<String> windowHandles = driver.getWindowHandles();

        for (String id: windowHandles){

            Thread.sleep(2000);
            driver.switchTo().window(id);
            if (driver.getTitle().equals(facebookTitle)){
                break;
            }

        }
        Thread.sleep(2000);
        WebElement xButtonOnFacebookPage = driver.findElement(By.xpath("//div[@aria-label='Close']"));
        xButtonOnFacebookPage.click();


    }

    @Test
    public void taskToSwitchWindows() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement newWindowTab = driver.findElement(By.cssSelector("button[id='newTabBtn']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(newWindowTab).build().perform();
        newWindowTab.click();

        String currentWindowId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id:allWindowIds){
            if (!currentWindowId.equals(id)){
                driver.switchTo().window(id);
            }
        }

        Thread.sleep(2000);

        WebElement clickMeButtonOnNewWindow = driver.findElement(By.cssSelector("#alertBox"));
        clickMeButtonOnNewWindow.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedAlertText = "I am an alert box!";
        Assert.assertEquals(expectedAlertText, alertText);
        alert.accept();






    }
}
