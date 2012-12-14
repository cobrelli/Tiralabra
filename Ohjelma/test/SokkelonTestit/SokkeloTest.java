package SokkelonTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sokkelo.Sokkelo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Sokkelo olion testejä. Sisältää mm. testejä jotka tarkistavat ettei sokkelo
 * alussa tai maalissa ole testejä sekä että saatu sokkelo on yleensä edes
 * mahdollista läpäistä.
 *
 * @author Cobrelli
 */
public class SokkeloTest {

    Sokkelo s;

    /**
     * Konstruktori
     */
    public SokkeloTest() {
    }

    /**
     * Luo uuden Sokkelo olion, jonka tekemiä sokkeloita testataan
     */
    @Before
    public void setUp() {
        s = new Sokkelo();
    }

    /**
     * Tarkistaa että sokkeloa luotaessa aloituspaikka ei sisällä seinää eli 1
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaAlkuun() {
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[0][0]);
    }

    /**
     * Tarkistaa että sokkeloa luotaessa lopetuspaikka ei sisällä seinää eli 1
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaLoppuun() {
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[4][4]);
    }

    /**
     * Testaa että Sokkelo luo halutun korkuisen matriisin
     */
    @Test
    public void testaaEttaLuotusSokkeloOnOikeanKorkuinen(){
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(5, t.length);
    }
    
    /**
     * Testaa että Sokkelo luo halutun levyisen matriisin
     */
    @Test
    public void testaaEttaLuotusSokkeloOnOikeanLevyinen(){
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(5, t[0].length);
    }
    
    /**
     * Tarkastaa että sokkelo on mahdollista läpäistä
     */
    @Test
    public void testaaEttaSokkeloOnMahdollistaLapaista() {
    }
}
