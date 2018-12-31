/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.nodo;

import storeproject.model.Product;

public class ProductNodo {
    
    public Product info;
    public ProductNodo sig;
    
    public ProductNodo(Product informacion){
        info = informacion;
        sig = null;
    }
    
}
