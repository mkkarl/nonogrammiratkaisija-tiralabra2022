package nonogrammiratkaisija.logiikka;

public class Vaakarivi extends Rivi {
    
    /**
     * Nonogrammin vaakarivi.
     * 
     * @param rivinumero    Vaakarivin järjestysnumero, ylimmän rivin numero 0
     * @param patkat    Vaakarivin mustat pätkät taulukkona
     */
    public Vaakarivi(int rivinumero, MustaPatka[] patkat) {
        super(rivinumero, patkat);
    }

    
}
