package nonogrammiratkaisija.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {
    Sovelluslogiikka sovelluslogiikka;

    public SovelluslogiikkaTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sovelluslogiikka = new Sovelluslogiikka();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void alustajaLuoNonogrammin() {
        String[] yksiMusta = {"1"};
        sovelluslogiikka.alustaNonogrammi(yksiMusta, yksiMusta);
        assertNotNull(sovelluslogiikka.getNonogrammi());
    }
}
