package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.Pino;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Pino tietorakenteelle tarkoitetut testit.
 * @author Cobrelli
 */
public class PinoTest {

    Pino pino;

    /**
     * Konstruktori
     */
    public PinoTest() {
    }

    /**
     * Alustaa testeille uuden pinon.
     */
    @Before
    public void setUp() {
        pino = new Pino(10);
    }

    /**
     * Testaa että jos pino on tyhjä ja kutsutaan pop(), palautuu null.
     */
    @Test
    public void testaaEttaPalauttaaNullJosTyhjaJaPopataan() {
        assertEquals(null, pino.pop());
    }

    /**
     * Testaa että kun paikka olio pushataan pinoon palauttaa pop saman olion.
     */
    @Test
    public void testaaEttaPopPalauttaaPushatun() {
        Paikka p = new Paikka(1, 1, 1);
        pino.push(p);
        assertEquals(p, pino.pop());
    }

    /**
     * Testaa ettei tayteen pinoon laittaminen aiheuta poikkeusta.
     */
    @Test
    public void testaaEtteiTayteenPinoonLisaaminenAiheutaPoikkeusta() {
        for (int i = 0; i < 20; i++) {
            pino.push(new Paikka(1, 1, 1));
        }
    }
    
    /**
     * Testaa että vaikka pinoon laitetaan useita pysyy sen järjestys samana.
     */
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
