/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.Hajautustaulu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Cobrelli
 */
public class HajautustauluTest {
    
    Hajautustaulu ht;
    
    public HajautustauluTest() {
    }
    
    @Before
    public void setUp() {
        ht = new Hajautustaulu(10);
    }
    
     @Test
     public void testaaEttaLisattyPalautuuTaulusta() {
         Paikka p = new Paikka(1, 1, 1);
         ht.put(p);
         assertEquals(p, ht.get(p));
     }
     
     @Test
     public void testaaEttaHajautustauluunVoidaanLisataUseita(){
         Paikka ennenLisayksia = new Paikka(1, 1, 1);
         ht.put(ennenLisayksia);
         for(int i = 0;i<50;i++){
             ht.put(new Paikka(i, i, i));
         }
         assertEquals(ennenLisayksia, ht.get(ennenLisayksia));
     }
     
     @Test
     public void testaaEttaHakuTyhjastaPalauttaaNull(){
         assertEquals(null, ht.get(new Paikka(1, 1, 1)));
     }
     
}
