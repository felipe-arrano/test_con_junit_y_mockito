package util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.awt.*;

public class StringUtilTest {

    @Test
    public void repeatOnce(){
        Assert.assertEquals("Hola", StringUtil.repeat("Hola", 1));
    }

    @Test
    public void repeatMultipesTimes(){
        Assert.assertEquals("HolaHolaHola", StringUtil.repeat("Hola", 3));
    }

    @Test()
    public void repeatZeroTimes(){
        Assert.assertEquals("", StringUtil.repeat("Hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatNegativeTimeValue(){
        Assert.assertEquals("", StringUtil.repeat("Hola", -1));
    }
}