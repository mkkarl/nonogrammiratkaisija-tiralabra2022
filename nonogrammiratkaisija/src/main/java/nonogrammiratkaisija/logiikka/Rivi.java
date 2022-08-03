package nonogrammiratkaisija.logiikka;

public abstract class Rivi {
    private int rivinumero;
    private boolean valmis;
    private MustaPatka[] patkat;

    /**
     * Nonogrammin rivi.
     * 
     * @param rivinumero Rivinumero, numerointi alkaa nollasta
     * @param patkat    Rivin mustat pätkät taulukkona
     */
    public Rivi(int rivinumero, MustaPatka[] patkat) {
        this.rivinumero = rivinumero;
        this.valmis = false;
        this.patkat = patkat;
    }

    
}
