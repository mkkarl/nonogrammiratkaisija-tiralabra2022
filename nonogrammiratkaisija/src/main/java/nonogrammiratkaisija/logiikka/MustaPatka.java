package nonogrammiratkaisija.logiikka;

import java.util.ArrayList;

public class MustaPatka {
    private int pituus;
    private int pieninMahdAlkupiste;
    private int suurinMahdLoppupiste;

    /**
     * Vaaka- tai pystyrivin yksittäinen musta alue.
     * 
     * @param pituus               Mustan pätkän pituus (LB_i)
     * @param pieninMahdAlkupiste  Ensimmäinen mahdollinen alkamispiste (r_js)
     * @param suurinMahdLoppupiste Viimeinen mahdollinen loppumispiste (r_je)
     */
    public MustaPatka(int pituus, int pieninMahdAlkupiste, int suurinMahdLoppupiste) {
        this.pituus = pituus;
        this.pieninMahdAlkupiste = pieninMahdAlkupiste;
        this.suurinMahdLoppupiste = suurinMahdLoppupiste;
    }

    public int getPituus() {
        return this.pituus;
    }

    public int getPieninMahdAlkupiste() {
        return this.pieninMahdAlkupiste;
    }

    public int getSuurinMahdLoppupiste() {
        return this.suurinMahdLoppupiste;
    }

    @Override
    public String toString() {
        return "p: " + this.pituus + ", a: " + this.pieninMahdAlkupiste + ", l: " + this.suurinMahdLoppupiste;
    }

    // SÄÄNNÖT

    // Osa 1

    // Sääntö 1.1

    /**
     * Laskee mustan pätkän varman mustan alueen.
     * 
     * @return Palauttaa varman mustan alueen alku- ja loppupisteen taulukkona. Jos
     *         varmaa aluetta ei ole, palauttaa null.
     */
    public int[] varmaMustaAlkuLoppu() {
        int u = (this.suurinMahdLoppupiste - this.pieninMahdAlkupiste + 1) - this.pituus;
        int alku = this.pieninMahdAlkupiste + u;
        int loppu = this.suurinMahdLoppupiste - u;

        if (alku <= loppu) {
            int[] alkuLoppu = { alku, loppu };
            return alkuLoppu;
        } else {
            return null;
        }
    }

    // Sääntö 1.2

    /**
     * Laskee mustien pätkien ulkopuolelle jäävät valkoiset ruudut.
     * 
     * @param edellinen   Mustaa pätkää edeltävä musta pätkä samalla rivillä. null,
     *                    jos edeltävää ei ole.
     * @param seuraava    Mustaa pätkää seuraava musta pätkä samalla rivillä. null,
     *                    jos seuraavaa ei ole.
     * @param rivinPituus Rivin kokonaispituus.
     * @return Valkoisten alueiden alku- ja loppupisteet. {{alkupiste edellä,
     *         loppupiste edellä}, {alkupiste perässä, loppupiste perässä}}
     */
    public int[] mustanPatkanUlkopuolisetValkoiset(MustaPatka edellinen, MustaPatka seuraava, int rivinPituus) {
        int[] valkoiset = { -1, -1, -1, -1 };

        if (edellinen == null && this.pieninMahdAlkupiste > 0) {
            valkoiset[0] = 0;
            valkoiset[1] = this.pieninMahdAlkupiste - 1;
        }

        if (seuraava == null) {
            if (this.suurinMahdLoppupiste < rivinPituus - 1) {
                valkoiset[2] = this.suurinMahdLoppupiste + 1;
                valkoiset[3] = rivinPituus - 1;
            }
        } else {
            if (this.suurinMahdLoppupiste < seuraava.getPieninMahdAlkupiste() - 1) {
                valkoiset[2] = this.suurinMahdLoppupiste + 1;
                valkoiset[3] = seuraava.getPieninMahdAlkupiste() - 1;
            }
        }

        return valkoiset;
    }

