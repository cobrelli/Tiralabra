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

    List[] taulukko;
    int koko;
    int kapasiteetti;

    public Hajautustaulu(int koko) {
        this.taulukko = new List[(koko)];
        this.kapasiteetti = koko;
        this.koko = 0;
    }

    public void put(Paikka p) {
        koko++;
//        int paikka = hashaa(p);
//        System.out.println(p.hashCode() % kapasiteetti);
        int idx = hashaa(p);

//        List<Paikka> L = taulukko[idx];
        if (taulukko[hashaa(p)] == null) {
            List<Paikka> L = new LinkedList();
            taulukko[idx] = L;
            L.add(p);

        } else {
            taulukko[idx].add(p);
        }
    }

    public Paikka get(Paikka p) {
        List<Paikka> L = taulukko[hashaa(p)];
//        System.out.println(p.hashCode() % kapasiteetti);

        for (Paikka paikka : L) {
            if (paikka == p) {
                return paikka;
            }
        }

        return null;
    }

    public int hashaa(Paikka p) {
//        System.out.println(p.hashCode() % kapasiteetti);
        return (p.getEtaisyys() + p.getEtaisyysLoppuun()) % kapasiteetti;
    }

    public int size() {
        return this.koko;
    }
}
