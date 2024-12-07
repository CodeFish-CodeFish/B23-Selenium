package validations;

import org.junit.Assert;
import org.junit.Test;

public class CompareTwoValues {

    @Test
    public void test1() {
        String name = "Codefish";
        String name2 = "Codefish";
        Assert.assertEquals(name, name2);
    }

    @Test
    public void test2() {
        String value = "hello";
        String value2 = "bye";
        Assert.assertEquals(value2, value);
    }

    @Test
    public void test3(){
        Assert.assertEquals(10, 10);
    }


}
