package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MustaPatkaTest {

    MustaPatka patka;
    
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
        patka = new MustaPatka(2, 3, 9);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPituudenOikein() {
        int pituus = patka.getPituus();

        assertEquals(2, pituus);
    }

    @Test
    public void konstruktoriAsettaaAlkupisteenOikein() {
        int alkupiste = patka.getPieninMahdAlkupiste();

        assertEquals(3, alkupiste);
    }

    @Test
    public void konstruktoriAsettaaLoppupisteenOikein() {
        int loppupiste = patka.getSuurinMahdLoppupiste();

        assertEquals(9, loppupiste);
    }
}
