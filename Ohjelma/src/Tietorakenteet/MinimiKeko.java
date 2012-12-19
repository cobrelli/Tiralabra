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
        this.heapSize = 0;
    }
    
    public void minHeapify(){
        
    }

    public int getLength(){
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
}
