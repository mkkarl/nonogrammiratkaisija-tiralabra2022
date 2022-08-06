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
                koordinaatit[laskuri][0] = super.getRivinumero();
                koordinaatit[laskuri][1] = varmat[i][0] + j;
                laskuri++;
            }
        }

        return koordinaatit;
    }

    
}
