/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TietorakenteidenTestit;

import Algoritmit.Paikka;
import Tietorakenteet.Lista;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cobrelli
 */
public class ListaTest {

    Lista l;

    public ListaTest() {
    }

    @Before
    public void setUp() {
        l = new Lista();
    }

    @Test
    public void testaaEttaLisattySolmuLoytyyListasta() {
        Paikka p = new Paikka(1, 1, 1);
        l.add(p);
        assertEquals(p, l.etsiSolmu(p));
    }

    @Test
    public void testaaEttaLisatyllaJaLoydetyllaSamatXPlusY() {
        l.add(new Paikka(4, 4, 2));
        Paikka p = new Paikka(1, 1, 1);
        l.add(p);
        l.add(new Paikka(4, 4, 2));

        Paikka loydetty = l.etsiSolmu(p);

        int pituusP = (p.getX() + p.getY());
        int pituusLoydetty = (loydetty.getX() + loydetty.getY());

        assertEquals(pituusP, pituusLoydetty);
    }

    @Test
    public void testaaEttaSolmuLoytyyListastaVaikkaLisataanUseita() {
        Paikka p = new Paikka(1, 1, 1);

        l.add(new Paikka(4, 4, 2));
        l.add(p);
        l.add(new Paikka(4, 4, 2));
        l.add(new Paikka(4, 4, 2));

        assertEquals(p, l.etsiSolmu(p));
    }
    
    @Test (expected = NullPointerException.class)
    public void testaaEttaPalauttaaNullJosseiLoydy(){
        l.etsiSolmu(new Paikka(1, 1, 2));
    }
}
