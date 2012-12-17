package AlgoritmienTestit;

import Algoritmit.Paikka;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa paikkaluokan toimivuuden
 *
 * @author Cobrelli
 */
public class PaikkaTest {

    /**
     * Konstruktori
     */
    public PaikkaTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Tarkistaa että paikalle asetettu Y arvo palautetaan oikein
     */
    @Test
    public void testaaEttaAnnettuPaikkaPalauttaaYOikein() {
        Paikka p = new Paikka(1, 3, 0);
        assertEquals(1, p.getY());
    }

    /**
     * Tarkistaa että paikalle asetettu X arvo palautetaan oikein
     */
    @Test
    public void testaaEttaAnnettuPaikkaOnOikea() {
        Paikka p = new Paikka(5, 1, 0);
        assertEquals(1, p.getX());
    }
}
