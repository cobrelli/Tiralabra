package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.ListaSolmu;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Silmasolmuille tarkoitetut testit
 * @author Cobrelli
 */
public class ListaSolmuTest {
    
    /**
     * Konstruktori
     */
    public ListaSolmuTest() {
    }
    
    /**
     * 
     */
    @Before
    public void setUp() {
    }
    
    /**
     * Testaa että kun listasolmuun lisätään paikka olio, löytyy se sieltä myös
     * halutessa.
     */
    @Test
    public void testaaEttaListaSolmuLisaltaaOikeinPaikan(){
        Paikka eka = new Paikka(1, 1, 1);
        ListaSolmu ls = new ListaSolmu(eka, null);
        assertEquals(eka, ls.getPaikka());
    }
    
    /**
     * Testaa että viite seuraavaan solmuun palautuu oikein.
     */
    @Test
    public void testaaEttaPalauttaaViitteenSeuraavaanOikein(){
        ListaSolmu eka = new ListaSolmu(new Paikka(1, 1, 1), null);
        ListaSolmu toka = new ListaSolmu(new Paikka(1, 1, 1), eka);
        
        assertEquals(eka, toka.getSeuraava());
    }
}
