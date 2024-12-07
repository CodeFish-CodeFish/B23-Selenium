package testDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;

public class QAFoxDataProviderPractice extends TestBase {

    @DataProvider(name = "testDataQAFox")
    public Object[][] getData() {

        return new Object[][]{

                {"test@test.com", "1233534656", "Warning: No match for E-Mail Address and/or Password."},
                {"test@test.com", "!@#@#@#!$@#%", "Warning: No match for E-Mail Address and/or Password."},
                {"@#$!@#$@test.com", "weqewrefdsf", "Warning: No match for E-Mail Address and/or Password."},
                {"12323@test.com", "SDFADGFDGFD", "Warning: No match for E-Mail Address and/or Password."},
        };

    }


    @Test(dataProvider = "testDataQAFox")
    public void validateLoginFunctionality(String username, String password, String errorMessage) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        QaFoxLoginPage loginPage = new QaFoxLoginPage(driver);
        loginPage.setLogin(username, password, errorMessage);
    }


}
