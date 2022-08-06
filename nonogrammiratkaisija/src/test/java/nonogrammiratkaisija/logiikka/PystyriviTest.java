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
    public void varmojenKoordinaatitOikein() {
        int[][] varmatTyhja = tyhjaRivi.varmojenMustienKoordinaatit();

        assertNull(varmatTyhja);

        int[][] varmat1 = yhdenRivi.varmojenMustienKoordinaatit();
        assertNull(varmat1);

        int[][] varmat2 = neljanRivi.varmojenMustienKoordinaatit();
        int[][] vertaus2 = {{4, 4}, {5, 4}};

        assertArrayEquals(vertaus2, varmat2);
    }
    
}
