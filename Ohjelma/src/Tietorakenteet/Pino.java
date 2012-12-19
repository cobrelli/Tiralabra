package Tietorakenteet;

import Algoritmit.Paikka;

/**
 *
 * @author Cobrelli
 */
public class Pino {

    private Paikka[] alkiot;
    private int top;

    public Pino(int koko) {
        top = -1;
        alkiot = new Paikka[koko];
    }

    public Paikka pop() {
        if (tyhja()) {
            return null;
        }
        Paikka poistettava = alkiot[top];
        top--;
        return poistettava;
    }

    public void push(Paikka uusi) {
        if (taysi()) {
            return;
        }
        top++;
        alkiot[top] = uusi;
    }

    public boolean tyhja() {
        return top == -1;
    }

    public boolean taysi() {
        return top == alkiot.length - 1;
    }
}
