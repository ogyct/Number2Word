package test;

import static org.junit.Assert.*;
import main.Number2WordCZ;
import main.Number2WordSK;

import org.junit.Before;
import org.junit.Test;

import utils.Currency;

public class TestSK extends Number2WordSK {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        System.out.println(number2SlovakWord("123,23", true, false, Currency.CROWNS));
        System.out.println(number2SlovakWord("123", true, false, Currency.INTEGER));
        System.out.println(number2SlovakWord("12", true, false, Currency.INTEGER));
        System.out.println(number2SlovakWord("4", true, false, Currency.INTEGER));
        System.out.println(number2SlovakWord("123 456 789", true, false, Currency.INTEGER));
        System.out.println("------------");
    }

}
