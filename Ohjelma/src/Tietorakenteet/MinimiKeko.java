package Tietorakenteet;

import Algoritmit.Paikka;

/**
 *
 * @author Cobrelli
 */
public class MinimiKeko {

    int heapSize;
    Paikka[] alkiot;

    public MinimiKeko(int koko) {
        this.alkiot = new Paikka[koko + 1];
        this.heapSize = 0;
    }

    public void heapInsert(Paikka p) {

        alkiot[heapSize] = p;
        int i = heapSize;

        while (i > 0 && alkiot[parent(i)].compareTo(p) > 0) {
            vaihda(i, parent(i));
            i = parent(i);
        }

        heapSize++;
    }

    public Paikka heapDelMin() {

        Paikka min = alkiot[0];
        alkiot[0] = alkiot[heapSize - 1];
        heapSize--;
        if (heapSize > 0) {
            minHeapify(0);
        }
        return min;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

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

    public void heapDecKey(int i, int uusiArvo) {
        if (uusiArvo < alkiot[i].getEtaisyys()) {
            alkiot[i].setEtaisyys(uusiArvo);
            minHeapify(i);
        }
    }

    public int getLength() {
        return alkiot.length;
    }

    public int parent(int i) {
        return i - 1 / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void vaihda(int i, int pienin) {
        Paikka vaihdettava = alkiot[i];
        alkiot[i] = alkiot[pienin];
        alkiot[pienin] = vaihdettava;
    }
}
