package com.github.ogyct.Number2Word.cz;

import com.github.ogyct.Number2Word.utils.Currency;
import com.github.ogyct.Number2Word.utils.NumberWrapper;
import com.github.ogyct.Number2Word.utils.Utils;

/**
 * This class contains methods to convert a number into a czech word
 * The only public method here is "public static String number2CzechWord()" which is to be called from main API class.
 * @author Dmitry
 *
 */
public class Number2WordCZ {
    private static final String JEDNO = "jedno";
    private static final String JEDEN = "jeden";
    private static final String JEDNA = "jedna";
    private static final String DVA = "dva";
    private static final String DVE = "dvě";
    private static final String TRI_HACEK = "tři";
    private static final String CTYRI = "čtyři";
    private static final String PET = "pět";
    private static final String SEST = "šest";
    private static final String SEDM = "sedm";
    private static final String OSM = "osm";
    private static final String DEVET = "devět";

    private static final String DESET = "deset";
    private static final String JEDENACT = "jedenáct";
    private static final String DVANACT = "dvanáct";
    private static final String TRINACT = "třináct";
    private static final String CTRNACT = "čtrnáct";
    private static final String PATNACT = "patnáct";
    private static final String SESTNACT = "šestnáct";
    private static final String SEDMNACT = "sedmnáct";
    private static final String OSMNACT = "osmnáct";
    private static final String DEVATENACT = "devatenáct";

    private static final String CET = "cet";
    private static final String PADESAT = "padesát";
    private static final String SEDESAT = "šedesát";
    private static final String DEVADESAT = "devadesát";
    private static final String DESAT = "desát";

    private static final String KORUNA = "koruna";
    private static final String KORUNY = "koruny";
    private static final String KORUN = "korun";

    private static final String HALER = "haléř";
    private static final String HALERU = "haléřů";
    private static final String HALERE = "haléře";

    private static final String STO = "sto";
    private static final String STE = "stě";
    private static final String STA = "sta";
    private static final String SET = "set";

    private static final String TISIC = "tisíc";
    private static final String TISICE = "tisíce";
    private static final String MI = "mi";
    private static final String BI = "bi";
    private static final String TRI_NON_HACEK = "tri";
    private static final String KVADRI = "kvadri";
    private static final String LION = "lion";
    private static final String LIONY = "liony";
    private static final String LIONU = "lionů";
    private static final String LIARDA = "liarda";
    private static final String LIARDY = "liardy";
    private static final String LIARD = "liárd";

    private static final String CELA = "celá";
    private static final String CELE = "celé";
    private static final String CELYCH = "celých";

    private static final String DESETISIC = "desetisíc";
    private static final String STOTISIC = "stotisíc";
    private static final String MILIONT = "miliónt";
    private static final String INA = "ina";
    private static final String INY = "iny";
    private static final String IN = "in";

    private static final String EURO = "euro";
    private static final String EURA = "eura";
    private static final String EUR = "eur";

    private static final String CENT = "cent";
    private static final String CENTY = "centy";
    private static final String CENTU = "centů";

