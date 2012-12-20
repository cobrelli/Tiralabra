
package Tietorakenteet;

import Algoritmit.Paikka;

/**
 *
 * @author Cobrelli
 */
public class ListaSolmu {
    
    Paikka p;
    ListaSolmu seuraava;
    
    public ListaSolmu(Paikka p, ListaSolmu seuraava){
        this.p = p;
        this.seuraava = seuraava;
    }
}
