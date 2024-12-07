package dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Practice1 {

    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        dropdownLink.click();

        WebElement dropdown =
                driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        select.selectByIndex(1);

        select.selectByValue("2");






    }








}
