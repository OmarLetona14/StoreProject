/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.nodo;

import storeproject.model.User;

public class UserNodo {
    
    public User info;
    public UserNodo sig;
    
    public UserNodo(User informacion){
        info = informacion;
        sig = null;
    }
    
}
