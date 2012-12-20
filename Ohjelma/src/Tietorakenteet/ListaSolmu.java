
package Tietorakenteet;

import Algoritmit.Paikka;

/**
 * Listan sisältämien solmujen luokka.
 * @author Cobrelli
 */
public class ListaSolmu {
    
    private Paikka p;
    private ListaSolmu seuraava;
    
    /**
     * Konstruktori, luo uuden solmun jolla tallessa paikka olio sekä tieto seuraavasta
     * solmusta listalla.
     * @param p             Tallentaa solmuun viitteen paikka oliosta.
     * @param seuraava      Kertoo seuraavan listasolmun.
     */
    public ListaSolmu(Paikka p, ListaSolmu seuraava){
        this.p = p;
        this.seuraava = seuraava;
    }
    
    /**
     * Getteri
     * @return          Palauttaa viitteen paikka olioon.
     */
    public Paikka getPaikka(){
        return p;
    }
    
    /**
     * Getteri
     * @return          Palauttaa viitteen seuraavaan listasolmuun.
     */
    public ListaSolmu getSeuraava(){
        return seuraava;
    }
}
