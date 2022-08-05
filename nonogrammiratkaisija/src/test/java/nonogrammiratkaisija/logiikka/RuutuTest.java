package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    Ruutu ruutu;

    public RuutuTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruutu = new Ruutu();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaTilanOikein() {
        String tila = ruutu.getTila().toString();

        assertEquals("TUNTEMATON", tila);
    }

    @Test
    public void tilaMuuttuuValkoiseksi() {
        ruutu.setValkoinen();
        assertEquals("VALKOINEN", ruutu.getTila().toString());
    }

    @Test
    public void tilaMuuttuuMustaksi() {
        ruutu.setMusta();
        assertEquals("MUSTA", ruutu.getTila().toString());
    }

    @Test
    public void valkoinenMuuttuuVirheeksiEikaMustaksi() {
        ruutu.setValkoinen();
        ruutu.setMusta();
        assertEquals("VIRHE", ruutu.getTila().toString());
    }

    @Test
    public void mustaMuuttuuVirheeksiEikaValoiseksi() {
        ruutu.setMusta();
        ruutu.setValkoinen();
        assertEquals("VIRHE", ruutu.getTila().toString());
    }

    @Test
    public void valkoinenPysyyValkoisena() {
        ruutu.setValkoinen();
        ruutu.setValkoinen();
        assertEquals("VALKOINEN", ruutu.getTila().toString());
    }

    @Test
    public void mustaPysyyMustana() {
        ruutu.setMusta();
        ruutu.setMusta();
        assertEquals("MUSTA", ruutu.getTila().toString());
    }
    
}
