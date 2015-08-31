package com.github.ogyct.Number2Word.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.ogyct.Number2Word.API;
import com.github.ogyct.Number2Word.utils.Currency;
import com.github.ogyct.Number2Word.utils.Language;

/**
 * Main test class, where all tests will be stored
 * @author avgustisd
 *
 */
public final class Number2WordTest {

    private API api;

    @Before
    public void setUp() throws Exception {
        api = new API();
    }

    /**
     * Results to compare are taken from http://www.castkaslovy.cz/
     */
    @Test
    public void testNumber2CzechWord() {
        String result = api.number2Word("1", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "jedno euro");

        result = api.number2Word("10", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "deset eur");

        result = api.number2Word("22", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "dvacet dva eur");

        result = api.number2Word("479", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "čtyři sta sedmdesát devět eur");

        result = api.number2Word("1555", false, true, Currency.EUROS, Language.CZ);
        assertEquals(result, "jedentisícpětsetpadesátpět eur");

        result = api.number2Word("4890", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "čtyři tisíce osm set devadesát eur");

        result = api.number2Word("453678", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "čtyři sta padesát tři tisíc šest set sedmdesát osm eur");

        result = api.number2Word("43666900", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "čtyřicet tři milionů šest set šedesát šest tisíc devět set eur");

        result = api.number2Word("1789445667", false, false, Currency.EUROS, Language.CZ);
        assertEquals(result, "miliarda sedm set osmdesát devět milionů čtyři sta čtyřicet pět tisíc šest set šedesát sedm eur");
    }

    /**
     * This method uses data from http://sumaslovom.sk/
     */
    @Test
    public void testNumber2SlovakWord() {
        String result = api.number2Word("1", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "jeden");

        result = api.number2Word("12", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "dvanásť");

        result = api.number2Word("567", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "päťstošesťdesiatsedem");

        result = api.number2Word("1234", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "jedentisícdvestotridsaťštyri");

        result = api.number2Word("345987", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "tristoštyridsaťpäťtisícdeväťstoosemdesiatsedem");

        result = api.number2Word("55222333", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "päťdesiatpäťmiliónovdvestodvadsaťdvatisíctristotridsaťtri");

        result = api.number2Word("1 452 306 954", false, true, Currency.NO_CURRENCY, Language.SK);
        assertEquals(result, "jednamiliardaštyristopäťdesiatdvamiliónovtristošesťtisícdeväťstopäťdesiatštyri");

    }

}
