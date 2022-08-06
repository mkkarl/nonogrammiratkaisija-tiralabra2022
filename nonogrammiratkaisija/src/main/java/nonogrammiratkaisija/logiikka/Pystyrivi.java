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

    @Override
    public int[][] varmojenMustienKoordinaatit() {
        int[][] varmat = super.varmatMustatAlkuLoppu();

        if (varmat == null) {
            return null;
        }

        int ruudutYhteensa = 0;

        for (int i = 0; i < varmat.length; i++) {
            ruudutYhteensa += varmat[i][2];
        }

        if (ruudutYhteensa == 0) {
            return null;
        }

        int[][] koordinaatit = new int[ruudutYhteensa][2];

        int laskuri = 0;

        for (int i = 0; i < varmat.length; i++) {
            for (int j = 0; j < varmat[i][2]; j++) {
                koordinaatit[laskuri][0] = varmat[i][0] + j;
                koordinaatit[laskuri][1] = super.getRivinumero();
                laskuri++;
            }
        }

        return koordinaatit;
    }
}
