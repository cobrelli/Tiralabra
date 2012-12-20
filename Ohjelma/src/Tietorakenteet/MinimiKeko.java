/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        this.alkiot = new Paikka[koko];
        this.heapSize = -1;
    }

    public void heapInsert(Paikka p) {
        heapSize++;
        int i = heapSize;
        while (i > 1 && alkiot[parent(i)].compareTo(p) > 0) {
            alkiot[i] = alkiot[parent(i)];
            i = parent(i);
            alkiot[i] = p;
        }
    }

    public Paikka heapDelMin() {
        Paikka min = alkiot[0];
        alkiot[0] = alkiot[heapSize];
        heapSize--;
        minHeapify(0);
        return min;
    }

    public void minHeapify(int i) {
//        Paikka l = alkiot[left(i)];
//        Paikka r = alkiot[right(i)];

        int l = left(i);
        int r = right(i);
        int pienin;

        if (r <= heapSize) {
            if (alkiot[l].compareTo(alkiot[r]) < 0) {
                pienin = l;
            } else {
                pienin = r;
            }
            if (alkiot[i].compareTo(alkiot[pienin]) > 0) {
                vaihda(i, pienin);
                minHeapify(pienin);
            }
        } else if (l == heapSize && alkiot[i].compareTo(alkiot[l]) > 0) {
            vaihda(i, l);
        }
    }

    public void heapDecKey(int i, int uusiArvo){
        if(uusiArvo<alkiot[i].getEtaisyys()){
            alkiot[i].setEtaisyys(uusiArvo);
            minHeapify(i);
        }
    }
    
    public int getLength() {
        return alkiot.length;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return (2 * 1) + 1;
    }

    public void vaihda(int i, int pienin) {
        //vaihda i ja pienin
        Paikka vaihdettava = alkiot[i];
        alkiot[i] = alkiot[pienin];
        alkiot[pienin] = vaihdettava;
    }
}
