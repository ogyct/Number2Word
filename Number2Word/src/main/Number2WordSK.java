package main;

import utils.Currency;
import utils.Utils;

/**
 * This class contains methods to convert number to a slovak word
 * @author avgustisd
 *
 */
public class Number2WordSK {
    private static final String JEDNO = "jedno";
    private static final String JEDEN = "jeden";
    private static final String JEDNA = "jedna";
    private static final String DVA = "dva";
    private static final String DVE = "dve";
    private static final String TRI_HACEK = "tri";
    private static final String CTYRI = "štyri";
    private static final String PET = "päť";
    private static final String SEST = "šesť";
    private static final String SEDM = "sedem";
    private static final String OSM = "osem";
    private static final String DEVET = "deväť";

    private static final String DESET = "desať";
    private static final String JEDENACT = "jedenásť";
    private static final String DVANACT = "dvanásť";
    private static final String TRINACT = "trinásť";
    private static final String CTRNACT = "štrnásť";
    private static final String PATNACT = "pätnásť";
    private static final String SESTNACT = "šestnásť";
    private static final String SEDMNACT = "sedemnásť";
    private static final String OSMNACT = "osemnásť";
    private static final String DEVATENACT = "devätnásť";

    private static final String CET = "cet";

    private static final String DESAT = "desat";

    private static final String KORUNA = "koruna";
    private static final String KORUNY = "koruny";
    private static final String KORUN = "korún";

    private static final String HALER = "halier";
    private static final String HALERU = "halierov";
    private static final String HALERE = "haliere";

    private static final String STO = "sto";
    private static final String STE = "stě";
    private static final String STA = "sta";
    private static final String SET = "stot";

    private static final String TISIC = "tisíc";
    private static final String TISICE = "tisíce";
    private static final String MI = "mi";
    private static final String BI = "bi";
    private static final String TRI_NON_HACEK = "tri";
    private static final String KVADRI = "kvadri";
    private static final String LION = "lión";
    private static final String LIONY = "lióny";
    private static final String LIONU = "liónov";
    private static final String LIARDA = "liarda";
    private static final String LIARDY = "liardy";
    private static final String LIARD = "liárd";

    private static final String CELA = "celá";
    private static final String CELE = "celé";
    private static final String CELYCH = "celých";

    private static final String DESETISIC = "desaťtisíc";
    private static final String STOTISIC = "stotisíc";
    private static final String MILIONT = "miliónt";
    private static final String INA = "ina";
    private static final String INY = "iny";
    private static final String IN = "in";
    private static final String IN_HACEK = "ín";

    private static final String EURO = "euro";
    private static final String EURA = "eurá";
    private static final String EUR = "eur";

    private static final String CENT = "cent";
    private static final String CENTY = "centy";
    private static final String CENTU = "centov";

    private static final String DSAT = "dsať";
    private static final String DESIAT = "desiat";
    private static final String NULA = "nula";

    /**
     * REM Funkcia na prevod čísiel 1-9 na reťazec
     */
    private static String oneDigit2Word(int iNumber, int iRow) {
        String result = "";
        switch (iNumber) {
        case 1:
            if (iRow == 0) {
                result = JEDEN;
            }
            break;
        case 2:
            //Dvojka sa skloňuje - dva, dvesto, dvetisíc, dvamilióny, dvemiliardy, …
            if ((iRow % 2) == 0) {
                result = DVA;
            } else {
                result = DVE;
            }
            break;
        case 3:
            result = TRI_HACEK;
            break;
        case 4:
            result = CTYRI;
            break;
        case 5:
            result = PET;
            break;
        case 6:
            result = SEST;
            break;
        case 7:
            result = SEDM;
            break;
        case 8:
            result = OSM;
            break;
        case 9:
            result = DEVET;
            break;
        case 0:
            break;
        }
        return result;
    }

