/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author Cobrelli
 */
public class MinimiKeko {

    int heapSize;
    int[] alkiot;
    
    public MinimiKeko() {
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
