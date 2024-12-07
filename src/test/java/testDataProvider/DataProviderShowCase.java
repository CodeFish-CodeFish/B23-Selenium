package testDataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderShowCase {

//    @DataProvider(name = "myTestData")
//    public Object[][] getData(){
//
//        return new Object[][]{
//
//                {"Oleg", "Sasha", "name3"},
//                {"Alex", "Bran", "name4"},
//                {"John", "Mycky", "asds"},
//                {"2", "4", "some name"}
//        };
//    }


    @Test(dataProvider = "myTestData", dataProviderClass = DataProviderFromDifferentClass.class)
    public void testDataProvider1(String name1, String name2, String name3){

        System.out.println(name1 + " " + name2 + " " + name3);

    }


}
