package nonogrammiratkaisija.logiikka;

public class MustaPatka {
    private int pituus;
    private int pieninMahdAlkupiste;
    private int suurinMahdLoppupiste;

    /**
     * Vaaka- tai pystyrivin yksittäinen musta alue.
     * 
     * @param pituus    Mustan pätkän pituus (LB_i)
     * @param pieninMahdAlkupiste   Ensimmäinen mahdollinen alkamispiste (r_js)
     * @param suurinMahdLoppupiste  Viimeinen mahdollinen loppumispiste (r_je)
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

    //SÄÄNNÖT

    // Osa 1

    // Sääntö 1.1

    /**
     * Laskee mustan pätkän varman mustan alueen.
     * 
     * @return  Palauttaa varman mustan alueen alku- ja loppupisteen taulukkona. Jos varmaa aluetta ei ole, palauttaa null.
     */
    public int[] varmaMustaAlkuLoppu() {
        int u = (this.suurinMahdLoppupiste - this.pieninMahdAlkupiste + 1) - this.pituus;
        int alku = this.pieninMahdAlkupiste + u;
        int loppu = this.suurinMahdLoppupiste - u;

        if (alku <= loppu) {
            int[] alkuLoppu = {alku, loppu};
            return alkuLoppu;
        } else {
            return null;
        }
    }
}
