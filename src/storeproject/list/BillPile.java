/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.list;

import storeproject.model.Bill;
import storeproject.model.CreditCard;
import storeproject.model.User;
import storeproject.nodo.BillNodo;

public class BillPile {
    
    private BillNodo first;
    int size=1;
    
    public BillPile(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void push(User user, CreditCard creditCard, String address, String name, String NIT){
        Bill bill = new Bill(size, user, creditCard, address, name, NIT);
        BillNodo newNodo = new BillNodo(bill);
        if(empty()){   
            first = newNodo;
        }else{
            BillNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
    }
    
    public Bill getBillAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
                return first.info;
            }else{
                BillNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
}
