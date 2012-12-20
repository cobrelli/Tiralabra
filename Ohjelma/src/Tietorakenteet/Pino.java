package Tietorakenteet;

import Algoritmit.Paikka;

/**
 * Pino, jota käytetään aputietorakenteena iteratiivisessa DFS:ssä.
 * @author Cobrelli
 */
public class Pino {

    private Paikka[] alkiot;
    private int top;

    /**
     * Luo uuden pino-olion annetulla koolla sekä alustaa sen tyhjäksi.
     * @param koko      Kertoo halutun pinon koon.
     */
    public Pino(int koko) {
        top = -1;
        alkiot = new Paikka[koko];
    }

    /**
     * Poistaa ja palauttaa ylimmän olion pinossa.
     * @return          Palauttaa ylimmän olion.
     */
    public Paikka pop() {
        if (tyhja()) {
            return null;
        }
        Paikka poistettava = alkiot[top];
        top--;
        return poistettava;
    }

    /**
     * Puskee pinoon uuden olion.
     * @param uusi      Antaa viitteen uusimpaan lisättävään paikka olioon.
     */
    public void push(Paikka uusi) {
        if (taysi()) {
            return;
        }
        top++;
        alkiot[top] = uusi;
    }

    /**
     * Kertoo onko pino tyhjä.
     * @return          Palauttaa true jos pino on tyhjä, muuten false.
     */
    public boolean tyhja() {
        return top == -1;
    }

    /**
     * Kertoo onko pino taysi.
     * @return          Palauttaa true jos pino on täysi, false jos ei.
     */
    public boolean taysi() {
        return top == alkiot.length - 1;
    }
}
