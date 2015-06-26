package test;

import static org.junit.Assert.*;
import main.Number2Word;

import org.junit.Before;
import org.junit.Test;

public class Number2WordTest extends Number2Word {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOneDigit2Word() {
		assertEquals("", OneDigit2Word(-1, 0));
		assertEquals("", OneDigit2Word(2, -1));
		assertEquals(JEDNA, OneDigit2Word(1, 0));
		assertEquals(DVA, OneDigit2Word(2, 0));
		assertEquals(DVE, OneDigit2Word(2, 9));
	}

}
