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
    public void varmojenMustienAlkuJaLoppuOikein() {
        int[][] varmatTyhja = tyhjaRivi.varmatMustatAlkuLoppu();
        assertNull(varmatTyhja);

        int[][] varmat1 = yhdenRivi.varmatMustatAlkuLoppu();
        int[][] vertaus1 = {{-1, -1, 0}};
        assertArrayEquals(vertaus1, varmat1);

        int[][] varmat2 = neljanRivi.varmatMustatAlkuLoppu();
        int[][] vertaus2 = {{4, 5, 2}};
        assertArrayEquals(vertaus2, varmat2);
    }

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
}
