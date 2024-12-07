package Frames;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NestedIFrames {

    public WebDriver driver;// this is at class level
    @Before
    public void setUp(){
        //initializing our driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void nestedFramesShowCase(){

        driver.get("https://www.lambdatest.com/selenium-playground/nested-frames/");

        //Top frame
        driver.switchTo().frame("frame-top");

        WebElement topText = driver.findElement(By.xpath("//p[.='Top']"));
        System.out.println(topText.getText());
        Assert.assertEquals("Top", topText.getText());

        //Bring the driver to its original state
        driver.switchTo().defaultContent();

        //Bottom frame plus 'Left' text
        driver.switchTo().frame("frame-bottom"); // switching the driver to bottom frame
        driver.switchTo().frame("frame-left"); // switching the driver to the nest frame which is located within the bottom frame

        WebElement bottomLeftText = driver.findElement(By.xpath("//p[.='Left']"));
        System.out.println(bottomLeftText.getText());
        Assert.assertEquals("Left", bottomLeftText.getText());

        //Get the text from bottom middle
        driver.switchTo().parentFrame(); // this will bring the driver one step back
        driver.switchTo().frame("frame-middle");
        WebElement bottomMiddleText = driver.findElement(By.xpath("//p[.='Middle']"));
        System.out.println(bottomMiddleText.getText());
        Assert.assertEquals("Middle", bottomMiddleText.getText());

        //Task, get the text from bottom right using defaultContent();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        driver.switchTo().frame("frame-right");
        WebElement bottomRightText = driver.findElement(By.xpath("//p[.='Right']"));
        System.out.println(bottomRightText.getText());
        Assert.assertEquals("Right", bottomRightText.getText());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
