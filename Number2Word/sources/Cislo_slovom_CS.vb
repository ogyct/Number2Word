REM Funkcia na prevod čísiel 1-9 na reťazec
function Slovne_Jedno_Cislo_CS(iCislo%, iRad%) as string
' Pre stovky, kde sa skloňuje číslovka 2 použijeme hodnotu iRad=3
 dim sPom_Nazov$ : sPom_Nazov=""
 
 select case iCislo
  case 1
   ' Číslovka „jedna“ sa pri rádoch tisíc, milión,... nepíše
   if (iRad=0) then 
    sPom_Nazov="jedna"
   endif
  case 2
   ' Dvojka sa skloňuje - dva, dvěstě, dvatisíce, dvamilióny, dvěmiliardy, …
   select case iRad
    case 0, 1, 2 ' dva, dva tisíce, dva milióny
     sPom_Nazov="dva"
    case 3
     sPom_Nazov="dvě" ' dvě stě, dvě miliardy
    case 4
     sPom_Nazov="dva" ' dva bilióny
    case 5
     sPom_Nazov="dvě" ' dvě biliardy
    case 6
     sPom_Nazov="dva" ' dva trilióny
    case 7
     sPom_Nazov="dvě" ' dvě triliardy
    case 8
     sPom_Nazov="dva" ' dva kvadrilióny
    case 9
     sPom_Nazov="dvě" ' dvě kvadriliardy
   end select
  case 3
   sPom_Nazov="tři"
  case 4
   sPom_Nazov="čtyři"
  case 5
   sPom_Nazov="pět"
  case 6
   sPom_Nazov="šest"
  case 7
   sPom_Nazov="sedm"
  case 8
   sPom_Nazov="osm"
  case 9
   sPom_Nazov="devět"
 end select
 Slovne_Jedno_Cislo_CS=sPom_Nazov
end function

REM Funkcia na prevod čísiel 10-99 na reťazec
function Slovne_Desiatky_CS(iJednotky%, iDesiatky%, iSpolu%) as string
 dim sPom_Nazov$ : sPom_Nazov=""
 dim sPom_Jednotky$
 dim bMedzery as boolean : bMedzery=((iSpolu=0) or (iSpolu=2)) ' Medzi rádmi sú podľa gramatiky medzery (ak to chceme)
 
 select case iDesiatky
  case 1
   ' desať – devätnásť
   select case iJednotky
    case 0
     sPom_Nazov="deset"
    case 1
     sPom_Nazov="jedenáct"
    case 2
     sPom_Nazov="dvanáct"
    case 3
     sPom_Nazov="třináct"
    case 4
     sPom_Nazov="čtrnáct"
    case 5
     sPom_Nazov="patnáct"
    case 6
     sPom_Nazov="šestnáct"
    case 7
     sPom_Nazov="sedmnáct"
    case 8
     sPom_Nazov="osmnáct"
    case 9
     sPom_Nazov="devatenáct"
   end select
   iJednotky=0
  case 2 to 4
   ' "cet" – dvacet až čtyřicet
   sPom_Nazov=Slovne_Jedno_Cislo_CS(iDesiatky,0)+"cet"
  case 5
   sPom_Nazov="padesát"
  case 6
   sPom_Nazov="šedesát"
  case 7, 8
   ' "desár" - sedmdesát, osmdesát
   sPom_Nazov=Slovne_Jedno_Cislo_CS(iDesiatky,0)+"desát"
  case else
   ' devadesát
   sPom_Nazov="devadesát"
 end select
 sPom_Jednotky=Slovne_Jedno_Cislo_CS(iJednotky,0)
 if sPom_Jednotky<>"" then
  if bMedzery then ' ak nie sú finančné číslovky, tak sa jednotky píšu pri desiatkách s medzerou
   sPom_Nazov=sPom_Nazov+" "+sPom_Jednotky
  else ' pri finančných číslach sa nepíše medzera
   sPom_Nazov=sPom_Nazov+sPom_Jednotky
  endif
 endif
 Slovne_Desiatky_CS=sPom_Nazov
end function

