# Toteutusdokumentti

## Käyttöliittymä

Käyttöliittymä toteutetaan tekstipohjaisena. Nonogrammin voi syöttää ainakin käsin ohjelman ollessa käynnissä, mutta perehdyn mahdollisuuteen lisätä se myös esimerkiksi määrätyssä muodossa olevasta tekstitiedostosta.

Nonogrammin syötössä tulee huomioida, että nonogrammissa saattaa olla kokonaan valkoisia rivejä. Tästä johtuen käyttäjän tulee ensin kertoa vaaka- ja pystyrivien määrä ja sen jälkeen kunkin rivin numerot vasemmalta oikealle ja ylhäältä alas.

Nonogrammin kuvan tulostuksen helpottamiseksi tulosteeseen ei tule numeroita ainakaan aluksi.

## Algoritmi

Nonogrammin ratkaisualgoritmi toteutaan artikkelin ["An efficient algorithm for solving nonograms" (Yu ym. 2011)](https://helsinki.primo.exlibrisgroup.com/permalink/358UOH_INST/qn0n39/cdi_gale_infotracacademiconefile_A272876190) pohjalta. Algoritmi koostuu kolmesta pääosasta.

### Alustus

Saadun syötteen perusteella luodaan taulukot `ruudukko[][]` ja `rivit[]`. Jokaisen rivin luonnin aikana tarkistetaan, että rivien numeroiden summa ei ole liian iso, joka on ensimmäinen merkki siitä, onko nonogrammi mahdollisesti ratkaistavissa. Riville luodaan myös mustat pätkät.

### Loogiset säännöt

Loogisissa säännöissä tarkastelun kohteena ovat joko mustat pätkät tai yksittäiset solut. Säännöt toteutetaan luokan `Rivi` metodeina, jotka tarvittaessa kutsuvat luokan `MustaPatka` metodeja. Jokainen sääntö toteutetaan omana metodina, jotta esimerkiksi testaus helpompaa.

Rivit ovat taulukkona. Taulukkoa läpikäydessä käytetään luokassa `Nonogrammi` boolean-muuttujaa, joka pitää kirjaa, onko kierroksella tehty muutoksia.

```
boolean muutoksiaEdellisellaKierroksella = true

while(muutoksiaEdellisellaKierroksella)
    muutoksiaEdellisellaKierroksella = false
    for rivi in rivit:
        // läpikäydään säännöt

        if muutoksia:
            muutoksiaEdellisellaKierroksella = true
```

Jos muutoksia ei ole tapahtunut, siirytään peruuttavaan hakuun ((*chronological*) *backtracking*).

### Peruuttava haku

Peruuttavassa haussa käytetään apuna loogisia sääntöjä rajaamaan tutkittavien vaihtoehtojen määrää.

Luokan `Nonogrammi` oliosta voidaan luoda kopioita ratkaisuvaihtoehtojen läpikäyntiä varten. Kun päädytään peruuttavan haun tilanteeseen, etsitään nonogrammista ensimmäinen rivi, joka ei ole vielä valmis ja luodaan uudet Nonogrammi-oliot näiden ratkaisuvaihtoehtojen pohjalta ja jatketaan ratkaisu(je)n etsimistä loogisten sääntöjen avulla.

## Omat tietorakenteet ja luokat

Luokka `Nonogrammi`, joka pitää tallessa nonogrammia käsittelevää tietoa
- Kaksiuloitteinen taulukko `ruudukko[][]`, joka koostuu luokan `Ruutu` olioista ja kuvastaa nonogrammista syntyvää kuvaa. *ehkä sittenkin luokkana?*
- Taulukko `rivit[]`, joka koostuu luokan `Rivi` olioista.

Luokka `Ruutu`, joka pitää kirjaa nonogrammin yksittäisen ruudun tilasta (tuntematon, musta, valkoinen, virhe; toteutetaan enumilla `RuudunTila`). Tilaksi merkitään virhe, jos mustaa ruutua yritetään merkitä valkoiseksi tai päinvastoin. (Täytyy selvittää, miten ohjelman keskeytys tässä tapauksessa onnistuu.)

Luokat `Vaakarivi` ja `Pystyrivi`, jotka perivät yläluokan `Rivi` ????

- rivinumero
- ensimmäinen musta pätkä? / taulukko mustista pätkistä
- valmis boolean

Luokka `MustaPatka`, joka sisältää tiedot tietyn mustan pätkän (mahdollisista) alku- ja loppupisteistä ja pituudesta
- rivi, jolla pätkä on
    - voisi tuoda myös jokaisen metodin parametrina, mutta luonnista asti aina sama, joten ehkä helpompi näin?
- edellinen pätkä (ensimmäisellä null) ???
    - tämänkin voisi tuoda parametrillä tarvittaessa, mutta aina sama
- seuraava pätkä (viimeisellä null) ???
    - ks. edellinen
- pituus
- pienin mahdollinen alkupiste
- suurin mahdollinen loppupiste