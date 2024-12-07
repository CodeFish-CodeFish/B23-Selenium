package google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    @Test
    public void navigateTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");  //navigate to specified URL
        //find needed element
        WebElement searchField = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchField.sendKeys("iphone"+ Keys.ENTER); //type text
    }




}
