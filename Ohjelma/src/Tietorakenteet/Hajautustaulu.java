/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import Algoritmit.Paikka;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Cobrelli
 */
public class Hajautustaulu {

    Lista[] taulukko;
    int koko;
    int kapasiteetti;

    public Hajautustaulu(int koko) {
        this.taulukko = new Lista[(koko)];
        this.kapasiteetti = koko;
        this.koko = 0;
    }

    public void put(Paikka p) {
        koko++;
        int idx = hashaa(p);

//        List<Paikka> L = taulukko[idx];
        if (taulukko[hashaa(p)] == null) {
            Lista L = new Lista();
            taulukko[idx] = L;
            L.add(p);

        } else {
            taulukko[idx].add(p);
        }
    }

    public Paikka get(Paikka p) {

        if(p == null){
            return null;
        }
        Lista L = taulukko[hashaa(p)];

        if(L == null){
            return null;
        }
        
        return L.etsiSolmu(p);
    }

    public int hashaa(Paikka p) {
        return p.hashCode() % kapasiteetti;
    }

    public int size() {
        return this.koko;
    }
}
