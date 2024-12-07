package getAttribute;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice1 {


    @Test
    public void getAttributeShowCase(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/signup");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get attributes of name input field
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Kobe");

        String typeAttribute = nameField.getAttribute("type");
        System.out.println(typeAttribute);

        String dataQa = nameField.getAttribute("data-qa");
        System.out.println(dataQa);

        String placeHolder = nameField.getAttribute("placeholder");
        System.out.println(placeHolder);

        String value = nameField.getAttribute("value");
        System.out.println(value);

        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailField.sendKeys("test@test.com");

        String emailPlaceHolder = emailField.getAttribute("placeholder");
        System.out.println(emailPlaceHolder);

        String emailValueAttribute = emailField.getAttribute("value");
        System.out.println(emailValueAttribute);

    }

}
