package Main;

import Algoritmit.Paikka;
import Sokkelo.Sokkelo;

public class Main {

    public static void main(String[] args) {

        Paikka p = new Paikka(1, 1);

        Sokkelo s = new Sokkelo();
        
        int[][] toka = s.teeSokkelo(10, 10);

        tulosta(toka);
    }

    public static void tulosta(int[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int n = 0; n < s.length; n++) {
                System.out.print(s[i][n]);
            }
            System.out.println();
        }
    }
}