    private static final String NULA = "nula";

    
    /**
     * REM Funkcia na prevod čísla na české slovo <br />
     * REM Parametre OPTIONAL nie sú povinné, ak však niektorý z nich chce niekto zadať, musí zadať aj predchádzajúce (nasledujúce nie).<br />
     * REM Napr. ak chce niekto zadať parameter iSpolu, musí zadať aj predchádzajúce parametre iTyp a iPismeno, nasledujúci parameter iMena zadať nemusí.<br />
     *         
     *  ' Význam parametrov:<br />
     ' sCislo$ - prevádzané číslo ako reťazec<br />
     ' iTyp% - 0 – celé – štandardná hodnota, ak je na vstupe celé číslo<br />
     '         1 – reálne – štandardná hodnota, ak je na vstupe reálne číslo<br />
     '         2 - reálne - xx/100<br />
     '         3 - iba desatinná časť<br />
     '         4 a viac - iba desatinná časť v tvare xx/100 (ďalšie parametre - iPismeno, iSpolu a iMena nemajú v tomto prípade význam)<br />
     ' iPismeno% - 0 – prvé písmeno malé – štandardná hodnota<br />
     '             1 a viac – prvé písmeno veľké<br />
     ' iSpolu% - 0 – s medzerami – štandardná hodnota (Sto padesát)<br />
     '           1 – bez medzier (Stopadesát)<br />
     '           2 - s medzerami finančne (Jednosto padesát)<br />
     '           3 a viac - bez medzier finančne (Jendostopadesát)<br />
     ' iMena% - 0 – žiadna – štandardná hodnota<br />
     '          1 – celých, desetin (slovo desetin sa použije, ak iTyp<>xx/100)<br />
     '          2 – euro, centy (slovo centy sa použije, ak iTyp<>xx/100)<br />
     '          3 a viac – koruny, haléře (slovo haléře sa použije, ak iTyp<>xx/100)<br />
      */
    public static String number2CzechWord(String number, boolean capitalLetter, boolean financial, Currency currency) {
        String result = "";

        int lengthOfTenth; //iRadD: 1 - desetin, 2 - stotin, 3 - tisícin... (podľa počtu cifier v desatinnej časti)
        String integer = "";// Pomocná premenná pre prevod celej časti
        String tenth = ""; // Pomocná premenná na prevod desatinnej časti
        // ' Pretože vstupné parametre sú optional, vo funkcii sa používajú vnútorné premenné
        //' ktoré sa nastavia podľa parametrov, ak sú zadané, inak nastavíme štandardné hodnoty

        int iInt, iTenth; // cela a desetina cast cisla

        NumberWrapper nw = Utils.integerTenth(number);
        //iRowTenth = integerTenth(number, iInt, iTenth);
        lengthOfTenth = nw.getLengthOfTenth();
        iInt = nw.getInteger();
        iTenth = nw.getTenth();
        int iType = 0;
        if (lengthOfTenth > 0)
            iType = 1; //Je to reálne číslo (nenulový počet desatinných cifier)
        if (lengthOfTenth == 0)
            lengthOfTenth = 1; //Ak bolo zadané celé číslo, musíme zadať, že je jedno desatinné číslo (nula) pre prípad, že budeme prevádzať desatinnú časť

        //Ak sú parametre zadané, nastavíme vnútorné premenné podľa nich

        switch (iType) {
        case 0:
            integer = convert2Word(iInt, capitalLetter, financial, currency, 0); //Prevod celej časti
            break;
        case 1:
            integer = convert2Word(iInt, capitalLetter, financial, currency, 0);
            //Prevod desatinnej časti má význam iba vtedy, ak je zadaná mena
            if (currency != Currency.INTEGER)
                tenth = convert2Word(iTenth, capitalLetter, financial, currency, lengthOfTenth);
            break;
        case 2:
            integer = convert2Word(iInt, capitalLetter, financial, currency, 0);
            tenth = (tenth + String.valueOf(iTenth) + "/" + String.valueOf(Math.pow(10, lengthOfTenth))).trim();
            break;
        case 3:
            tenth = convert2Word(iTenth, capitalLetter, financial, currency, lengthOfTenth);
            break;
        default:
            tenth = (String.valueOf(iTenth) + "/" + String.valueOf(Math.pow(10, lengthOfTenth))).trim();
        }

        result = (integer + " " + tenth).trim();
        return result;
    }

    /**
     * REM Funkcia na prevod čísiel 1-9 na reťazec
     * 
     * @param iNumber
     * @param iRow
     * @return
     */
    private static String oneDigit2Word(int iNumber, int iRow) {
        String word = "";
        switch (iNumber) {
        case 1:
            if (iRow == 0) {
                word = JEDNA;
            }
            break;
        case 2:
            switch (iRow) {
            case 0:
                word = DVA;
                break;
            case 1:
                word = DVA;
                break;
            case 2:
                word = DVA;
                break;
            case 3:
                word = DVE;
                break;
            case 4:
                word = DVA;
                break;
            case 5:
                word = DVE;
                break;
            case 6:
                word = DVA;
                break;
            case 7:
                word = DVE;
                break;
            case 8:
                word = DVA;
                break;
            case 9:
                word = DVE;
                break;
            default:
                System.out.println("Unsupported parameter");
                break;
            }
            break;

        case 3:
            word = TRI_HACEK;
            break;
        case 4:
            word = CTYRI;
            break;
        case 5:
            word = PET;
            break;
        case 6:
            word = SEST;
            break;
        case 7:
            word = SEDM;
            break;
        case 8:
            word = OSM;
            break;
        case 9:
            word = DEVET;
            break;
        case 0:
            break;
        default:
            System.out.println("Unsupported parameter");
            break;
        }

        return word;
    }

