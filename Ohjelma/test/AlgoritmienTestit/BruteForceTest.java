
package AlgoritmienTestit;

import Algoritmit.BruteForce;
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class BruteForceTest {
    
    BruteForce bf;
    Sokkelo s;
    Random r;
    
    public BruteForceTest() {
    }
    
    @Before
    public void setUp() {
        bf = new BruteForce();
        r = new Random();
        s = new Sokkelo(r);
    }
    
    @Test
    public void testaaEtteiReitinPituusOlePienempiKuinEtaisyys(){
        int[][] sokkelo = s.teeSokkelo(3, 3);
        int koko = bf.AjaBruteForce(sokkelo, r);
        
        boolean onkoPienempi = false;
        if(koko<4){
            onkoPienempi = true;
        }
        
        assertFalse(onkoPienempi);
    }
    
    @Test
    public void testaaEtteiReitinPituusOlePienempiKuinEtaisyysYhdenkorkuisella(){
        int[][] sokkelo = s.teeSokkelo(10, 1);
        int koko = bf.AjaBruteForce(sokkelo, r);
        
        boolean onkoPienempi = false;
        if(koko<9){
            onkoPienempi = true;
        }
        
        assertFalse(onkoPienempi);
    }
    
}
