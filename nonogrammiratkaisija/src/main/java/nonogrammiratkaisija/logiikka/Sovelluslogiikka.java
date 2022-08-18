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

    /**
     * Ratkaisee nonogrammin sääntöjä noudattaen.
     */
    public void ratkaiseNonogrammi() {
        nonogrammi.saanto11();
        nonogrammi.saanto12();
        nonogrammi.saanto13();
        nonogrammi.saanto14();
        nonogrammi.saanto15();
        nonogrammi.saanto21();
        nonogrammi.saanto22();
        nonogrammi.saanto23();
    }
}
