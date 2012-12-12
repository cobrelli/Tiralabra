
import java.util.Random;

/**
 * Luo uuden luokan Sokkelo, joka tarvittaessa generoi matriisi -sokkeloita.
 * Sokkelot luokaan looppaamalla ja jokaisen kohdalla arvotaan satunnaisesti luku
 * välillä 0-1, jos luku on 0.3 tai alle niin kohdalle asetetaan seinä. Seiniä ei
 * luoda aloitus ja lopetuspaikkoihin, jotka sijaisevat alku, vasen ylänurkka ja loppu,
 * oikea alanurkka. Tämän jälkeen tarkastetaan syvyyssuuntaisella haulla onko 
 * saatu sokkelo mahdollista yleensä läpäistä. Jos ei niin generoidaan uusia niin
 * kauan että sokkelo on läpäistävissä.
 * @author Cobrelli
 */
public class Sokkelo {

    Random r;
    boolean onkoLapaistavissa;

    /**
     *  Konstruktori alustaa Randomin
     */
    public Sokkelo() {
        r = new Random();
    }

    
    /**
     * Luo uuden halutunkorkuisen ja levyisen sokkelon
     * generoi sokkelon ja testattavan sokkelon, ja kutsuu sitten testaaSokkeloa, joka
     * tarkistaa onko se yleensä mahdollista ratkaista, jos ei niin generoi uuden
     * sokkelon niin kauan kunnes sokkelo on ratkaistavissa.
     * 
     * @param korkeus   kertoo matriisin korkeuden
     * @param leveys    kertoo matriisin leveys
     * @return          palauttaa ratkaistavissa olevan sokkelon matriisina
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

    /**
     * Testaa DFS:llä että annettu sokkelo on mahdollista läpäistä. Jos on 
     * saavutettu maalipiste niin sokkelo on ratkaistavissa ja muutetaan globaali
     * muuttuja true arvoon, muuten palautetaan false. Käyttää
     * validien liikkeiden määrittelyyn apumetodia onkoValidi.
     * 
     * @param sokkelo   on testattava aiemmin generoitu sokkelo
     * @param y         on sen hetkinen akselin Y paikka taulukossa, alkaa 0.
     * @param x         on sen hetkinen akselin X paikka taulukossa, alkaa 0.
     * @return          Palauttaa true tai false riippuen ratkaistavuudesta    
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

    /**
     * Tarkistaa onko siirtyminen validi liike. Ei valideja liikkeitä ovat
     * matriisin reunojen ylitse menevät siirtymiset tai jos paikka sisältää
     * seinän.
     * 
     * @param s     taulukko, jota tarkastellaan
     * @param y     paikka Y akselilla johon halutaan liikkua
     * @param x     paikka X akselilla johon halutaan liikkua
     * @return      palauttaa false jos ei validi, palauttaa true jos validi.
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
