package herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

    @Test
    public void abTestingLink() {
        // Step 1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Step 2
        driver.get("https://the-internet.herokuapp.com/");


        // Step 3
        WebElement abTestLink =
                driver.findElement(By.xpath("//a[@href='/abtest']"));

        String text = abTestLink.getText();
        System.out.println(text);

        // Step 4
        abTestLink.click();

        // Code expectation: step1 thru step3 will happen within 1s
        // Computer reality: step1 takes 3s, step2 takes 2s, step3 1s
    }


}
