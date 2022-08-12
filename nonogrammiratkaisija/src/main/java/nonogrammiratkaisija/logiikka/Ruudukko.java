package nonogrammiratkaisija.logiikka;

public class Ruudukko {
    Ruutu[][] ruudukko;

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
