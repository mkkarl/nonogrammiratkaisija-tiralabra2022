package nonogrammiratkaisija.logiikka;

public class MustaPatka {
    private int pituus;
    private int pieninMahdAlkupiste;
    private int suurinMahdLoppupiste;

    /**
     * Vaaka- tai pystyrivin yksittäinen musta alue.
     * 
     * @param pituus    Mustan pätkän pituus
     * @param pieninMahdAlkupiste   Ensimmäinen mahdollinen alkamispiste
     * @param suurinMahdLoppupiste  Viimeinen mahdollinen loppumispiste
     */
    public MustaPatka(int pituus, int pieninMahdAlkupiste, int suurinMahdLoppupiste) {
        this.pituus = pituus;
        this.pieninMahdAlkupiste = pieninMahdAlkupiste;
        this.suurinMahdLoppupiste = suurinMahdLoppupiste;
    }
}
