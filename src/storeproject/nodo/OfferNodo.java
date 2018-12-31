/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.nodo;

import storeproject.model.Offer;

public class OfferNodo {
    public Offer info;
    public OfferNodo sig;
    
    public OfferNodo(Offer informacion){
        info = informacion;
        sig = null;
    }
}
