package testDataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderFromDifferentClass {

    @DataProvider(name = "myTestData")
    public Object[][] getData(){

        return new Object[][]{

                {"Oleg", "Sasha", "name3"},
                {"Alex", "Bran", "name4"},
                {"John", "Mycky", "asds"},
                {"2", "4", "some name"}
        };
    }



}
