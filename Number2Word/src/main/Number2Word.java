package main;

public class Number2Word {
    public static final String JEDNO = "jedno";
    public static final String JEDEN = "jeden";
    public static final String JEDNA = "jedna";
    public static final String DVA = "dva";
    public static final String DVE = "dvě";
    public static final String TRI_HACEK = "tři";
    public static final String CTYRI = "čtyři";
    public static final String PET = "pět";
    public static final String SEST = "šest";
    public static final String SEDM = "sedm";
    public static final String OSM = "osm";
    public static final String DEVET = "devět";

    public static final String DESET = "deset";
    public static final String JEDENACT = "jedenáct";
    public static final String DVANACT = "dvanáct";
    public static final String TRINACT = "třináct";
    public static final String CTRNACT = "čtrnáct";
    public static final String PATNACT = "patnáct";
    public static final String SESTNACT = "šestnáct";
    public static final String SEDMNACT = "sedmnáct";
    public static final String OSMNACT = "osmnáct";
    public static final String DEVATNACT = "devatenáct";

    public static final String CET = "cet";
    public static final String PADESAT = "padesát";
    public static final String SEDESAT = "šedesát";
    public static final String DEVADESAT = "devadesát";

    public static final String KORUNA = "koruna";
    public static final String KORUNY = "koruny";
    public static final String KORUN = "korun";

    public static final String HALER = "haléř";
    public static final String HALERU = "haléřů";
    public static final String HALERE = "haléře";

    public static final String STO = "sto";
    public static final String STE = "stě";
    public static final String STA = "sta";
    public static final String SET = "set";

    public static final String TISIC = "tisíc";
    public static final String TISICE = "tisíce";
    public static final String MI = "mi";
    public static final String BI = "bi";
    public static final String TRI_NON_HACEK = "tri";
    public static final String KVADRI = "kvadri";
    public static final String LION = "lión";
    public static final String LIONY = "lióny";
    public static final String LIONU = "liónů";
    public static final String LIARDA = "liarda";
    public static final String LIARDY = "liardy";
    public static final String LIARD = "liárd";

    public static final String CELA = "celá";
    public static final String CELE = "celé";
    public static final String CELYCH = "celých";

    public static final String DESETISIC = "desetisíc";
    public static final String STOTISIC = "stotisíc";
    public static final String MILIONT = "miliónt";
    public static final String INA = "ina";
    public static final String INY = "iny";
    public static final String IN = "in";

    public static final String EURO = "euro";
    public static final String EURA = "eura";
    public static final String EUR = "eur";

    public static final String CENT = "cent";
    public static final String CENTY = "centy";
    public static final String CENTU = "centů";

    public static final String NULA = "nula";

    public static final String A = "";

    /**
     * REM Funkcia na prevod čísiel 1-9 na reťazec
     * 
     * @param iNumber
     * @param iRow
     * @return
     */
    public static String OneDigit2Word(int iNumber, int iRow) {
        String word = "";
        switch (iNumber) {
        case 1:
            if (iRow == 0) {
                word = "jedna";
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
        default:
            System.out.println("Unsupported parameter");
            break;
        }

        return word;
    }

    public static String inflectHeller(int iNumber) {
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
        case 0:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            word = HALERU;
            break;
        default:
            System.out.println("Invalid iNumber");
            break;
        }

        return word;
    }

