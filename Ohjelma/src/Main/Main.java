package Main;

import Algoritmit.AStar;
import Algoritmit.BellmanFord;
import Algoritmit.BruteForce;
import Algoritmit.Dijkstra;
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

        ajaEsimerkkiAjot();

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
    /**
     *
     */
    public static int[][] s1 = {{0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0}};
    /**
     *
     */
    public static int[][] s2 = {{0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0}};

    /**
     * Suorittaa esimerkit kaikista algoritmeista ja laskee niiden tehon
     * annetulle taulukolle.
     */
    public static void ajaEsimerkkiAjot() {
        Random random = new Random();

        Sokkelo s = new Sokkelo(random);

        BruteForce bf = new BruteForce();
        
        System.out.println("Esimerkki ajo:");
        System.out.println("Taulukon koko 150 x 150, maalipisteen sijainti: (15), (88)");
        System.out.println();
        
        int[][] toka = s.teeSokkelo(7000, 7000, 6900, 6900);

//        double luku = System.currentTimeMillis();
//        int pituus = bf.AjaBruteForce(toka, random, s.getLoppuY(), s.getLoppuX());
//        double luku2 = System.currentTimeMillis();
//
//        System.out.println("BruteForce " + (luku2 - luku));
//        System.out.println("Reitin pituus: " + pituus);
//
//        BellmanFord bell = new BellmanFord();
//
//        double bell1 = System.currentTimeMillis();
//        int pituusBell = bell.ratkaiseSokkelo(toka, s.getLoppuY(), s.getLoppuX());
//        double bell2 = System.currentTimeMillis();
//
//        System.out.println("bellman " + (bell2 - bell1));
//        System.out.println("Reitin pituus: " + pituusBell);

        Dijkstra d = new Dijkstra();

        double D1 = System.currentTimeMillis();
        int pituusD = d.ratkaiseSokkelo(toka, s.getLoppuY(), s.getLoppuX());
        double D2 = System.currentTimeMillis();

        System.out.println("Dijkstra " + (D2 - D1));
        System.out.println("Reitin pituus: " + pituusD);

//        AStar a = new AStar();
//
//        double A1 = System.currentTimeMillis();
//        int pituusA = a.ratkaiseSokkelo(toka, s.getLoppuY(), s.getLoppuX());
//        double A2 = System.currentTimeMillis();
//
//        System.out.println("AStar " + (A2 - A1));
//        System.out.println("Reitin pituus: " + pituusA);

        System.out.println();
        System.out.println("Läpikäyty sokkelo");
//        tulosta(toka);
    }
}