    /**
     * Laskee rivin alussa olevat valkoiset ruudut.
     * 
     * @return {alkupiste, loppupiste}
     */
    public int[] valkoisetRivinAlussa() {
        int[] valkoiset = { -1, -1 };

        if (this.pieninMahdAlkupiste > 0) {
            valkoiset[0] = 0;
            valkoiset[1] = this.pieninMahdAlkupiste - 1;
        }

        return valkoiset;
    }

    /**
     * Laskee mustan pätkän ja seuraavan pätkän väliin jäävät valkoiset ruudut.
     * 
     * @param seuraava Seuraava musta pätkä (i+1)
     * @return {alkupiste, loppupiste}
     */
    public int[] valkoisetPatkienValissa(MustaPatka seuraava) {
        int[] valkoiset = { -1, -1 };

        if (this.suurinMahdLoppupiste < seuraava.getPieninMahdAlkupiste() - 1) {
            valkoiset[0] = this.suurinMahdLoppupiste + 1;
            valkoiset[1] = seuraava.getPieninMahdAlkupiste() - 1;
        }

        return valkoiset;
    }

    /**
     * Laskee rivin lopussa olevat valkoiset ruudut.
     * 
     * @param rivinPituus Rivin pituus
     * @return {alkupiste, loppupiste}
     */
    public int[] valkoisetRivinLopussa(int rivinPituus) {
        int[] valkoiset = { -1, -1 };

        if (this.suurinMahdLoppupiste < rivinPituus - 1) {
            valkoiset[0] = this.suurinMahdLoppupiste + 1;
            valkoiset[1] = rivinPituus - 1;
        }

        return valkoiset;
    }

    // Osa 2

    // Sääntö 2.1

    public void saanto21patkanAlku(MustaPatka edellinen) {
        if (this.pieninMahdAlkupiste <= edellinen.pieninMahdAlkupiste) {
            this.pieninMahdAlkupiste = edellinen.pieninMahdAlkupiste + edellinen.pituus + 1;
        }
    }

    public void saanto21patkanLoppu(MustaPatka seuraava) {
        if (this.suurinMahdLoppupiste >= seuraava.suurinMahdLoppupiste) {
            this.suurinMahdLoppupiste = seuraava.suurinMahdLoppupiste - seuraava.pituus - 1;
        }
    }

    // Sääntö 2.2

    public boolean saanto22patkanAlku(Ruutu edeltava) {
        if (edeltava.getTila() == RuudunTila.MUSTA) {
            this.pieninMahdAlkupiste += 1;
            return true;
        }

        return false;
    }

    public boolean saanto22patkanLoppu(Ruutu jalkeinen) {
        if (jalkeinen.getTila() == RuudunTila.MUSTA) {
            this.suurinMahdLoppupiste -= 1;
            return true;
        }

        return false;
    }

    // Sääntö 2.3

    public void saanto23segmentitAlussa(int[][] segmentit) {
        for (int i = 0; i < segmentit.length; i++) {
            if (segmentit[i][0] >= this.pieninMahdAlkupiste && segmentit[i][1] <= this.suurinMahdLoppupiste) {
                if (segmentit[i][1] - segmentit[i][0] + 1 > this.pituus) {
                    this.pieninMahdAlkupiste = segmentit[i][1] + 2;
                } else {
                    return;
                }
            } else {
                break;
            }
        }
    }

    public void saanto23segmentitLopussa(int[][] segmentit) {
        for (int i = segmentit.length - 1; i >= 0; i--) {
            if (segmentit[i][1] <= this.suurinMahdLoppupiste && segmentit[i][0] >= this.pieninMahdAlkupiste) {
                if (segmentit[i][1] - segmentit[i][0] + 1 > this.pituus) {
                    this.suurinMahdLoppupiste = segmentit[i][0] - 2;
                } else {
                    return;
                }
            } else {
                break;
            }
        }
    }

    // Osa 3

    // Sääntö 3.1