    /**
     * 
     * @param iNumber
     * @return
     */
    public static String inflectCrown(int iNumber) {
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
        case 0:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            word = KORUN;
            break;
        default:
            System.out.println("Invalid number");
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
    public static String tens2Word(int iUnits, int iTens, boolean financial) {
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
                result = DEVATNACT;
                break;
            default:
                System.out.println("Wrong digit");
            }
            iUnits = 0;
            break;
        case 2:
        case 3:
        case 4:
            result = OneDigit2Word(iTens, 0) + CET;
        case 5:
            result = PADESAT;
            break;
        case 6:
            result = SEDESAT;
            break;
        case 7:
        case 8:
            result = OneDigit2Word(iTens, 0);
            break;
        case 9:
            result = DEVADESAT;
            break;
        }
        units = OneDigit2Word(iUnits, 0);

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
    public static String hundreds2Word(int iNumber, int iRow, boolean financial) {
        String result = "";
        String resultHundreds = "";
        String hundreds_c;

        int iUnits = iNumber % 10; // z čísla vypreparujeme číslice na mieste
                                   // jednotiek,
        int iTens = (int) Math.floor(iNumber / 10); // desiatok
        int iHundreds = (int) Math.floor(iNumber / 100); // hundreds

        // Najprv prevedieme na text jednotky a desiatky (číslo 0 až 99)
        if (iTens == 0) {
            if (iHundreds == 0) {
                // celá trojica je číslo 0 až 9 a vtedy sa číslovka 1 a 2
                // skloňuje podľa rádu
                result = OneDigit2Word(iUnits, iRow);
            } else {
                // je to zložené číslo a vtedy sa číslovka 1 a 2 neskloňuje
                // (základný tvar je pre rád 0)
                result = OneDigit2Word(iUnits, 0);
            }
        } else {
            // 10-99
            result = tens2Word(iUnits, iTens, financial);
        }
        // teraz k prevedenému dvojcifernému číslu pridáme text o stovkách
        hundreds_c = OneDigit2Word(iHundreds, 3);
        switch (iHundreds) {
        case 1:
            // Pri stovkách sa jednosto píše iba finančne
            resultHundreds = STO;
            break;
        case 2:
            // TODO
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
    public static String rows2Word(int iNumber, int iRow, boolean financial) {

        // ' Texty o biliónoch, ... sú teoretické, pretože premenná typu LONG je
        // maximálne 2.147.483.647, t.j.
        // '
        // dvemiliardystoštyridsaťsedemmiliónovštyristoosemdesiattritisícšesťstoštyridsaťsedem

        String howMany = "";
        String prefix = "";

        switch (iRow) {
        case 1:
            switch (iNumber) {
            case 1:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                prefix = TISIC;
                break;
            case 2:
            case 3:
            case 4:
                prefix = TISICE;
                break;
            default:
                System.out.println("Wrong iNumber number");
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

        if (iRow == 1) {
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
                    howMany = prefix + LIARD;
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
        if (!financial && iRow > 0) {
            // číslovky tisíc, milión, miliarda ... píšeme s medzerami pred a za
            howMany = " " + howMany + " ";
        }
        return howMany;
    } // end ofrows2Word

    /**
     * Funkcia, ktorá vyskloňuje celé - 0-1 celá; 2-4 celé; 5... celých
     */
    public static String inflectInteger(int iNumber) {
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
            System.out.println("Wrong iNumber");
        }
        return result;
    }

    /**
     * Funkcia, ktorá vyskloňuje desatiny - max. milióntiny
     */
    public static String inflectTenths(int iNumber, int iRowTenth) {
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
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                result = result + IN; // pět desetIN
                break;
            default:
                System.out.println("Wrong iNumber");
            }
        }
        return result;
    }

    /**
     * REM Funkcia, ktorá vyskloňuje eurá - 1 euro; 2-4 eurá; 0, 5... eur
     */
    public static String inflectEuros(int iNumber) {
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
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 0:
            result = EURO;
            break;
        default:
            System.out.println("Wrong iNumber");

        }

        return result;
    }

    /**
     * REM Funkcia, ktorá vyskloňuje centy - 1 cent; 2-4 centy; 0, 5... centov
     */
    public static String inflectCents(int iNumber) {
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
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 0:
            result = CENTU;
            break;
        default:
            System.out.println("Wrong iNumber");
        }
        return result;
    }

    /**
     * REM Funkcia pre prevod čísla na slovo so skloňovaním
     */
    public static String convert2Word(int iNumber, int iWords, boolean financial, int iCurrency, int iRowTenths) {
        String result = "";
        String currency = "";

        int iAnalysis = 0;
        int iRow = 0;

        int iInflectNumber = iNumber;

        if (iNumber == 0) {
            result = NULA;
        } else {
            iRow = 0;
            do {
                iAnalysis = iNumber % 1000;
                result = hundreds2Word(iAnalysis, iRow, financial) + result;
                iNumber = (int) Math.floor(iNumber / 1000);
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
        if (financial) {
            if ((iAnalysis >= 100) && (iAnalysis <= 199)) {
                result = JEDNO + result;
            }
            if (iAnalysis == 1 && iRow > 0) {
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
                default: // TODO
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
            // TODO currency to enum
            case 0: // no currency
                currency = "";
                break;
            case 1: // integer cele
                currency = inflectInteger(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna celá
                    break;
                case 2:
                    result = DVE;
                    break;
                default: // TODO
                }
            case 2: // euro
                currency = inflectEuros(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNO; // jedno euro
                    break;
                case 2:
                    result = DVE;
                    break;
                default: // TODO

                }
            default: // crowns
                currency = inflectCrown(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna koruna
                    break;
                case 2:
                    result = DVE;
                    break;
                default: // TODO
                }
            }
        } else { // if (iRowTenths == 0) {
            // tenth, non integer
            // Číslo bolo desatinná časť
            switch (iCurrency) {
            // TODO currency to enum
            case 0: // no currency
                currency = "";
                break;
            case 1: // ...iny
                currency = inflectTenths(iInflectNumber, iRowTenths);
                switch (iInflectNumber) {
                case 1:
                    result = JEDNA; // jedna desetina
                    break;
                case 2:
                    result = DVE;
                    break;
                default: // TODO

                }
            case 2: // centy
                currency = inflectCents(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDEN; // jeden CENT
                    break;
                case 2:
                    result = DVA; // dva centy
                    break;
                default: // TODO
                }
            default: // hellers
                currency = inflectHeller(iInflectNumber);
                switch (iInflectNumber) {
                case 1:
                    result = JEDEN; // jeden haler
                    break;
                case 2:
                    result = DVA; // dva halere
                    break;
                default: // TODO
                }
            }
        }

        if (iWords > 0) {
            //capitalize 1st letter
            result = result.substring(0, 1).toUpperCase() + result.substring(1);

        }

        result = (result + currency).trim();
        return result;
    }

    /**
     * REM Funkcia na prevod čísla na české slovo
     * REM Parametre OPTIONAL nie sú povinné, ak však niektorý z nich chce niekto zadať, musí zadať aj predchádzajúce (nasledujúce nie).
     * REM Napr. ak chce niekto zadať parameter iSpolu, musí zadať aj predchádzajúce parametre iTyp a iPismeno, nasledujúci parameter iMena zadať nemusí.
     */

    public static String Number2CzechWord(String number, int iType, int iLetter, boolean financial, int currency) {
        String result = "";

        return result;
    }

}
