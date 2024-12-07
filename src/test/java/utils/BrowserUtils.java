package utils;

import com.beust.ah.A;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BrowserUtils {

    public static void selectBy(WebElement dropdown, String value, String methodName) {

        Select select = new Select(dropdown);

        switch (methodName) {

            case "visibleText":
                select.selectByVisibleText(value);
                break;
            case "byValue":
                select.selectByValue(value);
                break;
            case "byIndex":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Please choose correct select methods");

        }

    }

    public static WebElement waitForVisibility(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void takeScreenshot(WebDriver driver) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String location = "src/test/java/screenshots/";
        try {
            FileUtils.copyFileToDirectory(file, new File(location));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void scrollByAmountDynamic(WebDriver driver, int x, int y){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).build().perform();
    }

    public static void scrollToElementDynamic(WebDriver driver, WebElement element){

        Actions actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();
    }


}
