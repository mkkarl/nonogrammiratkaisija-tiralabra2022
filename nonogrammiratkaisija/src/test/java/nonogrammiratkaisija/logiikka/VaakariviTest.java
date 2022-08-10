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

    // Sääntö 1.1

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
}
