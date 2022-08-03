package nonogrammiratkaisija.logiikka;

public class Pystyrivi extends Rivi {
    
    /**
     * Nonogrammin pystyrivi.
     * 
     * @param rivinumero    Pystyrivin järjestysnumero, vasemmaisimman rivin numero 0
     * @param patkat    Pystyrivin mustat pätkät taulukkona
     */
    public Pystyrivi(int rivinumero, MustaPatka[] patkat) {
        super(rivinumero, patkat);
    }
}
