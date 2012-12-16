package Algoritmit;

/**
 *
 * @author Cobrelli
 */
public class BellmanFord {

    /**
     *
     */
    public BellmanFord() {
    }

    /**
     *
     * @param sokkelo
     * @return
     */
    public int ratkaiseSokkelo(int[][] sokkelo) {

        int[][] lapiKaytava = new int[sokkelo.length][sokkelo[0].length];

        for (int i = 0; i < sokkelo.length; i++) {
            for (int n = 0; n < sokkelo[0].length; n++) {
                if (sokkelo[i][n] != 1) {
                    lapiKaytava[i][n] = Integer.MAX_VALUE/2;
                }
            }
        }

        lapiKaytava[0][0] = 0;

        for (int i = 0; i < sokkelo.length; i++) {
            for (int n = 0; n < sokkelo[0].length; n++) {
                if (sokkelo[i][n] != 1) {
                    if (i == sokkelo.length - 1 && n == sokkelo[0].length - 1) {
                        System.out.println("apina");
                    } else {
                        TutkiKaikkiKaaret(sokkelo, lapiKaytava, i, n);
                    }
                }
            }
        }

        return lapiKaytava[lapiKaytava.length - 1][lapiKaytava[0].length - 1];
    }

    private void TutkiKaikkiKaaret(int[][] sokkelo, int[][] lapiKaytava, int y, int x) {
        if (onkoValidi(sokkelo, y - 1, x)) {
            relax(lapiKaytava, y, x, y - 1, x);
        }
        if (onkoValidi(sokkelo, y, x - 1)) {
            relax(lapiKaytava, y, x, y, x - 1);
        }
        if (onkoValidi(sokkelo, y + 1, x)) {
            relax(lapiKaytava, y, x, y + 1, x);
        }
        if (onkoValidi(sokkelo, y, x + 1)) {
            relax(lapiKaytava, y, x, y, x + 1);
        }
    }

    private boolean onkoValidi(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }

    private void relax(int[][] lapiKaytava, int y, int x, int yKohde, int xKohde) {
        if ((lapiKaytava[y][x] + 1) < lapiKaytava[yKohde][xKohde]) {
            lapiKaytava[yKohde][xKohde] = lapiKaytava[y][x] + 1;
        }
    }
}
