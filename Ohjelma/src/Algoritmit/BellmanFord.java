package Algoritmit;

/**
 * Bellman Ford algoritmi, joka käy lävitse kaikki solmut ja jokaisen solmun kaaret.
 * 
 * @author Cobrelli
 */
public class BellmanFord {

    /**
     * Konstruktori
     */
    public BellmanFord() {
    }

    /**
     * Päämetodi. Aluksi looppaa kaikki solmut läpi ja alustaa uuteen taulukkoon
     * niiden arvoksi todella suuren luvun. Tämän jälkeen asettaa alkuruudun 0.
     * Sitten se käy lävitse jokaisen solmun ja sen kaikki kaaret. Jos solmu on seinä
     * sitä ei käsitellä ollenkaan. Viimeistä solmua ei myöskään käsitellä.
     * 
     * @param sokkelo       Antaa tutkittavan sokkelon matriisina.
     * @return              Palauttaa löydetyn reitin pituuden.
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
                    } else {
                        TutkiKaikkiKaaret(sokkelo, lapiKaytava, i, n);
                    }
                }
            }
        }

        return lapiKaytava[lapiKaytava.length - 1][lapiKaytava[0].length - 1];
    }

    /**
     * Apumetodi TutkiKaikkiKaaret käy jokaisen solmun kaaren läpi, tarkastaa 
     * apumetodilta onkoValidi validiuden ja sitten relaxoi.
     * @param sokkelo           Matriisimuotoinen sokkelo, josta luetaan seinät ja 
     *                          käytävät.
     * @param lapiKaytava       Sokkelomatriisi johon lasketaan pituudet
     * @param y                 Solmun paikka y akselilla.
     * @param x                 Solmun paikka x akselilla.
     */
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

    /**
     *
     * @param s
     * @param y
     * @param x
     * @return
     */
    private boolean onkoValidi(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param lapiKaytava
     * @param y
     * @param x
     * @param yKohde
     * @param xKohde
     */
    private void relax(int[][] lapiKaytava, int y, int x, int yKohde, int xKohde) {
        if ((lapiKaytava[y][x] + 1) < lapiKaytava[yKohde][xKohde]) {
            lapiKaytava[yKohde][xKohde] = lapiKaytava[y][x] + 1;
        }
    }
}
