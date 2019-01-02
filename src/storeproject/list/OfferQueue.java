/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.list;

import storeproject.model.Offer;
import storeproject.nodo.OfferNodo;

public class OfferQueue {
    
    private OfferNodo first;
    int size=1;
    
    public OfferQueue(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(String description, double discount, SimplyLinkedCircularListProduct products){
        Offer offer = new Offer(size, description, discount, products);
        OfferNodo newNodo = new OfferNodo(offer);
        if(empty()){   
            first = newNodo;
        }else{
            OfferNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
     
    }
    
    public void addToBegin(String description, double discount, SimplyLinkedCircularListProduct products){
        Offer offer = new Offer(size, description, discount, products);
        OfferNodo newNodo = new OfferNodo(offer);
        if (empty()) {
            first = newNodo;
        } else{
            newNodo.sig = first;
            first = newNodo;
        }
        size++;
    }
    
    public Offer getOfferAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                OfferNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }

    public boolean serch(int idRef){
        OfferNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdOffer()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.info.getIdOffer()==idRef){
                first = first.sig;
            }else{
                OfferNodo aux = first;
                while(aux.sig.info.getIdOffer()!=idRef){
                    aux = aux.sig;
                }
                OfferNodo next = aux.sig.sig;
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        OfferNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.info.getIdOffer());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.info.getIdOffer());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
    
}
