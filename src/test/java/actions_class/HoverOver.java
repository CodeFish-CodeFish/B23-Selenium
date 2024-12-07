package actions_class;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HoverOver {

    @Test
    public void hoverTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement avatar1 =
                driver.findElement(By.xpath("//h5[text()='name: user1']//parent::div//preceding-sibling::img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar1).perform();



    }

    @Test
    public void hoverTest2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        WebElement chaiElement = driver.findElement(By.xpath("//img[@src='../content/web/foods/1.jpg']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(chaiElement).perform();

        WebElement chaiProductDescription =
                driver.findElement(By.xpath("//img[@src='../content/web/foods/1.jpg']//following-sibling::div"));

        System.out.println(chaiProductDescription.getText());

        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//h3//following-sibling::p"));
        List<WebElement> allProductNames = driver.findElements(By.xpath("//h3"));

        Map<String, String> productInfo = new HashMap<>();

        for (int i = 0; i < allImages.size(); i++) {

            Thread.sleep(500);
            actions.moveToElement(allImages.get(i)).perform();
            String prodName = allProductNames.get(i).getText();
            String price = allPrices.get(i).getText().replace("$", "");
            productInfo.put(prodName, price);

        }
        System.out.println(productInfo);









    }





}
