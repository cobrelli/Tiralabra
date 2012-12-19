package Algoritmit;

import java.util.PriorityQueue;

/**
 *
 * @author Cobrelli
 */
public class Dijkstra {

    int loppuY;
    int loppuX;
    
    public Dijkstra() {
    }

    public int ratkaiseSokkelo(int[][] sokkelo, int loppuY, int loppuX) {

        this.loppuY = loppuY;
        this.loppuX = loppuX;
        
        PriorityQueue<Paikka> q = new PriorityQueue<>();
        Paikka[][] paikat = new Paikka[sokkelo.length][sokkelo[0].length];

        paikat[0][0] = new Paikka(0, 0, 0);
        q.add(paikat[0][0]);
        
        while (!q.isEmpty()) {

            Paikka lahin = q.remove();

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

    public void relax(int[][] sokkelo, PriorityQueue<Paikka> q, Paikka[][] paikat,
            Paikka p, int y, int x) {
        if (x < 0 || y < 0 || x >= paikat[0].length || y >= paikat.length || 
                sokkelo[y][x] == 1) {
            return;
        }

        int uusiEtaisyys = p.getEtaisyys() + 1;
        
        if(paikat[y][x] == null){
            paikat[y][x] = new Paikka(y, x, uusiEtaisyys);
            q.add(paikat[y][x]);
            return;
        }
        
        int vanhaEtaisyys = paikat[y][x].getEtaisyys();
        if(uusiEtaisyys<vanhaEtaisyys){
            q.remove(paikat[y][x]);
            paikat[y][x] = new Paikka(y, x, uusiEtaisyys);
            q.add(paikat[y][x]);
        }
    }
}
