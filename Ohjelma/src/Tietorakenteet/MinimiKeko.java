package Tietorakenteet;

import Algoritmit.Paikka;

/**
 * MinimiKeko, jota käytetään priorityqueuen sijaan Dijkstran ja A* algoritmeissa.
 * @author Cobrelli
 */
public class MinimiKeko {

    int heapSize;
    Paikka[] alkiot;

    /**
     * Konstruktori luo uuden minimikeon, jonka heap-size alustetaan nollaan ja
     * jolle alustetaan uusi halutun kokoinen array.
     * @param koko          Kertoo halutun keon koon.
     */
    public MinimiKeko(int koko) {
        this.alkiot = new Paikka[koko + 1];
        this.heapSize = 0;
    }

    /**
     * Sijoittaa uuden olion kekoon. Olio sijoitetaan viimeiseksi ja tämän jälkeen
     * sitä nostellaan ylöspäin niin kauan ettei sen yläpuolella ole sitä itseään
     * suurempia olioita.
     * @param p         Antaa viitteen sijoitettavaan paikka olioon.
     */
    public void heapInsert(Paikka p) {

        if(heapSize == getLength()){
            return;
        }
        
        int i = heapSize;
        alkiot[i] = p;
        
        while (i > 0 && alkiot[parent(i)].compareTo(p) > 0) {
            vaihda(i, parent(i));
            i = parent(i);
        }

        heapSize++;
    }

    /**
     * Poistaa keon pienimmän eli päällimmäisen paikka olion ja palauttaa viitteen
     * siihen.
     * @return      Palauttaa pienimmän olion viitteen.
     */
    public Paikka heapDelMin() {

        if(heapSize<1){
            return null;
        }
        
        Paikka min = alkiot[0];
        alkiot[0] = alkiot[heapSize - 1];
        heapSize--;
        if (heapSize > 0) {
            minHeapify(0);
        }
        return min;
    }

    /**
     * Tarkistaa onko keko tyhjä.
     * @return          Jos tyhjä palauttaa true, muuten false.
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * Apumetodi keon operaatioille, joka huolehtii että keon alkiot ovat
     * järjestyksessä.
     * @param i         Kertoo järjesteltävän olion paikan keossa.
     */
    public void minHeapify(int i) {

        int l = left(i);
        int r = right(i);
        int pienin;

        if (l >= heapSize && r >= heapSize) {
            return;
        }

        if (alkiot[l].compareTo(alkiot[r]) < 0) {
            pienin = l;
        } else {
            pienin = r;
        }

        if (alkiot[r].compareTo(alkiot[pienin]) < 0) {
            pienin = r;
        }
        if (pienin != i) {
            vaihda(i, pienin);
            minHeapify(pienin);
        }
    }

    /**
     * Vähentää annetun paikan arvoa keossa.
     * @param i             Kertoo vähennettävän paikan.
     * @param uusiArvo      Kertoo uuden arvon joka paikalle asetetaan.
     */
    public void heapDecKey(int i, int uusiArvo) {
        if (uusiArvo < alkiot[i].getEtaisyys()) {
            alkiot[i].setEtaisyys(uusiArvo);
            minHeapify(i);
        }
    }

    /**
     * Getteri
     * @return          Palauttaa keon käyttämän taulukon pituuden.
     */
    public int getLength() {
        return alkiot.length;
    }

    /**
     * Kertoo solmun vanhemman indeksin.
     * @param i         Kertoo indeksin josta lasketaan tämän vanhempi.
     * @return          Palauttaa vanhemman indeksin.
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Laskee solmun vasemman lapsen indeksin.
     * @param i         Kertoo indeksin josta tämän vasen lapsi lasketaan.
     * @return          Palauttaa vasemman lapsen indeksin.
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Laskee solmun oikean lapsen indeksin.
     * @param i         Kertoo indeksin, josta tämän oikea lapsi lasketaan.
     * @return          Palauttaa oikean lapsen indeksin.
     */
    public int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Vaihtaa kaksi Paikka oliota keskenään.
     * @param i             Vaihdettava olio jonka tilalle pienin vaihdetaan.
     * @param pienin        Pienempi olio joka vaihdetaan ylemmäs keossa.
     */
    private void vaihda(int i, int pienin) {
        Paikka vaihdettava = alkiot[i];
        alkiot[i] = alkiot[pienin];
        alkiot[pienin] = vaihdettava;
    }
}
