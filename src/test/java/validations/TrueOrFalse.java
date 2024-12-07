package validations;

import org.junit.Assert;
import org.junit.Test;

public class TrueOrFalse {

    @Test
    public void test1(){
        String sentence = "Bank of America is open 365 days a year";
        String word = "Bank";
        Assert.assertTrue(sentence.contains(word));
    }

    @Test
    public void test2(){
        int price = 100;
        Assert.assertTrue(price > 50);
    }

    @Test
    public void test3(){
        String sentence = "Sun is out today";
        String word = "Moon";

        Assert.assertFalse(sentence.contains(word));
        Assert.assertTrue(sentence.startsWith("S"));
        Assert.assertTrue(sentence.endsWith("S"));
    }
}
