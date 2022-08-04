package nonogrammiratkaisija.logiikka;

public class Ruutu {
    private RuudunTila tila;

    /**
     * Ruutu nonogrammiruudukossa.
     */
    public Ruutu() {
        this.tila = RuudunTila.TUNTEMATON;
    }

    public RuudunTila getTila() {
        return this.tila;
    }
}
