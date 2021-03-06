package SokkelonTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Sokkelo.Sokkelo;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Sokkelo olion testejä. Sisältää mm. testejä jotka tarkistavat ettei sokkelo
 * alussa tai maalissa ole testejä sekä että saatu sokkelo on yleensä edes
 * mahdollista läpäistä.
 *
 * @author Cobrelli
 */
public class SokkeloTest {

    Sokkelo s;

    /**
     * Konstruktori
     */
    public SokkeloTest() {
    }

    /**
     * Luo uuden Sokkelo olion, jonka tekemiä sokkeloita testataan
     */
    @Before
    public void setUp() {
        Random random = new Random();
        s = new Sokkelo(random);
    }

    /**
     * Tarkistaa että sokkeloa luotaessa aloituspaikka ei sisällä seinää eli 1
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaAlkuun() {
        int[][] t = s.teeSokkelo(5, 5,4,4);
        assertEquals(0, t[0][0]);
    }

    /**
     * Tarkistaa että sokkeloa luotaessa lopetuspaikka ei sisällä seinää eli 1
     */
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaLoppuun() {
        int[][] t = s.teeSokkelo(5, 5,4,4);
        assertEquals(0, t[4][4]);
    }

    /**
     * Testaa että Sokkelo luo halutun korkuisen matriisin
     */
    @Test
    public void testaaEttaLuotusSokkeloOnOikeanKorkuinen() {
        int[][] t = s.teeSokkelo(5, 5,4,4);
        assertEquals(5, t.length);
    }

    /**
     * Testaa että Sokkelo luo halutun levyisen matriisin
     */
    @Test
    public void testaaEttaLuotusSokkeloOnOikeanLevyinen() {
        int[][] t = s.teeSokkelo(5, 5,4,4);
        assertEquals(5, t[0].length);
    }

    /**
     * Tarkistaa että pieni palautettava sokkelo on läpäistävissä, eli sokkelon oma
     * testi on mennyt läpi.
     */
    @Test
    public void testaaEttaPalautettavaPieniSokkeloPalauttaaTrue() {
        int[][] t = s.teeSokkelo(3, 3,2,2);

        assertTrue(s.getOnkoLapaistava());
    }

    /**
     * Tarkistaa että suuri palautettava sokkelo on läpäistävissä, eli sokkelon oma
     * testi on mennyt läpi.
     */
    @Test
    public void testaaEttaPalautettavaSuuriSokkeloPalauttaaTrue() {
        int[][] t = s.teeSokkelo(160, 160,159,159);

        assertTrue(s.getOnkoLapaistava());
    }
    
    /**
     * Tarkistaa 10 eri sokkelolla että kaikki sokkelot ovat läpäistäviä.
     */
    @Test
    public void testaaUseastiEttaPalautettavaSuuriSokkeloPalauttaaTrue() {
        boolean lapaistavyys = false;
        
        for(int i = 0;i<10;i++){
            int[][] t = s.teeSokkelo(160, 160,159,159);
            lapaistavyys = s.getOnkoLapaistava();
            if(!lapaistavyys){
                break;
            }
        }
        
        assertTrue(lapaistavyys);
    }

    /**
     * Tarkastaa että sokkelo on mahdollista läpäistä
     */
    @Test
    public void testaaEttaJoGeneroituSokkeloOnMahdollistaLapaista() {
        int[][] t = s.teeSokkelo(5, 5,4,4);
    
        testaaSokkelo(t, 0, 0);
        
        assertTrue(s.getOnkoLapaistava());
    }

    boolean onkoLapaistavissa;
    
    /**
     * Testaa DFS:llä että annettu sokkelo on mahdollista läpäistä. Jos on 
     * saavutettu maalipiste niin sokkelo on ratkaistavissa ja muutetaan globaali
     * muuttuja true arvoon, muuten palautetaan false. Käyttää
     * validien liikkeiden määrittelyyn apumetodia onkoValidi. Tämä on vielä
     * Sokkelo luokan oman DFS:n lisäksi toinen testi, joka tarkastaa että sokkelo
     * on oikeasti tuottanut läpäistävän sokkelon.
     * 
     * @param sokkelo   on testattava aiemmin generoitu sokkelo
     * @param y         on sen hetkinen akselin Y paikka taulukossa, alkaa 0.
     * @param x         on sen hetkinen akselin X paikka taulukossa, alkaa 0.
     */
    public void testaaSokkelo(int[][] sokkelo, int y, int x) {

        if (y == sokkelo.length - 1 && x == sokkelo[0].length - 1) {
            onkoLapaistavissa = true;
            return;
        }

        sokkelo[y][x] = 1;

        if (onkoValidi(sokkelo, y - 1, x)) {
            testaaSokkelo(sokkelo, y - 1, x);
        }
        if (onkoValidi(sokkelo, y, x - 1)) {
            testaaSokkelo(sokkelo, y, x - 1);
        }
        if (onkoValidi(sokkelo, y + 1, x)) {
            testaaSokkelo(sokkelo, y + 1, x);
        }
        if (onkoValidi(sokkelo, y, x + 1)) {
            testaaSokkelo(sokkelo, y, x + 1);
        }
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
}
