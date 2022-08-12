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
}
