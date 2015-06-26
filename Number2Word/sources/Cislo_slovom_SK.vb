REM Funkcia pre zistenie celej a desatinnej časti čísla
REM Funkcia vracia počet cifier desatinnej časti (lebo .5 je 5/10 ale .05 je 5/100)
function Cela_Desatinna(sCislo$, iCela&, iDesatinna&) as integer
 dim sCisla$ : sCisla="0123456789,." ' Definícia čísiel a desatinnej čiarky/bodky
 dim sPom$ : sPom=""
 dim sZnak$
 dim i%, kde%
 
 ' Vymazanie všetkých znakov okrem čísla a desatinnej čiarky/bodky z reťazca sumy
 for i=1 to len(sCislo)
  sZnak=mid(sCislo,i,1)
  if instr(sCisla,sZnak)<>0 then sPom=sPom+sZnak
 next i
 
 ' Vyhľadanie desatinnej čiarky
 kde=instr(sPom,",")
 if kde=0 then kde=instr(sPom,".")
 
 ' Predpokladáme, že reťazec je prázdny - vtedy je číslo nula a počet desatinných cifier nulový
 iCela=0
 iDesatinna=0
 Cela_Desatinna=0
 
 if kde>0 then ' Je zadaná desatinná čiarka/bodka - reálne číslo
  iCela=val(left(SPom,kde-1)) ' Celá časť prevedená na číslo
  kde=len(SPom)-kde ' Zistenie polohy desatinnej časti. Číslo môže byť zadané napr. "3.", vtedy sa bude považovať za celé
  if kde>0 then ' Desatinná časť nie je prázdna
   sPom=right(sPom,kde)
   sPom=left(sPom,9) ' Premenná typu LONG je maximálne 2.147.483.647. Calc dáva 14 desatinných miest, ponecháme iba 9 miest, inak vedie ku chybe.
   iDesatinna=val(sPom) ' desatinná časť prevedená na číslo
   Cela_Desatinna=len(sPom) ' Počet cifier desatinnej časti
  endif  
 else ' Nie je zadaná desatinná časť - celé číslo
  iCela=val(SPom) ' Prevod celého čísla
 endif
end function

REM Funkcia na prevod čísiel 1-9 na reťazec
function Slovne_Jedno_Cislo_SK(iCislo%, iRad%) as string
 dim sPom_Nazov$ : sPom_Nazov=""

 select case iCislo
  case 1
   ' Číslovka "jeden" sa pri rádoch tisíc, milión,... nepíše
   if iRad=0 then 
    sPom_Nazov="jeden"
   endif
  case 2
   ' Dvojka sa skloňuje - dva, dvesto, dvetisíc, dvamilióny, dvemiliardy, …
   if (iRad mod 2)=0 then 
    sPom_Nazov="dva"
   else
    sPom_Nazov="dve"
   endif
  case 3
   sPom_Nazov="tri"
  case 4
   sPom_Nazov="štyri"
  case 5
   sPom_Nazov="päť"
  case 6
   sPom_Nazov="šesť"
  case 7
   sPom_Nazov="sedem"
  case 8
   sPom_Nazov="osem"
  case 9
   sPom_Nazov="deväť"
 end select
 Slovne_Jedno_Cislo_SK=sPom_Nazov
end function

REM Funkcia na prevod čísiel 10-99 na reťazec
function Slovne_Desiatky_SK(iJednotky%, iDesiatky%) as string
 dim sPom_Nazov$ : sPom_Nazov=""

 select case iDesiatky
  case 1
   ' desať – devätnásť
   select case iJednotky
    case 0
     sPom_Nazov="desať"
    case 1
     sPom_Nazov="jedenásť"
    case 2
     sPom_Nazov="dvanásť"
    case 3
     sPom_Nazov="trinásť"
    case 4
     sPom_Nazov="štrnásť"
    case 5
     sPom_Nazov="pätnásť"
    case 6
     sPom_Nazov="šestnásť"
    case 7
     sPom_Nazov="sedemnásť"
    case 8
     sPom_Nazov="osemnásť"
    case 9
     sPom_Nazov="devätnásť"
   end select
  case 2 to 4
   ' "dsať" – dvadsať až štyridsať
   sPom_Nazov=Slovne_Jedno_Cislo_SK(iDesiatky,0)+"dsať"+Slovne_Jedno_Cislo_SK(iJednotky,0)
  case else
   ' "desiat" – päťdesiat až deväťdesiat
   sPom_Nazov=Slovne_Jedno_Cislo_SK(iDesiatky,0)+"desiat"+Slovne_Jedno_Cislo_SK(iJednotky,0)
 end select
 Slovne_Desiatky_SK=sPom_Nazov