    /**
     * REM Funkcia na prevod čísiel 10-99 na reťazec
     */
    private static String tens2Word(int iUnits, int iTens) {
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
            }
        case 2:
        case 3:
        case 4:
            //"dsať" – dvadsať až štyridsať
            result = oneDigit2Word(iTens, 0) + DSAT + oneDigit2Word(iUnits, 0);
            break;
        default:
            result = oneDigit2Word(iTens, 0) + DESIAT + oneDigit2Word(iUnits, 0);
        }

        return result;
    }

    /**
     * REM Funkcia na prevod čísiel 1-999 na reťazec
     */
    private static String hundreds2Word(int iNumber, int iRow) {
        String result = "";
        //z čísla vypreparujeme číslice na mieste jednotiek
        int iUnits = iNumber % 10;
        //desiatok
        int iTens = (int) (iNumber / 10) % 10;
        // a stoviek
        int iHundreds = (int) (iNumber / 100);
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
            result = tens2Word(iUnits, iTens);
        }

        //teraz k prevedenému dvojcifernému číslu pridáme text o stovkách
        switch (iHundreds) {
        case 1:
            result = STO + result;
            break;
        // pridávame príponu "sto" – dvesto až deväťsto
        // číslovka 2 sa pri stovkách skloňuje ako pri tisícoch (dvesto – dvetisíc). t.j. tvar pre rád 1
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            result = oneDigit2Word(iHundreds, 1) + STO + result;
            break;
        }

        return result;
    }

    /**
     * REM Funkcia na zistenie rádových prípon
     */
    private static String rows2Word(int iNumber, int iRow, boolean financial) {
        // ' Texty o biliónoch, ... sú teoretické, pretože premenná typu LONG je maximálne 2.147.483.647, t.j.
        //' dvemiliardystoštyridsaťsedemmiliónovštyristoosemdesiattritisícšesťstoštyridsaťsedem
        String howMany = "";
        String prefix = "";

        switch (iRow) {
        case 1:
            prefix = TISIC;
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
        // tisíce
        if (iRow == 1) {
            if (iNumber == 0) {
                howMany = "";
            } else {
                howMany = prefix;
            }
        } else {
            //„lióny“ – milión, bilióny, triliónov
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
                default:
                    howMany = prefix + LIONU;
                    break;
                }
            } else {
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
                default:
                    howMany = prefix + LIARD;
                    break;
                }
            }
        }

        if (financial && iRow == 1) {
            //pri tisícoch píšeme medzeru za
            howMany = howMany + " ";
        }
        if (financial && iRow > 1) {
            howMany = " " + howMany + " ";
        }

        return howMany;
    }

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
                if (iRowTenth <= 2) {
                    result = result + IN_HACEK; // päť desatÍN, 
                } else {
                    result = result + IN; //päť tisícIN
                }
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
     * REM Funkcia, ktorá vyskloňuje koruny - 1 koruna; 2-4 koruny; 0, 5... korún
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
     * REM Funkcia, ktorá vyskloňuje haliere - 1 halier; 2-4 haliere; 0, 5... halierov
     * @param iNumber
     * @return
     */
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
                result = hundreds2Word(iAnalysis, iRow) + result;
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
        //  ' Úprava na finančné číslovky - priadnie slova "jedno", "jeden", "jedna" (Jednosto ...)
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

        /*
         *  ' Príprava textu meny a úprava slovného znenia podľa toho, aká je zadaná mena a
         ' či je to celá alebo desatinná časť:
         ' jedna celá/koruna/desatina, jedno euro, jeden cent/halier/...ina (skloňujeme jedna, jedno, jeden)
         ' dve tri štyri celé/koruny/eurá, dva tri štyri haliere/centy/...iny (skloňujeme dve, dva)
         ' päť celých/korún/eur, päť halierov/centov/...ín
         */
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

    /**
     * REM Funkcia na prevod čísla na slovenské slovo
     * REM Parametre OPTIONAL nie sú povinné, ak však niektorý z nich chce niekto zadať, musí zadať aj predchádzajúce (nasledujúce nie).
     * REM Napr. ak chce niekto zadať parameter iSpolu, musí zadať aj predchádzajúce parametre iTyp a iPismeno, nasledujúci parameter iMena zadať nemusí.
     */
    public static String number2SlovakWord(String number, boolean capitalLetter, boolean financial, Currency currency) {
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

}
