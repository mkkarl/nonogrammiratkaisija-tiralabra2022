package nonogrammiratkaisija.logiikka;

public class Ruudukko {
    Ruutu[][] ruudukko;

    /**
     * Luo kaksiulotteisesta Ruutu-taulukosta oman olion.
     * 
     * @param ruudukko  Ruudut kaksiulotteisena taulukkona.
     */
    public Ruudukko(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    /**
     * Palauttaa ruudukon ruudun.
     * 
     * @param x Vaakarivin rivinumero (0...m-1)
     * @param y Pystyrivin rivinumero (0...n-1)
     * @return Ruutu (x,y)
     */
    public Ruutu getRuutu(int x, int y) {
        return ruudukko[x][y];
    }

    /**
     * Palauttaa rivillä olevat ruudut taulukkona.
     * 
     * @param rivinumero    Rivin järjestysnumero (0...n-1)
     * @param vaakarivi Vaakarivi 'True', Pystyrivi 'false'
     * @return  Ruudut taulukkona
     */
    public Ruutu[] getRivi(int rivinumero, boolean vaakarivi) {
        Ruutu[] rivi = new Ruutu[1];

        if (vaakarivi) {
            rivi = new Ruutu[ruudukko[0].length];

            for (int i = 0; i < ruudukko[0].length; i++) {
                rivi[i] = ruudukko[rivinumero][i];
            }
        } else {
            rivi = new Ruutu[ruudukko.length];

            for (int i = 0; i < ruudukko.length; i++) {
                rivi[i] = ruudukko[i][rivinumero];
            }
        }

        return rivi;
    }

    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
}
