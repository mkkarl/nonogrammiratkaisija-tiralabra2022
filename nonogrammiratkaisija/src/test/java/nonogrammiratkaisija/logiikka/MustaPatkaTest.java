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
}
