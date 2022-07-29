package nonogrammiratkaisija.logiikka;

public class Sovelluslogiikka {
    private Nonogrammi nonogrammi;
    
    public void alustaNonogrammi(String[] vaakarivit, String[] pystyrivit) {
        this.nonogrammi = new Nonogrammi(vaakarivit, pystyrivit);
    }
}
