# Viikkoraportti 5

## Päiväkirja

**Torstai**

Säännöt 2.1 ja 2.2 (n. 3h)

Sääntö 2.3 (n. 2,25h)

Sääntö 3.1: Tässä joudun hieman tekemään oletuksia siitä, mitä artikkelin kirjoittajat ovat tarkoittaneet merkinnöillään, sillä mielestäni merkinnät eivät ole yksiselitteisiä. Nonogrammikokemukseni perusteella oletan, että *m <= n*. Lisäksi pohdin, että pitäisikö rivien ensimmäiset ja viimeiset mustat pätkät jättää käsittelemättä vai *m* ja *n* laskea muulla tavoin niissä tapauksissa. Taidan märitellä, että ensimmäisessä pätkässä m on vain ensimmäinen musta ruutu ja viimeisessä n on viimeinen musta ruutu. Lisäksi tuli mieleeni mahdollisuus, että voiko sääntö 3.1 laajentaa patkan jo kapeammaksi saatua aluetta. Täytyy myös jättää käsittelemättä tapaukset, joissa *n - m + 1 > LB<sub>j</sub>*. (pohdintaa n. 1h)

**Perjantai**

Sääntö 3.1: Koodattu nyt niin, että ratkaistavissa olevalla nonogrammilla ei mielestäni pitäisi syntyä ongelmia. (Koodaus n. 0,5h)

Testejä ja koodin korjausta (n. 2,5h) 

Kun säännön 3.1 lisää sovelluslogiikkaan, niin ohjelman hajoaminen tulee esiin.

Käyttöliittymätestissä käytettävän nonogrammin tulisi valmiina näyttää tältä:

```
+--------+
| O  OOOO|
|OO  O   |
| O  O   |
| O  OOOO|
| O     O|
| O     O|
| O  O  O|
|OOO OOOO|
+--------+
```

Säännön 2.3 jälkeen se näyttää tältä:

```
+--------+
| O  OOOO|
|?O? O???|
| O  O   |
| O  OOOO|
| O  ?  O|
| O   ??O|
| O  O ?O|
|OOO OOOO|
+--------+
```

Säännön 3.1 jälkeen taas siinä on paljon virheellisiä ruutuja `X`:

```
+--------+
| OXXOOOO|
|?OOXOOOO|
| OXXOXXX|
| OXXOOOO|
| OX O  O|
| OX X??O|
| OXXO ?O|
|OOOXOOOO|
+--------+
```

`X` tarkoittaa, että valkoista ruutua on yritetty muuttaa mustaksi tai päinvastoin.

Aikaa on rajallisesti käytettävissä, joten jätän ongelman tutkimisen myöhemmäksi. Jätän luokassa `Sovelluslogikka` säännön 3.1 kommentoiduksi, jotta käyttöliittymän ohjelma on toimiva. Halutessaan kommentoinnin voi poistaa, jotta voi tutkia hajoavaa ohjelmaa.

Vertaisarviointi (n. 3,5h)

## Ajatuksia tästä viikosta

Osassa kaksi mustien pätkien testien rivikattavuudet ovat kehnoja, koska torstaina säännön 2.1 testin alusta oli unohtunut `@Test`, joten kuvittelin, että 0% rivikattavuus johtuu `void`-tyyppisestä metodista. Perjantaina tämän tajutessani en kuitenkaan alkanut kirjoittamaan lisää testejä vaan jatkoin meneillä olevaa asiaa.