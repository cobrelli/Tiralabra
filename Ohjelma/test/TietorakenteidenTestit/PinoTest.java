/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.Pino;
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
public class PinoTest {

    Pino pino;

    public PinoTest() {
    }

    @Before
    public void setUp() {
        pino = new Pino(10);
    }

    @Test
    public void testaaEttaPalauttaaNullJosTyhjaJaPopataan() {
        assertEquals(null, pino.pop());
    }

    @Test
    public void testaaEttaPopPalauttaaPushatun() {
        Paikka p = new Paikka(1, 1, 1);
        pino.push(p);
        assertEquals(p, pino.pop());
    }

    @Test
    public void testaaEtteiTayteenPinoonLisaaminenAiheutaPoikkeusta() {
        for (int i = 0; i < 20; i++) {
            pino.push(new Paikka(1, 1, 1));
        }
    }
    
    @Test
    public void testaaEtteiEttaJarjestysPysyy(){
        Paikka eka = new Paikka(1, 1, 1);
        Paikka toka = new Paikka(2, 2, 2);
        
        pino.push(eka);
        pino.push(toka);
        
        pino.pop();
        assertEquals(eka, pino.pop());
    }
}
