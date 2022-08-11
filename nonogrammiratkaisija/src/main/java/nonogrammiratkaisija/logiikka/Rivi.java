package nonogrammiratkaisija.logiikka;

public abstract class Rivi {
    private int rivinumero;
    private boolean valmis;
    private MustaPatka[] patkat;

    /**
     * Nonogrammin rivi.
     * 
     * @param rivinumero Rivinumero, numerointi alkaa nollasta
     * @param patkat     Rivin mustat pätkät taulukkona
     */
    public Rivi(int rivinumero, MustaPatka[] patkat) {
        this.rivinumero = rivinumero;
        this.valmis = false;
        this.patkat = patkat;
    }

    public int getRivinumero() {
        return this.rivinumero;
    }

    public boolean getValmis() {
        return this.valmis;
    }

    public MustaPatka[] getPatkat() {
        return this.patkat;
    }

    // SÄÄNNÖT

    // Osa 1

    // Sääntö 1.1

    /**
     * Laskee rivillä olevien mustien pätkien varmojen mustien koordinaatit.
     * 
     * @return [vaakarivi, pystyrivi]
     */
    public int[][] varmojenMustienKoordinaatit() {
        if (this.patkat == null) {
            return null;
        }

        int[][] valit = new int[this.patkat.length][3];

        for (int i = 0; i < this.patkat.length; i++) {
            int[] varmat = this.patkat[i].varmaMustaAlkuLoppu();

            if (varmat == null) {
                valit[i][0] = -1;
                valit[i][1] = -1;
                valit[i][2] = 0;
            } else {
                valit[i][0] = varmat[0];
                valit[i][1] = varmat[1];
                valit[i][2] = varmat[1] - varmat[0] + 1;
            }
        }

        int[][] koordinaatit = this.koordinaattilaskuri(valit);

        return koordinaatit;
    }



    // Sääntö 1.2

    /**
     * Laskee mustien pätkien ulkopuolelle jäävien valkoisten ruutujen koordinaatit.
     * 
     * @param rivinPituus Nonogrammin leveys (vaakarivi) tai korkeus (pystyrivi)
     * @return Valkoisten ruutujen koordinaatit {x, y} kaksiulotteisena taulukkona
     */
    public int[][] patkienUlkuopuolisetValkoisetKoordinaatit(int rivinPituus) {

        int[][] valit = new int[1][3];

        if (this.patkat == null) { // kokonaan valkoista riviä ei ehkä ole suoraan säännöissä mainittu, joten
                                   // lisätään se tähän yhteyteen
            valit[0][0] = 0;
            valit[0][1] = rivinPituus - 1;
            valit[0][2] = rivinPituus;
            this.valmis = true;
        } else {

            valit = new int[this.patkat.length + 1][3];

            for (int i = 0; i < this.patkat.length; i++) {
                if (i == 0) {
                    int[] valkoiset = this.patkat[i].valkoisetRivinAlussa();

                    valit[i][0] = valkoiset[0];
                    valit[i][1] = valkoiset[1];
                    if (valkoiset[0] == -1) {
                        valit[i][2] = 0;
                    } else {
                        valit[i][2] = valkoiset[1] - valkoiset[0] + 1;
                    }
                }

                int[] valkoiset = new int[2];

                if (i < this.patkat.length - 1) {
                    valkoiset = this.patkat[i].valkoisetPatkienValissa(this.patkat[i + 1]);
                } else {
                    valkoiset = this.patkat[i].valkoisetRivinLopussa(rivinPituus);
                }

                valit[i + 1][0] = valkoiset[0];
                valit[i + 1][1] = valkoiset[1];
                if (valkoiset[0] == -1) {
                    valit[i + 1][2] = 0;
                } else {
                    valit[i + 1][2] = valkoiset[1] - valkoiset[0] + 1;
                }
            }
        }

        int[][] koordinaatit = this.koordinaattilaskuri(valit);

        return koordinaatit;
    }

    // apumetodeja

    protected abstract int[][] koordinaattilaskuri(int[][] alutLoputPituudet);

}
