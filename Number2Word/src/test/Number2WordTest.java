package test;

import static org.junit.Assert.*;
import main.Currency;
import main.Number2Word;

import org.junit.Before;
import org.junit.Test;

public class Number2WordTest extends Number2Word {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testNumber2CzechWord() {
	    System.out.println(number2CzechWord("123,233", 0, true, false, Currency.CROWNS));
	    System.out.println(number2CzechWord("123", 0, true, false, Currency.CROWNS));
	    System.out.println(number2CzechWord("12", 0, true, false, Currency.CROWNS));
	    System.out.println(number2CzechWord("4", 0, true, false, Currency.CROWNS));
	    System.out.println(number2CzechWord("123456789", 0, true, false, Currency.CROWNS));
	}
	

}
