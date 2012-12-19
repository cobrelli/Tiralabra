package Algoritmit;

import java.util.Random;

/**
 * BruteForce menetelmällä sokkelon läpikäyntiä. Tarkoituksena olla mahdollisimman
 * tehoton, jotta saadaan vertailukohtaa oikeisiin pathfinding algoritmeihin.
 * @author Cobrelli
 */
public class BruteForce {

    int loppuY;
    int loppuX;
    
    /**
     * Konstruktoi uuden BruteForce luokan jolla voidaan ajaa erilaisia sokkeloita
     * lävitse ja tarkastella selvitysten nopeutta.
     */
    public BruteForce() {
    }

    /**
     * Ajaa bruteforcettamalla sokkelon lävitse. Ideana on satunnaisesti liikkua
     * johonkin suuntaan ja tarkistaa onko siirto validi, jos ei niin seuraavalla
     * kierrokselle haetaan uusi paikka. Oletuksena sokkelossa on että se on
     * läpäistävissä, muuten se jää looppaamaan. Suoritus päättyy kun saavutetaan
     * maaliruutu.
     * 
     * @param sokkelo       On sokkelo johon algoritmia lähdetään ajamaan.
     * @param random        Random oliolla saadaan satunnaisuus mukaan, jolloin
     *                      liikutaan satunnaisesti johonkin suuntaan.
     * @return              Palauttaa reitin kokonaispituuden.
     */
    public int AjaBruteForce(int[][] sokkelo, Random random, int loppuY, int loppuX) {
        
        this.loppuY = loppuY;
        this.loppuX = loppuX;
        
        int kokonaisPituus = 0;

        int y = 0;
        int x = 0;
        int luku;

        while (true) {

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
            
            if(x == loppuX && y == loppuY){
                break;
            }
            
        }

        return kokonaisPituus;
    }

    /**
     * Siirtymisen validiuden tarkistamisessa käytettävä apumetodi.
     * @param s     Sokkelo josta tarkistetaan paikkaa.
     * @param y     Kertoo haettavan kohdan paikan y -akselilla.
     * @param x     Kertoo haettavan kohdan paikan x -akselilla.
     * @return      Jos siirto voidaan suorittaa palauttaa true, muuten false.
     */
    private boolean onkoSallittuLiike(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }
}
