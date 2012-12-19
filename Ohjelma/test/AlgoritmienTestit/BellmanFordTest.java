package AlgoritmienTestit;

import Algoritmit.BellmanFord;
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class BellmanFordTest {
    
    BellmanFord bf;
    Sokkelo s;
    
    /**
     * Konstruktori
     */
    public BellmanFordTest() {
    }

    /**
     * Asettaa alkutilanteen ja alustaa käytettävät oliot.
     */
    @Before
    public void setUp() {
        bf = new BellmanFord();
        s = new Sokkelo(new Random());
    }
    
    /**
     * Testaa ettei 
     */
    @Test
    public void testaaEttaPituusEiOleLyhyempiiKuinPitaisi(){
        int pituus = bf.ratkaiseSokkelo(s.teeSokkelo(3, 3,2,2),s.getY(),s.getX());
        boolean onkoLiianLyhyt = (pituus>=4);
        assertTrue(onkoLiianLyhyt);
    }

    /**
     * Testaa että palautettavaa pituutta ei lasketa väärin.
     */
    @Test
    public void testaaPituuttaHelpolla(){
        int pituus = bf.ratkaiseSokkelo(s.teeSokkelo(1, 5,0,4),s.getY(),s.getX());
        assertEquals(4, pituus);
    }
    
}
