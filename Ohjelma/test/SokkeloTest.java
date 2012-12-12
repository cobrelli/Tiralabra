/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cobrelli
 */
public class SokkeloTest {

    Sokkelo s;

    /**
     *
     */
    public SokkeloTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        s = new Sokkelo();
    }

    /**
     *
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaAlkuun() {
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[0][0]);
    }

    /**
     *
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaLoppuun() {
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[4][4]);
    }

    //tee testi joka tarkastaa että sokkelo on mahdollista läpäistä
    /**
     *
     */
    @Test
    public void testaaEttaSokkeloOnMahdollistaLapaista() {
    }
}
