
import java.util.Random;

/**
 *
 * @author Cobrelli
 */
public class Sokkelo {

    Random r;
    boolean onkoLapaistavissa;

    /**
     *
     */
    public Sokkelo() {
        r = new Random();
    }

    
    /**
     *
     * @param korkeus
     * @param leveys
     * @return
     */
    public int[][] teeSokkelo(int korkeus, int leveys) {
        int[][] sokkelo = new int[korkeus][leveys];
        int[][] testattava = new int[korkeus][leveys];
        generoiSokkelo(korkeus, leveys, sokkelo, testattava);

        onkoLapaistavissa = false;

        testaaSokkelo(testattava, 0, 0);

        if (!onkoLapaistavissa) {
            return teeSokkelo(korkeus, leveys);
        }

        return sokkelo;
    }

    //testaa DFS:llä että annettu sokkelo on mahdollista läpäistä
    
    /**
     *
     * @param sokkelo
     * @param y
     * @param x
     * @return
     */
    public boolean testaaSokkelo(int[][] sokkelo, int y, int x) {

        if (y == sokkelo.length - 1 && x == sokkelo[0].length - 1) {
            onkoLapaistavissa = true;
            return true;
        }

        if (onkoValidi(sokkelo, y - 1, x)) {
            sokkelo[y][x] = 1;
            testaaSokkelo(sokkelo, y - 1, x);
        }
        if (onkoValidi(sokkelo, y, x - 1)) {
            sokkelo[y][x] = 1;
            testaaSokkelo(sokkelo, y, x - 1);
        }
        if (onkoValidi(sokkelo, y + 1, x)) {
            sokkelo[y][x] = 1;
            testaaSokkelo(sokkelo, y + 1, x);
        }
        if (onkoValidi(sokkelo, y, x + 1)) {
            sokkelo[y][x] = 1;
            testaaSokkelo(sokkelo, y, x + 1);
        }
        return false;
    }

    //tarkistaa onko siirtyminen mahdollista
    /**
     *
     * @param s
     * @param y
     * @param x
     * @return
     */
    public boolean onkoValidi(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param korkeus
     * @param leveys
     * @param sokkelo
     * @param testattava
     */
    public void generoiSokkelo(int korkeus, int leveys, int[][] sokkelo, int[][] testattava) {
        for (int i = 0; i < korkeus; i++) {
            for (int n = 0; n < leveys; n++) {
                double luku = r.nextDouble();
                if (i == 0 && n == 0 || i == korkeus - 1 && n == leveys - 1) {
                    sokkelo[i][n] = 0;
                    testattava[i][n] = 0;
                } else {
                    if (luku <= 0.3) {
                        sokkelo[i][n] = 1;
                        testattava[i][n] = 1;
                    } else {
                        sokkelo[i][n] = 0;
                        testattava[i][n] = 0;
                    }
                }
            }
        }
    }
}
