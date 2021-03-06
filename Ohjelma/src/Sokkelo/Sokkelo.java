package Sokkelo;

import Algoritmit.Paikka;
import Tietorakenteet.Pino;
import java.util.Random;

/**
 * Luo uuden luokan Sokkelo, joka tarvittaessa generoi matriisi -sokkeloita.
 * Sokkelot luokaan looppaamalla ja jokaisen kohdalla arvotaan satunnaisesti
 * luku välillä 0-1, jos luku on 0.3 tai alle niin kohdalle asetetaan seinä.
 * Seiniä ei luoda aloitus ja lopetuspaikkoihin, jotka sijaisevat alku, vasen
 * ylänurkka ja loppu, oikea alanurkka. Tämän jälkeen tarkastetaan
 * syvyyssuuntaisella haulla onko saatu sokkelo mahdollista yleensä läpäistä.
 * Jos ei niin generoidaan uusia niin kauan että sokkelo on läpäistävissä.
 *
 * @author Cobrelli
 */
public class Sokkelo {

    int loppuY;
    int loppuX;
    Random r;
    private boolean onkoLapaistavissa;

    /**
     * Konstruktori alustaa Randomin
     *
     * @param random Alustaa käytettävän randomin parametrina annetulla
     * randomilla
     */
    public Sokkelo(Random random) {
        r = random;

    }

    /**
     * Luo uuden halutunkorkuisen ja levyisen sokkelon generoi sokkelon ja
     * testattavan sokkelon, ja kutsuu sitten testaaSokkeloa, joka tarkistaa
     * onko se yleensä mahdollista ratkaista, jos ei niin generoi uuden sokkelon
     * niin kauan kunnes sokkelo on ratkaistavissa.
     *
     * @param korkeus kertoo matriisin korkeuden
     * @param leveys kertoo matriisin leveys
     * @param loppuY kertoo loppu pisteen paikan y -akselilla.
     * @param loppuX kertoo loppu pisteen paikan x -akselilla.
     * @return palauttaa ratkaistavissa olevan sokkelon matriisina
     */
    public int[][] teeSokkelo(int korkeus, int leveys, int loppuY, int loppuX) {
        int[][] sokkelo = new int[korkeus][leveys];
        int[][] testattava = new int[korkeus][leveys];
        generoiSokkelo(korkeus, leveys, sokkelo, testattava);
        this.loppuX = loppuX;
        this.loppuY = loppuY;

        onkoLapaistavissa = testaaSokkeloIteratiivisellaDFS(testattava);

        if (!onkoLapaistavissa) {
            return teeSokkelo(korkeus, leveys, loppuY, loppuX);
        }

        return sokkelo;
    }

    /**
     * Testaa DFS:llä että annettu sokkelo on mahdollista läpäistä. Jos on
     * saavutettu maalipiste niin sokkelo on ratkaistavissa ja muutetaan
     * globaali muuttuja true arvoon, muuten palautetaan false. Käyttää validien
     * liikkeiden määrittelyyn apumetodia onkoValidi. Ja pinoon puskemiseen
     * apumetodia puskeMahdollisetLiikkeetPinoon().
     *
     * @param sokkelo on testattava aiemmin generoitu sokkelo
     * @return Palauttaa true jos läpäistävissä, false jos ei.
     */
    private boolean testaaSokkeloIteratiivisellaDFS(int[][] sokkelo) {

//        Stack<Paikka> s = new Stack<>();
        Pino s = new Pino(sokkelo.length * sokkelo[0].length);
        int y = 0;
        int x = 0;

        puskeMahdollisetLiikkeetPinoon(sokkelo, 0, 0, s);

        while (!s.tyhja()) {

            Paikka p = s.pop();
            sokkelo[p.getY()][p.getX()] = 1;

            if (p.getX() == loppuX && p.getY() == loppuY) {
                return true;
            }

            sokkelo[y][x] = 1;
            puskeMahdollisetLiikkeetPinoon(sokkelo, p.getY(), p.getX(), s);
        }
        return false;
    }