    public int[] saanto31mustienTaytto(MustaPatka edellinen, MustaPatka seuraava, Ruutu[] ruudukonRivi) {
        int alku = -1;

        if (edellinen == null) {
            alku = this.pieninMahdAlkupiste;
        } else {
            alku = edellinen.suurinMahdLoppupiste + 1;
        }

        int m = -1;

        for (int i = alku; i <= this.suurinMahdLoppupiste; i++) {
            if (ruudukonRivi[i].getTila() == RuudunTila.MUSTA) {
                m = i;
                break;
            }
        }

        if (m == -1) {
            return null;
        }

        int loppu = -1;

        if (seuraava == null) {
            loppu = this.suurinMahdLoppupiste;
        } else {
            loppu = seuraava.pieninMahdAlkupiste - 1;
        }

        int n = -1;

        for (int i = loppu; i >= m; i--) {
            if (ruudukonRivi[i].getTila() == RuudunTila.MUSTA) {
                n = i;
                break;
            }
        }

        if (n == -1) {
            return null;
        }

        int u = this.pituus - (n - m + 1);

        if (m - u <= n + u) {
            this.pieninMahdAlkupiste = m - u;
            this.suurinMahdLoppupiste = n + u;

            int[] alkuLoppu = { m, n };

            return alkuLoppu;
        }

        return null;
    }

    public int[][] saanto32liianLyhyetValit(Ruutu[] ruudukonRivi, MustaPatka edellinen, MustaPatka seuraava) {
        if (this.suurinMahdLoppupiste - this.pieninMahdAlkupiste + 1 == this.pituus || this.pituus == 1) {
            return null;
        }

        // määritetään valkoisten väliin jäävät segmentit (voivat olla mustia tai
        // tuntemattomia)
        int[][] segmentit = new int[(this.suurinMahdLoppupiste - this.pieninMahdAlkupiste + 1) / 2][2];
        int segAlku = this.pieninMahdAlkupiste;
        int k = 0;

        for (int i = this.pieninMahdAlkupiste; i <= this.suurinMahdLoppupiste; i++) {
            if (ruudukonRivi[i].getTila() == RuudunTila.VALKOINEN) {
                if (segAlku != -1 && i != this.pieninMahdAlkupiste) {
                    segmentit[k][0] = segAlku;
                    segmentit[k][1] = i - 1;
                    k++;
                }

                segAlku = -1;
            } else if (segAlku == -1) {
                segAlku = i;
            }
        }

        // nyt k = b - 1 säännössä

        // askeleet 1-2

        int ekaSegmentti = -1;

        for (int i = 0; i <= k; i++) {
            if (segmentit[i][1] - segmentit[i][0] + 1 >= this.pituus) {
                this.pieninMahdAlkupiste = segmentit[i][0];
                ekaSegmentti = i; // ensimmäinen tarpeeksi pitkä segmentti
                break;
            }
        }

        // askeleet 3-4

        int vikaSegmentti = -1;

        for (int i = k; i >= 0; i--) {
            if (segmentit[i][1] - segmentit[i][0] + 1 >= this.pituus) {
                this.suurinMahdLoppupiste = segmentit[i][1];
                vikaSegmentti = i; // viimeinen tarpeeksi pitkä segmentti
                break;
            }
        }

        // askel 5

        ArrayList<int[]> alutLoput = new ArrayList<>();

        if (ekaSegmentti < vikaSegmentti + 1) {
            for (int i = ekaSegmentti + 1; i < vikaSegmentti; i++) {
                boolean eiEdellisenPaalla = (edellinen == null || segmentit[i][0] > edellinen.suurinMahdLoppupiste);
                boolean eiSeuraavanPaalla = (seuraava == null || segmentit[i][1] < seuraava.pieninMahdAlkupiste);
                if (segmentit[i][1] - segmentit[i][0] + 1 < this.pituus && eiEdellisenPaalla && eiSeuraavanPaalla) {
                    int[] alkuLoppu = { segmentit[i][0], segmentit[i][1] };
                    alutLoput.add(alkuLoppu);
                }
            }
        }

        if (alutLoput.size() > 0) {
            int[][] valkoiset = new int[alutLoput.size()][3];
            for (int i = 0; i < alutLoput.size(); i++) {
                valkoiset[i][0] = alutLoput.get(i)[0];
                valkoiset[i][1] = alutLoput.get(i)[1];
                valkoiset[i][2] = valkoiset[i][1] - valkoiset[i][0] + 1;
            }

            return valkoiset;
        }

        return null;
    }

