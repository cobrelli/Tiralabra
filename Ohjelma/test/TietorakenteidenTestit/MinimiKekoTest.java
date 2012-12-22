package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.MinimiKeko;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Minimikeolle tarkoitetut testit.
 * @author Cobrelli
 */
public class MinimiKekoTest {

    MinimiKeko keko;

    /**
     * Konstruktori.
     */
    public MinimiKekoTest() {
    }

    /**
     * Alustaa testeille uuden minimikeon.
     */
    @Before
    public void setUp() {
        keko = new MinimiKeko(5);
    }

    /**
     * Testaa että kekoon lisätty alkio löytyy heapdelmin metodilla.
     */
    @Test
    public void testaaEttaLisattyPaikkaLoytyyKeosta() {
        Paikka p = new Paikka(1, 1, 1);
        keko.heapInsert(p);
        assertEquals(p, keko.heapDelMin());
    }

    /**
     * Testaa että tyhjästä listasta haettaessa palautuu null.
     */
    @Test
    public void testaaEttaPalauttaaNullJosTyhja(){
        assertEquals(null, keko.heapDelMin());
    }
    
    /**
     * Testaa että HeapDelMin metodi palauttaa varmasti pienimmän olion.
     */
    @Test
    public void testaaEttaHeapDelMinPalauttaaPienimmän() {
        Paikka iso = new Paikka(2, 2, 7);
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka keski = new Paikka(2, 2, 3);

        keko.heapInsert(keski);
        keko.heapInsert(pieni);
        keko.heapInsert(iso);

        assertEquals(pieni, keko.heapDelMin());
    }

    /**
     * Testaa että heapdeckey metodi vähentää oikeasti paikkaolion arvoa.
     */
    @Test
    public void testaaEttaHeapDecKeyToimii() {
        Paikka p = new Paikka(2, 2, 3);
        keko.heapInsert(p);
        keko.heapDecKey(0, 1);
        assertEquals(1, p.getEtaisyys());
    }
    
    /**
     * Testaa että keko järjestyy oikein ja pienin palautuu HeapDelMin metodilla.
     */
    @Test
    public void testaaEttaHeapDelMinPalauttaaPienimmänUseista(){
        for(int i = 5;i>0;i--){
            keko.heapInsert(new Paikka(i, i, i));
        }
        assertEquals(1, keko.heapDelMin().getEtaisyys());
    }
    
    /**
     * Testaa että left kertoo vasemman lapsen indeksin.
     */
    @Test
    public void testaaEttaLeftPalauttaaLapsenIdx(){
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka isompi = new Paikka(2, 2, 3);

        keko.heapInsert(isompi);
        keko.heapInsert(pieni);
        
        assertEquals(1, keko.left(0));
    }
    
    /**
     * Testaa että right kertoo oikean lapsen indeksin.
     */
    @Test
    public void testaaEttaRightPalauttaaLapsenIdx(){
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka isompi = new Paikka(2, 2, 3);
        Paikka isoin = new Paikka(3,3,4);

        keko.heapInsert(isompi);
        keko.heapInsert(pieni);
        keko.heapInsert(isoin);
        
        assertEquals(2, keko.right(0));
    }
    
    /**
     * Testaa että parent palauttaa vanhemman indeksin.
     */
    @Test
    public void testaaEttaParentPalauttaaVanhemmanIdx(){
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka isompi = new Paikka(2, 2, 3);

        keko.heapInsert(isompi);
        keko.heapInsert(pieni);
        
        assertEquals(0, keko.parent(1));
    }
}