    /**
     * Käy lävitse kaikki mahdolliset liikkumiset, tarkistaa onko validi ja jos
     * on niin puskee pinoon.
     *
     * @param sokkelo Nykyinen tarkasteltavana oleva sokkelo
     * @param y Paikka missä ollaan Y -akselin mukaisesti
     * @param x Paikka missä ollaan X -akselin mukaisesti
     * @param s Pino johon uudet liikkumiset asetetaan
     */
    private void puskeMahdollisetLiikkeetPinoon(int[][] sokkelo, int y, int x, Pino s) {
        if (onkoValidi(sokkelo, y - 1, x)) {
            s.push(new Paikka(y - 1, x, 0));
        }
        if (onkoValidi(sokkelo, y, x - 1)) {
            s.push(new Paikka(y, x - 1, 0));
        }
        if (onkoValidi(sokkelo, y + 1, x)) {
            s.push(new Paikka(y + 1, x, 0));
        }
        if (onkoValidi(sokkelo, y, x + 1)) {
            s.push(new Paikka(y, x + 1, 0));
        }
    }

    /**
     * Tarkistaa onko siirtyminen validi liike. Ei valideja liikkeitä ovat
     * matriisin reunojen ylitse menevät siirtymiset tai jos paikka sisältää
     * seinän.
     *
     * @param s taulukko, jota tarkastellaan
     * @param y paikka Y akselilla johon halutaan liikkua
     * @param x paikka X akselilla johon halutaan liikkua
     * @return palauttaa false jos ei validi, palauttaa true jos validi.
     */
    private boolean onkoValidi(int[][] s, int y, int x) {
        if (y > s.length - 1 || y < 0 || x < 0 || x > s[0].length - 1 || s[y][x] == 1) {
            return false;
        }
        return true;
    }

    /**
     * Generoi uuden sokkelon, jossa randomilla saadaan luku 0-1 välillä, jos
     * luku on korkeitaan 0.3 niin akselin paikalle luodaan seinä, muuten
     * käytävä. Sokkeloita luodaan erikseen palautettava ja testattava.
     *
     * @param korkeus kertoo sokkelon maksimikorkeuden
     * @param leveys kertoo sokkelon maksimileveyden
     * @param sokkelo matriisi johon generoidaan sokkelo
     * @param testattava on toinen matriisi johon generoidaan sokkelo, tätä myös
     * tutkitaan DFS:llä
     */
    private void generoiSokkelo(int korkeus, int leveys, int[][] sokkelo, int[][] testattava) {
        for (int i = 0; i < korkeus; i++) {
            for (int n = 0; n < leveys; n++) {
                double luku = r.nextDouble();
                if (i == 0 && n == 0 || i == loppuY && n == loppuX) {
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

    /**
     * Getteri
     *
     * @return Palauttaa lopetuspaikan pisteen Y -akselilla.
     */
    public int getLoppuY() {
        return this.loppuY;
    }

    /**
     * Getteri
     *
     * @return Palauttaa lopetuspaikan pisteen X -akselilla.
     */
    public int getLoppuX() {
        return this.loppuX;
    }

    /**
     * Setteri
     *
     * @param uusi Kertoo uuden loppu pisteen paikan sijainnin Y -akselilla.
     */
    public void setLoppuY(int uusi) {
        this.loppuY = uusi;
    }

    /**
     * Setteri
     *
     * @param uusi Kertoo uuden loppu pisteen paikan sijainnin X -akselilla.
     */
    public void setLoppuX(int uusi) {
        this.loppuX = uusi;
    }

    /**
     *
     * @return palauttaa viimeisimmän luodun sokkelon lapaistavyyden
     */
    public boolean getOnkoLapaistava() {
        return this.onkoLapaistavissa;
    }
}
