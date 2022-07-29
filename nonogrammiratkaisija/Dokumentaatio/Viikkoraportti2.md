# Viikkoraportti 2

## Päiväkirja

**Lauantaina** aloitettu toteutusdokumentin teko, jotta saatu edeltävinä viikkoina mieleen tulleita toteutukseen liittyviä ajatuksia päästä ulos. (n. 1 h)

**Maanantaina** tutkittu artikkelia tarkemmin ja pohdittu toteutusdokumenttia. Toteutusdokumentti saatu varsin hyvälle mallille. (Yhteensä n. 5,5 h)

*Chronological backtracking* on sama kuin *backtracking*, joka on suomeksi peruuttava haku.

**Perjantaina** aloitettu varsinainen koodaus. Viikkoraportin kirjoittamista. (Yhteensä n. 6 h)

## Ajatuksia tästä viikosta

Olen varsin tyytyväinen kirjoittamaani totetutusdokumenttiin, vaikkei se aivan valmis kokonaisuuden kannalta olekaan vielä. Koodin edistyessä luultavasti selkenee kokonaiskuva toteutuksenkin kannalta. Myös koodauksessa pääsin omasta mielestäni hyvälle alulle ottaen huomioon, etten ole yli vuoteen kovin paljon koodannut juuri mitään. Varsinaisiin sääntöihin en vielä päässyt, mutta nonogrammin alustuksen pitäisi nyt toimia.

Testaamiseen täytyy panostaa ensi viikolla. Nyt en ehinyt edes käyttäjätestausta tekemään enempää kuin että ohjelma ei hajoa nonogrammia syötettäessa silloin kun kaikilla riveillä on numeroita. Jos joukossa on tyhjä rivi, niin silloin ohjelma kuitenkin hajoaa alustuksen aikana. Ongelmakohta on löydetty ja kommentoitu koodiin.

Yksikkötestaamiseen minun täytyy perehtyä kunnolla, koska aiemmilla kursseilla olen tehnyt yksikkötestejä varsin minimaalisen määrän. Luulen, että asiaa kuitenkin helpottaa, että olen nyt yrittänyt tehdä metodeista mahdollisimman pieniä.

Checkstylea en saanut tällä viikolla vielä konffattua, mutta muistaakseni se ei kovin vaikea ollut, joten se onnistunee melko helposti OhTen Java-materiaalista löytyvän ohjeen mukaan. JavaDocceja en ole aiemmin kirjoittanut, mutta siihenkin näyttäisi löytyvän OhTen sivuilta ihan hyvä ohje, samoin aiemmin mainittuihin yksikkötesteihin.

Aion nyt aluksi kirjoitta koodin mahdollisimman tarkkaan artikkelissa esitettyjen kaavojen mukaan. Tällä viikolla kuitenkin huomasin jo yhden kohdan kirjoittamassani koodissa, jossa pystyisin poistamaan for-silmukan toisen for-silmukan sisältä. Aion kommentoida kohdat koodiin, kuten nyt tein, ja jos aikaa riittää myöhemmin, palata tehostamaan niitä. Samassa yhteydessä voisi tehdä aikavertailua.