package dropdown;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Practice3 {

    /*
    In this class we will introduce new topics:
    1. Before and After annotations
    2. Assertions
     */
    public WebDriver driver;

    @Before
    public void setUpDriver(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");// make sure to track your url, if you have different get() inside the test, then that url will be executed
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Before method runs");
    }

    @Test
    public void bookAFlight() throws InterruptedException {

        // passenger count
        WebElement passenger = driver.findElement(By.name("passCount"));
        Select passDropdown = new Select(passenger);
        passDropdown.selectByVisibleText("4");

        // departing city selection
        WebElement departingCity = driver.findElement(By.name("fromPort"));
        Select departCityDropdown = new Select(departingCity);
        departCityDropdown.selectByValue("Zurich");

        // from month == December
        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonthDropdown = new Select(fromMonth);
        fromMonthDropdown.selectByIndex(11);

        // from day == 20
        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDayDropdown = new Select(fromDay);
        fromDayDropdown.selectByVisibleText("20");

        // arriving city == Seattle
        WebElement arrivingCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingCityDropdown = new Select(arrivingCity);
        arrivingCityDropdown.selectByVisibleText("Seattle");

        // returning month == December
        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonthDropdown = new Select(toMonth);
        toMonthDropdown.selectByValue("12");

        // returning day == 31
        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDayDropdown = new Select(toDay);
        toDayDropdown.selectByValue("31");

        // business class radio button
        WebElement businessClass = driver.findElement(By.xpath("//input[@value='Business']"));
        businessClass.click();

        WebElement airline = driver.findElement(By.name("airline"));
        Select allAirlines = new Select(airline);
        List<WebElement> airlineOptions = allAirlines.getOptions();

        for (WebElement eachAirline: airlineOptions){

            if (eachAirline.getText().startsWith("Un")){
                eachAirline.click();
                break;
            }

        }
        Thread.sleep(4000);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();

        // Not a normal practice to find locators, but if locators cannot be unique, this approach might help
        // However, we are risking to face StaleElementReferenceException[will cover in the future] while doing so
        List<WebElement> textElement = driver.findElements(By.xpath("//font[contains(.,'After')]"));

        String actualText = textElement.get(1).getText().trim();

        String expectedText = "After flight finder - No Seats Avaialble";

        // Validation method to verify that feature works as expected
        Assert.assertEquals("Failed to validate expected text",expectedText, actualText);
    }

    @Test
    public void sanityCheck(){

        //driver.get("https://www.google.com/"); this will navigate to google and get title - url from it.
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("After method runs");
        driver.quit();
    }





}
