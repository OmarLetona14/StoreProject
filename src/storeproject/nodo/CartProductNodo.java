/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.nodo;

import storeproject.model.Product;

public class CartProductNodo {
    
    public Product product;
    public CartProductNodo sig;
    public CartProductNodo ant;
    
    public CartProductNodo(Product product){
        this.product = product;
        sig = null;
        ant = null;
    }
}
 