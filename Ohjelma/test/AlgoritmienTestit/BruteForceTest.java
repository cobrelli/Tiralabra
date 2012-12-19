
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
    
    /**
     * Konstruktori
     */
    public BruteForceTest() {
    }
    
    /**
     * Asettaa alkutilanteen ja alustaa käytetyt oliot
     */
    @Before
    public void setUp() {
        bf = new BruteForce();
        r = new Random();
        s = new Sokkelo(r);
    }
    
    /**
     * Testaa ettei 3x3 reitillä ole mahdollista saada parempaa kuin oikeasti
     * pienintä mahdollista reittiä.
     */
    @Test
    public void testaaEtteiReitinPituusOlePienempiKuinEtaisyys(){
        int[][] sokkelo = s.teeSokkelo(3, 3,2,2);
        int koko = bf.AjaBruteForce(sokkelo, r,s.getY(),s.getX());
        
        boolean onkoPienempi = false;
        if(koko<4){
            onkoPienempi = true;
        }
        
        assertFalse(onkoPienempi);
    }
    
    /**
     * Testaa että reitin pituus lasketaan oikein.
     */
    @Test
    public void testaaEtteiReitinPituusOlePienempiKuinEtaisyysYhdenkorkuisella(){
        int[][] sokkelo = s.teeSokkelo(10, 1,9,0);
        int koko = bf.AjaBruteForce(sokkelo, r,s.getY(),s.getX());
        
        boolean onkoPienempi = false;
        if(koko<9){
            onkoPienempi = true;
        }
        
        assertFalse(onkoPienempi);
    }
    
}
