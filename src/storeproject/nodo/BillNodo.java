/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.nodo;

import storeproject.model.Bill;

public class BillNodo {
    
    public Bill info;
    public BillNodo sig;
    
    public BillNodo(Bill informacion){
        info = informacion;
        sig = null;
    }
    
}
