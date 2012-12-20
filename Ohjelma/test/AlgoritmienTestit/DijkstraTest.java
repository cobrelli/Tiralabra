/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmienTestit;

import Algoritmit.Dijkstra;
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class DijkstraTest {
    
    Sokkelo s;
    Dijkstra d;
    
    public DijkstraTest() {
    }
    
    @Before
    public void setUp() {
        s = new Sokkelo(new Random());
        d = new Dijkstra();
    }
    
    @Test
    public void testaaEtteiPalautaLiianLyhyttäPolkua() {
        int[][] sokkelo = s.teeSokkelo(4, 4, 3, 3);
        boolean onkoTarpeeksiPitka = d.ratkaiseSokkelo(sokkelo, s.getLoppuY(),
                s.getLoppuX()) >= 6;
        assertTrue(onkoTarpeeksiPitka);
    }
    
    @Test
    public void testaaEttaReittiLoytyyMyosEiSokkeloisemmalla() {
        s.teeSokkelo(5, 5, 4, 4);
        
        int pituus = d.ratkaiseSokkelo(s1, s.getLoppuY(), s.getLoppuX());
        assertEquals(16, pituus);        
    }
    public static int[][] s1 = {{0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0}};
    
    @Test
    public void testaaEttaReittiLoytyyMyosIsommalla(){
        d.ratkaiseSokkelo(s.teeSokkelo(500, 500, 499, 499), 499, 499);
    }
    
    @Test
    public void testaaEttaReittiOikeanmittainen(){
        int pituus = d.ratkaiseSokkelo(s.teeSokkelo(1, 6, 0, 5), 0, 5);
        assertEquals(5, pituus);
    }
}
