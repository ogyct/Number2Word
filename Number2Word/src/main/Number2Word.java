package main;

public class Number2Word {
    public static final String JEDNA = "jedna";
    public static final String DVA = "dva";
    public static final String DVE = "dvě";
    public static final String TRI = "tři";
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

    /**
     * REM Funkcia na prevod čísiel 1-9 na reťazec
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
            word = TRI;
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
            System.out.println("Invalid number");
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
            //financial means no spaces in czech grammar
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

        int iUnits = iNumber % 10; // z čísla vypreparujeme číslice na mieste jednotiek,
        int iTens = (int) Math.floor(iNumber / 10); //desiatok
        int iHundreds = (int) Math.floor(iNumber / 100); // hundreds

        //  Najprv prevedieme na text jednotky a desiatky (číslo 0 až 99)
        if (iTens == 0) {
            if (iHundreds == 0) {
                //celá trojica je číslo 0 až 9 a vtedy sa číslovka 1 a 2 skloňuje podľa rádu
                result = OneDigit2Word(iUnits, iRow);
            } else {
                //je to zložené číslo a vtedy sa číslovka 1 a 2 neskloňuje (základný tvar je pre rád 0)
                result = OneDigit2Word(iUnits, 0);
            }
        } else {
            //10-99
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
            //TODO
            //dvě stě
            resultHundreds = STE;
        }
        
        return result;

    }

}
