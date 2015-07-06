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

	public static final String KORUNA = "koruna";
	public static final String KORUNY = "koruny";
	public static final String KORUN = "korun";

	public static final String HALER = "haléř";
	public static final String HALERU = "haléřů";
	public static final String HALERE = "haléře";

	public static String OneDigit2Word(int number, int row) {
		String word = "";
		switch (number) {
		case 1:
			if (row == 0) {
				word = "jedna";
			}
			break;
		case 2:
			switch (row) {
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

	public static String inflectHeller(int number) {
		String word = "";
		switch (number) {
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

	public static String inflectCrown(int number) {
		String word = "";
		switch (number) {
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

}
