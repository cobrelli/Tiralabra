package Algoritmit;

import Tietorakenteet.MinimiKeko;
import java.util.PriorityQueue;

/**
 * Dijkstran algoritmi. Tutkii lyhimmän etäisyyden käyttäen hyväksi minimikekoa.
 * @author Cobrelli
 */
public class Dijkstra {

    int loppuY;
    int loppuX;
    
    /**
     * Konstruktori.
     */
    public Dijkstra() {
    }

    /**
     * Metodi ratkaisesokkelo aloittaa sokkelon lyhimmän reitin pituuden tutkimisen.
     * Aluksi se alustaa aloituspisteen ja lisää sen paikka matriisiin ja kekoon.
     * Tämän jälkeen se aloittaa looppaamaan matriisia läpi niin kauan kunnes
     * haluttu paikka löytyy tai keko on tyhjä, eli reittiä ei löytynyt.
     * Algoritmi ottaa keosta lähimmän paikan ja relaksoi sen kaikki naapurit.
     * 
     * @param sokkelo       Antaa algoritmille viitteen tutkittavaan sokkeloon.
     * @param loppuY        Kertoo lopetuspaikan sijainnin y -akselilla.
     * @param loppuX        Kertoo lopetuspaikan sijainnin x -akselilla.
     * @return              Palauttaa lyhimmän reitin jos maali on löytynyt, ja
     *                      palauttaa nollan jos paikkaa ei ole löytynyt.
     */
    public int ratkaiseSokkelo(int[][] sokkelo, int loppuY, int loppuX) {

        this.loppuY = loppuY;
        this.loppuX = loppuX;
        
//        PriorityQueue<Paikka> q = new PriorityQueue<>();
        MinimiKeko q = new MinimiKeko(sokkelo.length*sokkelo[0].length);
        
        Paikka[][] paikat = new Paikka[sokkelo.length][sokkelo[0].length];

        paikat[0][0] = new Paikka(0, 0, 0);
        q.heapInsert(paikat[0][0]);
        
        while (!q.isEmpty()) {

            Paikka lahin = q.heapDelMin();

            if(lahin.getY() == loppuY && lahin.getX() == loppuX){
                return paikat[loppuY][loppuX].getEtaisyys();
            }
            
            relax(sokkelo, q, paikat, lahin, lahin.getY() + 1, lahin.getX());
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() + 1);
            relax(sokkelo, q, paikat, lahin, lahin.getY() - 1, lahin.getX());
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() - 1);
        }

        return paikat[loppuY][loppuX].getEtaisyys();

    }

    /**
     * Relaksoi halutun paikan.
     * @param sokkelo       Antaa viitteen tutkittavaan olioon.
     * @param q             Antaa viitteen kekoon, johon lähimmät talletetaan.
     * @param paikat        Antaa viitteen matriisiin, joka sisältää paikat.
     * @param p             Antaa viitteen paikkaan josta lähdettiin nykyistä kohtaa
     *                      tutkimaan.
     * @param y             Kertoo tutkittavan paikan sijainnin y -akselilla.
     * @param x             Kertoo tutkittavan paikan sijainnin x -akselilla.
     */
    private void relax(int[][] sokkelo, MinimiKeko q, Paikka[][] paikat,
            Paikka p, int y, int x) {
        if (x < 0 || y < 0 || x >= paikat[0].length || y >= paikat.length || 
                sokkelo[y][x] == 1) {
            return;
        }

        int uusiEtaisyys = p.getEtaisyys() + 1;
        
        if(paikat[y][x] == null){
            paikat[y][x] = new Paikka(y, x, uusiEtaisyys);
            q.heapInsert(paikat[y][x]);
            return;
        }
        
        int vanhaEtaisyys = paikat[y][x].getEtaisyys();
        if(uusiEtaisyys<vanhaEtaisyys){
            q.heapDelMin();
            paikat[y][x] = new Paikka(y, x, uusiEtaisyys);
            q.heapInsert(paikat[y][x]);
        }
    }
}
