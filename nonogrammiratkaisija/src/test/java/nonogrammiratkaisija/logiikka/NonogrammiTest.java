package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NonogrammiTest {

    Nonogrammi nonogrammi1;
    Nonogrammi nonogrammi2;
    Nonogrammi nonogrammi3;
    Nonogrammi nonogrammi4;

    Nonogrammi nonogrammi6;
    Nonogrammi nonogrammi7;
    
    public NonogrammiTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String[] yksiValkoinen = new String[1];
        yksiValkoinen[0] = "";
        nonogrammi1 = new Nonogrammi(yksiValkoinen, yksiValkoinen);

        String[] yksiMusta = new String[1];
        yksiMusta[0] = "1";
        nonogrammi2 = new Nonogrammi(yksiMusta, yksiMusta);

        String[] vaaka3 = {"1","1"};
        String[] pysty3 = {"2",""};
        nonogrammi3 = new Nonogrammi(vaaka3, pysty3);
        nonogrammi4 = new Nonogrammi(pysty3, vaaka3);

        String[] vaaka6 = {"1","","1"};
        String[] pysty6 = {"1 1"};
        nonogrammi6 = new Nonogrammi(vaaka6, pysty6);
        nonogrammi7 = new Nonogrammi(pysty6, vaaka6);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriLuoRuudukon() {
        assertNotNull(nonogrammi1.getRuudukko());
        assertNotNull(nonogrammi2.getRuudukko());
        assertNotNull(nonogrammi3.getRuudukko());
        assertNotNull(nonogrammi4.getRuudukko());
        assertNotNull(nonogrammi6.getRuudukko());
        assertNotNull(nonogrammi7.getRuudukko());
    }

    @Test
    public void ruudukonKorkeusOnOikea() {
        assertEquals(1, nonogrammi1.getRuudukko().length);
        assertEquals(1, nonogrammi2.getRuudukko().length);
        assertEquals(2, nonogrammi3.getRuudukko().length);
        assertEquals(2, nonogrammi4.getRuudukko().length);
        assertEquals(3, nonogrammi6.getRuudukko().length);
        assertEquals(1, nonogrammi7.getRuudukko().length);
    }

    @Test public void ruudukonLeveysOnOikea() {
        assertEquals(1, nonogrammi1.getRuudukko()[0].length);
        assertEquals(1, nonogrammi2.getRuudukko()[0].length);
        assertEquals(2, nonogrammi3.getRuudukko()[0].length);
        assertEquals(2, nonogrammi4.getRuudukko()[0].length);
        assertEquals(1, nonogrammi6.getRuudukko()[0].length);
        assertEquals(3, nonogrammi7.getRuudukko()[0].length);
    }

    @Test
    public void konstruktoriLuoRivit() {
        assertNotNull(nonogrammi1.getRivit());
        assertNotNull(nonogrammi2.getRivit());
        assertNotNull(nonogrammi3.getRivit());
        assertNotNull(nonogrammi4.getRivit());
        assertNotNull(nonogrammi6.getRivit());
        assertNotNull(nonogrammi7.getRivit());
    }

    @Test
    public void rivitPituusOnOikea() {
        assertEquals(2, nonogrammi1.getRivit().length);
        assertEquals(2, nonogrammi2.getRivit().length);
        assertEquals(4, nonogrammi3.getRivit().length);
        assertEquals(4, nonogrammi4.getRivit().length);
        assertEquals(4, nonogrammi6.getRivit().length);
        assertEquals(4, nonogrammi7.getRivit().length);
    }

    @Test
    public void ruutu00OnTuntematon() {
        assertEquals("TUNTEMATON", nonogrammi1.getRuudukko()[0][0].getTila().toString());
    }

    @Test
    public void ruutuEiOleMustaSaanto11() {
        nonogrammi1.saanto11();
        assertNotEquals("MUSTA", nonogrammi1.getRuudukko()[0][0].getTila().toString());
    }

    @Test
    public void ruutuOnMustaSaanto11() {
        nonogrammi2.saanto11();
        assertEquals("MUSTA", nonogrammi2.getRuudukko()[0][0].getTila().toString());
    }

    @Test
    public void ruutuOnValkoinenSaanto12() {
        nonogrammi1.saanto12();
        assertEquals("VALKOINEN", nonogrammi1.getRuudukko()[0][0].getTila().toString());
    }

    @Test
    public void ruutuEiOleValkoinenSaanto12() {
        nonogrammi2.saanto12();
        assertNotEquals("VALKOINEN", nonogrammi2.getRuudukko()[0][0].getTila().toString());
    }
}