    private static String inflectHeller(int iNumber) {
        String word = "";
        switch (iNumber) {
        case 1:
            word = HALER;
            break;
        case 2:
        case 3:
        case 4:
            word = HALERE;
            break;
        default:
            word = HALERU;
            break;
        }

        return word;
    }

    /**
     * 
     * @param iNumber
     * @return
     */
    private static String inflectCrown(int iNumber) {
        String word = "";
        switch (iNumber) {
        case 1:
            word = KORUNA;
            break;
        case 2:
        case 3:
        case 4:
            word = KORUNY;
            break;
        default:
            word = KORUN;
            break;
        }
        return word;
    }

    /**
     * REM Funkcia na prevod čísiel 10-99 na reťazec
     * 
     * @param iUnits
     * @param iTens
     * @param financial
     * @return
     */
    private static String tens2Word(int iUnits, int iTens, boolean financial) {
        String result = "";
        String units;
        switch (iTens) {
        case 1:
            switch (iUnits) {
            case 0:
                result = DESET;
                break;
            case 1:
                result = JEDENACT;
                break;
            case 2:
                result = DVANACT;
                break;
            case 3:
                result = TRINACT;
                break;
            case 4:
                result = CTRNACT;
                break;
            case 5:
                result = PATNACT;
                break;
            case 6:
                result = SESTNACT;
                break;
            case 7:
                result = SEDMNACT;
                break;
            case 8:
                result = OSMNACT;
                break;
            case 9:
                result = DEVATENACT;
                break;
            default:
                System.out.println("Wrong digit");
            }
            iUnits = 0;
            break;
        case 2:
        case 3:
        case 4:
            result = oneDigit2Word(iTens, 0) + CET;
            break;
        case 5:
            result = PADESAT;
            break;
        case 6:
            result = SEDESAT;
            break;
        case 7:
        case 8:
            result = oneDigit2Word(iTens, 0) + DESAT;
            break;
        case 9:
            result = DEVADESAT;
            break;
        }
        units = oneDigit2Word(iUnits, 0);

        if (units != null) {
            // financial means no spaces in czech grammar
            if (financial) {
                result = result + units;
            } else {
                result = result + " " + units;
            }
        }
        return result;
    }

    /**
     * REM Funkcia na prevod čísiel 1-999 na reťazec
     */
    private static String hundreds2Word(int iNumber, int iRow, boolean financial) {
        String result = "";
        String resultHundreds = "";
        String hundreds_c;

        int iUnits = iNumber % 10; // z čísla vypreparujeme číslice na mieste
                                   // jednotiek,
        int iTens = (int) Math.floor(iNumber / 10) % 10; // desiatok
        int iHundreds = (int) Math.floor(iNumber / 100); // hundreds

        // Najprv prevedieme na text jednotky a desiatky (číslo 0 až 99)
        if (iTens == 0) {
            if (iHundreds == 0) {
                // celá trojica je číslo 0 až 9 a vtedy sa číslovka 1 a 2
                // skloňuje podľa rádu
                result = oneDigit2Word(iUnits, iRow);
            } else {
                // je to zložené číslo a vtedy sa číslovka 1 a 2 neskloňuje
                // (základný tvar je pre rád 0)
                result = oneDigit2Word(iUnits, 0);
            }
        } else {
            // 10-99
            result = tens2Word(iUnits, iTens, financial);
        }
        // teraz k prevedenému dvojcifernému číslu pridáme text o stovkách
        hundreds_c = oneDigit2Word(iHundreds, 3);
        switch (iHundreds) {
        case 1:
            // Pri stovkách sa jednosto píše iba finančne
            resultHundreds = STO;
            break;
        case 2:
            // dvě stě
            resultHundreds = STE;
            break;
        case 3:
        case 4:
            resultHundreds = STA;
            break;
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            resultHundreds = SET;
            break;
        case 0:
            break;
        default:
            System.out.println("Wrong number");
            break;
        }

        if (!resultHundreds.isEmpty()) {
            // financial numbers have no spaces
            if (!financial) {
                resultHundreds = hundreds_c + " " + resultHundreds;
            } else {
                resultHundreds = hundreds_c + resultHundreds;
            }
        }

        if (result.isEmpty()) {
            result = resultHundreds;
        } else {
            if (!financial) {
                result = resultHundreds + " " + result;
            } else {
                result = resultHundreds + result;
            }
        }
        return result;
    }

