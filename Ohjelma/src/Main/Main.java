package Main;

import Algoritmit.BellmanFord;
import Algoritmit.BruteForce;
import Algoritmit.Dijkstra;
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

//        Paikka p = new Paikka(1, 1);

        Sokkelo s = new Sokkelo(random);

//        double bf1 = System.currentTimeMillis();
        BruteForce bf = new BruteForce();
//        double bf2 = System.currentTimeMillis();

        int[][] toka = s.teeSokkelo(3000,3000);
//        tulosta(toka);
        
//        double luku = System.currentTimeMillis();
//        int pituus = bf.AjaBruteForce(toka, random);
//        double luku2 = System.currentTimeMillis();
////
//////        tulosta(toka);
////
//        System.out.println("BruteForce " + (luku2 - luku));
//        System.out.println(pituus);
//
//        System.out.println();
//        
//        BellmanFord bell = new BellmanFord();
//        
//        double bell1 = System.currentTimeMillis();
//        int pituusBell = bell.ratkaiseSokkelo(toka);
//        double bell2 = System.currentTimeMillis();
//
//        System.out.println("bellman " + (bell2-bell1));
//        System.out.println(pituusBell);
//
//        System.out.println();
        Dijkstra d = new Dijkstra();
        
        double D1 = System.currentTimeMillis();
        int pituusD = d.ratkaiseSokkelo(toka);
        double D2 = System.currentTimeMillis();
        
        System.out.println("Dijkstra " + (D2-D1));
        System.out.println(pituusD);

//        tulosta(toka);
    }

    /**
     *
     * @param s
     */
    public static void tulosta(int[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int n = 0; n < s[0].length; n++) {
                System.out.print(s[i][n]);
            }
            System.out.println();
        }
    }
    public static int[][] s1 = {{0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0}};
}
