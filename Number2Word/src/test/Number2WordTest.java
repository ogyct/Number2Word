package test;

import static org.junit.Assert.*;
import main.Number2WordCZ;

import org.junit.Before;
import org.junit.Test;

import utils.Currency;

public class Number2WordTest extends Number2WordCZ {

    @Before
    public void setUp() throws Exception {
    }

    //    @Test
    //    public void testNumber2CzechWordCrowns() {
    //        System.out.println(number2CzechWord("123,233", 0, true, false, Currency.CROWNS));
    //        System.out.println(number2CzechWord("123", 0, true, false, Currency.CROWNS));
    //        System.out.println(number2CzechWord("12", 0, true, false, Currency.CROWNS));
    //        System.out.println(number2CzechWord("4", 0, true, false, Currency.CROWNS));
    //        System.out.println(number2CzechWord("123456789", 0, true, false, Currency.CROWNS));
    //        System.out.println("------------");
    //    }

    @Test
    public void testNumber2CzechWordInteger() {
        System.out.println(number2CzechWord("123,23", true, false, Currency.CROWNS));
        System.out.println(number2CzechWord("123", true, false, Currency.INTEGER));
        System.out.println(number2CzechWord("12", true, false, Currency.INTEGER));
        System.out.println(number2CzechWord("4", true, false, Currency.INTEGER));
        System.out.println(number2CzechWord("123 456 789", true, false, Currency.INTEGER));
        System.out.println("------------");
    }

}