    /**
     * Funkcia na zistenie rádových prípon
     */
    private static String rows2Word(int iNumber, int iRow, boolean financial) {

        // ' Texty o biliónoch, ... sú teoretické, pretože premenná typu LONG je
        // maximálne 2.147.483.647, t.j.
        // '
        // dvemiliardystoštyridsaťsedemmiliónovštyristoosemdesiattritisícšesťstoštyridsaťsedem

        String howMany = "";
        String prefix = "";

        switch (iRow) {
        case 1:
            switch (iNumber) {

            case 2:
            case 3:
            case 4:
                prefix = TISICE;
                break;
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                prefix = TISIC;
                break;
            default:
                prefix = TISIC;
                break;
            }
            break;
        case 2:
        case 3:
            prefix = MI;
            break;
        case 4:
        case 5:
            prefix = BI;
            break;
        case 6:
        case 7:
            prefix = TRI_NON_HACEK;
            break;
        case 8:
        case 9:
            prefix = KVADRI;
            break;
        }

        if (iRow == 1) { //thousands
            switch (iNumber) {
            case 0:
                howMany = "";
                break;
            default:
                howMany = prefix;
            }
        } else {
            if ((iRow % 2) == 0) {
                switch (iNumber) {
                case 0:
                    howMany = "";
                    break;

                case 1:
                    howMany = prefix + LION;
                    break;
                case 2:
                case 3:
                case 4:
                    howMany = prefix + LIONY;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    howMany = prefix + LIONU;
                    break;
                default:
                    howMany = prefix + LIONU;
                    break;
                }
            } else {
                // lióny – milión, bilióny, triliónov
                if ((iRow % 2) == 0) {
                    switch (iNumber) {
                    case 0:
                        howMany = "";
                        break;
                    case 1:
                        howMany = prefix + LION;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        howMany = prefix + LIONY;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        howMany = prefix + LIONU;
                        break;
                    default:
                        System.out.println("Wrong iNumber");

                    }
                } else {
                    // liardy
                    switch (iNumber) {
                    case 0:
                        howMany = "";
                        break;
                    case 1:
                        howMany = prefix + LIARDA;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        howMany = prefix + LIARDY;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        howMany = prefix + LIARD;
                        break;
                    default:
                        System.out.println("Wrong iNumber");
                    }
                }
            }
        }
        if (!financial && iRow > 0) {
            // číslovky tisíc, milión, miliarda ... píšeme s medzerami pred a za
            howMany = " " + howMany + " ";
        }

        return howMany;
    }// end ofrows2Word

    /**
     * Funkcia, ktorá vyskloňuje celé - 0-1 celá; 2-4 celé; 5... celých
     */
    private static String inflectInteger(int iNumber) {
        String result = "";
        switch (iNumber) {
        case 0:
        case 1:
            result = CELA;
            break;
        case 2:
        case 3:
        case 4:
            result = CELE;
            break;
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            result = CELYCH;
            break;
        default:
            result = CELYCH;
            break;
        }
        return result;
    }

    /**
     * Funkcia, ktorá vyskloňuje desatiny - max. milióntiny
     */
    private static String inflectTenths(int iNumber, int iRowTenth) {
        String result = "";
        switch (iRowTenth) {
        case 1:
            result = DESET;
            break;
        case 2:
            result = SET;
            break;
        case 3:
            result = TISIC;
            break;
        case 4:
            result = DESETISIC;
            break;
        case 5:
            result = STOTISIC;
            break;
        case 6:
            result = MILIONT;
            break;
        default:
            System.out.println("Unsupported row > 6");
        }

        if (!result.isEmpty()) {
            switch (iNumber) {
            case 1:
                result = result + INA; // jedna desetINA
                break;
            case 2:
            case 3:
            case 4:
                result = result + INY; // dvě desetINY
                break;
            default:
                result = result + IN; // pět desetIN
                break;
            }
        }
        return result;
    }

    /**
     * REM Funkcia, ktorá vyskloňuje eurá - 1 euro; 2-4 eurá; 0, 5... eur
     */
    private static String inflectEuros(int iNumber) {
        String result = "";
        switch (iNumber) {
        case 1:
            result = EURO;
            break;
        case 2:
        case 3:
        case 4:
            result = EURA;
            break;
        default:
            result = EUR;
            break;
        }

        return result;
    }