REM Funkcia na prevod čísiel 1-999 na reťazec
function Slovne_Stovky_CS(iCislo%, iRad%, iSpolu%) as string
 dim iJednotky% : iJednotky=iCislo mod 10 ' z čísla vypreparujeme číslice na mieste jednotiek,
 dim iDesiatky% : iDesiatky=int(iCislo/10) mod 10 ' desiatok
 dim iStovky% : iStovky=int(iCislo/100) ' a stoviek
 dim sPom_Slovne$ : sPom_Slovne=""
 dim sPom_Stovky$ : sPom_Stovky=""
 dim sPom_Stovky_c$
 dim bMedzery as boolean : bMedzery=((iSpolu=0) or (iSpolu=2)) ' Medzi rádmi sú podľa gramatiky medzery (ak to chceme)
 
 ' Najprv prevedieme na text jednotky a desiatky (číslo 0 až 99)
 if iDesiatky=0 then
  ' iba jednotky (čísla 0 až 9)
  if iStovky=0 then
   ' celá trojica je číslo 0 až 9 a vtedy sa číslovka 1 a 2 skloňuje podľa rádu
   sPom_Slovne= Slovne_Jedno_Cislo_CS(iJednotky,iRad)
  else
   ' je to zložené číslo a vtedy sa číslovka 1 a 2 neskloňuje (základný tvar je pre rád 0)
   sPom_Slovne= Slovne_Jedno_Cislo_CS(iJednotky,0)
  endif
 else
  ' je to číslo od 10 do 99
  sPom_Slovne=Slovne_Desiatky_CS(iJednotky, iDesiatky, iSpolu)
 endif

 ' teraz k prevedenému dvojcifernému číslu pridáme text o stovkách
 sPom_Stovky_c=Slovne_Jedno_Cislo_CS(iStovky,3)
 select case iStovky
  case 1
   ' Pri stovkách sa jednosto píše iba finančne
   sPom_Stovky="sto"
  case 2
   ' dvě stě
   sPom_Stovky="stě"
  case 3, 4
   ' tři sta, čtyři sta
   sPom_Stovky="sta"
  case 5 to 9
   ' pět set až devět set
   sPom_Stovky="set"
 end select
 if sPom_Stovky_c<>"" then
  if bMedzery then ' ak nie sú finančné číslovky, tak sa jednotky píšu pri desiatkách s medzerou
   sPom_Stovky=sPom_Stovky_c+" "+sPom_Stovky
  else ' pri finančných číslach sa nepíše medzera
   sPom_Stovky=sPom_Stovky_c+sPom_Stovky
  endif
 endif
 if sPom_Slovne="" then
  sPom_Slovne=sPom_Stovky
 else
  if bMedzery then ' ak nie sú finančné číslovky, tak sa jednotky píšu stovky s medzerou
   sPom_Slovne=sPom_Stovky+" "+sPom_Slovne
  else ' pri finančných číslach sa nepíše medzera
   sPom_Slovne=sPom_Stovky+sPom_Slovne
  endif
 endif
 Slovne_Stovky_CS=sPom_Slovne
end function

REM Funkcia na zistenie rádových prípon
function Slovne_Rady_CS(iCislo%, iRad%, iSpolu%) as string
 ' Texty o biliónoch, ... sú teoretické, pretože premenná typu LONG je maximálne 2.147.483.647, t.j.
 ' dvemiliardystoštyridsaťsedemmiliónovštyristoosemdesiattritisícšesťstoštyridsaťsedem
 dim sPom_Kolko$ : sPom_Kolko=""
 dim sPredpona$ : sPredpona=""
 dim bMedzery as boolean : bMedzery=((iSpolu=0) or (iSpolu=2)) ' Medzi rádmi sú podľa gramatiky medzery (ak to chceme)
 
 select case iRad
  case 1
   select case iCislo
    case 1
     sPredpona="tisíc"
    case 2 to 4
     sPredpona="tisíce"
    case else
     sPredpona="tisíc"
   end select
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
     sPom_Kolko=sPredpona+"liónů"
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
 if bMedzery and (iRad>0) then sPom_Kolko=" "+sPom_Kolko+" " ' číslovky tisíc, milión, miliarda ... píšeme s medzerami pred a za
 Slovne_Rady_CS=sPom_Kolko
end function

REM Funkcia, ktorá vyskloňuje celé - 0-1 celá; 2-4 celé; 5... celých
function Sklonuj_Cele_CS(iCislo&) as string
 select case iCislo
  case 0, 1
   Sklonuj_Cele_CS="celá"
  case 2 to 4
   Sklonuj_Cele_CS="celé"
  case else
   Sklonuj_Cele_CS="celých"
 end select
