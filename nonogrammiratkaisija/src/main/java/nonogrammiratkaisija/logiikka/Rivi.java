package nonogrammiratkaisija.logiikka;

import java.util.ArrayList;

public abstract class Rivi {
    private int rivinumero;
    private boolean valmis;
    private MustaPatka[] patkat;
    private boolean onVaakarivi;

    /**
     * Nonogrammin rivi.
     * 
     * @param rivinumero Rivinumero, numerointi alkaa nollasta
     * @param patkat     Rivin mustat pätkät taulukkona
     */
    public Rivi(int rivinumero, MustaPatka[] patkat, boolean onVaakarivi) {
        this.rivinumero = rivinumero;
        this.valmis = false;
        this.patkat = patkat;
        this.onVaakarivi = onVaakarivi;
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

    public boolean onVaakarivi() {
        return this.onVaakarivi;
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

    // Sääntö 1.3

    /**
     * Laskee säännön 1.3 mukaisten valkoisten ruutujen koordinaatit rivillä.
     * 
     * @param ruudukko Nonogrammin ruudut
     * @return Valkoisten ruutujen koordinaatit {x, y}
     */
    public int[][] saanto13valkoistenKoordinaatit(Ruutu[][] ruudukko) {

        if (this.patkat == null) {
            return null;
        }

        ArrayList<Integer> indeksit = new ArrayList<>();

        for (int j = 0; j < this.patkat.length; j++) {
            int[] alkupiste = this.ruudunKoordinaatit(this.patkat[j].getPieninMahdAlkupiste());
            int[] loppupiste = this.ruudunKoordinaatit(this.patkat[j].getSuurinMahdLoppupiste());

            if (ruudukko[alkupiste[0]][alkupiste[1]].getTila() == RuudunTila.MUSTA && j != 0) {
                boolean eteenValkoinen = true;

                for (int i = 0; i < j; i++) {
                    if (patkat[i].getSuurinMahdLoppupiste() >= patkat[j].getPieninMahdAlkupiste()) {
                        if (patkat[i].getPituus() != 1) {
                            eteenValkoinen = false;
                        }
                    }
                }

                if (eteenValkoinen) {
                    indeksit.add(this.patkat[j].getPieninMahdAlkupiste() - 1);
                }
            }

            if (ruudukko[loppupiste[0]][loppupiste[1]].getTila() == RuudunTila.MUSTA && j != this.patkat.length - 1) {
                boolean peraanValkoinen = true;

                for (int i = j + 1; i < this.patkat.length; i++) {
                    if (patkat[i].getPieninMahdAlkupiste() <= patkat[j].getSuurinMahdLoppupiste()) {
                        if (patkat[i].getPituus() != 1) {
                            peraanValkoinen = false;
                        }
                    }
                }

                if (peraanValkoinen && !indeksit.contains(this.patkat[j].getSuurinMahdLoppupiste() + 1)) {
                    indeksit.add(this.patkat[j].getSuurinMahdLoppupiste() + 1);
                }
            }
        }

        if (indeksit.size() == 0) {
            return null;
        }

        int[][] koordinaatit = new int[indeksit.size()][2];

        for (int i = 0; i < indeksit.size(); i++) {
            int[] rk = this.ruudunKoordinaatit(indeksit.get(i));
            koordinaatit[i][0] = rk[0];
            koordinaatit[i][1] = rk[1];
        }

        return koordinaatit;
    }

    // Sääntö 1.4

    public int[][] saanto14valkoistenKoordinaatit(Ruutu[] ruudukonrivi) {
        if (this.patkat == null) {
            return null;
        }

        int mustatPituus1 = 0;

        ArrayList<Integer> indeksit = new ArrayList<>();

        for (int i = 0; i < ruudukonrivi.length - 1; i++) {
            if (ruudukonrivi[i].getTila() == RuudunTila.MUSTA) {
                mustatPituus1++;
            } else if (i > 0) {
                if (ruudukonrivi[i].getTila() == RuudunTila.VALKOINEN) {
                    mustatPituus1 = 0;
                } else if (ruudukonrivi[i].getTila() == RuudunTila.TUNTEMATON && mustatPituus1 > 0) {
                    int mustatPituus2 = 0;
                    for (int j = i + 1; j < ruudukonrivi.length; j++) {

                        if (ruudukonrivi[j].getTila() == RuudunTila.MUSTA) {
                            mustatPituus2++;
                        }

                        if (ruudukonrivi[j].getTila() == RuudunTila.VALKOINEN
                                || ruudukonrivi[j].getTila() == RuudunTila.TUNTEMATON || j == ruudukonrivi.length - 1) {
                            if (mustatPituus2 > 0) {
                                int yhteisPituus = mustatPituus1 + mustatPituus2 + 1;
                                int pisin = 0;

                                for (int k = 0; k < this.patkat.length; k++) {
                                    if (this.patkat[k].getPieninMahdAlkupiste() <= i - 1
                                            && this.patkat[k].getSuurinMahdLoppupiste() >= i + 1) {
                                        if (pisin < this.patkat[k].getPituus()) {
                                            pisin = this.patkat[k].getPituus();
                                        }
                                    }
                                }

                                if (pisin < yhteisPituus) {
                                    indeksit.add(i);
                                }
                            }
                            mustatPituus1 = 0;
                            break;
                        }
                    }
                }
            }
        }

        if (indeksit.size() == 0) {
            return null;
        }

        int[][] koordinaatit = new int[indeksit.size()][2];

        for (int i = 0; i < indeksit.size(); i++) {
            int[] rk = this.ruudunKoordinaatit(indeksit.get(i));
            koordinaatit[i][0] = rk[0];
            koordinaatit[i][1] = rk[1];
        }

        return koordinaatit;
    }

    // Sääntö 1.5

    public int[][] saanto15mustienKoordinaatit(Ruutu[] ruudukonRivi) {
        if (this.patkat == null) {
            return null;
        }

        ArrayList<Integer> indeksit = new ArrayList<>();

        for (int i = 1; i < ruudukonRivi.length; i++) {
            if (ruudukonRivi[i].getTila() == RuudunTila.MUSTA && (ruudukonRivi[i - 1].getTila() == RuudunTila.VALKOINEN
                    || ruudukonRivi[i - 1].getTila() == RuudunTila.TUNTEMATON)) {
                // 1.
                int lyhin = ruudukonRivi.length; // min L

                for (int j = 0; j < this.patkat.length; j++) {
                    if (this.patkat[j].getPieninMahdAlkupiste() <= i && this.patkat[j].getSuurinMahdLoppupiste() >= i) {
                        if (lyhin > this.patkat[j].getPituus()) {
                            lyhin = this.patkat[j].getPituus();
                        }
                    }
                }

                // 2.
                int m = -1;

                int alaraja = Math.max(i - lyhin + 1, 0);

                for (int k = i - 1; k >= alaraja; k--) {
                    if (ruudukonRivi[k].getTila() == RuudunTila.VALKOINEN) {
                        m = k;
                        break;
                    }
                }

                if (m != -1) {
                    for (int p = i + 1; p <= m + lyhin; p++) {
                        if (!indeksit.contains(p)) {
                            indeksit.add(p);
                        }
                    }
                }

                // 3.
                int n = -1;

                int ylaraja = Math.min(i + lyhin, ruudukonRivi.length);

                for (int k = i + 1; k < ylaraja; k++) {
                    if (ruudukonRivi[k].getTila() == RuudunTila.VALKOINEN) {
                        n = k;
                        break;
                    }
                }

                if (n != -1) {
                    for (int p = n - lyhin; p <= i - 1; p++) {
                        if (!indeksit.contains(p)) {
                            indeksit.add(p);
                        }
                    }
                }

            }
        }

        if (indeksit.size() == 0) {
            return null;
        }

        int[][] koordinaatit = new int[indeksit.size()][2];

        for (int i = 0; i < indeksit.size(); i++) {
            int[] rk = this.ruudunKoordinaatit(indeksit.get(i));
            koordinaatit[i][0] = rk[0];
            koordinaatit[i][1] = rk[1];
        }

        return koordinaatit;
    }

    public int[][] saanto15valkoistenKoordinaatit(Ruutu[] ruudukonRivi) {
        if (this.patkat == null) {
            return null;
        }

        ArrayList<Integer> indeksit = new ArrayList<>();

        for (int i = 1; i < ruudukonRivi.length; i++) {
            if (ruudukonRivi[i].getTila() == RuudunTila.MUSTA && (ruudukonRivi[i - 1].getTila() == RuudunTila.VALKOINEN
                    || ruudukonRivi[i - 1].getTila() == RuudunTila.TUNTEMATON)) {

                // 4.
                boolean samanPituiset = true;
                int vertausPituus = 0;

                for (int j = 0; j < this.patkat.length; j++) {
                    if (this.patkat[j].getPieninMahdAlkupiste() <= i && this.patkat[j].getSuurinMahdLoppupiste() >= i) {
                        if (vertausPituus == 0) {
                            vertausPituus = this.patkat[j].getPituus();
                        } else if (this.patkat[j].getPituus() != vertausPituus) {
                            samanPituiset = false;
                            break;
                        }
                    }
                }

                if (samanPituiset) {
                    int s = -1;
                    int e = -1;

                    for (int k = i - 1; k >= 0; k--) {
                        if (ruudukonRivi[k].getTila() == RuudunTila.VALKOINEN
                                || ruudukonRivi[k].getTila() == RuudunTila.TUNTEMATON) {
                            s = k + 1;
                            break;
                        } else if (k == 0) {
                            s = k;
                        }
                    }

                    for (int k = i + 1; k < ruudukonRivi.length; k++) {
                        if (ruudukonRivi[k].getTila() == RuudunTila.VALKOINEN
                                || ruudukonRivi[k].getTila() == RuudunTila.TUNTEMATON) {
                            e = k - 1;
                            break;
                        } else if (k == ruudukonRivi.length - 1) {
                            e = k;
                        }
                    }

                    if (vertausPituus == e - s + 1) {
                        if (s > 0 && !indeksit.contains(s - 1)) {
                            indeksit.add(s - 1);
                        }

                        if (e < ruudukonRivi.length - 1 && !indeksit.contains(e + 1)) {
                            indeksit.add(e + 1);
                        }
                    }
                }
            }
        }

        if (indeksit.size() == 0) {
            return null;
        }

        int[][] koordinaatit = new int[indeksit.size()][2];

        for (int i = 0; i < indeksit.size(); i++) {
            int[] rk = this.ruudunKoordinaatit(indeksit.get(i));
            koordinaatit[i][0] = rk[0];
            koordinaatit[i][1] = rk[1];
        }

        return koordinaatit;
    }

    // apumetodeja

    protected abstract int[][] koordinaattilaskuri(int[][] alutLoputPituudet);

    protected abstract int[] ruudunKoordinaatit(int indeksi);

}
