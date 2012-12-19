/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * A* algoritmi, joka ratkaisee annetun sokkelon. Oletetaan että sokkelo on
 * läpäistävissä, eli lopetuspisteeseen on mahdollista päästä.
 * @author Cobrelli
 */
public class AStar {
    
    int loppuY;
    int loppuX;
    
    /**
     * Konstruktori
     */
    public AStar(){
    }
    
    /**
     * Kutsuu AStar oliota ratkaisemaan annetun sokkelo.
     * @param sokkelo       Antaa metodille ratkaistavan sokkelon.
     * @param loppuY        Kertoo lopetuspisteen paikan Y -akselilla.
     * @param loppuX        Kertoo lopetuspisteen paikan X -akselilla.
     * @return              Palauttaa lyhimmän reitin pituuden.
     */
    public int ratkaiseSokkelo(int[][] sokkelo, int loppuY, int loppuX) {

        this.loppuX = loppuX;
        this.loppuY = loppuY;
        
        PriorityQueue<PaikkaAStar> q = new PriorityQueue<>();
        PaikkaAStar[][] paikat = new PaikkaAStar[sokkelo.length][sokkelo[0].length];
//        List<PaikkaAStar> kaydyt = new LinkedList();
        Set<PaikkaAStar> kaydyt = new HashSet();
        
        paikat[0][0] = new PaikkaAStar(0, 0, 0);
        paikat[0][0].setEtaisyysloppuun(arvioiEtaisyys(sokkelo, 0, 0));
        q.add(paikat[0][0]);
        
        while (!q.isEmpty()) {

            PaikkaAStar lahin = q.remove();
            kaydyt.add(lahin);
            
            if(lahin.getY() == loppuY && lahin.getX() == loppuX){
                return paikat[loppuY][loppuX].getEtaisyys();
            }
            
            relax(sokkelo, q, paikat, lahin, lahin.getY() + 1, lahin.getX(), kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() + 1, kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY() - 1, lahin.getX(), kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() - 1, kaydyt);
        }

        return paikat[loppuY][loppuX].getEtaisyys();

    }

    /**
     * Relaksoi halutun paikan. Aluksi tarkistaa että kaari on validi. Tämän
     * jälkeen vertaa nykyisen etäisyyttä verrattavaan, jos löydetty reitti on
     * lyhyempi kuin vanha niin reitti asetetaan vanhan tilalle.
     * @param sokkelo       Antaa relaksointia varten tutkittavan sokkelon.
     * @param q             Antaa viitteen käytössä olevaan kekoon.
     * @param paikat        Antaa viitteen matriisiin, johon paikan on tallennettu.
     * @param p             Antaa viitteen yksittäiseen paikkaolioon, jota vertaillaan.
     * @param y             Tutkittavan paikan sijainti y -akselilla.
     * @param x             Tutkittavan paikan sijainti x -akselilla.
     * @param kaydyt        Hajautustaulu jo käydyistä sijainneista.
     */
    public void relax(int[][] sokkelo, PriorityQueue<PaikkaAStar> q, PaikkaAStar[][] paikat,
            PaikkaAStar p, int y, int x, Set kaydyt) {
        if (x < 0 || y < 0 || x >= paikat[0].length || y >= paikat.length || 
                sokkelo[y][x] == 1 || kaydyt.contains(paikat[y][x])) {
            return;
        }

        int uusiEtaisyys = p.getEtaisyys() + 1;
        
        if(paikat[y][x] == null){
            paikat[y][x] = new PaikkaAStar(y, x, uusiEtaisyys);
            paikat[y][x].setEtaisyysloppuun(arvioiEtaisyys(sokkelo, y, x));
            q.add(paikat[y][x]);
            return;
        }
        
        int vanhaEtaisyys = paikat[y][x].getEtaisyys();
        if(uusiEtaisyys<vanhaEtaisyys){
            q.remove(paikat[y][x]);
            paikat[y][x] = new PaikkaAStar(y, x, uusiEtaisyys);
            q.add(paikat[y][x]);
        }
    }
    
    /**
     * Algoritmin heuristiikkaa. Metodi arvioi etaisyyden nykyisestä sijainnista
     * loppupisteeseen.
     * @param sokkelo       Antaa viitteen tutkittavaan sokkeloon.
     * @param y             Sijainti y -akselilla.
     * @param x             Sijainti x -akselilla.
     * @return              Palauttaa arvioidun etäisyyden Integerinä.
     */
    public int arvioiEtaisyys(int[][] sokkelo, int y, int x){
        int etaisyys = (loppuY-y)+(loppuX-x);
        return etaisyys;
    }
}
