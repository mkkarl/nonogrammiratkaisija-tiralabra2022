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
}
