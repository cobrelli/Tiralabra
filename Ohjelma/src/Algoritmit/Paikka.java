package Algoritmit;

/**
 * Paikkaluokka joka muuntaa matriisin koordinaatit yhteen olioon jolla sekä x
 * että y akseli tiedossa
 *
 * @author Cobrelli
 */
public class Paikka implements Comparable<Paikka> {

    private int y;
    private int x;
    private int etaisyys;
    private int etaisyysLoppuun;

    /**
     * Paikkaluokan konstruktori, joka saa arvot y ja x
     *
     * @param y             kertoo paikan y akselilla matriisissa
     * @param x             kertoo paikan x akselilla matriisissa
     * @param etaisyys      kertoo etäisyyden aloituspisteeseen.
     */
    public Paikka(int y, int x, int etaisyys) {
        this.x = x;
        this.y = y;
        this.etaisyys = etaisyys;
        this.etaisyysLoppuun = 0;
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

    /**
     * Getteri
     * @return      Palauttaa etäisyyden aloituspisteeseen.
     */
    public int getEtaisyys() {
        return this.etaisyys;
    }

    /**
     * Setteri, asettaa uuden etäisyyden alkupisteeseen.
     * @param etaisyys      Uusi etäisyys alkuun.
     */
    public void setEtaisyys(int etaisyys) {
        this.etaisyys = etaisyys;
    }

    /**
     * Setteri, asettaa uuden etäisyyden maaliin.
     * @param uusi          Uusi etäisyys maaliin.
     */
    public void setEtaisyysloppuun(int uusi) {
        this.etaisyysLoppuun = uusi;
    }

    /**
     * Getteri
     * @return      Palauttaa etäisyyden loppuun.
     */
    public int getEtaisyysLoppuun() {
        return this.etaisyysLoppuun;
    }

    @Override
    public int compareTo(Paikka o) {
        if ((this.etaisyys + this.etaisyysLoppuun) == (o.etaisyys + this.etaisyysLoppuun)) {
            return 0;
        } else if ((this.etaisyys + this.etaisyysLoppuun) > (o.etaisyys + this.etaisyysLoppuun)) {
            return 1;
        }
        return -1;
    }
}
