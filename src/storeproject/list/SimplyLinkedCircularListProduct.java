/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.list;

import storeproject.model.Offer;
import storeproject.model.Product;
import storeproject.nodo.ProductNodo;

public class SimplyLinkedCircularListProduct {
    
    private ProductNodo first;
    private boolean passed=false;
    int size=1;
    
    public SimplyLinkedCircularListProduct(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(int identifier, String name, String description, double price, int stock, String imageDirection, Offer offer){
        Product product = new Product(size, identifier, name, description, price, stock, imageDirection, offer,0);
        ProductNodo newNodo = new ProductNodo(product);
        if(empty()){   
            first = newNodo;
        }else{
            ProductNodo aux = first;
            while(aux.sig!=null && aux.sig!=first){
                aux = aux.sig;
            }
            aux.sig = newNodo; 
            newNodo.sig = first;
        }
       size++;
    }
    
    public void addToBegin(int identifier, String name, String description, double price, int stock, String imageDirection){
        Product product = new Product(size, identifier, name, description, price, stock, imageDirection, null,0);
        ProductNodo newNodo = new ProductNodo(product);
        if (empty()) {
            first = newNodo;
        } else{
            newNodo.sig = first;
            first = newNodo;
        }
        size++;
    }
    
    public Product getProductAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                ProductNodo aux = first;
                for(int i=1; i<idRef; i++){
                    if(aux.sig==first){
                    passed = true;
                    }
                    aux = aux.sig;
                }                
                return aux.info;
            }
        }
        return null;
    }
    
    public Product getProductByName(String name){
        ProductNodo aux = first;
        while(aux != null && !passed){
            if(name.equals(aux.info.getName())){
                return aux.info;
            }else{
                if(aux.sig==first){
                    passed = true;
                 }
                aux = aux.sig;
            }
        }
        passed = false;
        return null;
    }
    
    public Product getProductByGain(int gain){
        ProductNodo aux = first;
        while(aux != null && !passed){
            if(gain == (int)aux.info.getGain()){
                return aux.info;
            }else{
                if(aux.sig==first){
                    passed = true;
                 }
                aux = aux.sig;
            }
        }
        passed = false;
        return null;
    }

    public boolean serch(int idRef){
        ProductNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdProduct()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public void edit(int idRef, String name, String description, double price, int stock, String imageDirection){
        if(serch(idRef)){
            ProductNodo aux = first;
            while(aux.info.getIdProduct() != idRef && !passed){
                if(aux.sig==first){
                    passed = true;
                }
                aux = aux.sig;
            }
            aux.info.setName(name);
            aux.info.setDescription(description);
            aux.info.setPrice(price);
            aux.info.setStock(stock);
            aux.info.setImageDirection(imageDirection);
            passed = false;
        }
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.info.getIdProduct()==idRef){
                first = first.sig;
            }else{
                ProductNodo aux = first;
                while(aux.sig.info.getIdProduct()!=idRef && !passed){
                    if(aux.sig==first){
                        passed = true;
                    }
                    aux = aux.sig;
                }
                ProductNodo next = aux.sig.sig;
                aux.sig = next;
            }
            passed = false;
            size--;
        }
    }
}
