/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.list;

import storeproject.model.Offer;
import storeproject.model.Product;
import storeproject.nodo.CartProductNodo;

public class DoubleLinkedCircularListCartProduct {
    private CartProductNodo actual;
    private int size = 1;
    private boolean passed=false;
    
    public DoubleLinkedCircularListCartProduct(){
        actual = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(actual==null);
    }
    
    public void addToFinal(int identifier, String name, String description, double price, int stock, String imageDirection, Offer offer){
        Product product = new Product(size, identifier, name, description, price, stock, imageDirection, offer);
        CartProductNodo nuevo = new CartProductNodo(product);
        if(empty()){
            actual = nuevo;  
        }else{
            CartProductNodo aux = actual;
            aux.ant = nuevo;
            while(aux.sig!=null && aux.sig!=actual){
               aux = aux.sig; 
            }
            aux.sig = nuevo;
            nuevo.ant = aux;
            nuevo.sig = actual;
        }   
        size++;
    }
    
    public Product getProductAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){     
                return actual.product;
            }else{
                CartProductNodo aux = actual;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.product;
            }
        }
        passed = false;
        return null;
    }
 
     public boolean serch(int idRef){
        CartProductNodo aux = actual;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.product.getIdProduct()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(actual.product.getIdProduct()==idRef){
                actual = actual.sig;
            }else{
                CartProductNodo aux = actual;
                while(aux.sig.product.getIdProduct()!=idRef && !passed){
                    if(aux.sig==actual){
                        passed = true;
                    }
                    aux = aux.sig;
                }
                CartProductNodo next = aux.sig.sig;
                aux.sig = next;
            }
            passed = false;
            size--;
        }
    }
     
    public void print(){
        
        CartProductNodo temp = actual;
        
        while(temp != null && !passed){
            if(temp.ant != null){
                System.out.println("Anterior: "+temp.ant.product.getIdProduct());
            }
            System.out.println("Actual: "+temp.product.getIdProduct());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.product.getIdProduct());
            }
            System.out.println("-----------------------------");
            if(temp.sig==actual){
                passed = true;
            }
            temp = temp.sig;
        }
        passed = false;
        
    }
}
