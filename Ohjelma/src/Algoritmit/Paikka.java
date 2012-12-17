package Algoritmit;

/**
 * Paikkaluokka joka muuntaa matriisin koordinaatit yhteen olioon jolla sekä
 * x että y akseli tiedossa
 * @author Cobrelli
 */
public class Paikka {

    private int y;
    private int x;
    
    /**
     * Paikkaluokan konstruktori, joka saa arvot y ja x
     * @param y kertoo paikan y akselilla matriisissa
     * @param x kertoo paikan x akselilla matriisissa
     */
    public Paikka(int y, int x){
        this.x = x;
        this.y = y;
    }

    /**
     * Getteri 
     * @return palauttaa Y akselin arvon
     */
    public int getY(){
        return this.y;
    }
    /**
     * Getteri
     * @return palauttaa X akselin arvon
     */
    public int getX(){
        return this.x;
    }
    
}