    // Sääntö 3.3-1

    /**
     * Toteuttaa säännön 3.3-1 mustalle pätkälle vasempaan päähän.
     * Tee vain pätkälle, jonka edellä ei ole pätkää tai edeltävä pätkä ei ole
     * päälekkäinen,
     * ja jonka pienin mahdollinen alkupiste on musta.
     */
    public Ruutu[] saanto331vasenPaa(Ruutu[] ruudukonRivi, MustaPatka edellinen, MustaPatka seuraava) {

        // kohta 1

        for (int i = this.pieninMahdAlkupiste; i <= this.pieninMahdAlkupiste + this.pituus - 1; i++) {
            ruudukonRivi[i].setMusta();
        }

        if (this.pieninMahdAlkupiste > 0) {
            ruudukonRivi[this.pieninMahdAlkupiste - 1].setValkoinen();
        }
        if (this.pieninMahdAlkupiste + this.pituus < ruudukonRivi.length) {
            ruudukonRivi[this.pieninMahdAlkupiste + this.pituus].setValkoinen();
        }
        

        // kohta 2

        this.suurinMahdLoppupiste = this.pieninMahdAlkupiste + this.pituus - 1;

        // kohta 3

        if (seuraava != null && this.suurinMahdLoppupiste >= seuraava.pieninMahdAlkupiste) {
            seuraava.pieninMahdAlkupiste = this.suurinMahdLoppupiste + 2;
        }

        // kohta 4

        if (edellinen != null && edellinen.suurinMahdLoppupiste == this.pieninMahdAlkupiste - 1) {
            edellinen.suurinMahdLoppupiste = this.pieninMahdAlkupiste - 2;
        }

        return ruudukonRivi;
    }

    /**
     * Toteuttaa säännön 3.3-1 mustalle pätkälle oikeaan päähän.
     * Tee vain pätkälle, jonka jäljessä ei ole pätkää tai seuraava pätkä ei ole
     * päälekkäinen,
     * ja jonka suurin mahdollinen loppupiste on musta.
     */
    public Ruutu[] saanto331oikeaPaa(Ruutu[] ruudukonRivi, MustaPatka edellinen, MustaPatka seuraava) {

        // kohta 1

        for (int i = this.suurinMahdLoppupiste; i >= this.suurinMahdLoppupiste - this.pituus + 1; i--) {
            ruudukonRivi[i].setMusta();
        }

        if (this.suurinMahdLoppupiste + 1 < ruudukonRivi.length) {
            ruudukonRivi[this.suurinMahdLoppupiste + 1].setValkoinen();
        }
        if (this.suurinMahdLoppupiste - this.pituus >= 0) {
            ruudukonRivi[this.suurinMahdLoppupiste - this.pituus].setValkoinen();
        }
        

        // kohta 2

        this.pieninMahdAlkupiste = this.suurinMahdLoppupiste - this.pituus + 1;

        // kohta 3

        if (edellinen != null && this.pieninMahdAlkupiste <= edellinen.suurinMahdLoppupiste) {
            edellinen.suurinMahdLoppupiste = this.pieninMahdAlkupiste - 2;
        }

        // kohta 4

        if (seuraava != null && seuraava.pieninMahdAlkupiste == this.suurinMahdLoppupiste + 1) {
            seuraava.pieninMahdAlkupiste = this.suurinMahdLoppupiste + 2;
        }

        return ruudukonRivi;
    }

