
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
     *
     */
    @Test
    public void testaaEttaAnnettuPaikkaPalauttaaYOikein() {
        Paikka p = new Paikka(1, 1);
        assertEquals(1, p.getY());
    }

    /**
     *
     */
    @Test
    public void testaaEttaAnnettuPaikkaOnOikea() {
        Paikka p = new Paikka(1, 1);
        assertEquals(1, p.getX());
    }
}
