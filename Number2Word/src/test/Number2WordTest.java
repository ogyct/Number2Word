package test;

import static org.junit.Assert.*;
import main.Number2Word;

import org.junit.Before;
import org.junit.Test;

public class Number2WordTest extends Number2Word {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testOneDigit2Word() {
//		assertEquals("", OneDigit2Word(-1, 0));
//		assertEquals("", OneDigit2Word(2, -1));
//		assertEquals(JEDNA, OneDigit2Word(1, 0));
//		assertEquals(DVA, OneDigit2Word(2, 0));
//		assertEquals(DVE, OneDigit2Word(2, 9));
//	}
//	
//	@Test
//	public void testHundreds2Word(){
//	    System.out.println(hundreds2Word(123, 0, false));
//	    System.out.println(hundreds2Word(321, 0, false));
//	    System.out.println(hundreds2Word(999, 0, false));
//	    System.out.println(hundreds2Word(847, 0, false));
//	    System.out.println(hundreds2Word(102, 0, false));
//	    System.out.println(hundreds2Word(300, 0, false));
//	    System.out.println(hundreds2Word(400, 0, false));
//	    System.out.println(hundreds2Word(778, 0, false));
//	    System.out.println(hundreds2Word(334, 0, false));
//	    System.out.println(hundreds2Word(765, 0, false));
//	}
	
	@Test
	public void testConvert2Word() {
//		System.out.println(convert2Word(1, 1, false, 2, 0));
//		System.out.println(convert2Word(2, 1, false, 1, 0));
//		System.out.println(convert2Word(3, 1, false, 1, 0));
//		System.out.println(convert2Word(4, 1, false, 1, 0));
//		System.out.println(convert2Word(5, 1, false, 1, 0));
//		System.out.println(convert2Word(6, 1, false, 1, 0));
//		System.out.println(convert2Word(7, 1, false, 1, 0));
//		System.out.println(convert2Word(8, 1, false, 1, 0));
//		System.out.println(convert2Word(9, 1, false, 1, 0));
//		System.out.println(convert2Word(0, 1, false, 1, 0));
//		System.out.println(convert2Word(1000, 0, false, 1, 0));
	    System.out.println(number2CzechWord("1000", 0, 0, false, 2));

		
	}
	
//	@Test
//	public void testIntegerTength(){
//	    System.out.println(integerTenth("11235123", 1, 2234));
//	}
	

}
