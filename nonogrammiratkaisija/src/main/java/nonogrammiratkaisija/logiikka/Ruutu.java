package nonogrammiratkaisija.logiikka;

public class Ruutu implements Comparable<Ruutu> {
    private RuudunTila tila;

    /**
     * Ruutu nonogrammiruudukossa.
     */
    public Ruutu() {
        this.tila = RuudunTila.TUNTEMATON;
    }

    /**
     * Muuttaa ruudun valkoiseksi, jos se on tuntematon tai valkoinen. Mustan ruudun muuttaa virheeksi.
     */
    public void setValkoinen() {
        if (this.tila == RuudunTila.VALKOINEN) {
            return;
        } else if (this.tila == RuudunTila.TUNTEMATON) {
            this.tila = RuudunTila.VALKOINEN;
        } else {
            this.tila = RuudunTila.VIRHE;
        }
    }

    /**
     * Muuttaa ruudun mustaksi, jos se on tuntematon tai musta. Valkoisen ruudun muuttaa virheeksi.
     */
    public void setMusta() {
        if (this.tila == RuudunTila.MUSTA) {
            return;
        } else if (this.tila == RuudunTila.TUNTEMATON) {
            this.tila = RuudunTila.MUSTA;
        } else {
            this.tila = RuudunTila.VIRHE;
        }
    }

    public RuudunTila getTila() {
        return this.tila;
    }

    @Override
    public int compareTo(Ruutu ruutu) {
        if (this.tila == ruutu.tila) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object verrattava) {
        if (this == verrattava) {
            return true;
        }

        if (!(verrattava instanceof Ruutu)) {
            return false;
        }

        Ruutu verrattavaRuutu = (Ruutu) verrattava;

        if (this.tila == verrattavaRuutu.tila) {
            return true;
        }

        return false;
    }
}
