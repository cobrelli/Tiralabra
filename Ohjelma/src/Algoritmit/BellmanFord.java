package Algoritmit;

/**
 * Bellman Ford algoritmi, joka käy lävitse kaikki solmut ja jokaisen solmun
 * kaaret.
 *
 * @author Cobrelli
 */
public class BellmanFord {

    int loppuY;
    int loppuX;
    
    /**
     * Konstruktori
     */
    public BellmanFord() {
    }

    /**
     * Päämetodi. Aluksi looppaa kaikki solmut läpi ja alustaa uuteen taulukkoon
     * niiden arvoksi todella suuren luvun. Tämän jälkeen asettaa alkuruudun 0.
     * Sitten se käy lävitse jokaisen solmun ja sen kaikki kaaret. Jos solmu on
     * seinä sitä ei käsitellä ollenkaan. Viimeistä solmua ei myöskään
     * käsitellä.
     *
     * @param sokkelo       Antaa tutkittavan sokkelon matriisina.
     * @param loppuY        Kertoo lopetuspaikan sijainnin y -akselilla.
     * @param loppuX        Kertoo lopetuspaikan sijainnin x -akselilla.
     * @return Palauttaa löydetyn reitin pituuden.
     */
    public int ratkaiseSokkelo(int[][] sokkelo, int loppuY, int loppuX) {

        this.loppuY = loppuY;
        this.loppuX = loppuX;
        
        int[][] lapiKaytava = new int[sokkelo.length][sokkelo[0].length];

        for (int i = 0; i < sokkelo.length; i++) {
            for (int n = 0; n < sokkelo[0].length; n++) {
                if (sokkelo[i][n] == 1) {
                } else {
                    lapiKaytava[i][n] = Integer.MAX_VALUE / 2;
                }
            }
        }

        int lapikaynnit = Math.max(sokkelo[0].length-1, sokkelo.length-1);
        lapiKaytava[0][0] = 0;

        for (int kierros = 0; kierros < lapikaynnit; kierros++) {
            for (int i = 0; i < sokkelo.length; i++) {
                for (int n = 0; n < sokkelo[0].length; n++) {
                    if (sokkelo[i][n] != 1) {
                        if (i == loppuY && n == loppuX) {
                        } else {
                            TutkiKaikkiKaaret(sokkelo, lapiKaytava, i, n);
                        }
                    }
                }
            }
        }

        return lapiKaytava[loppuY][loppuX];
    }

    /**
     * Apumetodi TutkiKaikkiKaaret käy jokaisen solmun kaaren läpi, tarkastaa
     * apumetodilta onkoValidi validiuden ja sitten relaxoi.
     *
     * @param sokkelo Matriisimuotoinen sokkelo, josta luetaan seinät ja
     * käytävät.
     * @param lapiKaytava Sokkelomatriisi johon lasketaan pituudet
     * @param y Solmun paikka y akselilla.
     * @param x Solmun paikka x akselilla.
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
     * Tarkistaa onko määritelty paikka sokkelossa validi. Eli voidaanko tänne
     * siirtyä.
     *
     * @param s Antaa testille sokkelon josta tarkistetaan.
     * @param y Kertoo tarkistettavan kohdan y-akselilla.
     * @param x Kertoo tarkistettavan kohdan x-akselilla.
     * @return Palauttaa false jos siirto ei validi, true jos on.
     */
    private boolean onkoValidi(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }

    /**
     * Relaksoi annetun kohdan. Eli tarkistaa onko siirto lyhyempi kuin
     * edelliset löydetyt reitit. Jos on niin merkitsee uuden pituuden.
     *
     * @param lapiKaytava Antaa tarkasteltavan sokkelon matriisiesityksen.
     * @param y Antaa tarkasteltavan sijainnin y -akselilla.
     * @param x Antaa tarkasteltavan sijainnin x -akselilla.
     * @param yKohde Antaa uuden mahdollisen reitin kohdan y-akselilla.
     * @param xKohde Antaa uuden mahdollisen reitin kohdan x-akselilla.
     */
    private void relax(int[][] lapiKaytava, int y, int x, int yKohde, int xKohde) {
        if ((lapiKaytava[y][x] + 1) < lapiKaytava[yKohde][xKohde]) {
            lapiKaytava[yKohde][xKohde] = lapiKaytava[y][x] + 1;
        }
    }
}
