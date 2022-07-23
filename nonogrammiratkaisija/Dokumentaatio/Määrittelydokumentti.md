# Määrittelydokumentti

Ohjelmointikielenä harjoitustyössä käytetään Javaa, jolla olen suorittanut OhPen ja OhJan. Tämän lisäksi olen ehtinyt hieman tutustua myös Pythoniin tekemällä OhPen tehtäviä. Luonnollisena kielenä käytössä on suomi.

Nonogrammiratkaisijan toteutan algoritmillä, joka on kuvattu [Helkasta löytyvässä artikkelissa](https://helsinki.primo.exlibrisgroup.com/permalink/358UOH_INST/qn0n39/cdi_gale_infotracacademiconefile_A272876190). Algoritmi käy ensin läpi rivejä ja sarakkeita kerta toisensa jälkeen tiettyjen sääntöjen mukaan kunnes rivit ja sarakkeet on ratkaistu tai niihin ei enää pysty soveltamaan kyseisiä sääntöjä. Jos ratkaisua ei ole tämän vaiheen jälkeen löytynyt, käytetään kronologista perääntymistä (chronological backtracking), joka perustuu syvyyshaukuun (depth-first search).

Opinto-ohjelmani on tietojenkäsittelytieteen kanditaatti.