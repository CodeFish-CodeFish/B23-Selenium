package dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Practice2 {


    @Test
    public void test1(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement dd = driver.findElement(By.xpath("//select[@id='maxRows']"));
        Select ddHandler = new Select(dd);
        ddHandler.selectByVisibleText("30");

    }

    @Test
    public void mapFirstNameAndEmail(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String optionFromDropdown = "Show";
        WebElement dd = driver.findElement(By.xpath("//select[@id='maxRows']"));

        Select select = new Select(dd);
        List<WebElement> selectOptions = select.getOptions();

        for (int i = 0; i < selectOptions.size(); i++) {

            if (selectOptions.get(i).getText().startsWith(optionFromDropdown)){
                System.out.println(selectOptions.get(i).getText());
                selectOptions.get(i).click();
                break;
            }
        }

        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> phoneNumbers = driver.findElements(By.xpath("//tr//td[5]"));

        Map<String, String> customerInfo = new HashMap<>();
        for (int i = 0; i < firstNames.size(); i++) {
            String firsName = firstNames.get(i).getText();
            String email = emails.get(i).getText();
            customerInfo.put(firsName, email);
        }
        System.out.println(customerInfo);

        Map<String, String> fullInfo = new TreeMap<>();

        for (int i = 0; i < lastNames.size(); i++) {

            String fullName = firstNames.get(i).getText() + "/" + lastNames.get(i).getText();
            String cellphone = phoneNumbers.get(i).getText().replace("-", "");
            fullInfo.put(fullName, cellphone);

        }
        System.out.println(fullInfo);





    }






}
