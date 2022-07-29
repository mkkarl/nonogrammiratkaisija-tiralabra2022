package nonogrammiratkaisija.logiikka;

public abstract class Rivi {
    private int rivinumero;
    private boolean valmis;

    public Rivi(int rivinumero) {
        this.rivinumero = rivinumero;
        this.valmis = false;
    }

    
}
