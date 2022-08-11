package nonogrammiratkaisija.logiikka;

public class Nonogrammi {
    private Ruutu[][] ruudukko;
    private Rivi[] rivit;

    /**
     * Nonogrammi, joka koostuu riveistä ja ruuduista.
     * 
     * @param vaakarivit    Nonogrammin vaakarivien numerot vasemmalta oikealle ja ylhäältä alas taulukkona
     * @param pystyrivit    Nonogrammin pystyrivien numerot ylhäältä alas ja vasemmalta oikealle taulukkona
     */
    public Nonogrammi(String[] vaakarivit, String[] pystyrivit) {
        this.ruudukko = new Ruutu[vaakarivit.length][pystyrivit.length];

        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }

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
        return this.ruudukko;
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
                ruudukko[koordinaatit[j][0]][koordinaatit[j][1]].setMusta();
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
                rivinPituus = ruudukko[0].length;
            } else {
                rivinPituus = ruudukko.length;
            }

            int[][] koordinaatit = rivit[i].patkienUlkuopuolisetValkoisetKoordinaatit(rivinPituus);

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko[koordinaatit[j][0]][koordinaatit[j][1]].setValkoinen();
            }
        }
    }

    /**
     * Toteuttaa säännön 1.3
     */
    public void saanto13() {
        for (int i = 0; i < rivit.length; i++) {
            int[][] koordinaatit = rivit[i].saanto13valkoistenKoordinaatit(ruudukko);

            if (koordinaatit == null) {
                continue;
            }

            for (int j = 0; j < koordinaatit.length; j++) {
                ruudukko[koordinaatit[j][0]][koordinaatit[j][1]].setValkoinen();
            }
        }
    }
}
