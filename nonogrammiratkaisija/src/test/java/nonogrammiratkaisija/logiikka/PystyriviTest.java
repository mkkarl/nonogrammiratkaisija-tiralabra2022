package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PystyriviTest {

    Pystyrivi tyhjaRivi;
    Pystyrivi yhdenRivi;
    Pystyrivi neljanRivi;
    Pystyrivi rivi3;
    Pystyrivi rivi4;

    public PystyriviTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tyhjaRivi = new Pystyrivi(2, null);

        MustaPatka[] patkat1 = new MustaPatka[1];
        patkat1[0] = new MustaPatka(1, 3, 6);

        yhdenRivi = new Pystyrivi(3, patkat1);

        MustaPatka[] patkat2 = new MustaPatka[1];
        patkat2[0] = new MustaPatka(4, 2, 7);

        neljanRivi = new Pystyrivi(4, patkat2);

        MustaPatka patka1 = new MustaPatka(2, 0, 3);
        MustaPatka patka2 = new MustaPatka(3, 3, 7);
        MustaPatka[] patkat3 = {patka1, patka2};
        rivi3 = new Pystyrivi(5, patkat3);

        MustaPatka[] patkat4 = {new MustaPatka(2, 0, 2)};
        rivi4 = new Pystyrivi(2, patkat4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaRivinumeronOikein() {
        int rivinroTyhja = tyhjaRivi.getRivinumero();

        assertEquals(2, rivinroTyhja);
    }

    @Test
    public void eiOleVaakarivi() {
        assertFalse(tyhjaRivi.onVaakarivi());
    }

    // Sääntö 1.1

    @Test
    public void varmojenKoordinaatitOikein() {
        int[][] varmatTyhja = tyhjaRivi.varmojenMustienKoordinaatit();

        assertNull(varmatTyhja);

        int[][] varmat1 = yhdenRivi.varmojenMustienKoordinaatit();
        assertNull(varmat1);

        int[][] varmat2 = neljanRivi.varmojenMustienKoordinaatit();
        int[][] vertaus2 = {{4, 4}, {5, 4}};

        assertArrayEquals(vertaus2, varmat2);
    }

    // Sääntö 1.2

    @Test
    public void valkoistenKoordinaatitOikein() {
        int[][] tulos1 = tyhjaRivi.patkienUlkuopuolisetValkoisetKoordinaatit(2);
        int[][] vertaus1 = {{0, 2}, {1, 2}};
        assertArrayEquals(vertaus1, tulos1);

        int[][] tulos2 = yhdenRivi.patkienUlkuopuolisetValkoisetKoordinaatit(7);
        int[][] vertaus2 = {{0, 3}, {1, 3}, {2, 3}};
        assertArrayEquals(vertaus2, tulos2);

        int[][] tulos3 = rivi3.patkienUlkuopuolisetValkoisetKoordinaatit(8);
        int[][] vertaus3 = null;
        assertArrayEquals(vertaus3, tulos3);

        int[][] tulos4 = rivi4.patkienUlkuopuolisetValkoisetKoordinaatit(4);
        int[][] vertaus4 = {{3, 2}};
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
        Pystyrivi riviFig8 = new Pystyrivi(0, patkatFig8);
        Ruutu[][] ruudukko = new Ruutu[12][1];
        for (int i = 0; i < ruudukko.length; i++) {
            ruudukko[i][0] = new Ruutu();
        }
        ruudukko[7][0].setMusta();
        ruudukko[9][0].setMusta();
        int[][] koordinaatitFig8 = riviFig8.saanto13valkoistenKoordinaatit(ruudukko);
        int[][] vertausFig8 = {{6, 0}};

        assertArrayEquals(vertausFig8, koordinaatitFig8);
    }
}
