package windowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {


    @Test
    public void windowHandleShowCase(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement currentWindowElement = driver.findElement(By.linkText("Click Here"));
        currentWindowElement.click();

        String currentWindowId = driver.getWindowHandle();// retrieves current window unique ID
        Set<String> windowHandles = driver.getWindowHandles(); // retrieves all the open window IDs, they all unique

        // this approach will work only if there are 2 windows
        // if we have more than 2 windows, then this will fail
        for (String id:windowHandles){

            if (!id.equals(currentWindowId)){
                driver.switchTo().window(id);
            }

        }
        System.out.println(windowHandles);
        System.out.println(currentWindowId);

        WebElement newWindowElement = driver.findElement(By.xpath("//h3"));
        System.out.println(newWindowElement.getText());

    }





}