end function

REM Funkcia na prevod čísiel 1-999 na reťazec
function Slovne_Stovky_SK(iCislo%, iRad%) as string
 dim iJednotky% : iJednotky=iCislo mod 10 ' z čísla vypreparujeme číslice na mieste jednotiek,
 dim iDesiatky% : iDesiatky=int(iCislo/10) mod 10 ' desiatok
 dim iStovky% : iStovky=int(iCislo/100) ' a stoviek
 dim sPom_Slovne$ : sPom_Slovne=""
 
 ' Najprv prevedieme na text jednotky a desiatky (čísla 0 až 99)
 if iDesiatky=0 then
  ' iba jednotky (čísla 0 až 9)
  if iStovky=0 then
   ' celá trojica je číslo 0 až 9 a vtedy sa číslovka 1 a 2 skloňuje podľa rádu
   sPom_Slovne=Slovne_Jedno_Cislo_SK(iJednotky,iRad)
  else
   ' je to zložené číslo a vtedy sa číslovka 1 a 2 neskloňuje (základný tvar je pre rád 0)
   sPom_Slovne=Slovne_Jedno_Cislo_SK(iJednotky,0)
  endif
 else
  ' je to číslo od 10 do 99
  sPom_Slovne=Slovne_Desiatky_SK(iJednotky, iDesiatky)
 endif

 ' teraz k prevedenému dvojcifernému číslu pridáme text o stovkách
 select case iStovky
  case 1
   ' Pri stovkách sa jednosto píše iba finančne
   sPom_Slovne="sto"+sPom_Slovne
  case 2 to 9
   ' pridávame príponu "sto" – dvesto až deväťsto
   ' číslovka 2 sa pri stovkách skloňuje ako pri tisícoch (dvesto – dvetisíc). t.j. tvar pre rád 1
   sPom_Slovne=Slovne_Jedno_Cislo_SK(iStovky,1)+"sto"+sPom_Slovne
 end select
 Slovne_Stovky_SK=sPom_Slovne
end function

REM Funkcia na zistenie rádových prípon
function Slovne_Rady_SK(iCislo%, iRad%, iSpolu%) as string
 ' Texty o biliónoch, ... sú teoretické, pretože premenná typu LONG je maximálne 2.147.483.647, t.j.
 ' dvemiliardystoštyridsaťsedemmiliónovštyristoosemdesiattritisícšesťstoštyridsaťsedem
 dim sPom_Kolko$ : sPom_Kolko=""
 dim sPredpona$ : sPredpona=""
 dim bMedzery as boolean : bMedzery=((iSpolu=0) or (iSpolu=2)) ' Medzi rádmi sú podľa gramatiky medzery (ak to chceme)
 
 select case iRad
  case 1
   sPredpona="tisíc"
  case 2, 3
   sPredpona="mi"
  case 4, 5
   sPredpona="bi"
  case 6, 7
   sPredpona="tri"
  case 8, 9
   sPredpona="kvadri"
 end select
 if iRad=1 then ' tisíce
  select case iCislo
   case 0
    sPom_Kolko=""
   case else
    sPom_Kolko=sPredpona
  end select
 else
  if (iRad mod 2)=0 then ' „lióny“ – milión, bilióny, triliónov
   select case iCislo
    case 0
     sPom_Kolko=""
    case 1
     sPom_Kolko=sPredpona+"lión"
    case 2 to 4
     sPom_Kolko=sPredpona+"lióny"
    case else
     sPom_Kolko=sPredpona+"liónov"
   end select
  else ' „liardy“ – miliarda, biliardy, triliárd
   select case iCislo
    case 0
     sPom_Kolko=""
    case 1
     sPom_Kolko=sPredpona+"liarda"
    case 2 to 4
     sPom_Kolko=sPredpona+"liardy"
    case else
     sPom_Kolko=sPredpona+"liárd"
   end select
  endif
 endif
 
 if bMedzery and (iRad=1) then
  ' pri tisícoch píšeme medzeru za
  sPom_Kolko=sPom_Kolko+" "
 endif
 if bMedzery and (iRad>1) then
  ' číslovky milión, miliarda ... píšeme s medzerami pred a za
  sPom_Kolko=" "+sPom_Kolko+" "
 end if
 Slovne_Rady_SK=sPom_Kolko
