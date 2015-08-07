package com.github.ogyct.Number2Word.utils;


/**
 * This class contains methods which are common for both CZ and SK classes
 * @author Dmitry
 *
 */
public class Utils {
    
    /**
     * REM Funkcia pre zistenie celej a desatinnej časti čísla
     * REM Funkcia vracia počet cifier desatinnej časti (lebo .5 je 5/10 ale .05 je 5/100)
     * @param number
     * @param iInt
     * @param iTenth
     * @return
     */
    public static NumberWrapper integerTenth(String number) {
        //wrapper to store all the values;
        NumberWrapper nw = new NumberWrapper();
        String numbers = "0123456789,.";
        String result = "";
        int lengthOfTenth;
        char character;
        int where;

        //Vymazanie všetkých znakov okrem čísla a desatinnej čiarky/bodky z reťazca sumy
        for (int i = 0; i < number.length(); i++) {
            //character = lastSubstring(number, i, 0);
            character = number.charAt(i);
            if (numbers.indexOf(character) != -1) {
                result = result + character;
            }
        }
        // ' Vyhľadanie desatinnej čiarky
        where = result.indexOf(",");
        if (where == -1)
            where = result.indexOf(".");

        // ' Predpokladáme, že reťazec je prázdny - vtedy je číslo nula a počet desatinných cifier nulový
        int iInt = 0;
        int iTenth = 0;
        lengthOfTenth = 0;

        if (where > 0) {
            //' Je zadaná desatinná čiarka/bodka - reálne číslo
            //Celá časť prevedená na číslo
            if (result.length() != 0)
                iInt = Integer.valueOf(result.substring(0, where));
            //Zistenie polohy desatinnej časti. Číslo môže byť zadané napr. "3.", vtedy sa bude považovať za celé
            //where = result.length() - where;
            //
            if (where > 0) {
                //Desatinná časť nie je prázdna
                //result = result.substring(0, 9);
                result = result.substring(where + 1, result.length());
                //trim result to only 9 numbers to fit into integer
                if (result.length() > 9)
                    result = result.substring(0, 9);
                if (result.length() != 0)
                    iTenth = Integer.parseInt(result);
                lengthOfTenth = String.valueOf(iTenth).length();
            }

        } else {
            //Nie je zadaná desatinná časť - celé číslo
            iInt = Integer.valueOf(result);
        }
        //saving values
        nw.setInteger(iInt);
        nw.setTenth(iTenth);
        nw.setLengthOfTenth(lengthOfTenth);
        

        return nw;
    }

}
