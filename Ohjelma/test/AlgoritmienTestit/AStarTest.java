package AlgoritmienTestit;

import Algoritmit.AStar;
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testaa A* algoritmin toimintaa.
 * @author Cobrelli
 */
public class AStarTest {
    
    Sokkelo s;
    AStar a;
    
    /**
     * Konstruktori
     */
    public AStarTest() {
    }
    
    /**
     * Alustaa sokkelon ja algoritmin luokkien luonnit.
     */
    @Before
    public void setUp() {
        s = new Sokkelo(new Random());
        a = new AStar();
    }
    
    /**
     * Testaa että annettu reitti on lineaarisella reitillä oikean pituinen.
     */
    @Test
    public void testaaEttaReittiOnOikeanPituinen(){
        int pituus = a.ratkaiseSokkelo(s.teeSokkelo(1, 6, 0, 5), 0, 5);
        assertEquals(5, pituus);
    }
    
    /**
     * Tarkistaa ettei suuren sokkelon selvittäminen ei aiheuta poikkeuksia.
     */
    @Test
    public void testaaEttaSelviaaSuurehkoistaSyotteista(){
        a.ratkaiseSokkelo(s.teeSokkelo(500, 500, 499, 499), 499, 499);
    }
    
    /**
     * Tarkistaa että useallakin suorituskerralla ohjelma ei aiheuta poikkeusta.
     */
    @Test
    public void testaaEttaUseillaSuoritusKerroillaTestiEiKaaduMillaan(){
        for(int i = 0;i<10;i++){
            a.ratkaiseSokkelo(s.teeSokkelo(50, 50, 49, 49), 49, 49);
        }
    }
    
    /**
     * Testaa että löytää perille erikseen tehdyssä labyrintissa, jossa reitti
     * kulkee seinien ohjaamana.
     */
    @Test
    public void testaaEttaReittiLoytyyMyosEiSokkeloisemmalla() {
        s.teeSokkelo(5, 5, 4, 4);
        
        int pituus = a.ratkaiseSokkelo(s1, s.getLoppuY(), s.getLoppuX());
        assertEquals(16, pituus);        
    }
    /**
     * Erikseen generoitu sokkelo, jossa reitti kulkee jatkuvien seinien ohjaamana.
     */
    public static int[][] s1 = {{0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0}};
    
    
}