end function

REM Funkcia, ktorá vyskloňuje celé - 0-1 celá; 2-4 celé; 5... celých
function Sklonuj_Cele_SK(iCislo&) as string
 select case iCislo
  case 0, 1
   Sklonuj_Cele_SK="celá"
  case 2 to 4
   Sklonuj_Cele_SK="celé"
  case else
   Sklonuj_Cele_SK="celých"
 end select
end function

REM Funkcia, ktorá vyskloňuje desatiny - max. milióntiny
function Sklonuj_Desatiny_SK(iCislo&, iRadD%) as string
 dim sPom_Text$
 sPom_Text=""
 select case iRadD
  case 1
   sPom_Text="desat" ' DESATina, iny, ín
  case 2
   sPom_Text="stot" ' STOTina, iny, ín
  case 3
   sPom_Text="tisíc" ' TISÍCina, iny, in
  case 4
   sPom_Text="desaťtisíc" ' DESAŤTISÍCina, iny, in
  case 5
   sPom_Text="stotisíc" ' STOTISÍCina, iny, in
  case 6
   sPom_Text="miliónt" ' MILIÓNTina, iny, in
 end select
 if sPom_Text<>"" then ' Ak sme zadali "rád"
  select case iCislo
   case 1 ' jedna desatINA
    sPom_Text=sPom_Text+"ina"
   case 2 to 4 ' dve desatINY
    sPom_Text=sPom_Text+"iny"
   case else
    if iRadD<=2 then ' päť desatÍN, 
     sPom_Text=sPom_Text+"ín"
    else ' päť tisícIN
     sPom_Text=sPom_Text+"in"
    endif
  end select
 end if
 Sklonuj_Desatiny_SK=sPom_Text
end function

