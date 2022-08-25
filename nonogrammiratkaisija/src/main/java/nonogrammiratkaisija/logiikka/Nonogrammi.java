package nonogrammiratkaisija.logiikka;

public class Nonogrammi {
    private Ruudukko ruudukko;
    private Rivi[] rivit;

    /**
     * Nonogrammi, joka koostuu riveistä ja ruuduista.
     * 
     * @param vaakarivit Nonogrammin vaakarivien numerot vasemmalta oikealle ja
     *                   ylhäältä alas taulukkona
     * @param pystyrivit Nonogrammin pystyrivien numerot ylhäältä alas ja vasemmalta
     *                   oikealle taulukkona
     */
    public Nonogrammi(String[] vaakarivit, String[] pystyrivit) {
        Ruutu[][] apuruudukko = new Ruutu[vaakarivit.length][pystyrivit.length];

        for (int i = 0; i < apuruudukko.length; i++) {
            for (int j = 0; j < apuruudukko[0].length; j++) {
                apuruudukko[i][j] = new Ruutu();
            }
        }

        this.ruudukko = new Ruudukko(apuruudukko);

        this.rivit = new Rivi[vaakarivit.length + pystyrivit.length];

        for (int i = 0; i < vaakarivit.length; i++) {
            String[] palat = vaakarivit[i].split(" ");
            MustaPatka[] patkat = luoPatkat(pystyrivit.length, palat);
            Vaakarivi rivi = new Vaakarivi(i, patkat);
            rivit[i] = rivi;
        }

        for (int i = 0; i < pystyrivit.length; i++) {
            String[] palat = pystyrivit[i].split(" ");
            MustaPatka[] patkat = luoPatkat(vaakarivit.length, palat);
            Pystyrivi rivi = new Pystyrivi(i, patkat);
            rivit[vaakarivit.length + i] = rivi;
        }
    }

    private MustaPatka[] luoPatkat(int rivinPituus, String[] palat) {
        MustaPatka[] patkat;

        if (palat.length == 1 && palat[0].equals("")) {
            patkat = null;
        } else {
            patkat = new MustaPatka[palat.length];
            int k = palat.length;
            int[] lb = new int[palat.length];

            for (int i = 0; i < palat.length; i++) {
                lb[i] = Integer.valueOf(palat[i]);
            }

            // seuraava for-silmukka (O(n2)) on toteutettu artikkelin mukaisella kaavalla
            // pystyisi tehostamaan laskemalla pätkät yhteen ja käyttämällä muuttujia
            // edeltävät pätkät, käsiteltävä pätkä ja seuraavat pätkät (O(n))

            for (int j = 1; j <= k; j++) {
                int alku = 0;

                if (j > 1) {
                    for (int i = 1; i <= (j - 1); i++) {
                        alku += lb[i - 1] + 1;
                    }
                }

                int loppu = rivinPituus - 1;

                if (j < k) {
                    for (int i = (j + 1); i <= k; i++) {
                        loppu -= lb[i - 1] + 1;
                    }
                }

                patkat[j - 1] = new MustaPatka(lb[j - 1], alku, loppu);

            }
        }

        return patkat;
    }

    public Ruutu[][] getRuudukko() {
        return this.ruudukko.getRuudukko();
    }

    public Rivi[] getRivit() {
        return this.rivit;
    }

    // SÄÄNNÖT

    // Osa 1

    /**
     * Toteuttaa säännön 1.1.
     */
    public void saanto11() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] koordinaatit = rivit[i].varmojenMustienKoordinaatit();

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko.getRuudukko()[koordinaatit[j][0]][koordinaatit[j][1]].setMusta();
            }
        }
    }

    /**
     * Toteuttaa säännön 1.2.
     */
    public void saanto12() {
        for (int i = 0; i < rivit.length; i++) {

            int rivinPituus = 0;

            if (rivit[i] instanceof Vaakarivi) {
                rivinPituus = ruudukko.getRuudukko()[0].length;
            } else {
                rivinPituus = ruudukko.getRuudukko().length;
            }

            int[][] koordinaatit = rivit[i].patkienUlkuopuolisetValkoisetKoordinaatit(rivinPituus);

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko.getRuudukko()[koordinaatit[j][0]][koordinaatit[j][1]].setValkoinen();
            }
        }
    }

    /**
     * Toteuttaa säännön 1.3.
     */
    public void saanto13() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] koordinaatit = rivit[i].saanto13valkoistenKoordinaatit(ruudukko.getRuudukko());

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko.getRuudukko()[koordinaatit[j][0]][koordinaatit[j][1]].setValkoinen();
            }
        }
    }

    /**
     * Toteuttaa säännön 1.4.
     */
    public void saanto14() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] koordinaatit = rivit[i]
                    .saanto14valkoistenKoordinaatit(ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko.getRuudukko()[koordinaatit[j][0]][koordinaatit[j][1]].setValkoinen();
            }
        }
    }

    /**
     * Toteuttaa säännön 1.5.
     */
    public void saanto15() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] mustat = rivit[i]
                    .saanto15mustienKoordinaatit(ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));

            if (mustat != null) {
                for (int j = 0; j < mustat.length; j++) {
                    ruudukko.getRuudukko()[mustat[j][0]][mustat[j][1]].setMusta();
                }
            }

            int[][] valkoiset = rivit[i]
                    .saanto15valkoistenKoordinaatit(ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));

            if (valkoiset != null) {
                for (int j = 0; j < valkoiset.length; j++) {
                    ruudukko.getRuudukko()[valkoiset[j][0]][valkoiset[j][1]].setValkoinen();
                }
            }
        }
    }

    // Osa 2

    public void saanto21() {
        for (int i = 0; i < rivit.length; i++) {
            rivit[i].saanto21patkienAlutJaLoput();
        }
    }

    public void saanto22() {
        for (int i = 0; i < rivit.length; i++) {
            rivit[i].saanto22patkienAlutJaLoput(ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));
        }
    }

    public void saanto23() {
        for (int i = 0; i < rivit.length; i++) {
            rivit[i].saanto23ylipitkatSegmentit(ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));
        }
    }

    // Osa 3

    public void saanto31() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] mustat = rivit[i].saanto31pituuksienKorjausJaMustat(
                    ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));

            if (mustat != null) {
                for (int j = 0; j < mustat.length; j++) {
                    if (mustat[j][0] != -1) {
                        ruudukko.getRuudukko()[mustat[j][0]][mustat[j][1]].setMusta();
                    }
                }
            }
        }
    }

    public void saanto32() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] valkoiset = rivit[i].saanto32lyhyetSegmentitJaValkoisetKeskella(
                    ruudukko.getRivi(rivit[i].getRivinumero(), rivit[i].onVaakarivi()));

            if (valkoiset != null) {
                for (int j = 0; j < valkoiset.length; j++) {
                    if (valkoiset[j][0] != -1) {
                        ruudukko.getRuudukko()[valkoiset[j][0]][valkoiset[j][1]].setValkoinen();
                    }
                }
            }
        }
    }
}
