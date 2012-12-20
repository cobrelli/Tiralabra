/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmienTestit;

import Algoritmit.AStar;
import Sokkelo.Sokkelo;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cobrelli
 */
public class AStarTest {
    
    Sokkelo s;
    AStar a;
    
    public AStarTest() {
    }
    
    @Before
    public void setUp() {
        s = new Sokkelo(new Random());
        a = new AStar();
    }
    
    @Test
    public void testaaEttaReittiOnOikeanPituinen(){
        int pituus = a.ratkaiseSokkelo(s.teeSokkelo(1, 6, 0, 5), 0, 5);
        assertEquals(5, pituus);
    }
    
}
