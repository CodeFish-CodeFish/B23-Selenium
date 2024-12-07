package Frames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IFrames {

    public WebDriver driver;// this is at class level
    @Before
    public void setUp(){
        //initializing our driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void iframeShowCase() throws InterruptedException {

        // using our already initialized driver
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(3000);

        //handling iframes by switching our driver to the iframe
        driver.switchTo().frame("mce_0_ifr");

        WebElement box = driver.findElement(By.xpath("//p"));
        System.out.println(box.getText());

    }

    @Test
    public void iframeExample(){
        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");

        //handling iframes by switching our driver to the iframe
        driver.switchTo().frame("iFrame1");
        WebElement contentText = driver.findElement(By.xpath("//div[.='Your content.']"));
        System.out.println(contentText.getText());
    }

    @Test
    public void clickOnFAQ(){
        // Task to click on FAQ tab which might be hidden inside iFrame
        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");

        // switching the driver to a specific iFrame
        //driver.switchTo().frame("iFrame2");//it takes to switch to the iFrame
        WebElement iframeAsWebElement = driver.findElement(By.xpath("//iframe[@id='iFrame2']"));
        driver.switchTo().frame(iframeAsWebElement);// this switches much faster
        WebElement frequentlyAskedQuestionsTab = driver.findElement(By.xpath("//a[@href='/support/faq/']"));
        frequentlyAskedQuestionsTab.click();

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
