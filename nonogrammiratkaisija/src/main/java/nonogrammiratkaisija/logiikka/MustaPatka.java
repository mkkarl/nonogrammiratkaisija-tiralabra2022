package nonogrammiratkaisija.logiikka;

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
     * @return  {alkupiste, loppupiste}
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
     * @param seuraava  Seuraava musta pätkä (i+1)
     * @return  {alkupiste, loppupiste}
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
     * @param rivinPituus   Rivin pituus
     * @return  {alkupiste, loppupiste}
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
            if (segmentit[i][1] <= this. suurinMahdLoppupiste && segmentit[i][0] >= this.pieninMahdAlkupiste) {
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
            loppu = seuraava.pieninMahdAlkupiste + 1;
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

        this.pieninMahdAlkupiste = m - u;
        this.suurinMahdLoppupiste = n + u;

        int[] alkuLoppu = {m, n};

        return alkuLoppu;
    }
}
