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

    /**
     * Konstuktori
     */
    public ListaTest() {
    }

    /**
     * Alustaa uuden listan testeille.
     */
    @Before
    public void setUp() {
        l = new Lista();
    }

    /**
     * Testaa että listaan lisätty solmu löytyy etsi metodilla.
     */
    @Test
    public void testaaEttaLisattySolmuLoytyyListasta() {
        Paikka p = new Paikka(1, 1, 1);
        l.add(p);
        assertEquals(p, l.etsiSolmu(p));
    }

    /**
     * Tarkistaa vielä että kun paikka lisätään on se etsittäessä varmasti sama
     * laskemalla x+y koordinaatit yhteen ja vertaamalla alkuperäiseen lisäykseen.
     */
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

    /**
     * Testaa että haluttu solmu löytyy etsi metodilla vaikka listassa olisi useita
     * talletettuja olioita.
     */
    @Test
    public void testaaEttaSolmuLoytyyListastaVaikkaLisataanUseita() {
        Paikka p = new Paikka(1, 1, 1);

        l.add(new Paikka(4, 4, 2));
        l.add(p);
        l.add(new Paikka(4, 4, 2));
        l.add(new Paikka(4, 4, 2));

        assertEquals(p, l.etsiSolmu(p));
    }
    
    /**
     * Testaa että olematonta etsiessä palautuu null.
     */
    @Test (expected = NullPointerException.class)
    public void testaaEttaPalauttaaNullJosseiLoydy(){
        l.etsiSolmu(new Paikka(1, 1, 2));
    }
}
