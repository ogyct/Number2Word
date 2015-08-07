# Number2Word
This library is based on sources for OpenOffice extension by Július Pastierik with his agreement
http://www.openoffice.cz/doplnky/rozsirenie-pre-vkladanie-cisla-slovom

The entry point to this lib is through API class. It contains 2 methods:
public String number2Word(String number, boolean firstCapitalLetter, boolean financial, Currency currency, Language lang)

Which allow to customize your output by setting currency, capital letter, spaces(financial flag) and language.

The second one is a simplified one:
    public String number2Word(String number, Language lang) 
    
which will only output word in specified language without currency and other customizations.

Please, report any bugs you find: avgdima@gmail.com
