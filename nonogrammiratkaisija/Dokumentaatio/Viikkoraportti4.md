# Viikkoraportti 4

## Päiväkirja

**Tiistai**

Checkstylessa metodin maksimipituudeksi muutettu 30 riviä, aiemmin 20. Ainakin nykyisillä metodeilla riittävä.

Aloitettu säännön 1.2 työstö.

(n. 1,5h)

**Keskiviikko**

Sääntö 1.2 valmiiksi.

(n. 4,5h)

**Torstai**

Opin, että yläluokassa abstraktien metodien määreenä voi käyttää `protected`, jolloin metodia voi hyödyntää alaluokissa tehtävänä varsinaisena metodina, jota hyödynnetään yläluokan metodissa. Tämän perusteella luokista `Vaakarivi` ja `Pystyrivi` poistettu toisteisuus.

Sääntö 1.3 toteutettu.

(n. 5h)

**Perjantai**

Tehty nonogrammiruudukolle oma luokka `Ruudukko`, jotta sääntöjen käsittelyä varten saa `Rivi`-olion metodeille syötettyä vain tarvittavan rivin ruudukosta. Tätä varten lisätty `Rivi`-oliolle `boolean onVaakarivi`. (n. 1h)

Sääntö 1.4 toteutettu. (n. 4h)

**Pe-la yö**

Sääntö 1.5 aloitettu. (n. 2,5h)

**Lauantai**

Sääntö 1.5 viimeistelty. (n. 1h)

Raportointi: Hieman päivitetty toteutusdokumenttia. Viikkoraportin viimeistelyä. (n. 1h)

Puuttuvien JavaDocien lisäys. (n. 0,25h)

## Ajatuksia viikosta

Koodia on tällä viikolla kirjoitettu yksikkötestien rivi- ja etenkin haaraumakattavuuksien kustannuksella. Osan 1 säännöt on nyt saatu toteutettua. Ainakin säännöt 1.3 ja 1.4 tuntuivat vaativan paljon sanallisen kuvauksen ymmärtämistä, mikä tuntui hidastavan koodin kirjoittamista ja vaati asian pohtimista melko paljon ennen varsinaista koodin kirjoittamista. Sääntö 1.5 sen sijaan oli selkeästi kirjoitettu matemaattisia merkintöjä käyttäen, mikä nopeutti koodin kirjoittamista. Osissa 2 ja 3 vaikuttaisi olevan hyödynnetty enemmän matemaattisia merkintöjä, joten niiden ja osan 1 koodaamisen aikana luotujen työkalujen avulla seuraavien sääntöjen kirjoittaminen sujunee nopeammin.

Yritin selvittää hieman, että miten saisin tulevaan testausraporttiin näkyviin badgen yksikkötestien rivikattavuudesta. Ilmeisesti sen saisi Codecovin avulla, mutta OhTun ohjeet on tehty Gradlelle ja tässä on käytössä Maven, enkä enää jaksanut alkaa selvittämään sen käyttöönottoa tarkemmin. Päivä pari taukoa ohjelmoinnista, niin sitten taas jaksaa.