    /**
     * REM Funkcia, ktorá vyskloňuje centy - 1 cent; 2-4 centy; 0, 5... centov
     */
    private static String inflectCents(int iNumber) {
        String result = "";
        switch (iNumber) {
        case 1:
            result = CENT;
            break;
        case 2:
        case 3:
        case 4:
            result = CENTY;
            break;
        default:
            result = CENTU;
            break;
        }
        return result;
    }

    /**
     * REM Funkcia pre prevod čísla na slovo so skloňovaním
     */
    private static String convert2Word(int iNumber, boolean capitalLetter, boolean financial, Currency iCurrency, int iRowTenths) {
        String result = "";
        String currency = "";

        int iAnalysis = 0; //Prevádzaná časť čísla na slovo
        int iRow = 0; //iRad: 1 – tisíc, 2 – milion, 3 – miliarda...
        int iInflectNumber = iNumber;

        //Osobitne musíme ošetriť číslo nula
        if (iNumber == 0) {
            result = NULA;
        } else {
            iRow = 0;
            do {
                // ' Z čísla vyberieme posledné tri číslice
                iAnalysis = iNumber % 1000;
                //ktoré prevedieme na text
                result = hundreds2Word(iAnalysis, iRow, financial) + result;
                //číslo zmenšíme o už spracovanú časť
                iNumber = (int) (iNumber / 1000);
                //a pridáme text rádu, ktorý budeme spracovávať v ďalšom kroku cyklu
                if (iNumber != 0) {
                    iRow = iRow + 1;
                    result = rows2Word(iNumber % 1000, iRow, financial) + result;
                }
            } while (iNumber != 0);
        }

        // Vymazanie prebytočných medzier na začiatku a konci slovného znenia
        result = result.trim();

        // Úprava na finančné číslovky - priadnie slova "jedno", "jeden",
        // "jedna"
        //TODO
        if (financial) {
            if ((iAnalysis >= 100) && (iAnalysis <= 199)) {
                result = JEDNO + result;
            }
            if (iAnalysis == 1 && iRow > 0) {
                //úprava výsledku pre ostatné rády
                switch (iRow) {
                case 1:
                case 2:
                case 4:
                case 6:
                case 8:
                    result = JEDEN + result;
                    break;
                case 3:
                case 5:
                case 7:
                case 9:
                    result = JEDNA + result;
                    break;
                }
            }
        }

        // ' Príprava textu meny a úprava slovného znenia podľa toho, aká je
        // zadaná mena a
        // ' či je to celá alebo desatinná časť:
        // ' jedna celá/koruna/desetina, jedno euro, jeden cent/haléř/...ina
        // (skloňujeme jedna, jedno, jeden)
        // ' dvě tři čtyři celé/koruny/eura, dva tři čtyři haléře/centy/...iny
        // (skloňujeme dvě, dva)
        // ' pět celých/korun/eur, pět haléřů/centů/...in

        
        if (iRowTenths == 0) {
            // Číslo bolo celá časť
            switch (iCurrency) {
            case NO_CURRENCY: // no currency
                currency = "";
                break;
            case INTEGER: // integer cele
                currency = inflectInteger(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna celá
                    break;
                case 2:
                    result = DVE;
                    break;
                }
                break;
            case EUROS: // euro
                currency = inflectEuros(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNO; // jedno euro
                    break;
                case 2:
                    result = DVE;
                    break;
                }
                break;
            case CROWNS: // crowns
                currency = inflectCrown(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna koruna
                    break;
                case 2:
                    result = DVE;
                    break;
                }
                break;
            }
        } else { // if (iRowTenths == 0) {
            // tenth, non integer
            // Číslo bolo desatinná časť
            switch (iCurrency) {
            case NO_CURRENCY: // no currency
                currency = "";
                break;
            case INTEGER: // ...iny
                currency = inflectTenths(iInflectNumber, iRowTenths);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna desetina
                    break;
                case 2:
                    result = DVE;
                    break;

                }
            case EUROS: // centy
                currency = inflectCents(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDEN; // jeden CENT
                    break;
                case 2:
                    result = DVA; // dva centy
                    break;
                }
            case CROWNS: // hellers
                currency = inflectHeller(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDEN; // jeden haler
                    break;
                case 2:
                    result = DVA; // dva halere
                    break;
                }
                break;
            }
        }

        if (capitalLetter) {
            //capitalize 1st letter
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }

        result = (result + " " + currency).trim();
        return result;
    }

    

}