end function

REM Funkcia, ktorá vyskloňuje desatiny - max. milióntiny
function Sklonuj_Desatiny_CS(iCislo&, iRadD%) as string
 dim sPom_Text$
 sPom_Text=""
 select case iRadD
  case 1
   sPom_Text="deset" ' DESEATina, iny, in
  case 2
   sPom_Text="set" ' SETina, iny, in
  case 3
   sPom_Text="tisíc" ' TISÍCina, iny, in
  case 4
   sPom_Text="desetisíc" ' DESETISÍCina, iny, in
  case 5
   sPom_Text="stotisíc" ' STOTISÍCina, iny, in
  case 6
   sPom_Text="miliónt" ' MILIÓNTina, iny, in
 end select
 if sPom_Text<>"" then ' Ak sme zadali "rád"
  select case iCislo
   case 1 ' jedna desetINA
    sPom_Text=sPom_Text+"ina"
   case 2 to 4 ' dvě desetINY
    sPom_Text=sPom_Text+"iny"
   case else ' pět desetIN
    sPom_Text=sPom_Text+"in"
  end select
 end if
 Sklonuj_Desatiny_CS=sPom_Text
end function

REM Funkcia, ktorá vyskloňuje eurá - 1 euro; 2-4 eurá; 0, 5... eur
function Sklonuj_Euro_CS(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Euro_CS="euro"
  case 2 to 4
   Sklonuj_Euro_CS="eura"
  case else
   Sklonuj_Euro_CS="eur"
 end select
end function

REM Funkcia, ktorá vyskloňuje centy - 1 cent; 2-4 centy; 0, 5... centov
function Sklonuj_Centy_CS(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Centy_CS="cent"
  case 2 to 4
   Sklonuj_Centy_CS="centy"
  case else
   Sklonuj_Centy_CS="centů"
 end select
end function

REM Funkcia, ktorá vyskloňuje koruny - 1 koruna; 2-4 koruny; 0, 5... korún
function Sklonuj_Koruny_CS(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Koruny_CS="koruna"
  case 2 to 4
   Sklonuj_Koruny_CS="koruny"
  case else
   Sklonuj_Koruny_CS="korun"
 end select
end function

REM Funkcia, ktorá vyskloňuje haliere - 1 halier; 2-4 haliere; 0, 5... halierov
function Sklonuj_Halier_CS(iCislo&) as string
 select case iCislo
  case 1
   Sklonuj_Halier_CS="haléř"
  case 2 to 4
   Sklonuj_Halier_CS="haléře"
  case else
   Sklonuj_Halier_CS="haléřů"
 end select
end function

REM Funkcia pre prevod čísla na slovo so skloňovaním
function Preved_na_Slovo_CS(iCislo&, iPismeno%, iSpolu%, iMena%, iRadD%) as string
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
   sSlovne=Slovne_Stovky_CS(iAnalyza, iRad, iSpolu)+sSlovne
   ' číslo zmenšíme o už spracovanú časť
   iCislo=int(iCislo/1000)
   ' a pridáme text rádu, ktorý budeme spracovávať v ďalšom kroku cyklu
   if iCislo<>0 then
    iRad=iRad+1
    sSlovne=Slovne_Rady_CS(iCislo mod 1000, iRad, iSpolu)+sSlovne
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
 ' jedna celá/koruna/desetina, jedno euro, jeden cent/haléř/...ina (skloňujeme jedna, jedno, jeden)
 ' dvě tři čtyři celé/koruny/eura, dva tři čtyři haléře/centy/...iny (skloňujeme dvě, dva)
 ' pět celých/korun/eur, pět haléřů/centů/...in
 if iRadD=0 then ' Číslo bolo celá časť
  select case iMena
   case 0 ' Nie je žiadna mena
    sMena=""
   case 1 ' celé
    sMena=Sklonuj_Cele_CS(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna celá
     case 2
      sSlovne="dvě" ' dvě celé
    end select
   case 2 ' euro
    sMena=Sklonuj_Euro_CS(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedno" ' jedno euro
     case 2
      sSlovne="dvě" ' dvě eura
    end select
   case else ' koruna
    sMena=Sklonuj_Koruny_CS(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna koruna
     case 2
      sSlovne="dvě" ' dve koruny
    end select
  end select
 else ' Číslo bolo desatinná časť
  select case iMena
   case 0 ' Nie je žiadna mena
    sMena=""
   case 1 ' ...iny
    sMena=Sklonuj_Desatiny_CS(iSklonujCislo, iRadD)
    select case iSklonujCislo
     case 1
      sSlovne="jedna" ' jedna desetina
     case 2
      sSlovne="dvě" ' dve desetiny
    end select
   case 2 ' centy
    sMena=Sklonuj_Centy_CS(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jeden" ' jeden cent
     case 2
      sSlovne="dva" ' dva centy
    end select
   case else ' halier
    sMena=Sklonuj_Halier_CS(iSklonujCislo)
    select case iSklonujCislo
     case 1
      sSlovne="jeden" ' jeden haléř
     case 2
      sSlovne="dva" ' dva haléře
    end select
  end select
 end if
 
 if iPismeno>0 then sSlovne=uCase(left(sSlovne,1))+right(sSlovne,len(sSlovne)-1) ' Prvé pímeno bude veľké

 ' Vo výsledku spojíme číslo s menou a orežeme o medzery (ak je mena nezadaná)
 Preved_na_Slovo_CS=trim(sSlovne+" "+sMena) 
end function

REM Funkcia na prevod čísla na české slovo
REM Parametre OPTIONAL nie sú povinné, ak však niektorý z nich chce niekto zadať, musí zadať aj predchádzajúce (nasledujúce nie).
REM Napr. ak chce niekto zadať parameter iSpolu, musí zadať aj predchádzajúce parametre iTyp a iPismeno, nasledujúci parameter iMena zadať nemusí.
function Daj_Slovne_CS(sCislo$, optional iTyp%, optional iPismeno%, optional iSpolu%, optional iMena%) as string
 ' Význam parametrov:
 ' sCislo$ - prevádzané číslo ako reťazec
 ' iTyp% - 0 – celé – štandardná hodnota, ak je na vstupe celé číslo
 '         1 – reálne – štandardná hodnota, ak je na vstupe reálne číslo
 '         2 - reálne - xx/100
 '         3 - iba desatinná časť
 '         4 a viac - iba desatinná časť v tvare xx/100 (ďalšie parametre - iPismeno, iSpolu a iMena nemajú v tomto prípade význam)
 ' iPismeno% - 0 – prvé písmeno malé – štandardná hodnota
 '             1 a viac – prvé písmeno veľké
 ' iSpolu% - 0 – s medzerami – štandardná hodnota (Sto padesát)
 '           1 – bez medzier (Stopadesát)
 '           2 - s medzerami finančne (Jednosto padesát)
 '           3 a viac - bez medzier finančne (Jendostopadesát)
 ' iMena% - 0 – žiadna – štandardná hodnota
 '          1 – celých, desetin (slovo desetin sa použije, ak iTyp<>xx/100)
 '          2 – euro, centy (slovo centy sa použije, ak iTyp<>xx/100)
 '          3 a viac – koruny, haléře (slovo haléře sa použije, ak iTyp<>xx/100)
 dim iRadD% ' iRadD: 1 - desetin, 2 - stotin, 3 - tisícin... (podľa počtu cifier v desatinnej časti)
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
   sPomCela=Preved_na_Slovo_CS(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
  case 1
   sPomCela=Preved_na_Slovo_CS(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
   if ipMena>0 then sPomDesat=Preved_na_Slovo_CS(iDesatinna, ipPismeno, ipSpolu, ipMena, iRadD) ' Prevod desatinnej časti má význam iba vtedy, ak je zadaná mena
  case 2
   sPomCela=Preved_na_Slovo_CS(iCela, ipPismeno, ipSpolu, ipMena, 0) ' Prevod celej časti
   sPomDesat=+trim(str(iDesatinna))+"/"+trim(str(10^iRadD)) ' Prevod desatinnej časti na xx/100
  case 3
   sPomDesat=Preved_na_Slovo_CS(iDesatinna, ipPismeno, ipSpolu, ipMena, iRadD) ' Prevod desatinnej časti
  case else
   sPomDesat=+trim(str(iDesatinna))+"/"+trim(str(10^iRadD)) ' Prevod desatinnej časti na xx/100
 end select
 
 Daj_Slovne_CS=trim(sPomCela+" "+sPomDesat)
end function

