package locators;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class LocatorPractice {

    @Test
    public void TC_01() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize(); // This will maximize the window
        WebElement text = driver.findElement(By.tagName("h1"));

        String expectedText = "Welcome to the-internet"; // ex. Developer gave this or PM gave this
        String actualText = text.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test failed");
        }
    }


    @Test
    public void TC_02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize(); // This will maximize the window

        //Find element and clicked on it
        WebElement horizontal_slider = driver.findElement(By.linkText("Horizontal Slider"));
        horizontal_slider.click();

        /*
        Please validate the following text.
        Expected text:
        Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left.
        Or click and drag the slider with your mouse.
        It will indicate the value of the slider to the right.
         */

        String expectedText = "Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left. Or click and drag the slider with your mouse. It will indicate the value of the slider to the right.";
        WebElement horizontalText = driver.findElement(By.tagName("h4"));
        Thread.sleep(3000);
        String actualText = horizontalText.getText().trim();

        if (expectedText.equals(actualText)) {
            System.out.println("Test pass for horizontal text");
        } else {
            System.out.println("Test failed for horizontal text");
        }

        WebElement footerLink = driver.findElement(By.partialLinkText("Elemental"));
        footerLink.click();
    }

    @Test
    public void TC_03() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String urlOfLambda = "https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo";
        String youtubeLink = "https://www.youtube.com/watch?v=WwPStbxD51E&list=RDWwPStbxD51E&start_radio=1";
        String ebayLink = "https://www.ebay.com/";
        driver.navigate().to(urlOfLambda); // does not wait for the webpage to be loaded

        //driver.get(""); //wait for webpage to be loaded

//        Thread.sleep(3000); // it is a pause produced by Java NOT from Selenium
//        driver.navigate().refresh(); // will refresh the page
//        driver.navigate().to(youtubeLink); // navigates to YouTube link
//        Thread.sleep(3000);
//        driver.navigate().to(ebayLink);
//        Thread.sleep(3000);
//
//        driver.navigate().back(); // goes back to previous page
//        Thread.sleep(3000);
//        driver.navigate().back(); // At this moment our code and page is on Lambda URL

        WebElement nameInputField = driver.findElement(By.id("title"));
        nameInputField.sendKeys("Kuba, wassap!");

        WebElement messageBox = driver.findElement(By.xpath("//textarea[@id='description']"));
        messageBox.sendKeys("Please review my latest code and need your feedback on this");

        WebElement submitButton = driver.findElement(By.xpath("//input[@name='btn-submit']"));
        submitButton.click();

        Thread.sleep(3000);

        driver.quit();// shuts down all the browsers opened during this code execution only
        //driver.close();// it closes only the current window and not the driver instance,
        // Also, driver.close();  will close only the window where driver is looking at, all other
        //windows will remain open.


    }

    @Test
    public void TC_04() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// please wait for webpage to be loaded for up to 10 seconds

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Mykky");

        WebElement email = driver.findElement(By.id("inputEmail4"));
        email.sendKeys("test@test.mykky.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("23895784375kjfdhgkjfdg");

        WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
        company.sendKeys("IBM");

        WebElement website = driver.findElement(By.xpath("//input[@placeholder='Website']"));
        website.sendKeys("www.ibm.com");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Oshington");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("123 NE Aviator Dr");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("Test street");

        WebElement state = driver.findElement(By.id("inputState"));
        state.sendKeys("Washington");

        WebElement zipcode = driver.findElement(By.id("inputZip"));
        zipcode.sendKeys("60067");

        Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        Thread.sleep(3000);
        driver.quit();

        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        element.isSelected();
        element.isDisplayed();
        element.isEnabled();









    }








}
