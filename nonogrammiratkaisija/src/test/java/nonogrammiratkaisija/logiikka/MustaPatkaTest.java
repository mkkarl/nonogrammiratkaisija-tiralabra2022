package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MustaPatkaTest {

    MustaPatka patka1;
    MustaPatka patka2;
    MustaPatka patka3;
    MustaPatka patka4;
    MustaPatka patka5;
    MustaPatka patka6;
    
    public MustaPatkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        patka1 = new MustaPatka(2, 3, 9);
        patka2 = new MustaPatka(3, 0, 4);
        patka3 = new MustaPatka(4, 2, 7);
        patka4 = new MustaPatka(2, 8, 10);
        patka5 = new MustaPatka(2, 9, 10);
        patka6 = new MustaPatka(2, 10, 11);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPituudenOikein() {
        int pituus = patka1.getPituus();

        assertEquals(2, pituus);
    }

    @Test
    public void konstruktoriAsettaaAlkupisteenOikein() {
        int alkupiste = patka1.getPieninMahdAlkupiste();

        assertEquals(3, alkupiste);
    }

    @Test
    public void konstruktoriAsettaaLoppupisteenOikein() {
        int loppupiste = patka1.getSuurinMahdLoppupiste();

        assertEquals(9, loppupiste);
    }

    @Test
    public void toStringToimiiOikein() {
        String tulos = patka1.toString();
        String vertaus = "p: 2, a: 3, l: 9";

        assertEquals(vertaus, tulos);
    }

    // Sääntö 1.1

    @Test
    public void varmaAlkuJaLoppuOikein() {
        assertNull(patka1.varmaMustaAlkuLoppu());

        int[] alkuLoppu2 = {2, 2};
        assertArrayEquals(alkuLoppu2, patka2.varmaMustaAlkuLoppu());

        int[] alkuLoppu3 = {4, 5};
        assertArrayEquals(alkuLoppu3, patka3.varmaMustaAlkuLoppu());
    }

    // Sääntö 1.2

    @Test
    public void valkoisetPatkienPaissaOikein() {
        int[] tulos1 = patka2.mustanPatkanUlkopuolisetValkoiset(null, null, 5);
        int[] vertaus1 = {-1, -1, -1, -1};
        assertArrayEquals(vertaus1, tulos1);

        int[] tulos2 = patka2.mustanPatkanUlkopuolisetValkoiset(null, null, 7);
        int[] vertaus2 = {-1, -1, 5, 6};
        assertArrayEquals(vertaus2, tulos2);

        int[] tulos3 = patka3.mustanPatkanUlkopuolisetValkoiset(null, null, 8);
        int[] vertaus3 = {0, 1, -1, -1};
        assertArrayEquals(vertaus3, tulos3);

        int[] tulos4 = patka3.mustanPatkanUlkopuolisetValkoiset(patka2, patka4, 11);
        int[] vertaus4 = {-1, -1, -1, -1};
        assertArrayEquals(vertaus4, tulos4);

        int[] tulos5 = patka3.mustanPatkanUlkopuolisetValkoiset(null, patka5, 11);
        int[] vertaus5 = {0, 1, 8, 8};
        assertArrayEquals(vertaus5, tulos5);

    }

    @Test
    public void valkoisetRivinAlussaOikein() {
        int[] tulos1 = patka1.valkoisetRivinAlussa();
        int[] vertaus1 = {0, 2};
        assertArrayEquals(vertaus1, tulos1);

        int[] tulos2 = patka2.valkoisetRivinAlussa();
        int[] vertaus2 = {-1, -1};
        assertArrayEquals(vertaus2, tulos2);
    }

    @Test
    public void valkoisetPatkienValissaOikein() {
        int[] tulos1 = patka3.valkoisetPatkienValissa(patka4);
        int[] vertaus1 = {-1, -1};
        assertArrayEquals(vertaus1, tulos1);

        int[] tulos2 = patka3.valkoisetPatkienValissa(patka5);
        int[] vertaus2 = {8, 8};
        assertArrayEquals(vertaus2, tulos2);

        int[] tulos3 = patka3.valkoisetPatkienValissa(patka6);
        int[] vertaus3 = {8, 9};
        assertArrayEquals(vertaus3, tulos3);
    }

    @Test
    public void valkoisetRivinLopussaOikein() {
        int[] tulos1 = patka1.valkoisetRivinLopussa(10);
        int[] vertaus1 = {-1, -1};
        assertArrayEquals(vertaus1, tulos1);

        int[] tulos2 = patka1.valkoisetRivinLopussa(11);
        int[] vertaus2 = {10, 10};
        assertArrayEquals(vertaus2, tulos2);

        int[] tulos3 = patka1.valkoisetRivinLopussa(12);
        int[] vertaus3 = {10, 11};
        assertArrayEquals(vertaus3, tulos3);
    }

    // Osa 2

    // Sääntö 2.1

    @Test
    public void saanto21alkupisteMuuttuuOikein() {
        MustaPatka patkaA = new MustaPatka(2, 3, 5);
        MustaPatka patkaB = new MustaPatka(3, 3, 10);

        patkaB.saanto21patkanAlku(patkaA);

        assertEquals(6, patkaB.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto21alkupistePysyySamana() {
        patka3.saanto21patkanAlku(patka2);
        assertEquals(2, patka3.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto21loppupisteMuuttuuOikein() {
        MustaPatka patkaA = new MustaPatka(3, 0, 9);
        MustaPatka patkaB = new MustaPatka(2, 4, 7);

        patkaA.saanto21patkanLoppu(patkaB);

        assertEquals(4, patkaA.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto21loppupistePysyySamana() {
        patka2.saanto21patkanLoppu(patka3);
        assertEquals(4, patka2.getSuurinMahdLoppupiste());
    }

    // Sääntö 2.2

    @Test
    public void saanto22edellaMustaRuutuMuuttaa() {
        Ruutu musta = new Ruutu();
        musta.setMusta();

        patka1.saanto22patkanAlku(musta);

        assertEquals(4, patka1.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto22edellaValkoinenRuutuEiMuuta() {
        Ruutu valkoinen = new Ruutu();
        valkoinen.setValkoinen();

        patka1.saanto22patkanAlku(valkoinen);

        assertEquals(3, patka1.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto22edellaTuntematonRuutuEiMuuta() {
        Ruutu tuntematon = new Ruutu();
        tuntematon.setValkoinen();

        patka1.saanto22patkanAlku(tuntematon);

        assertEquals(3, patka1.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto22jaljessaMustaRuutuMuuttaa() {
        Ruutu musta = new Ruutu();
        musta.setMusta();

        patka1.saanto22patkanLoppu(musta);

        assertEquals(8, patka1.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto22jaljessaValkoinenRuutuEiMuuta() {
        Ruutu valkoinen = new Ruutu();
        valkoinen.setValkoinen();

        patka1.saanto22patkanLoppu(valkoinen);

        assertEquals(9, patka1.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto22jaljessaTuntematonRuutuEiMuuta() {
        Ruutu tuntematon = new Ruutu();
        tuntematon.setValkoinen();

        patka1.saanto22patkanLoppu(tuntematon);

        assertEquals(9, patka1.getSuurinMahdLoppupiste());
    }

    // Sääntö 2.3

    @Test
    public void saanto23liianPitkaMustaMuuttaaAlkua() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{4, 6}, {11, 11}};

        patka.saanto23segmentitAlussa(segmentit);

        assertEquals(8, patka.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto23yhtaPitkaAlussaEiMuuta() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{4, 4}, {11, 11}};

        patka.saanto23segmentitAlussa(segmentit);

        assertEquals(4, patka.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto23kaikkiLapiAlustaLoppuunIlmanMuutoksia() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{1,1}, {4, 4}, {11, 11}, {13, 13}};

        patka.saanto23segmentitAlussa(segmentit);

        assertEquals(4, patka.getPieninMahdAlkupiste());
    }

    @Test
    public void saanto23liianPitkaMustaMuuttaaLoppua() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{4, 4}, {9, 11}};

        patka.saanto23segmentitLopussa(segmentit);

        assertEquals(7, patka.getSuurinMahdLoppupiste());
    }

    public void saanto23yhtaPitkaLopussaEiMuuta() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{4, 6}, {11, 11}};

        patka.saanto23segmentitLopussa(segmentit);

        assertEquals(11, patka.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto23kaikkiLapiLopustaAlkuunIlmanMuutoksia() {
        MustaPatka patka = new MustaPatka(1, 4, 11);
        int[][] segmentit = {{1,1}, {4, 4}, {11, 11}, {13, 13}};

        patka.saanto23segmentitLopussa(segmentit);

        assertEquals(11, patka.getSuurinMahdLoppupiste());
    }

    // Osa 3

    // Sääntö 3.1

    @Test
    public void saanto31fig13toimii() {
        MustaPatka patkaA = new MustaPatka(1, 0, 3);
        MustaPatka patkaB = new MustaPatka(4, 2, 8);
        MustaPatka patkaC = new MustaPatka(3, 7, 12);
        Ruutu[] rivi = new Ruutu[13];

        for (int i = 0; i < rivi.length; i++) {
            rivi[i] = new Ruutu();
        }

        rivi[4].setMusta();
        rivi[6].setMusta();

        int[] tulosA = patkaA.saanto31mustienTaytto(null, patkaB, rivi);
        int[] tulosB = patkaB.saanto31mustienTaytto(patkaA, patkaC, rivi);
        int[] tulosC = patkaC.saanto31mustienTaytto(patkaB, null, rivi);

        int[] vertausB = {4, 6};

        assertNull("PatkaA", tulosA);
        assertArrayEquals("PatkaB", vertausB, tulosB);
        assertNull("PatkaC", tulosC);
    }

    @Test
    public void saanto32fig14() {
        MustaPatka patkaA = new MustaPatka(1, 0, 8);
        MustaPatka patkaB = new MustaPatka(3, 1, 16);
        MustaPatka patkaC = new MustaPatka(1, 12, 17);
        Ruutu[] ruudukonRivi = new Ruutu[18];
        for (int i = 0; i < ruudukonRivi.length; i++) {
            ruudukonRivi[i] = new Ruutu();
        }
        ruudukonRivi[2].setValkoinen();
        ruudukonRivi[4].setValkoinen();
        ruudukonRivi[5].setValkoinen();
        ruudukonRivi[8].setMusta();
        ruudukonRivi[9].setValkoinen();
        ruudukonRivi[11].setValkoinen();
        ruudukonRivi[13].setMusta();
        ruudukonRivi[15].setValkoinen();

        int[][] tulos = patkaB.saanto32liianLyhyetValit(ruudukonRivi, patkaA, patkaC);
        int[][] vertaus = {{10, 10, 1}};

        assertArrayEquals("Ei palauta taulukkoa oikein", vertaus, tulos);
        assertEquals("Pienin mahdollinen alkupiste", 6, patkaB.getPieninMahdAlkupiste());
        assertEquals("Suurin mahdollinen loppupiste", 14, patkaB.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto331fig15() {
        MustaPatka patkaA = new MustaPatka(1, 0, 4);
        MustaPatka patkaB = new MustaPatka(4, 5, 10);
        MustaPatka patkaC = new MustaPatka(1, 7, 11);
        Ruutu[] ruudukonRivi = new Ruutu[12];
        for (int i = 0; i < ruudukonRivi.length; i++) {
            ruudukonRivi[i] = new Ruutu();
        }
        ruudukonRivi[5].setMusta();

        Ruutu[] tulos = patkaB.saanto331vasenPaa(ruudukonRivi, patkaA, patkaC);
        Ruutu[] vertaus = new Ruutu[12];
        for (int i = 0; i < vertaus.length; i++) {
            vertaus[i] = new Ruutu();
        }
        vertaus[4].setValkoinen();
        vertaus[5].setMusta();
        vertaus[6].setMusta();
        vertaus[7].setMusta();
        vertaus[8].setMusta();
        vertaus[9].setValkoinen();

        assertArrayEquals(vertaus, tulos);

        assertEquals(0, patkaA.getPieninMahdAlkupiste());
        assertEquals(3, patkaA.getSuurinMahdLoppupiste());
        assertEquals(5, patkaB.getPieninMahdAlkupiste());
        assertEquals(8, patkaB.getSuurinMahdLoppupiste());
        assertEquals(10, patkaC.getPieninMahdAlkupiste());
        assertEquals(11, patkaC.getSuurinMahdLoppupiste());
    }

    @Test
    public void saanto331fig15rev() {
        MustaPatka patkaA = new MustaPatka(1, 0, 4);
        MustaPatka patkaB = new MustaPatka(4, 1, 6);
        MustaPatka patkaC = new MustaPatka(1, 7, 11);
        Ruutu[] ruudukonRivi = new Ruutu[12];
        for (int i = 0; i < ruudukonRivi.length; i++) {
            ruudukonRivi[i] = new Ruutu();
        }
        ruudukonRivi[6].setMusta();

        Ruutu[] tulos = patkaB.saanto331oikeaPaa(ruudukonRivi, patkaA, patkaC);
        Ruutu[] vertaus = new Ruutu[12];
        for (int i = 0; i < vertaus.length; i++) {
            vertaus[i] = new Ruutu();
        }
        vertaus[2].setValkoinen();
        vertaus[3].setMusta();
        vertaus[4].setMusta();
        vertaus[5].setMusta();
        vertaus[6].setMusta();
        vertaus[7].setValkoinen();

        assertArrayEquals(vertaus, tulos);

        assertEquals(0, patkaA.getPieninMahdAlkupiste());
        assertEquals(1, patkaA.getSuurinMahdLoppupiste());
        assertEquals(3, patkaB.getPieninMahdAlkupiste());
        assertEquals(6, patkaB.getSuurinMahdLoppupiste());
        assertEquals(8, patkaC.getPieninMahdAlkupiste());
        assertEquals(11, patkaC.getSuurinMahdLoppupiste());
    }
}
