/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.list;

import storeproject.model.CreditCard;
import storeproject.model.User;
import storeproject.nodo.UserNodo;

public class SimplyLinkedListUser {
    private UserNodo first;
    int size=1;
    
    public SimplyLinkedListUser(){
        first = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(first==null);
    }
    
    public void addToFinal(String name, String email, String nickname, String password, String creditCardName, String expirationDate, String CVCCode){
        CreditCard creditCard = new CreditCard(creditCardName, expirationDate, CVCCode);
        User user  = new User(size, name, email, nickname, password, creditCard);
        UserNodo newNodo = new UserNodo(user);
        if(empty()){   
            first = newNodo;
        }else{
            UserNodo aux = first;
            while(aux.sig!=null){
                aux = aux.sig;
            }
            aux.sig = newNodo;           
        }
       size++;
     
    }
    
    public boolean loginSerch(String nicknameRef, String passwordRef){
        UserNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(nicknameRef.equals(aux.info.getNickname()) && passwordRef.equals(aux.info.getPassword())){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public User getUserAt(int idRef) throws Exception{
        if(idRef>=1 && !empty()){
            if(idRef==1){
            return first.info;
            }else{
                UserNodo aux = first;
                for(int i=1; i<idRef; i++){
                    aux = aux.sig;
                }
                return aux.info;
            }
        }
        return null;
    }
    public User getUserByNickname(String nickname){
        UserNodo aux = first;
        while(aux != null){
            if(nickname.equals(aux.info.getNickname())){
                return aux.info;
            }else{
                aux = aux.sig;
            }
        }
        return null;
    }

    public boolean serch(int idRef){
        UserNodo aux = first;
        boolean found = false;
        while(aux != null && found!=true){
            if(idRef==aux.info.getIdUser()){
                found = true;
            }else{
                aux = aux.sig;
            }
        }
        return found;
    }
    
    public void edit(int idRef, String name, String email, String nickname, String password, String creditCardName, String expirationDate, String CVCCode){
        if(serch(idRef)){
            UserNodo aux = first;
            while(aux.info.getIdUser() != idRef){
                aux = aux.sig;
            }
            aux.info.setName(name);
            aux.info.setEmail(email);
            aux.info.setNickname(nickname);
            aux.info.setPassword(password);
            aux.info.getCreditCard().setCreditCardName(creditCardName);
            aux.info.getCreditCard().setExpirationDate(expirationDate);
            aux.info.getCreditCard().setCVCCode(CVCCode);
        }
    
    }
   
    public void delete(int idRef){
        if(serch(idRef)){
            if(first.info.getIdUser()==idRef){
                first = first.sig;
            }else{
                UserNodo aux = first;
                while(aux.sig.info.getIdUser()!=idRef){
                    aux = aux.sig;
                }
                UserNodo next = aux.sig.sig;
                aux.sig = next;
            }
            size--;
        }
    }
    
    public void print(){
        
        UserNodo temp = first;
        
        while(temp != null){

            System.out.println("Actual: "+temp.info.getIdUser());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.info.getIdUser());
            }
            System.out.println("-----------------------------");
            
            temp = temp.sig;
        }
    }
}
