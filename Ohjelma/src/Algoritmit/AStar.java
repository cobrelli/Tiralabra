/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmit;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Cobrelli
 */
public class AStar {
    
    public AStar(){
    }
    
    public int ratkaiseSokkelo(int[][] sokkelo) {

        PriorityQueue<PaikkaAStar> q = new PriorityQueue<>();
        PaikkaAStar[][] paikat = new PaikkaAStar[sokkelo.length][sokkelo[0].length];
        List kaydyt = new LinkedList();
        
        paikat[0][0] = new PaikkaAStar(0, 0, 0);
        paikat[0][0].setEtaisyysloppuun(arvioiEtaisyys(sokkelo, 0, 0));
        q.add(paikat[0][0]);
        
        while (!q.isEmpty()) {

            PaikkaAStar lahin = q.remove();
            kaydyt.add(lahin);
            
            relax(sokkelo, q, paikat, lahin, lahin.getY() + 1, lahin.getX(), kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() + 1, kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY() - 1, lahin.getX(), kaydyt);
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() - 1, kaydyt);
        }

        return paikat[sokkelo.length-1][sokkelo[0].length-1].getEtaisyys();

    }

    public void relax(int[][] sokkelo, PriorityQueue<PaikkaAStar> q, PaikkaAStar[][] paikat,
            PaikkaAStar p, int y, int x, List kaydyt) {
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
    
    public int arvioiEtaisyys(int[][] sokkelo, int y, int x){
        int etaisyys = (sokkelo.length-y)+(sokkelo[0].length-x);
        return etaisyys;
    }
}
