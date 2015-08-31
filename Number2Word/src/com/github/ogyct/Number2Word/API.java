package com.github.ogyct.Number2Word;

import com.github.ogyct.Number2Word.cz.Number2WordCZ;
import com.github.ogyct.Number2Word.sk.Number2WordSK;
import com.github.ogyct.Number2Word.utils.Currency;
import com.github.ogyct.Number2Word.utils.Language;

/**
 * This library allows to convert czech or slovak number to word.
 * The author of original plugin for OpenOffice is Július Pastierik.
 * This library was ported to Java from Basic based on Július Pastierik's source code.
 * @author avgustisd
 *
 */
public class API {

    /**
     * Use this to convert number to word
     * @param number - number to be converted
     * @param firstCapitalLetter - true: number will be written with capital letter
     * @param financial - true: for financial documents number will be written without white spaces; <br>
     * false: normal conversion with spaces according to grammar
     * @param currency - one of these: Currency.EUROS, Currency.INTEGER, Currency.CROWNS, Currency.NO_CURRENCY
     * @param lang - Language.SK or Language.CZ
     * @return
     */
    public String number2Word(String number, boolean firstCapitalLetter, boolean financial, Currency currency, Language lang) {
        String result = null;
        if (number == null || number.equals("")) {
            return "";
        }
        if (lang == Language.SK) {
            result = Number2WordSK.number2SlovakWord(number, firstCapitalLetter, financial, currency);
        }
        if (lang == Language.CZ) {
            result = Number2WordCZ.number2CzechWord(number, firstCapitalLetter, financial, currency);
        }
        return result;
    }

    /**
     * Simplified method to convert number to word without currency, without capital letter, non-financial
     * @param number - number to be converted
     * @param lang - Language.SK or Language.CZ
     * @return
     */
    public String number2Word(String number, Language lang) {
        String result = number2Word(number, false, false, Currency.NO_CURRENCY, lang);
        return result;
    }

}
