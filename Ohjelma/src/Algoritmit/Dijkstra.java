package Algoritmit;

import java.util.PriorityQueue;

/**
 *
 * @author Cobrelli
 */
public class Dijkstra {

    public Dijkstra() {
    }

    public int ratkaiseSokkelo(int[][] sokkelo) {

        PriorityQueue<Paikka> q = new PriorityQueue<>();
        Paikka[][] paikat = new Paikka[sokkelo.length][sokkelo[0].length];

//        for (int i = 0; i < sokkelo.length; i++) {
//            for (int n = 0; n < sokkelo[0].length; n++) {
//                if (i == 0 && n == 0) {
//                    q.add(new Paikka(i, n, 1));
//                    muokattava[0][0] = 0;
//                } else {
//                    q.add(new Paikka(i, n, Integer.MAX_VALUE));
//                    muokattava[i][n] = Integer.MAX_VALUE;
//                }
//            }
//        }

        paikat[0][0] = new Paikka(0, 0, 0);
        
        while (!q.isEmpty()) {

            Paikka lahin = q.remove();

//            if (lahin.getY() == sokkelo.length - 1 && lahin.getX() == sokkelo[0].length - 1) {
//                return paikat[sokkelo.length - 1][sokkelo[0].length - 1];
//            }
//
//            if (paikat[lahin.getY()][lahin.getX()] == Integer.MAX_VALUE) {
//                break;
//            }

            relax(sokkelo, q, paikat, lahin, lahin.getY() + 1, lahin.getX());
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() + 1);
            relax(sokkelo, q, paikat, lahin, lahin.getY() - 1, lahin.getX());
            relax(sokkelo, q, paikat, lahin, lahin.getY(), lahin.getX() - 1);
        }

        return paikat[sokkelo.length-1][sokkelo[0].length-1].getEtaisyys();

    }

    public void relax(int[][] sokkelo, PriorityQueue<Paikka> q, Paikka[][] paikat,
            Paikka p, int y, int x) {
        if (x < 0 || y < 0 || x >= paikat[0].length || y >= paikat.length) {
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
