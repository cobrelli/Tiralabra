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
    
    public BellmanFordTest() {
    }

    @Before
    public void setUp() {
        bf = new BellmanFord();
        s = new Sokkelo(new Random());
    }
    
    @Test
    public void testaaEttaPituusEiOlePidempiKuinPitaisi(){
        int pituus = bf.ratkaiseSokkelo(s.teeSokkelo(3, 3));
        boolean onkoLiianPitka = (pituus>=4);
        assertTrue(onkoLiianPitka);
    }

}
