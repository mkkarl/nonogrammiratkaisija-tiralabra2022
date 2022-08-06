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
    public void varmaAlkuJaLoppuOikein() {
        assertNull(patka1.varmaMustaAlkuLoppu());

        int[] alkuLoppu2 = {2, 2};
        assertArrayEquals(alkuLoppu2, patka2.varmaMustaAlkuLoppu());

        int[] alkuLoppu3 = {4, 5};
        assertArrayEquals(alkuLoppu3, patka3.varmaMustaAlkuLoppu());
    }
}
