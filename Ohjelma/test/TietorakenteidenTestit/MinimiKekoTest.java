/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.MinimiKeko;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class MinimiKekoTest {

    MinimiKeko keko;

    public MinimiKekoTest() {
    }

    @Before
    public void setUp() {
        keko = new MinimiKeko(5);
    }

    @Test
    public void testaaEttaLisattyPaikkaLoytyyKeosta() {
        Paikka p = new Paikka(1, 1, 1);
        keko.heapInsert(p);
        assertEquals(p, keko.heapDelMin());
    }

    @Test
    public void testaaEttaPalauttaaNullJosTyhja(){
        assertEquals(null, keko.heapDelMin());
    }
    
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

    @Test
    public void testaaEttaHeapDecKeyToimii() {
        Paikka p = new Paikka(2, 2, 3);
        keko.heapInsert(p);
        keko.heapDecKey(0, 1);
        assertEquals(1, p.getEtaisyys());
    }
    
    @Test
    public void testaaEttaHeapDelMinPalauttaaPienimmänUseista(){
        for(int i = 5;i>0;i--){
            keko.heapInsert(new Paikka(i, i, i));
        }
        assertEquals(1, keko.heapDelMin().getEtaisyys());
    }
    
    @Test
    public void testaaEttaLeftPalauttaaLapsenIdx(){
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka isompi = new Paikka(2, 2, 3);

        keko.heapInsert(isompi);
        keko.heapInsert(pieni);
        
        assertEquals(1, keko.left(0));
    }
    
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
    
    @Test
    public void testaaEttaParentPalauttaaVanhemmanIdx(){
        Paikka pieni = new Paikka(1, 1, 1);
        Paikka isompi = new Paikka(2, 2, 3);

        keko.heapInsert(isompi);
        keko.heapInsert(pieni);
        
        assertEquals(0, keko.parent(1));
    }
}
