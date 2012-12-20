/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.ListaSolmu;
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
public class ListaSolmuTest {
    
    public ListaSolmuTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testaaEttaListaSolmuLisaltaaOikeinPaikan(){
        Paikka eka = new Paikka(1, 1, 1);
        ListaSolmu ls = new ListaSolmu(eka, null);
        assertEquals(eka, ls.getPaikka());
    }
    
    @Test
    public void testaaEttaPalauttaaViitteenSeuraavaanOikein(){
        ListaSolmu eka = new ListaSolmu(new Paikka(1, 1, 1), null);
        ListaSolmu toka = new ListaSolmu(new Paikka(1, 1, 1), eka);
        
        assertEquals(eka, toka.getSeuraava());
    }
}
