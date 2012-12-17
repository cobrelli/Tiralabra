package AlgoritmienTestit;

import Algoritmit.BellmanFord;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class BellmanFordTest {
    
    BellmanFord bf;
    
    public BellmanFordTest() {
    }

    @Before
    public void setUp() {
         bf = new BellmanFord();
    }
    
    @Test
    public void test(){
        assertEquals(1, 1);
    }

}
