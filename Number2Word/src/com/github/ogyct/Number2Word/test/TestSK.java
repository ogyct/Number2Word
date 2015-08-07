package com.github.ogyct.Number2Word.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.ogyct.Number2Word.API;
import com.github.ogyct.Number2Word.cz.Number2WordCZ;
import com.github.ogyct.Number2Word.sk.Number2WordSK;
import com.github.ogyct.Number2Word.utils.Currency;
import com.github.ogyct.Number2Word.utils.Language;

public class TestSK extends Number2WordSK {
    
    private API api;

    @Before
    public void setUp() throws Exception {
        api = new API();
    }

    @Test
    public void test() {
        String result = api.number2Word("122333", false, false, Currency.NO_CURRENCY, Language.SK);
        System.out.println(result);

    }

}