REM Funkcia, ktorá vyskloňuje eurá - 1 euro; 2-4 eurá; 0, 5... eur
function Sklonuj_Euro_SK(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Euro_SK="euro"
  case 2 to 4
   Sklonuj_Euro_SK="eurá"
  case else
   Sklonuj_Euro_SK="eur"
 end select
end function

REM Funkcia, ktorá vyskloňuje centy - 1 cent; 2-4 centy; 0, 5... centov
function Sklonuj_Centy_SK(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Centy_SK="cent"
  case 2 to 4
   Sklonuj_Centy_SK="centy"
  case else
   Sklonuj_Centy_SK="centov"
 end select
end function

REM Funkcia, ktorá vyskloňuje koruny - 1 koruna; 2-4 koruny; 0, 5... korún
function Sklonuj_Koruny_SK(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Koruny_SK="koruna"
  case 2 to 4
   Sklonuj_Koruny_SK="koruny"
  case else
   Sklonuj_Koruny_SK="korún"
 end select
end function

REM Funkcia, ktorá vyskloňuje haliere - 1 halier; 2-4 haliere; 0, 5... halierov
function Sklonuj_Halier_SK(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Halier_SK="halier"
  case 2 to 4
   Sklonuj_Halier_SK="haliere"
  case else
   Sklonuj_Halier_SK="halierov"
 end select
end function

REM Funkcia pre prevod čísla na slovo so skloňovaním
function Preved_na_Slovo_SK(iCislo&, iPismeno%, iSpolu%, iMena%, iRadD%) as string
 dim sSlovne$, sMena$ ' Pomocné premenné pre výstupný reťazec
 dim iAnalyza& ' Prevádzaná časť čísla na slovo
 dim iRad% ' iRad: 1 – tisíc, 2 – milion, 3 – miliarda...
 dim iSklonujCislo& : iSklonujCislo=iCislo ' Pri prevode sa číslo zníži na nulu, potom ho však potrebujeme testovať pre skloňovanie
 
 sSlovne=""
 
 if iCislo=0 then
  ' Osobitne musíme ošetriť číslo „nula“
  sSlovne="nula"
 else
  iRad=0
  do while iCislo<>0 ' Pokiaľ sme ešte nespracovali celé číslo
   ' Z čísla vyberieme posledné tri číslice
   iAnalyza=iCislo mod 1000
   ' ktoré prevedieme na text
   sSlovne=Slovne_Stovky_SK(iAnalyza, iRad)+sSlovne
   ' číslo zmenšíme o už spracovanú časť
   iCislo=int(iCislo/1000)
   ' a pridáme text rádu, ktorý budeme spracovávať v ďalšom kroku cyklu
   if iCislo<>0 then
    iRad=iRad+1
    sSlovne=Slovne_Rady_SK(iCislo mod 1000, iRad, iSpolu)+sSlovne
   endif
  loop
  
  ' Vymazanie prebytočných medzier na začiatku a konci slovného znenia
  sSlovne=trim(sSlovne)
  
  ' Úprava na finančné číslovky - priadnie slova "jedno", "jeden", "jedna" (Jednosto ...)
  if iSpolu>=2 then ' Prevádzame na finančné číslovky
   if (iAnalyza>=100) and (iAnalyza<=199) then
    ' úprava výsledku pre stovky
    sSlovne="jedno"+sSlovne ' jednosto...
   endif
   if (iAnalyza=1) and (iRad>0) then
    ' úprava výsledku pre ostatné rády
    select case iRad
     case 1, 2, 4, 6, 8
      sSlovne="jeden"+sSlovne ' jedentisíc, jedenmilión, …
     case 3, 5, 7, 9
      sSlovne="jedna"+sSlovne ' jednamilarda, …
    end select
   endif
  endif
 endif
 
 ' Príprava textu meny a úprava slovného znenia podľa toho, aká je zadaná mena a
 ' či je to celá alebo desatinná časť:
 ' jedna celá/koruna/desatina, jedno euro, jeden cent/halier/...ina (skloňujeme jedna, jedno, jeden)
 ' dve tri štyri celé/koruny/eurá, dva tri štyri haliere/centy/...iny (skloňujeme dve, dva)
 ' päť celých/korún/eur, päť halierov/centov/...ín
 if iRadD=0 then ' Číslo bolo celá časť
  select case iMena
   case 0 ' Nie je žiadna mena
    sMena=""
   case 1 ' celé
    sMena=Sklonuj_Cele_SK(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna celá
     case 2
      sSlovne="dve" ' dve celé
    end select
   case 2 ' euro
    sMena=Sklonuj_Euro_SK(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedno" ' jedno euro
     case 2
      sSlovne="dve" ' dve eurá
    end select
   case else ' koruna
    sMena=Sklonuj_Koruny_SK(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna koruna
     case 2
      sSlovne="dve" ' dve koruny
    end select
  end select
 else ' Číslo bolo desatinná časť
  select case iMena
   case 0 ' Nie je žiadna mena
    sMena=""
   case 1 ' ...iny
    sMena=Sklonuj_Desatiny_SK(iSklonujCislo, iRadD)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna desatina
     case 2
      sSlovne="dve" ' dve desatiny
    end select
   case 2 ' centy
    sMena=Sklonuj_Centy_SK(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jeden" ' jeden cent
     case 2
      sSlovne="dva" ' dva centy
    end select
   case else ' halier
    sMena=Sklonuj_Halier_SK(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jeden" ' jeden halier
     case 2
      sSlovne="dva" ' dva haliere
    end select
  end select
 end if
 
 if iPismeno>0 then sSlovne=uCase(left(sSlovne,1))+right(sSlovne,len(sSlovne)-1) ' Prvé pímeno bude veľké

 ' Vo výsledku spojíme číslo s menou a orežeme o medzery (ak je mena nezadaná)
 Preved_na_Slovo_SK=trim(sSlovne+" "+sMena) 
end function

REM Funkcia na prevod čísla na slovenské slovo
REM Parametre OPTIONAL nie sú povinné, ak však niektorý z nich chce niekto zadať, musí zadať aj predchádzajúce (nasledujúce nie).
REM Napr. ak chce niekto zadať parameter iSpolu, musí zadať aj predchádzajúce parametre iTyp a iPismeno, nasledujúci parameter iMena zadať nemusí.
function Daj_Slovne_SK(sCislo$,  optional iTyp%, optional iPismeno%, optional iSpolu%,optional iMena%) as string
 ' Význam parametrov:
 ' sCislo$ - prevádzané číslo ako reťazec
 ' iTyp% - 0 – celé – štandardná hodnota, ak je na vstupe celé číslo
 '         1 – reálne – štandardná hodnota, ak je na vstupe reálne číslo
 '         2 - reálne - xx/100
 '         3 - iba desatinná časť
 '         4 a viac - iba desatinná časť v tvare xx/100 (ďalšie parametre - iPismeno, iSpolu a iMena nemajú v tomto prípade význam)
 ' iPismeno% - 0 – prvé písmeno malé – štandardná hodnota
 '             1 a viac – prvé písmeno veľké
 ' iSpolu% - 0 – s medzerami – štandardná hodnota (Stotisíc dvesto)
 '           1 – bez medzier (Stotisícdvesto)
 '           2 - s medzerami finančne (Jednostopäťdesiattisíc dvesto)
 '           3 a viac - bez medzier finančne (Jendostopäťdesiattisícdvesto)
 ' iMena% - 0 – žiadna – štandardná hodnota
 '          1 – celých, desatín (slovo desatín sa použije, ak iTyp<>xx/100)
 '          2 – euro, centy (slovo centy sa použije, ak iTyp<>xx/100)
 '          3 a viac – koruny, haliere (slovo haliere sa použije, ak iTyp<>xx/100)
 dim iRadD% ' iRadD: 1 - desatín, 2 - stotín, 3 - tisícin... (podľa počtu cifier v desatinnej časti)
 dim sPomCela$ : sPomCela="" ' Pomocná premenná pre prevod celej časti
 dim sPomDesat$ : sPomDesat$="" ' Pomocná premenná na prevod desatinnej časti
 ' Pretože vstupné parametre sú optional, vo funkcii sa používajú vnútorné premenné
 ' ktoré sa nastavia podľa parametrov, ak sú zadané, inak nastavíme štandardné hodnoty
 dim ipPismeno% : ipPismeno=0
 dim ipSpolu% : ipSPolu=0 
 dim ipTyp% : ipTyp=0 ' Štandardnú hodnotu ake je reálne číslo zadáme, keď zistíme, či to je reálne číslo
 dim ipMena% : ipMena=0
 dim iCela&, iDesatinna&
 
 iRadD=Cela_Desatinna(sCislo, iCela, iDesatinna)
 if iRadD>0 then ipTyp=1 ' Je to reálne číslo (nenulový počet desatinných cifier)
 if iRadD=0 then iRadD=1 ' Ak bolo zadané celé číslo, musíme zadať, že je jedno desatinné číslo (nula) pre prípad, že budeme prevádzať desatinnú časť
 
 ' Ak sú parametre zadané, nastavíme vnútorné premenné podľa nich
 if not IsMissing(iPismeno ) then ipPismeno=iPismeno ' Parameter veľkosti prvého písmena je zadaný
 if not IsMissing(iSpolu) then ipSpolu=iSpolu ' Parameter s/bez medzier je zadaný
 if not IsMissing(iTyp) then ipTyp=iTyp ' Parameter reálne/celé číslo je zadaný
 if not IsMissing(iMena) then ipMena=iMena ' Parameter meny je zadaný
 
 select case ipTyp
  case 0
   sPomCela=Preved_na_Slovo_SK(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
  case 1
   sPomCela=Preved_na_Slovo_SK(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
   if ipMena>0 then sPomDesat=Preved_na_Slovo_SK(iDesatinna, ipPismeno, ipSpolu, ipMena, iRadD) ' Prevod desatinnej časti má význam iba vtedy, ak je zadaná mena
  case 2
   sPomCela=Preved_na_Slovo_SK(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
   sPomDesat=+trim(str(iDesatinna))+"/"+trim(str(10^iRadD)) ' Prevod desatinnej časti na xx/100
  case 3
   sPomDesat=Preved_na_Slovo_SK(iDesatinna, ipPismeno, ipSpolu, ipMena, iRadD) ' Prevod desatinnej časti
  case else
   sPomDesat=+trim(str(iDesatinna))+"/"+trim(str(10^iRadD)) ' Prevod desatinnej časti na xx/100
 end select
 
 Daj_Slovne_SK=trim(sPomCela+" "+sPomDesat)
end function

function Daj_Slovne(i&, a as boolean, b as boolean) as string
end function
