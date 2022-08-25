package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VaakariviTest {

    Vaakarivi tyhjaRivi;
    Vaakarivi yhdenRivi;
    Vaakarivi neljanRivi;
    Vaakarivi rivi3;
    Vaakarivi rivi4;

    public VaakariviTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tyhjaRivi = new Vaakarivi(2, null);

        MustaPatka[] patkat1 = new MustaPatka[1];
        patkat1[0] = new MustaPatka(1, 3, 6);

        yhdenRivi = new Vaakarivi(3, patkat1);

        MustaPatka[] patkat2 = new MustaPatka[1];
        patkat2[0] = new MustaPatka(4, 2, 7);

        neljanRivi = new Vaakarivi(4, patkat2);

        MustaPatka patka1 = new MustaPatka(2, 0, 3);
        MustaPatka patka2 = new MustaPatka(3, 3, 7);
        MustaPatka[] patkat3 = {patka1, patka2};
        rivi3 = new Vaakarivi(5, patkat3);

        MustaPatka[] patkat4 = {new MustaPatka(2, 0, 2)};
        rivi4 = new Vaakarivi(2, patkat4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaRivinumeronOikein() {
        int rivinroTyhja = tyhjaRivi.getRivinumero();
        int rivinroYhden = yhdenRivi.getRivinumero();

        assertEquals(2, rivinroTyhja);
        assertEquals(3, rivinroYhden);
    }

    @Test
    public void patkatOnNull() {
        MustaPatka[] patkat = tyhjaRivi.getPatkat();

        assertNull(patkat);
    }

    @Test
    public void patkatEiOleNull() {
        MustaPatka[] patkat = yhdenRivi.getPatkat();

        assertNotNull(patkat);
    }

    @Test
    public void alussaEiOleValmis() {
        boolean valmis = tyhjaRivi.getValmis();

        assertFalse(valmis);
    }

    @Test
    public void onVaakarivi() {
        assertTrue(tyhjaRivi.onVaakarivi());
    }

    // Osa 1

    // Sääntö 1.1

    @Test
    public void varmojenKoordinaatitOikein() {
        int[][] varmatTyhja = tyhjaRivi.varmojenMustienKoordinaatit();

        assertNull(varmatTyhja);

        int[][] varmat1 = yhdenRivi.varmojenMustienKoordinaatit();
        assertNull(varmat1);

        int[][] varmat2 = neljanRivi.varmojenMustienKoordinaatit();
        int[][] vertaus2 = {{4, 4}, {4, 5}};

        assertArrayEquals(vertaus2, varmat2);
    }

    // Sääntö 1.2

    @Test
    public void valkoistenKoordinaatitOikein() {
        int[][] tulos1 = tyhjaRivi.patkienUlkuopuolisetValkoisetKoordinaatit(2);
        int[][] vertaus1 = {{2, 0}, {2, 1}};
        assertArrayEquals(vertaus1, tulos1);

        int[][] tulos2 = yhdenRivi.patkienUlkuopuolisetValkoisetKoordinaatit(7);
        int[][] vertaus2 = {{3, 0}, {3, 1}, {3, 2}};
        assertArrayEquals(vertaus2, tulos2);

        int[][] tulos3 = rivi3.patkienUlkuopuolisetValkoisetKoordinaatit(8);
        int[][] vertaus3 = null;
        assertArrayEquals(vertaus3, tulos3);

        int[][] tulos4 = rivi4.patkienUlkuopuolisetValkoisetKoordinaatit(4);
        int[][] vertaus4 = {{2, 3}};
        assertArrayEquals(vertaus4, tulos4);
    }

    // Sääntö 1.3

    @Test
    public void saanto13valkoistenKoordinaatitOikein() {
        MustaPatka patkaA = new MustaPatka(2, 0, 3);
        MustaPatka patkaB = new MustaPatka(1, 3, 5);
        MustaPatka patkaC = new MustaPatka(1, 5, 7);
        MustaPatka patkaD = new MustaPatka(3, 7, 11);
        MustaPatka[] patkatFig8 = {patkaA, patkaB, patkaC, patkaD};
        Vaakarivi riviFig8 = new Vaakarivi(0, patkatFig8);
        Ruutu[][] ruudukko = new Ruutu[1][12];
        for (int i = 0; i < ruudukko[0].length; i++) {
            ruudukko[0][i] = new Ruutu();
        }
        ruudukko[0][7].setMusta();
        ruudukko[0][9].setMusta();
        int[][] koordinaatitFig8 = riviFig8.saanto13valkoistenKoordinaatit(ruudukko);
        int[][] vertausFig8 = {{0, 6}};

        assertArrayEquals(vertausFig8, koordinaatitFig8);

        MustaPatka patkaE = new MustaPatka(3, 0, 4);
        MustaPatka patkaF = new MustaPatka(1, 4, 6);
        MustaPatka patkaG = new MustaPatka(1, 6, 8);
        MustaPatka patkaH = new MustaPatka(2, 8, 11);
        MustaPatka[] patkatFig8rev = {patkaE, patkaF, patkaG, patkaH};
        Vaakarivi riviFig8rev = new Vaakarivi(0, patkatFig8rev);
        Ruutu[][] ruudukkoRev = new Ruutu[1][12];
        for (int i = 0; i < ruudukkoRev[0].length; i++) {
            ruudukkoRev[0][i] = new Ruutu();
        }
        ruudukkoRev[0][2].setMusta();
        ruudukkoRev[0][4].setMusta();
        int[][] koordinaatitFig8rev = riviFig8rev.saanto13valkoistenKoordinaatit(ruudukkoRev);
        int[][] vertausFig8rev = {{0, 5}};

        assertArrayEquals(vertausFig8rev, koordinaatitFig8rev);

        Ruutu[][] ruudukkoX = new Ruutu[1][12];
        for (int i = 0; i < ruudukkoX[0].length; i++) {
            ruudukkoX[0][i] = new Ruutu();
        }
        int[][] koordinaatitFig8X = riviFig8.saanto13valkoistenKoordinaatit(ruudukkoX);
        int[][] vertausFig8X = null;

        assertArrayEquals(vertausFig8X, koordinaatitFig8X);

        assertNull(tyhjaRivi.saanto13valkoistenKoordinaatit(ruudukkoX));
    }

    // Sääntö 1.4

    @Test
    public void saanto14valkoistenKoordinaatitOikein() {
        MustaPatka patkaA = new MustaPatka(1, 0, 2);
        MustaPatka patkaB = new MustaPatka(3, 1, 6);
        MustaPatka patkaC = new MustaPatka(1, 6, 9);
        MustaPatka[] patkatFig9 = {patkaA, patkaB, patkaC};
        Vaakarivi riviFig9 = new Vaakarivi(2, patkatFig9);
        Ruutu[] ruudukonrivi = new Ruutu[10];
        for (int i = 0; i < ruudukonrivi.length; i++) {
            ruudukonrivi[i] = new Ruutu();
        }
        ruudukonrivi[2].setMusta();
        ruudukonrivi[4].setMusta();
        ruudukonrivi[5].setMusta();
        int[][] koordinaatitFig9 = riviFig9.saanto14valkoistenKoordinaatit(ruudukonrivi);
        int[][] vertausFig9 = {{2, 3}};

        assertArrayEquals(vertausFig9, koordinaatitFig9);

        Ruutu[] ruudukonriviTyhja = {new Ruutu(), new Ruutu()};
        assertNull(tyhjaRivi.saanto14valkoistenKoordinaatit(ruudukonriviTyhja));
    }

    // Sääntö 1.5

    @Test
    public void saanto15mustienKoordinaatitOikein() {
        MustaPatka patkaA = new MustaPatka(3, 0, 7);
        MustaPatka patkaB = new MustaPatka(4, 4, 12);
        MustaPatka[] patkatFig10 = {patkaA, patkaB};
        Vaakarivi riviFig10 = new Vaakarivi(1, patkatFig10);
        Ruutu[] ruudukonRiviFig10 = new Ruutu[13];
        for (int i = 0; i < ruudukonRiviFig10.length; i++) {
            ruudukonRiviFig10[i] = new Ruutu();
        }
        ruudukonRiviFig10[5].setMusta();
        ruudukonRiviFig10[3].setValkoinen();
        int[][] koordinaatitFig10 = riviFig10.saanto15mustienKoordinaatit(ruudukonRiviFig10);
        int[][] vertausFig10 = {{1, 6}};

        assertArrayEquals(vertausFig10, koordinaatitFig10);
    }

    @Test
    public void saanto15valkoistenKoordinaatitOikein() {
        MustaPatka patkaA = new MustaPatka(1, 0, 3);
        MustaPatka patkaB = new MustaPatka(2, 2, 6);
        MustaPatka patkaC = new MustaPatka(2, 5, 9);
        MustaPatka patkaD = new MustaPatka(3, 8, 13);
        MustaPatka[] patkatFig11 = {patkaA, patkaB, patkaC, patkaD};
        Vaakarivi riviFig11 = new Vaakarivi(0, patkatFig11);
        Ruutu[] ruudukonRiviFig11 = new Ruutu[14];
        for (int i = 0; i < ruudukonRiviFig11.length; i++) {
            ruudukonRiviFig11[i] = new Ruutu();
        }
        ruudukonRiviFig11[5].setMusta();
        ruudukonRiviFig11[6].setMusta();
        int[][] koordinaatitFig11 = riviFig11.saanto15valkoistenKoordinaatit(ruudukonRiviFig11);
        int[][] vertausFig11 = {{0, 4}, {0, 7}};

        assertArrayEquals(vertausFig11, koordinaatitFig11);
    }

    // Osa 2

    // Sääntö 2.1

    @Test
    public void saanto21toimii() {
        MustaPatka patkaA = new MustaPatka(2, 0, 10);
        MustaPatka patkaB = new MustaPatka(3, 0, 10);
        MustaPatka[] patkat = {patkaA, patkaB};
        Vaakarivi rivi = new Vaakarivi(1, patkat);
        rivi.saanto21patkienAlutJaLoput();

        assertEquals("Alun muutos", 3, rivi.getPatkat()[1].getPieninMahdAlkupiste());
        assertEquals("Lopun muutos", 6, rivi.getPatkat()[0].getSuurinMahdLoppupiste());
    }

    // Osa 3

    // Sääntö 3.1

    @Test
    public void saanto31fig13() {
        MustaPatka patkaA = new MustaPatka(1, 0, 3);
        MustaPatka patkaB = new MustaPatka(4, 2, 8);
        MustaPatka patkaC = new MustaPatka(3, 7, 12);
        MustaPatka[] patkat = {patkaA, patkaB, patkaC};
        Vaakarivi rivi = new Vaakarivi(2, patkat);

        Ruutu[] ruudukonRivi = new Ruutu[13];

        for (int i = 0; i < ruudukonRivi.length; i++) {
            ruudukonRivi[i] = new Ruutu();
        }

        ruudukonRivi[4].setMusta();
        ruudukonRivi[6].setMusta();

        int[][] tulos = rivi.saanto31pituuksienKorjausJaMustat(ruudukonRivi);
        int[][] vertaus = {{2, 4}, {2, 5}, {2, 6}};

        assertArrayEquals(vertaus, tulos);
    }

    // Sääntö 3.2

    @Test
    public void saanto32fig14() {
        MustaPatka patkaA = new MustaPatka(1, 0, 8);
        MustaPatka patkaB = new MustaPatka(3, 1, 16);
        MustaPatka patkaC = new MustaPatka(1, 12, 17);
        MustaPatka[] patkat = {patkaA, patkaB, patkaC};
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

        Vaakarivi rivi = new Vaakarivi(2, patkat);

        int[][] tulos = rivi.saanto32lyhyetSegmentitJaValkoisetKeskella(ruudukonRivi);
        int[][] vertaus = {{2, 10}};

        assertArrayEquals(vertaus, tulos);
    }
}
