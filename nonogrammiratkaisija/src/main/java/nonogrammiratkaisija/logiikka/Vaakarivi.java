package nonogrammiratkaisija.logiikka;

public class Vaakarivi extends Rivi {

    /**
     * Nonogrammin vaakarivi.
     * 
     * @param rivinumero Vaakarivin järjestysnumero, ylimmän rivin numero 0
     * @param patkat     Vaakarivin mustat pätkät taulukkona
     */
    public Vaakarivi(int rivinumero, MustaPatka[] patkat) {
        super(rivinumero, patkat);
    }

    // SÄÄNNÖT

    // Osa 1

    // Sääntö 1.1

    @Override
    public int[][] varmojenMustienKoordinaatit() {
        int[][] varmat = super.varmatMustatAlkuLoppu();

        if (varmat == null) {
            return null;
        }

        int[][] koordinaatit = this.koordinaattilaskuri(varmat);

        return koordinaatit;
    }

    // Sääntö 1.2

    @Override
    public int[][] patkienUlkuopuolisetValkoisetKoordinaatit(int rivinPituus) {
        int[][] valkoiset = super.valkoisetAlkuLoppu(rivinPituus);

        int[][] koordinaatit = this.koordinaattilaskuri(valkoiset);

        return koordinaatit;
    }

    // apumetodeja

    private int[][] koordinaattilaskuri(int[][] alutLoputPituudet) {

        int ruudutYhteensa = 0;

        for (int i = 0; i < alutLoputPituudet.length; i++) {
            ruudutYhteensa += alutLoputPituudet[i][2];
        }

        if (ruudutYhteensa == 0) {
            return null;
        }

        int[][] koordinaatit = new int[ruudutYhteensa][2];

        int laskuri = 0;

        for (int i = 0; i < alutLoputPituudet.length; i++) {
            for (int j = 0; j < alutLoputPituudet[i][2]; j++) {
                koordinaatit[laskuri][0] = super.getRivinumero();
                koordinaatit[laskuri][1] = alutLoputPituudet[i][0] + j;
                laskuri++;
            }
        }

        return koordinaatit;

    }

}
