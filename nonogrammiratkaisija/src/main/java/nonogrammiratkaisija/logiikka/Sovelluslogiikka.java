package nonogrammiratkaisija.logiikka;

public class Sovelluslogiikka {
    private Nonogrammi nonogrammi;
    
    /**
     * Nonogrammin alustus.
     * 
     * @param vaakarivit    Nonogrammin vaakarivien numerot vasemmalta oikealle ja ylhäältä alas taulukkona
     * @param pystyrivit    Nonogrammin pystyrivien numerot ylhäältä alas ja vasemmalta oikealle taulukkona
     */
    public void alustaNonogrammi(String[] vaakarivit, String[] pystyrivit) {
        this.nonogrammi = new Nonogrammi(vaakarivit, pystyrivit);
    }

    public Nonogrammi getNonogrammi() {
        return this.nonogrammi;
    }
}
