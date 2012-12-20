/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

import Algoritmit.Paikka;

/**
 * Hajautustaulu luokka. Hajautustaululle toteutettu lisäys, haku, hashaus, sekä
 * se käyttää apunaan linkitettyjä listoja.
 *
 * @author Cobrelli
 */
public class Hajautustaulu {

    Lista[] taulukko;
    int koko;
    int kapasiteetti;

    /**
     * Konstruktori luo uuden hajautustaulun, jolla arraylisti johon talletetaan
     * yksittäiset listat, kapasiteetti ja taulun sisältämien olioiden määrä.
     *
     * @param koko Kertoo kuinka iso taulu luodaan.
     */
    public Hajautustaulu(int koko) {
        this.taulukko = new Lista[(koko)];
        this.kapasiteetti = koko;
        this.koko = 0;
    }

    /**
     * Metodi, jolla talletetaan tauluun uusi olio.
     *
     * @param p Antaa viitteen talletettavaan paikkaolioon.
     */
    public void put(Paikka p) {
        koko++;
        int idx = hashaa(p);

        if (taulukko[hashaa(p)] == null) {
            Lista L = new Lista();
            taulukko[idx] = L;
            L.add(p);

        } else {
            taulukko[idx].add(p);
        }
    }

    /**
     * Etsii ja palauttaa halutun olion taulusta jos se on siellä.
     *
     * @param p Kertoo haettavan paikka olion.
     * @return Palauttaa löytyessään viitteen paikkaolioon.
     */
    public Paikka get(Paikka p) {

        if (p == null) {
            return null;
        }
        Lista L = taulukko[hashaa(p)];

        if (L == null) {
            return null;
        }

        return L.etsiSolmu(p);
    }

    /**
     * Muuttaa talletettavan paikkaluokan hashcodeksi ja laskee siitä modulon,
     * jolloin saadaan sille arvo, joka talletetaan tauluun.
     *
     * @param p Kertoo paikkaolion, jolle etsitään paikka taulusta.
     * @return Palauttaa paikan johon olio talletetaan tai on talletettu.
     */
    private int hashaa(Paikka p) {
        return p.hashCode() % kapasiteetti;
    }
}
