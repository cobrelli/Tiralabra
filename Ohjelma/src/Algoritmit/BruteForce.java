/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import java.util.Random;

/**
 *
 * @author Cobrelli
 */
public class BruteForce {

    /**
     * Konstruktoi uuden BruteForce luokan jolla voidaan ajaa erilaisia sokkeloita
     * lävitse ja tarkastella selvitysten nopeutta.
     */
    public BruteForce() {
    }

    /**
     *
     * @param sokkelo
     * @param random
     * @return
     */
    public int AjaBruteForce(int[][] sokkelo, Random random) {
        int kokonaisPituus = 0;

        int y = 0;
        int x = 0;
        int luku;

        while (x != sokkelo[0].length-1 && y != sokkelo.length-1) {

            luku = random.nextInt(4) + 1;

            if (luku == 1) {
                if (onkoSallittuLiike(sokkelo, y - 1, x)) {
                    y--;
                    kokonaisPituus++;
                }
            } else if (luku == 2) {
                if (onkoSallittuLiike(sokkelo, y, x - 1)) {
                    x--;
                    kokonaisPituus++;
                }
            } else if (luku == 3) {
                if (onkoSallittuLiike(sokkelo, y + 1, x)) {
                    y++;
                    kokonaisPituus++;
                }
            } else if (luku == 4) {
                if (onkoSallittuLiike(sokkelo, y, x + 1)) {
                    x++;
                    kokonaisPituus++;
                }
            }
            
        }

        return kokonaisPituus;
    }

    /**
     *
     * @param s
     * @param y
     * @param x
     * @return
     */
    public boolean onkoSallittuLiike(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }
}
