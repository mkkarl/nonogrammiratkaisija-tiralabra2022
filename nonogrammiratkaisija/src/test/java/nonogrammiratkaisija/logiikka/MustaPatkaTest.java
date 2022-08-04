package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MustaPatkaTest {
    
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPituudenOikein() {
        MustaPatka patka = new MustaPatka(2, 3, 9);

        int pituus = patka.getPituus();

        assertEquals(2, pituus);
    }

    @Test
    public void konstruktoriAsettaaAlkupisteenOikein() {
        MustaPatka patka = new MustaPatka(2, 3, 9);

        int alkupiste = patka.getPieninMahdAlkupiste();

        assertEquals(3, alkupiste);
    }

    @Test
    public void konstruktoriAsettaaLoppupisteenOikein() {
        MustaPatka patka = new MustaPatka(2, 3, 9);

        int loppupiste = patka.getSuurinMahdLoppupiste();

        assertEquals(9, loppupiste);
    }
}
