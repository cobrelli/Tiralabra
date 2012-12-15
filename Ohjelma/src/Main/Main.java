package Main;

import Algoritmit.BruteForce;
import Algoritmit.Paikka;
import Sokkelo.Sokkelo;
import java.util.Random;

/**
 *
 * @author Cobrelli
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();

        Paikka p = new Paikka(1, 1);

        Sokkelo s = new Sokkelo(random);

        BruteForce bf = new BruteForce();

        int[][] toka = s.teeSokkelo(3, 3);
//        tulosta(toka);
        double luku = System.currentTimeMillis();
        int pituus = bf.AjaBruteForce(toka, random);
        double luku2 = System.currentTimeMillis();
        
//        tulosta(toka);
        
        System.out.println("asd " + (luku2-luku));
        System.out.println(pituus);
        
    }

    /**
     *
     * @param s
     */
    public static void tulosta(int[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int n = 0; n < s.length; n++) {
                System.out.print(s[i][n]);
            }
            System.out.println();
        }
    }
}
