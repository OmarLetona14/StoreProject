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

    public boolean serch(int idRef){
        BillNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdBill()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.info.getIdBill()==idRef){
                first = first.sig;
            }else{
                BillNodo aux = first;
                while(aux.sig.info.getIdBill()!=idRef){
                    aux = aux.sig;
                }
                BillNodo next = aux.sig.sig;
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        BillNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.info.getIdBill());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.info.getIdBill());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
    
}
