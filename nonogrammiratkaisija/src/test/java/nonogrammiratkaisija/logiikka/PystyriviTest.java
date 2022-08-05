package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PystyriviTest {

    Pystyrivi tyhjaRivi;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaRivinumeronOikein() {
        int rivinroTyhja = tyhjaRivi.getRivinumero();

        assertEquals(2, rivinroTyhja);
    }
    
}