    /**
     * Toteuttaa säännön 3.3-2 mustalle pätkälle vasempaan päähän.
     * Tee vain pätkälle, jonka edellä ei ole pätkää tai edeltävä pätkä ei ole
     * päälekkäinen,
     * ja jonka pienin mahdollinen alkupiste on muu kuin musta musta.
     */
    public void saanto332vasenPaa(Ruutu[] ruudukonRivi) {
        boolean mustaLoytynyt = false;

        for (int i = this.pieninMahdAlkupiste; i <= this.suurinMahdLoppupiste; i++) {
            if (!mustaLoytynyt && ruudukonRivi[i].getTila() == RuudunTila.MUSTA) {
                mustaLoytynyt = true;
            } else if (mustaLoytynyt && ruudukonRivi[i].getTila() == RuudunTila.VALKOINEN) {
                this.suurinMahdLoppupiste = i - 1;
            }
        }
    }

    /**
     * Toteuttaa säännön 3.3-2 mustalle pätkälle oikeaan päähän.
     * Tee vain pätkälle, jonka jäljessä ei ole pätkää tai seuraava pätkä ei ole
     * päälekkäinen,
     * ja jonka suurin mahdollinen loppupiste on muu kuin musta.
     */
    public void saanto332oikeaPaa(Ruutu[] ruudukonRivi) {
        boolean mustaLoytynyt = false;

        for (int i = this.suurinMahdLoppupiste; i >= this.pieninMahdAlkupiste; i--) {
            if (!mustaLoytynyt && ruudukonRivi[i].getTila() == RuudunTila.MUSTA) {
                mustaLoytynyt = true;
            } else if (mustaLoytynyt && ruudukonRivi[i].getTila() == RuudunTila.VALKOINEN) {
                this.pieninMahdAlkupiste = i + 1;
            }
        }
    }

    public void saanto333vasenPaa(int[][] segmentit) {
        int segmenttienLkm = 0;
        int i = -1;

        for (int k = 0; k < segmentit.length; k++) {
            if (segmentit[k][0] >= this.pieninMahdAlkupiste && segmentit[k][1] <= this.suurinMahdLoppupiste) {
                if (segmenttienLkm == 0) {
                    i = k; // aske 1
                }

                segmenttienLkm++;
            } else if (segmentit[k][1] > this.suurinMahdLoppupiste) {
                break;
            }
        }

        if (segmenttienLkm > 1) {
            int s = segmentit[i][0]; // askel 2
            int m = i + 1; // askel 3

            // askel 4
            while (m < i + segmenttienLkm) {
                int t = segmentit[m][0];
                int e = segmentit[m][1];

                if (e - s + 1 > this.pituus) {
                    this.suurinMahdLoppupiste = t - 2;
                    return;
                } else {
                    m++;
                }
            }
        }
    }

    public void saanto333oikeaPaa(int[][] segmentit) {
        int segmenttienLkm = 0;
        int i = -1;

        for (int k = segmentit.length - 1; k >= 0; k--) {
            if (segmentit[k][0] >= this.pieninMahdAlkupiste && segmentit[k][1] <= this.suurinMahdLoppupiste) {
                if (segmenttienLkm == 0) {
                    i = k; // aske 1
                }

                segmenttienLkm++;
            } else if (segmentit[k][0] < this.pieninMahdAlkupiste) {
                break;
            }
        }

        if (segmenttienLkm > 1) {
            int e = segmentit[i][1]; // askel 2
            int m = i - 1; // askel 3

            // askel 4
            while (m > i - segmenttienLkm) {
                int t = segmentit[m][1];
                int s = segmentit[m][0];

                if (e - s + 1 > this.pituus) {
                    this.pieninMahdAlkupiste = t + 2;
                    return;
                } else {
                    m--;
                }
            }
        }
    }
}
