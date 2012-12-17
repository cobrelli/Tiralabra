package Algoritmit;

/**
 * Paikkaluokka joka muuntaa matriisin koordinaatit yhteen olioon jolla sekä
 * x että y akseli tiedossa
 * @author Cobrelli
 */
public class Paikka implements Comparable<Paikka> {

    private int y;
    private int x;
    private int etaisyys;
    
    /**
     * Paikkaluokan konstruktori, joka saa arvot y ja x
     * @param y kertoo paikan y akselilla matriisissa
     * @param x kertoo paikan x akselilla matriisissa
     */
    public Paikka(int y, int x, int etaisyys){
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
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

    public int getEtaisyys(){
        return this.etaisyys;
    }
    
    public void setEtaisyys(int etaisyys){
        this.etaisyys = etaisyys;
    }
    
    @Override
    public int compareTo(Paikka o) {
        if(this.etaisyys == o.etaisyys){
            return 0;
        }else if(this.etaisyys>o.etaisyys){
            return 1;
        }        
        return -1;
    }
        
}
