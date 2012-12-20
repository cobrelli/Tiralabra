/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import Algoritmit.Paikka;

/**
 * Linkitetty rakenne johon talletetaan paikka olioita.
 *
 * @author Cobrelli
 */
public class Lista {

    private ListaSolmu top;

    /**
     * Konstruktori luo uuden tyhjän listan.
     */
    public Lista() {
        top = null;
    }

    /**
     * Lisää halutun paikka olion listaan.
     *
     * @param p Antaa viitteen talletettavaan paikka olioon.
     */
    public void add(Paikka p) {
        ListaSolmu uusi = new ListaSolmu(p, top);
        top = uusi;
    }

    /**
     * Etsii halutun solmun listalta.
     *
     * @param p Antaa viitteen etsittävään paikka olioon.
     * @return Palauttaa etsityn paikka olion, jos sellainen löytyi, muuten
     * null.
     */
    public Paikka etsiSolmu(Paikka p) {

        if (top.p == p) {
            return top.p;
        }

        ListaSolmu vertailtava = top.seuraava;

        while (vertailtava != null) {
            if (vertailtava.p == p) {
                return vertailtava.p;
            } else {
                vertailtava = vertailtava.seuraava;
            }
        }
        return null;
    }
}
