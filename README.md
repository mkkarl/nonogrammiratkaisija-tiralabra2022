# Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit

Tämä on loppukesän 2022 Tiralabrassa tehtävän harjoitustyön repositorio. Harjoitustyössä toteutetaan nonogrammiratkaisija.

Nonogrammi eli japanilainen ristikko on ristikko, jossa ruudukon ruutuja väritetään mustiksi tai jätetään valkoisiksi riveillä ja sarakkeilla olevien numeroiden perusteella. Tarkemmin nonogrammeista voi lukea esimerkiksi [Wikipediasta](https://fi.wikipedia.org/wiki/Japanilainen_ristikko).

## Dokumentaatio

[Määrittelydokumentti](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/M%C3%A4%C3%A4rittelydokumentti.md)

[Toteutusdokumentti](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Toteutusdokumentti.md)

### Viikkoraportointi

[Viikkoraportti 1](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Viikkoraportti1.md)

[Viikkoraportti 2](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Viikkoraportti2.md)

[Viikkoraportti 3](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Viikkoraportti3.md)

[Viikkoraportti 4](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Viikkoraportti4.md)

[Viikkoraportti 5](https://github.com/mkkarl/nonogrammiratkaisija-tiralabra2022/blob/main/nonogrammiratkaisija/Dokumentaatio/Viikkoraportti5.md)

## Käyttöohjeita

### JavaDoc

JavaDocien html-version saa luotua komentorivillä komennolla `mvn javadoc:javadoc` ja se löytyy polusta *nonogrammiratkaisija/target/apidocs/index.html*.

### Checkstyle

Checkstyle-raportin saa luotua komentorivillä komennolla `mvn jxr:jxr checkstyle:checkstyle` ja se löytyy polusta *nonogrammiratkaisja/target/checkstyle.html*.

### JaCoCo

JaCoCo-raportin saa luotua komentorivillä komennolla `mvn test jacoco:report` ja se löytyy polusta *nonogrammiratkaisija/target/jacoco/index.html*.