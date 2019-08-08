package util;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void divisiblePorTresEsFizz(){
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    public void divisiblePorCincoEsBuzz(){
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    public void divisiblePorTresYCincoEsFizzBuzz(){
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }
}
