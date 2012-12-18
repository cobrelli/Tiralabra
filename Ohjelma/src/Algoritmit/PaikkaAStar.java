package Algoritmit;

/**
 * Paikkaluokka joka muuntaa matriisin koordinaatit yhteen olioon jolla sekä x
 * että y akseli tiedossa
 *
 * @author Cobrelli
 */
public class PaikkaAStar implements Comparable<PaikkaAStar> {

    private int y;
    private int x;
    private int etaisyys;
    private int etaisyysLoppuun;

    /**
     * Paikkaluokan konstruktori, joka saa arvot y ja x
     *
     * @param y kertoo paikan y akselilla matriisissa
     * @param x kertoo paikan x akselilla matriisissa
     */
    public PaikkaAStar(int y, int x, int etaisyys) {
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
    }

    /**
     * Getteri
     *
     * @return palauttaa Y akselin arvon
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getteri
     *
     * @return palauttaa X akselin arvon
     */
    public int getX() {
        return this.x;
    }

    public int getEtaisyys() {
        return this.etaisyys;
    }

    public void setEtaisyys(int etaisyys) {
        this.etaisyys = etaisyys;
    }

    public void setEtaisyysloppuun(int uusi) {
        this.etaisyysLoppuun = uusi;
    }

    public int getEtaisyysLoppuun() {
        return this.etaisyysLoppuun;
    }

    @Override
    public int compareTo(PaikkaAStar o) {
        if ((this.etaisyys + this.etaisyysLoppuun) == (o.etaisyys + this.etaisyysLoppuun)) {
            return 0;
        } else if ((this.etaisyys + this.etaisyysLoppuun) > (o.etaisyys + this.etaisyysLoppuun)) {
            return 1;
        }
        return -1;
    }
}
