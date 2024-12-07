package fileUploads;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice1 {

    public WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void uploadFileShowCase(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement fileUploadLink = driver.findElement(By.linkText("File Upload"));
        fileUploadLink.click();

        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys("/Users/codefish/Downloads/peakyBlindersB23.jpeg");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String expectedText = "peakyBlindersB23.jpeg";
        String actualText = uploadedFile.getText().trim();
        Assert.assertEquals("Failed to validate uploaded files text",expectedText, actualText);
    }

    @Test
    public void taskToUploadFile(){
        // task to upload a file on this url https://automationexercise.com/contact_us
        driver.get("https://automationexercise.com/contact_us");

        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Kobe");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");

        WebElement subject = driver.findElement(By.name("subject"));
        subject.sendKeys("subject of the message");

        WebElement message = driver.findElement(By.id("message"));
        message.sendKeys("Message to the manager...");

        WebElement chooseFileButton = driver.findElement(By.name("upload_file"));
        chooseFileButton.sendKeys("/Users/codefish/Downloads/peakyBlindersB23.jpeg");

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
