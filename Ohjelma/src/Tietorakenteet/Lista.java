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
public class Lista {
    
    private ListaSolmu top;
    
    public Lista(){
        top = null;
    }
    
    public void add(Paikka p){
        ListaSolmu uusi = new ListaSolmu(p, top);
        top = uusi;
    }
    
    public Paikka etsiSolmu(Paikka p){
        
        if(top.p==p){
            return top.p;
        }
        
        ListaSolmu vertailtava = top.seuraava;
        
        while(vertailtava != null){
            if(vertailtava.p == p){
                return vertailtava.p;
            }else{
                vertailtava = vertailtava.seuraava;
            }
        }
        
        
        return null;
    }
}
