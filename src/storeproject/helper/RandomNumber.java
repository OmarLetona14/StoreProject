/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.helper;

import java.util.Random;

public class RandomNumber {
    
    private static RandomNumber randomNumberInstance;
    
    public int generateIdentifier(){
        Random r = new Random();
        int valorEntero =r.nextInt(1000)+1;
        return valorEntero;
    }
    
    private RandomNumber(){}
    
    public static RandomNumber getSingletonInstance(){
        if(randomNumberInstance==null){
            randomNumberInstance = new RandomNumber();
        }
        return randomNumberInstance;
    }
    
}
