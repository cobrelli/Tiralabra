/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmienTestit;

import Algoritmit.AStar;
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    
    @Test
    public void testaaEttaSelviaaSuurehkoistaSyotteista(){
        a.ratkaiseSokkelo(s.teeSokkelo(500, 500, 499, 499), 499, 499);
    }
    
    @Test
    public void testaaEttaUseillaSuoritusKerroillaTestiEiKaaduMillaan(){
        for(int i = 0;i<10;i++){
            a.ratkaiseSokkelo(s.teeSokkelo(50, 50, 49, 49), 49, 49);
        }
    }
    
    @Test
    public void testaaEttaReittiLoytyyMyosEiSokkeloisemmalla() {
        s.teeSokkelo(5, 5, 4, 4);
        
        int pituus = a.ratkaiseSokkelo(s1, s.getLoppuY(), s.getLoppuX());
        assertEquals(16, pituus);        
    }
    public static int[][] s1 = {{0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0}};
    
    
}
