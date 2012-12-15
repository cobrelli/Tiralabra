package Sokkelo;

import Algoritmit.Paikka;
import java.util.Random;
import java.util.Stack;

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

    Random r;
    private boolean onkoLapaistavissa;

    /**
     * Konstruktori alustaa Randomin
     * @param random    Alustaa käytettävän randomin parametrina annetulla randomilla
     */
    public Sokkelo(Random random) {
        r = random;
    }

    /**
     *
     * @return palauttaa viimeisimmän luodun sokkelon lapaistavyyden
     */
    public boolean getOnkoLapaistava() {
        return this.onkoLapaistavissa;
    }

    /**
     * Luo uuden halutunkorkuisen ja levyisen sokkelon generoi sokkelon ja
     * testattavan sokkelon, ja kutsuu sitten testaaSokkeloa, joka tarkistaa
     * onko se yleensä mahdollista ratkaista, jos ei niin generoi uuden sokkelon
     * niin kauan kunnes sokkelo on ratkaistavissa.
     *
     * @param korkeus kertoo matriisin korkeuden
     * @param leveys kertoo matriisin leveys
     * @return palauttaa ratkaistavissa olevan sokkelon matriisina
     */
    public int[][] teeSokkelo(int korkeus, int leveys) {
        int[][] sokkelo = new int[korkeus][leveys];
        int[][] testattava = new int[korkeus][leveys];
        generoiSokkelo(korkeus, leveys, sokkelo, testattava);

        onkoLapaistavissa = testaaSokkeloIteratiivisellaDFS(testattava);

        if (!onkoLapaistavissa) {
            return teeSokkelo(korkeus, leveys);
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
     * @return      Palauttaa true jos läpäistävissä, false jos ei. 
     */
    public boolean testaaSokkeloIteratiivisellaDFS(int[][] sokkelo) {

        Stack<Paikka> s = new Stack<>();
        int y = 0;
        int x = 0;
        
        puskeMahdollisetLiikkeetPinoon(sokkelo, 0, 0, s);
        
        while (!s.isEmpty()) {
            
            Paikka p = s.pop();
            sokkelo[p.getY()][p.getX()] = 1;
            
            if(p.getX() == sokkelo[0].length-1 && p.getY() == sokkelo.length-1){
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
     * @param sokkelo       Nykyinen tarkasteltavana oleva sokkelo
     * @param y             Paikka missä ollaan Y -akselin mukaisesti
     * @param x             Paikka missä ollaan X -akselin mukaisesti
     * @param s             Pino johon uudet liikkumiset asetetaan
     */
    public void puskeMahdollisetLiikkeetPinoon(int[][] sokkelo, int y, int x, Stack s) {
        if (onkoValidi(sokkelo, y - 1, x)) {
            s.add(new Paikka(y-1, x));
        }
        if (onkoValidi(sokkelo, y, x - 1)) {
            s.add(new Paikka(y, x-1));
        }
        if (onkoValidi(sokkelo, y + 1, x)) {
            s.add(new Paikka(y+1, x));
        }
        if (onkoValidi(sokkelo, y, x + 1)) {
            s.add(new Paikka(y, x+1));
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
    public boolean onkoValidi(int[][] s, int y, int x) {
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
