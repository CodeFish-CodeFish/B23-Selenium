package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverHelper {

    /*
    Singleton pattern design
    Singleton class to centralize our driver
     */

    private static WebDriver driver;

    private DriverHelper() {
    }

    public static WebDriver getDriver() {

        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {

            switch (ConfigReader.readProperty("browser")) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "fireFox":
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        return driver;

    }


}
